package com.example.moviez.dao;

import com.example.moviez.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, String> {
}
