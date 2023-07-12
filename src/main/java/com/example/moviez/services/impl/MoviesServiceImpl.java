package com.example.moviez.services.impl;

import com.example.moviez.dao.MoviesRepository;
import com.example.moviez.models.Movie;
import com.example.moviez.models.Result;
import com.example.moviez.models.RootResponse;
import com.example.moviez.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;


    @Value("${openai.api.url}")
    private String apiUrl;

    @Value("${openai.api.key}")
    private String openaiApiKey;

    @Override
    public ArrayList<Movie> getAllMovies() {
        return (ArrayList<Movie>) moviesRepository.findAll();
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


    public void addMoviesToDatabase() {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl; // remplacer par l'URL de votre API

        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
            return execution.execute(request, body);
        });

        ResponseEntity<RootResponse> response = restTemplate.exchange(url, HttpMethod.GET, null, RootResponse.class);


        System.out.println(response.getBody().results);
        for (Result result : response.getBody().results) {
            Movie movie = new Movie();
            movie.setTitle(result.title);
            movie.setSynopsis(result.overview);
            movie.setMainActor(null);
            movie.setRating(result.vote_average);
            movie.setReleaseDate(LocalDate.parse(result.release_date));
            movie.setGenre(null);
            moviesRepository.save(movie);

        }

    }
}
