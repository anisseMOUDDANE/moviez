package com.example.moviez.dao;

import com.example.moviez.models.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MoviesRepository  extends CrudRepository<Movie, String> {
}
