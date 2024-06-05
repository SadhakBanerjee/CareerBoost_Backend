package com.careerboost.service;

import java.util.List;

import com.careerboost.dto.UserDto;
import com.careerboost.entity.User;

public interface UserService {

	List<User> getAllUsers();
	UserDto createUser(User user);
}
