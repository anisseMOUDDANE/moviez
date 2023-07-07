package com.example.moviez.rest;

import com.example.moviez.models.Movie;
import com.example.moviez.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class MovieController {

    @Autowired
    public MoviesService movService;
    @GetMapping("/movies")
    public Set<Movie> findAll() {
        return movService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie findById(@PathVariable("id") String id) {
        return movService.getMovieById(id);
    }
  /*
    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        // api
        return movService.createMovie(movie);
    }

   */
}




