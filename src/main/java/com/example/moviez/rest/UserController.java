package com.example.moviez.rest;

import com.example.moviez.models.User;
import com.example.moviez.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class UserController {

    @Autowired
    public UserService userService;
    @GetMapping("/users")
    public Set<User> findAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }


}
