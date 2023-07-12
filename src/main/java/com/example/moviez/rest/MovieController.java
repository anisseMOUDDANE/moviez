package com.example.moviez.rest;

import com.example.moviez.models.Movie;
import com.example.moviez.models.RootResponse;
import com.example.moviez.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @PostMapping("/movies/api/all")
    public void findAllMovies() {
        // api
        movService.addMoviesToDatabase();

    }



}




