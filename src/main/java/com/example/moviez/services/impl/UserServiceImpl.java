package com.example.moviez.services.impl;

import com.example.moviez.dao.MoviesRepository;
import com.example.moviez.dao.UserRepository;
import com.example.moviez.models.Movie;
import com.example.moviez.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.moviez.services.UserService;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;


    @Override
    public List<User> getAllUsers() {
        List<User> userList = (List<User>) userRepo.findAll();
        return userList;
    }


    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public User createUser(User user) {
        System.out.println("test");
        User savedUser = userRepo.save(user);

        return userRepo.findById(savedUser.getId()).orElse(null);
    }

    @Override
    public void updateUser(String id, User user) {

    }

    @Override
    public void deleteUser(String id) {

    }
}


