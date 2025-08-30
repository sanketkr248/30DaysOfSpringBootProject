package com.sanket.user_registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@GetMapping("/health")
	public String healthChecck()
	{
		return "healthy controller";
	}
	
	@GetMapping("/health/{name}")
	public String greeting(@PathVariable String name)
	{
		return "hello "+name;
	}

}
