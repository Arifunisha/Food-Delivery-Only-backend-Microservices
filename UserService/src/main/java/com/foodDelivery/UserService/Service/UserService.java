package com.foodDelivery.UserService.Service;

import com.foodDelivery.UserService.Repository.UserRepository;
import com.foodDelivery.UserService.entity.User;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User createUser(User user) {

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    // Get one user by ID
    public User getUserById(Integer id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}