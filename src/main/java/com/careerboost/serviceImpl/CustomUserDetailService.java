package com.careerboost.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.careerboost.entity.User;
import com.careerboost.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepository.findByEmailId(username)
	                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
	        return user;  // No need to cast, User already implements UserDetails
	    }

}
