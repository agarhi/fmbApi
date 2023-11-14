package com.fmb.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmb.api.db.entity.Menu;
import com.fmb.api.db.entity.RazaStatus;
import com.fmb.api.db.entity.User;
import com.fmb.api.error.handling.FmbException;
import com.fmb.api.model.request.MenuRequest;
import com.fmb.api.model.request.RazaRejectRequest;
import com.fmb.api.model.request.RsvpRequest;
import com.fmb.api.model.request.SignUpRequest;
import com.fmb.api.model.response.RsvpResponse;
import com.fmb.api.model.response.SignUpResponse;
import com.fmb.api.service.MenuService;
import com.fmb.api.service.RazaStatusService;
import com.fmb.api.service.RsvpService;
import com.fmb.api.service.TestDBService;
import com.fmb.api.service.UserService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FmbController {
		
	@Autowired
	private TestDBService dbService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RazaStatusService razaStatusService;
	
	@Autowired
	private RsvpService rsvpService;
	
	
		
	@GetMapping("/test")
	@Secured("ROLE_USER")
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("Test pass'd at "+dbService.getDate());
	}
	
	@GetMapping("/admin-test")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<String> helloAdmin() {
		return ResponseEntity.ok("Hello Admin "+dbService.getDate());
	}
	
	@GetMapping("/menu")
	public ResponseEntity<List<Menu>> getByWeek(@RequestBody MenuRequest menuRequest) {
		return ResponseEntity.ok(menuService.getByWeek(menuRequest.getOffset()));
	}
	
	@GetMapping("/rsvp/{userId}/{menuOffset}")
	public ResponseEntity<List<RsvpResponse>> getRsvp(@PathVariable Integer userId, @PathVariable Integer menuOffset) throws FmbException {
		return ResponseEntity.ok(rsvpService.getByUserIdAndMenuOffset(userId, menuOffset));
	}
	
	@PutMapping("/rsvp")
	public ResponseEntity<List<RsvpResponse>> updateRsvp(@RequestBody RsvpRequest rsvpRequest) throws FmbException {
		return ResponseEntity.ok(rsvpService.updateRsvp(rsvpRequest.getUserId(), rsvpRequest.getMenuIds(), rsvpRequest.getOffset(), rsvpRequest.isChoice()));
	}
	
	@PutMapping("/rsvp/size")
	public ResponseEntity<List<RsvpResponse>> updateRsvpSize(@RequestBody RsvpRequest rsvpRequest) throws FmbException {
		return ResponseEntity.ok(rsvpService.updateSize(rsvpRequest.getUserId(), rsvpRequest.getMenuId(), rsvpRequest.getOffset(), rsvpRequest.getSize()));
	}
	
	@PutMapping("/rsvp/carbs")
	public ResponseEntity<List<RsvpResponse>> updateRsvpCarbsChoice(@RequestBody RsvpRequest rsvpRequest) throws FmbException {
		return ResponseEntity.ok(rsvpService.updateCarbSelection(rsvpRequest.getUserId(), rsvpRequest.getMenuId(), rsvpRequest.getOffset(), rsvpRequest.isLessCarbsChoice()));
	}
	
	@PostMapping("/register")
	public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest signUpRequest) throws FmbException {
		userService.register(signUpRequest);
		return ResponseEntity.ok(SignUpResponse.success());
	}
	
	@GetMapping("/user/{username}")
	public ResponseEntity<User> getUser(@PathVariable String username) throws FmbException {
		User user = userService.getByUsername(username);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/raza/status/{its}")
	public ResponseEntity<RazaStatus> getRazaStatus(@PathVariable String its) throws FmbException {
		return ResponseEntity.ok(razaStatusService.getRazaStatus(its));
	}
	
	@PutMapping("/raza/approve/{its}")
	public ResponseEntity<RazaStatus> approveRazaStatus(@PathVariable String its) throws FmbException {
		return ResponseEntity.ok(razaStatusService.approveRazaStatus(its));
	}
	
	@PutMapping("/raza/reject/{its}")
	public ResponseEntity<RazaStatus> rejectRazaStatus(@PathVariable String its, @RequestBody RazaRejectRequest razaRejectRequest) throws FmbException {
		return ResponseEntity.ok(razaStatusService.rejectRazaStatus(its, razaRejectRequest.getReason()));
	}
}