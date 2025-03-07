package com.JavaTaskFlow.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class index {
	
	@GetMapping
	public Map<String, String> helloWorld() {
	    return Map.of("message", "Hello World! 123");
	}
}
