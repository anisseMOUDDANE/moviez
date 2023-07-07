package com.example.moviez.services;

import com.example.moviez.models.User;

import java.util.Set;

public interface UserService {

    public Set<User> getAllUsers();

    public User getUserById(String id);

    public String createUser(User user);

    public void updateUser(String id, User user);

    public void deleteUser(String id);

}
