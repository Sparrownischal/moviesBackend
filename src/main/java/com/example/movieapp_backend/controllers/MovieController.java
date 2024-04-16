package com.example.movieapp_backend.controllers;

import com.example.movieapp_backend.models.MoviesModel;
import com.example.movieapp_backend.services.MovieService;
import com.example.movieapp_backend.utilities.ResponseUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MoviesModel> createMovie(@RequestBody MoviesModel movie) {
        MoviesModel createdMovie = movieService.createMovie(movie);
        return ResponseEntity.ok(createdMovie);
    }

    @GetMapping
    public ResponseEntity<Object> getAllMovies() {
        List<MoviesModel> movies = movieService.getAllMovies();
        return ResponseUtil.createApiResponse("Success", movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoviesModel> getMovieById(@PathVariable String id) {
        MoviesModel movie = movieService.getMovieById(id);
        if (movie != null) {
            movie.setViews(movie.getViews() + 1);
            movieService.updateViewCount(id, movie);
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/featured")
    public ResponseEntity<Object> getFeaturedMovies() {
        List<MoviesModel> movies = movieService.getFeaturedMovies();
        return ResponseUtil.createApiResponse("Success", movies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMovie(@PathVariable String id, @RequestBody MoviesModel movie) {
        try {
            movieService.updateMovie(id, movie);
            return ResponseEntity.ok("Movie updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update movie");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable String id) {
        boolean deleted = movieService.deleteMovieById(id);
        if (deleted) {
            return ResponseEntity.ok().body("Movie with ID: " + id + " was deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found with ID: " + id);
        }
    }
}
