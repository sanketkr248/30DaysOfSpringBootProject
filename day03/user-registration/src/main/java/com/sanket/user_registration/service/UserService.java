package com.sanket.user_registration.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.user_registration.dto.UserProfileDto;
import com.sanket.user_registration.dto.request.LoginRequestDto;
import com.sanket.user_registration.dto.request.UserRequestDto;
import com.sanket.user_registration.dto.response.LoginResponseDto;
import com.sanket.user_registration.dto.response.UserResponseDto;
import com.sanket.user_registration.exception.UserAlreadyExistsException;
import com.sanket.user_registration.model.Users;
import com.sanket.user_registration.repository.UserRepository;


@Service
public class UserService implements UserServiceInterface{	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserResponseDto registerUser(UserRequestDto request) {
		
		if(userRepository.existsByEmail(request.getEmail()))
		{
			throw new UserAlreadyExistsException("User Already Exists with email: " + request.getEmail());
		}
		
		Users user = new Users();
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setEmail(request.getEmail());
		user.setAddress(request.getAddress());
		user.setAge(request.getAge());
		
		Users savedUser = userRepository.save(user);
		
		UserResponseDto response = new UserResponseDto();
		response.setId(savedUser.getId());
		response.setName(savedUser.getName());
		response.setEmail(savedUser.getEmail());
		return response;
	}

	@Override
	public UserResponseDto getUserById(Long id) {
		Users user = userRepository.findById(id).orElse(null);
		if(user == null)
			return null;
		
		UserResponseDto response = new UserResponseDto();
		response.setId(user.getId());
		response.setName(user.getName());
		response.setEmail(user.getEmail());
		return response;
	}

	@Override
	public List<UserResponseDto> getAllUser() {
		
		List<Users> users = userRepository.findAll();
		List<UserResponseDto> responseList = new ArrayList<UserResponseDto>();
		
	    for (Users user : users) {
	        UserResponseDto response = new UserResponseDto();
	        response.setId(user.getId());
	        response.setName(user.getName());
	        response.setEmail(user.getEmail());
	        responseList.add(response);
	    }
	    return responseList;
	}

	@Override
	public LoginResponseDto login(LoginRequestDto request) {
//		Users user = users.values().stream()
//							.filter(u -> u.getEmail().equals(request.getEmail()))
//							.findFirst()
//							.orElse(null);
		Users user = userRepository.findByEmail(request.getEmail());
		
		if (user == null || !user.getPassword().equals(request.getPassword())) {
	        // You could also throw custom exception
			 return null; 
	    }
		
		LoginResponseDto response = new LoginResponseDto();
		response.setUserId(String.valueOf(user.getId()));
		response.setName(user.getName());
		return response;
	}

	@Override
	public UserProfileDto getUserProfile(Long id) {
		Users user = userRepository.findById(id).orElse(null);
		if(user == null)
			return null;
	
		
		UserProfileDto profile = new UserProfileDto();
		profile.setName(user.getName());
		profile.setEmail(user.getEmail());
		profile.setAddress(user.getAddress());
		profile.setAge(user.getAge());	
		return profile;
	}

}
