package com.sanket.user_registration.service;

import java.util.List;

import com.sanket.user_registration.dto.UserRequestDto;
import com.sanket.user_registration.dto.UserResponseDto;

public interface UserServiceInterface {
	
	UserResponseDto registerUser(UserRequestDto user);
	UserResponseDto getUserById(Long id);
	
	List<UserResponseDto> getAllUser();
}
