package com.JavaTaskFlow.controllers;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.JavaTaskFlow.DTO.LoginRequest;
import com.JavaTaskFlow.DTO.LoginResponse;
import com.JavaTaskFlow.models.User;
import com.JavaTaskFlow.services.UserService;
import com.JavaTaskFlow.services.exception.BadCredentialsException;
import com.nimbusds.jwt.JWTClaimsSet;

@RestController
public class TokenController {
	@Autowired
	private JwtEncoder jwtEncoder;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserService userService;
	
	public TokenController(JwtEncoder jwtEncoder) {
		this.jwtEncoder=jwtEncoder;
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
		User user = userService.findByEmail(loginRequest.email());
		
		if(!user.isLoginCorrect(loginRequest, bCryptPasswordEncoder)){
			throw new BadCredentialsException("usuário ou senha é invalido!");
		}
		
		Instant now = Instant.now();
		Long expiresIn = 300L;
		
		var claims = JwtClaimsSet.builder()
				.issuer("JavaTaskFlow")
				.subject(user.getId().toString())
				.issuedAt(now)
				.expiresAt(now.plusSeconds(expiresIn))
				.build();
		
		var jwtValue=jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
		
		return ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn));
		
	}
}
