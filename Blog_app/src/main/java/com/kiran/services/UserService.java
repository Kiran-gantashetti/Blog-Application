package com.kiran.services;

import java.util.List;

import com.kiran.payloads.UserDto;

public interface UserService {
 
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user , Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto > getAllUser();
	void deletUser(Integer UserId);
	

}
