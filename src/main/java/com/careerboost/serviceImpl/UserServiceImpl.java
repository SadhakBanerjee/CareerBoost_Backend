package com.careerboost.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.careerboost.dto.UserDto;
import com.careerboost.entity.User;
import com.careerboost.repository.UserRepository;
import com.careerboost.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

//	@Override
//	public UserDto createUser(User user) {
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		User userData = userRepository.save(user);
//		return this.modelMapper.map(userData, UserDto.class);
//	}
	
	@Override
	public UserDto createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User userData = userRepository.save(user);
		UserDto userDto = this.modelMapper.map(userData, UserDto.class);
		userDto.setUserName(userData.getUserName());
		return userDto;
	}
	
}
