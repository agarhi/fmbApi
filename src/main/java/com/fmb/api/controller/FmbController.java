package com.fmb.api.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fmb.api.db.entity.FoodFeedback;
import com.fmb.api.db.entity.Menu;
import com.fmb.api.db.entity.RazaStatus;
import com.fmb.api.db.entity.SpecialInstructions;
import com.fmb.api.db.entity.User;
import com.fmb.api.error.handling.FmbException;
import com.fmb.api.model.request.MenuRequest;
import com.fmb.api.model.request.RazaRejectRequest;
import com.fmb.api.model.request.RsvpRequest;
import com.fmb.api.model.request.SignUpRequest;
import com.fmb.api.model.request.SpInstructionsRequest;
import com.fmb.api.model.response.RsvpResponse;
import com.fmb.api.model.response.SignUpResponse;
import com.fmb.api.service.FoodFeedbackService;
import com.fmb.api.service.MenuService;
import com.fmb.api.service.RazaStatusService;
import com.fmb.api.service.RsvpService;
import com.fmb.api.service.SpInstructionsService;
import com.fmb.api.service.TestDBService;
import com.fmb.api.service.UserService;

@RestController
@RequestMapping("/")
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
	
	@Autowired
	private SpInstructionsService spInstructionsService;
	
	@Autowired
	private FoodFeedbackService foodFeedbackService;
	
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
	public ResponseEntity<List<Menu>> getByWeek(@RequestBody MenuRequest menuRequest) throws FmbException {
		return ResponseEntity.ok(menuService.getByWeek(menuRequest.getOffset()));
	}
	
	@PutMapping("/menu")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<String> updateMenu(@RequestBody List<Menu> menus) throws FmbException {
		menuService.save(menus);
		return ResponseEntity.ok("{\"result\": \"Menus saved\"}");
	}
	
	@GetMapping("/menu/{date}")
	public ResponseEntity<List<Menu>> getByDate(@PathVariable String date) throws FmbException {
		return ResponseEntity.ok(menuService.getByDate(date));
	}
	
	@GetMapping("/rsvp/{menuOffset}")
	public ResponseEntity<List<RsvpResponse>> getRsvp(@PathVariable Integer menuOffset) throws FmbException {
		return ResponseEntity.ok(rsvpService.getByUserIdAndMenuOffset(menuOffset));
	}
	
	@PutMapping("/rsvp")
	public ResponseEntity<List<RsvpResponse>> updateRsvp(@RequestBody RsvpRequest rsvpRequest) throws FmbException {
		return ResponseEntity.ok(rsvpService.updateRsvp(rsvpRequest.getMenuIds(), rsvpRequest.getOffset(), rsvpRequest.isChoice()));
	}
	
	@PutMapping("/rsvp/size")
	public ResponseEntity<List<RsvpResponse>> updateRsvpSize(@RequestBody RsvpRequest rsvpRequest) throws FmbException {
		return ResponseEntity.ok(rsvpService.updateSize(rsvpRequest.getMenuId(), rsvpRequest.getOffset(), rsvpRequest.getSize()));
	}
	
	@PutMapping("/rsvp/carbs")
	public ResponseEntity<List<RsvpResponse>> updateRsvpCarbsChoice(@RequestBody RsvpRequest rsvpRequest) throws FmbException {
		return ResponseEntity.ok(rsvpService.updateCarbSelection(rsvpRequest.getMenuId(), rsvpRequest.getOffset(), rsvpRequest.isLessCarbsChoice()));
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
	@Secured("ROLE_ADMIN")
	public ResponseEntity<RazaStatus> approveRazaStatus(@PathVariable String its) throws FmbException {
		return ResponseEntity.ok(razaStatusService.approveRazaStatus(its));
	}
	
	@PutMapping("/raza/reject/{its}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<RazaStatus> rejectRazaStatus(@PathVariable String its, @RequestBody RazaRejectRequest razaRejectRequest) throws FmbException {
		return ResponseEntity.ok(razaStatusService.rejectRazaStatus(its, razaRejectRequest.getReason()));
	}
	
	@GetMapping("/spInstructions/{date}")
	public ResponseEntity<SpecialInstructions> getSpInstructions(@PathVariable String date) throws FmbException {
		return ResponseEntity.ok(spInstructionsService.getByDate(date));
	}
	
	@PutMapping("/spInstructions")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<String> addSpecialInstructions(@RequestBody SpInstructionsRequest speInstructionsRequest) throws FmbException {
		spInstructionsService.save(speInstructionsRequest);
		return ResponseEntity.ok("{\"result\": \"Instructions saved\"}");
	}
	
	@GetMapping("/feedback")
	public ResponseEntity<List<FoodFeedback>> getFeedback(@RequestParam Set<Integer> menuIds) throws FmbException {
		return ResponseEntity.ok(foodFeedbackService.getByMenuIds(menuIds));
	}
}