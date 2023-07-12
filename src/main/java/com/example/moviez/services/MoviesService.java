package com.example.moviez.services;

import com.example.moviez.models.Movie;

import java.util.Set;

public interface MoviesService {

    public Set<Movie> getAllMovies();

    public Movie getMovieById(String id);

    public String createMovie(Movie Movie);

    public void updateMovie(String id, Movie Movie);

    public void deleteMovie(String id);

    public void addMoviesToDatabase();

}
