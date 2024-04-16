package com.example.movieapp_backend.controllers;
import com.example.movieapp_backend.models.MoviesModel;
import com.example.movieapp_backend.models.Tvshowsmodel;
import com.example.movieapp_backend.services.TvshowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.movieapp_backend.services.MovieService;

@RestController
@RequestMapping("/api/search")

public class SearchController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private TvshowsService tvShowService;

    @GetMapping
    public ResponseEntity<?> search(@RequestParam String keyword) {
        List<MoviesModel> movies = movieService.searchMoviesByTitle(keyword);
        List<Tvshowsmodel> tvShows = tvShowService.searcShowsByTitle(keyword);

        Map<String, Object> searchResult = new HashMap<>();
        searchResult.put("movies", movies);
        searchResult.put("tvShows", tvShows);

        return ResponseEntity.ok(searchResult);
    }
}