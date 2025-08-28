package com.sanket.user_registration.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.user_registration.dto.UserProfileDto;
import com.sanket.user_registration.dto.request.LoginRequestDto;
import com.sanket.user_registration.dto.request.UserRequestDto;
import com.sanket.user_registration.dto.response.LoginResponseDto;
import com.sanket.user_registration.dto.response.UserResponseDto;
import com.sanket.user_registration.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public UserResponseDto createUser(@RequestBody UserRequestDto user)
	{
		return userService.registerUser(user);
	}
	
	
	@GetMapping("/{id}")
	public UserResponseDto getUser(@PathVariable Long id)
	{
		return userService.getUserById(id);
	}
	
	@GetMapping()
	public List<UserResponseDto> getallUser()
	{
		return userService.getAllUser();
	}
	
	@PostMapping("/login")
	public LoginResponseDto login(@RequestBody LoginRequestDto request)
	{
		return userService.login(request);
	}
	
	@GetMapping("profile/{id}")
	public UserProfileDto userProfile(@PathVariable Long id)
	{
		return userService.getUserProfile(id);
	}

}
