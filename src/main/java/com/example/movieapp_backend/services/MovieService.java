package com.example.movieapp_backend.services;

import com.example.movieapp_backend.models.MoviesModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MoviesModel createMovie(MoviesModel movie) {
        // Implement logic to create a movie
        return movieRepository.save(movie);
    }

    public List<MoviesModel> getAllMovies() {
        // Implement logic to retrieve all movies
        return movieRepository.findAll();
    }

    public List<MoviesModel> getFeaturedMovies() {
        return movieRepository.findByFeatured(true);
    }

    public MoviesModel getMovieById(String id) {
        Optional<MoviesModel> movie = movieRepository.findById(id);
        return movie.orElse(null);
    }

    public boolean deleteMovieById(String id) {

        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public void updateMovie(String id, MoviesModel movie) {
        movie.setId(id);
        movieRepository.save(movie);
    }

    public void updateViewCount(String movieId, MoviesModel movie) {
        movieRepository.save(movie);
    }

    public List<MoviesModel> searchMoviesByTitle(String keyword) {
        return movieRepository.findByTitleContainingIgnoreCase(keyword);
    }


}