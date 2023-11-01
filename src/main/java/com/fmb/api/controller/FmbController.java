package com.fmb.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmb.api.db.entity.Menu;
import com.fmb.api.error.handling.FmbException;
import com.fmb.api.model.request.SignUpRequest;
import com.fmb.api.model.request.SignUpResponse;
import com.fmb.api.service.MenuService;
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
		
	@GetMapping("/test")
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("Test pass'd at "+dbService.getDate());
	}
	
	@GetMapping("/menus")
	public ResponseEntity<Iterable<Menu>> getAllMenu() {
		return ResponseEntity.ok(menuService.getAll());
	}
	
	@PostMapping("/user")
	public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest signUpRequest) throws FmbException {
		userService.register(signUpRequest);
		return ResponseEntity.ok(SignUpResponse.success());
	}
}