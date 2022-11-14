package com.example.imagestorebackend.service;

import com.example.imagestorebackend.model.User;
import com.example.imagestorebackend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public User validateUser(String username, String password) {
        User foundUser = userRepository.findByUsername(username);
        if (foundUser.getPassword().equals(password)) {
            return foundUser;
        }
        else {
            return null;
        }
    }
}
