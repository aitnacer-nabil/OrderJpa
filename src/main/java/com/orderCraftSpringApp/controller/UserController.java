package com.orderCraftSpringApp.controller;

import com.orderCraftSpringApp.entities.User;
import com.orderCraftSpringApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        users.forEach(System.out::println);
        model.addAttribute("users", users);
        return "users";
    }
}