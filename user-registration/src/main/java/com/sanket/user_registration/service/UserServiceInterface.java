package com.sanket.user_registration.service;

import java.util.List;

import com.sanket.user_registration.dto.UserProfileDto;
import com.sanket.user_registration.dto.request.LoginRequestDto;
import com.sanket.user_registration.dto.request.UserRequestDto;
import com.sanket.user_registration.dto.response.LoginResponseDto;
import com.sanket.user_registration.dto.response.UserResponseDto;

public interface UserServiceInterface {
	
	UserResponseDto registerUser(UserRequestDto user);
	UserResponseDto getUserById(Long id);
	
	List<UserResponseDto> getAllUser();
	
	LoginResponseDto login(LoginRequestDto request);
	
	UserProfileDto getUserProfile(Long id);
}
