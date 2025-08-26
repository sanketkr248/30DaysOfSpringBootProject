package com.sanket.user_registration.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sanket.user_registration.dto.UserRequestDto;
import com.sanket.user_registration.dto.UserResponseDto;
import com.sanket.user_registration.model.Users;


@Service
public class UserService implements UserServiceInterface{
	
	private Map<Long, Users> users = new HashMap<>();
	private Long countIdCounter = 1L;

	@Override
	public UserResponseDto registerUser(UserRequestDto request) {
		Users user = new Users();
		user.setId(countIdCounter++);
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setEmail(request.getEmail());
		user.setAddress(request.getAddress());
		users.put(user.getId(), user);
		
		UserResponseDto response = new UserResponseDto();
		response.setId(user.getId());
		response.setName(user.getName());
		response.setEmail(user.getEmail());
		return response;
	}

	@Override
	public UserResponseDto getUserById(Long id) {
		Users user = users.get(id);
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
		List<UserResponseDto> responseList = new ArrayList<UserResponseDto>();
	    for (Users user : users.values()) {
	        UserResponseDto response = new UserResponseDto();
	        response.setId(user.getId());
	        response.setName(user.getName());
	        response.setEmail(user.getEmail());
	        responseList.add(response);
	    }
	    return responseList;
	}

}
