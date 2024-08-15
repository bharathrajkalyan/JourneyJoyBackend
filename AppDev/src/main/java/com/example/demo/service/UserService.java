package com.example.demo.service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    // Method for user signup
    public User signUp(User user) {
        return userRepository.save(user);
    }

    // Method for user login
    public Optional<User> login(String email, String password) {
        // Find user by email
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // Check if the provided password matches the stored password
            if (password.equals(user.getPassword())) { // Basic check without encryption
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

}
