package com.fmb.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fmb.api.service.TestDBService;

@Controller
@RequestMapping("/test")
public class FmbController {
	
	@Autowired
	private TestDBService dbService;
	
	@GetMapping
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("Test pass'd at "+dbService.getDate());
	}
}