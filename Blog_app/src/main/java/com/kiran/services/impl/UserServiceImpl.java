package com.kiran.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.entity.User;
import com.kiran.exceptions.ResourceNotFoundException;
import com.kiran.payloads.UserDto;
import com.kiran.repositries.UserRepo;
import com.kiran.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user1 = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user1);
		return this.UserTodto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user1 = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		
		user1.setName(userDto.getName());
		user1.setEmail(userDto.getEmail());
		user1.setPassword(userDto.getPassword());
		user1.setAbout(userDto.getAbout());
		User updateUser = this.userRepo.save(user1);
		UserDto userDto1= this.UserTodto(updateUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
	   
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		return this.UserTodto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		
		List<User> users= this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.UserTodto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deletUser(Integer UserId) {
	
		User user=this.userRepo.findById(UserId).orElseThrow(() -> new ResourceNotFoundException("User","id",UserId));
		this.userRepo.delete(user);

	}

	private User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setAbout(userDto.getAbout());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
		return user;
	}

	public UserDto UserTodto(User user) {
		UserDto userDto = this.modelMapper.map(user,UserDto.class);
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setAbout(user.getAbout());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());

		return userDto;
	}

}
