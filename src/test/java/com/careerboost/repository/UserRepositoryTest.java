package com.careerboost.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.careerboost.entity.User;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmailId() {
        // Arrange
        User user = new User();
        user.setEmailId("test@example.com");
        userRepository.save(user);

        // Act
        Optional<User> foundUser = userRepository.findByEmailId("test@example.com");

        // Assert
        assertTrue(foundUser.isPresent());
        assertEquals("test@example.com", foundUser.get().getEmailId());
    }

    @Test
    public void testDeleteByEmailId() {
        // Arrange
        User user = new User();
        user.setEmailId("test@example.com");
        userRepository.save(user);

        // Act
        userRepository.deleteByEmailId("test@example.com");
        Optional<User> foundUser = userRepository.findByEmailId("test@example.com");

        // Assert
        assertFalse(foundUser.isPresent());
    }
}

