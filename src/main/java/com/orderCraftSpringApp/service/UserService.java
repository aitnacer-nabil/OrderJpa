package com.orderCraftSpringApp.service;

import com.orderCraftSpringApp.entities.User;
import com.orderCraftSpringApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Other CRUD operations
}