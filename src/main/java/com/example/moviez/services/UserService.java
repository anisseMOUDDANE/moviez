package com.example.moviez.services;

import com.example.moviez.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserById(String id);

    public User createUser(User user);

    public void updateUser(String id, User user);

    public void deleteUser(String id);

}
