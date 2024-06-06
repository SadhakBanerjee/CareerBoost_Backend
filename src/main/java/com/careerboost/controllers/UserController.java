//package com.careerboost.controllers;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.careerboost.dto.UserDto;
//import com.careerboost.entity.JwtResponse;
//import com.careerboost.entity.User;
//import com.careerboost.security.JwtHelper;
//import com.careerboost.service.UserService;
//
//@RestController
//@CrossOrigin("*")
//@RequestMapping("/CareerBoost")
//public class UserController {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private AuthenticationManager manager;
//
//    @Autowired
//    private JwtHelper jwtHelper;
//
//    private Logger logger = LoggerFactory.getLogger(UserController.class);
//
//    @PostMapping("/register")
//    public UserDto register(@RequestBody User user) {
//        logger.info("Received request to register user with email: {}", user.getEmailId());
//        if (user.getPassword() == null || user.getPassword().isEmpty()) {
//            logger.error("Registration failed: Password cannot be null or empty for user with email: {}", user.getEmailId());
//            throw new IllegalArgumentException("Password cannot be null or empty");
//        }
//        UserDto createdUser = userService.createUser(user);
//        logger.info("User registered successfully with email: {}", createdUser.getEmailId());
//        return createdUser;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<JwtResponse> login(@RequestBody User request) {
//        logger.info("Received login request for email: {}", request.getEmailId());
//        try {
//            this.doAuthenticate(request.getEmailId(), request.getPassword());
//        } catch (BadCredentialsException e) {
//            logger.error("Login failed: Invalid username or password for email: {}", request.getEmailId());
//            throw e;
//        }
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmailId());
//        String token = this.jwtHelper.generateToken(userDetails);
//
//        JwtResponse response = JwtResponse.builder()
//                .jwtToken(token)
//                .username(userDetails.getUsername()).build();
//        logger.info("Login successful for email: {}", request.getEmailId());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    private void doAuthenticate(String email, String password) {
//        logger.debug("Authenticating user with email: {}", email);
//        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
//        try {
//            manager.authenticate(authentication);
//            logger.debug("Authentication successful for email: {}", email);
//        } catch (BadCredentialsException e) {
//            logger.error("Authentication failed: Invalid username or password for email: {}", email);
//            throw e;
//        }
//    }
//
//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity<String> exceptionHandler(BadCredentialsException e) {
//        logger.warn("Handling BadCredentialsException - {}", e.getMessage());
//        return new ResponseEntity<>("Credentials Invalid !!", HttpStatus.UNAUTHORIZED);
//    }
//}

package com.careerboost.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerboost.dto.UserDto;
import com.careerboost.entity.JwtResponse;
import com.careerboost.entity.User;
import com.careerboost.security.JwtHelper;
import com.careerboost.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/CareerBoost")
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper jwtHelper;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

//    @PostMapping("/register")
//    public UserDto register(@RequestBody User user) {
//        logger.info("Received request to register user with email: {}", user.getEmailId());
//        if (user.getPassword() == null || user.getPassword().isEmpty()) {
//            logger.error("Registration failed: Password cannot be null or empty for user with email: {}", user.getEmailId());
//            throw new IllegalArgumentException("Password cannot be null or empty");
//        }
//        UserDto createdUser = userService.createUser(user);
//        logger.info("User registered successfully with email: {}", createdUser.getEmailId());
//        return createdUser; 
//    }
    
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody User user) {
        logger.info("Received request to register user with email: {}", user.getEmailId());
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            logger.error("Registration failed: Password cannot be null or empty for user with email: {}", user.getEmailId());
            UserDto response = new UserDto(null, user.getEmailId(), "Registration failed: Password cannot be null or empty", null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            UserDto createdUser = userService.createUser(user);
            createdUser.setMessage("User registered successfully");
            logger.info("User registered successfully with email: {}", createdUser.getEmailId());
            return new ResponseEntity<>(createdUser, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Registration failed: {}", e.getMessage());
            UserDto response = new UserDto(null, user.getEmailId(), "Registration failed: " + e.getMessage(), null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody User request) {
        logger.info("Received login request for email: {}", request.getEmailId());
        try {
            this.doAuthenticate(request.getEmailId(), request.getPassword());
        } catch (BadCredentialsException e) {
            logger.error("Login failed: Invalid username or password for email: {}", request.getEmailId());
            JwtResponse response = JwtResponse.builder()
                    .message("Login failed: Invalid username or password")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmailId());
        String token = this.jwtHelper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(((User) userDetails).getUserName())
                .message("Login successful")
                .build();
        logger.info("Login successful for email: {}", request.getEmailId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    private void doAuthenticate(String email, String password) {
        logger.debug("Authenticating user with email: {}", email);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
            logger.debug("Authentication successful for email: {}", email);
        } catch (BadCredentialsException e) {
            logger.error("Authentication failed: Invalid username or password for email: {}", email);
            throw e;
        }
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<JwtResponse> exceptionHandler(BadCredentialsException e) {
        logger.warn("Handling BadCredentialsException - {}", e.getMessage());
        JwtResponse response = JwtResponse.builder()
                .message("Credentials Invalid !!")
                .build();
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}



