package com.market.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.demo.domain.dto.AuthenticationRequest;
import com.market.demo.domain.dto.AuthenticationResponse;
import com.market.demo.domain.service.LocalAuthUserDetailsService;
import com.market.demo.web.security.JWTUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private LocalAuthUserDetailsService localAuthUserDetailsService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			UserDetails userDetails = localAuthUserDetailsService.loadUserByUsername(request.getUsername());
			String jwt = jwtUtil.generate(userDetails);
			return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(jwt), HttpStatus.OK);
		} catch (BadCredentialsException e) {
			return new ResponseEntity<AuthenticationResponse>(HttpStatus.FORBIDDEN); 
		}

	}

}
