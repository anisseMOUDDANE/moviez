package com.example.moviez.services.impl;

import com.example.moviez.dao.MoviesRepository;
import com.example.moviez.models.Movie;
import com.example.moviez.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;


    @Override
    public Set<Movie> getAllMovies() {
        return (Set<Movie>) moviesRepository.findAll();
    }

    @Override
    public Movie getMovieById(String id) {
        return moviesRepository.findById(id).orElse(null);
    }

    @Override
    public String createMovie(Movie Movie) {
        //create a movie and return the i
        Movie savedMovie = moviesRepository.save(Movie);
        return savedMovie.getId();
    }

    @Override
    public void updateMovie(String id, Movie Movie) {
        Movie movieToUpdate = moviesRepository.findById(id).orElse(null);
        if(movieToUpdate != null){
            movieToUpdate.setTitle(Movie.getTitle());
            movieToUpdate.setSynopsis(Movie.getSynopsis());
            movieToUpdate.setMainActor(Movie.getMainActor());
            movieToUpdate.setRating(Movie.getRating());
            movieToUpdate.setReleaseDate(Movie.getReleaseDate());
            movieToUpdate.setGenre(Movie.getGenre());
            moviesRepository.save(movieToUpdate);
        }
    }

    @Override
    public void deleteMovie(String id) {
        moviesRepository.deleteById(id);
    }
}
