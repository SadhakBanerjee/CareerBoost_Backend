package com.careerboost.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerboost.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public Optional<User> findByEmailId(String emailId);
	 void deleteByEmailId(String emailId);

}
