package com.careerboost.servicesImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.careerboost.dto.UserDto;
import com.careerboost.entity.User;
import com.careerboost.repository.UserRepository;
import com.careerboost.serviceImpl.UserServiceImpl;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        // Arrange
        User user1 = new User();
        User user2 = new User();
        List<User> userList = Arrays.asList(user1, user2);
        when(userRepository.findAll()).thenReturn(userList);

        // Act
        List<User> result = userService.getAllUsers();

        // Assert
        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testCreateUser() {
        // Arrange
        User user = new User();
        user.setPassword("plainPassword");

        User savedUser = new User();
        savedUser.setUserId(1L);
        savedUser.setPassword("encodedPassword");

        UserDto userDto = new UserDto();
        userDto.setUserId(1L);

        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        when(modelMapper.map(savedUser, UserDto.class)).thenReturn(userDto);

        // Act
        UserDto result = userService.createUser(user);

        // Assert
        assertEquals(1L, result.getUserId());
        verify(passwordEncoder, times(1)).encode("plainPassword");
        verify(userRepository, times(1)).save(any(User.class));
        verify(modelMapper, times(1)).map(savedUser, UserDto.class);
    }
}

