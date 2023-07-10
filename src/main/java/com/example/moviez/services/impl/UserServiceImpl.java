package com.example.moviez.services.impl;

import com.example.moviez.models.User;
import org.springframework.stereotype.Service;
import com.example.moviez.services.UserService;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public Set<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public String createUser(User user) {
        return null;
    }

    @Override
    public void updateUser(String id, User user) {

    }

    @Override
    public void deleteUser(String id) {

    }
}


