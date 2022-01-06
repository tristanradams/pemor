package com.example.demo.controllers;

import com.example.demo.data.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RequestMapping("/api/users")
@RestController
public class UserController {
    public UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @ExceptionHandler
    public String handle(Exception e) {
        return e.getMessage();
    }

    @GetMapping
    public List<User> getUsers() {
        return service.findAll();
    }

    @GetMapping("/featured")
    public User getFeaturedUser() {
        List<User> allUsers = service.findAll();
        Random random = new Random();
        int chosenIndex = random.nextInt(0, allUsers.size());

        return allUsers.get(chosenIndex);
    }

    @PostMapping
    public User createUser(@RequestBody User candidate) throws Exception {
        return service.createUser(candidate);
    }
}
