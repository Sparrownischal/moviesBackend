package com.example.movieapp_backend.controllers;

import com.example.movieapp_backend.models.MoviesModel;
import com.example.movieapp_backend.models.Tvshowsmodel;
import com.example.movieapp_backend.services.MovieService;
import com.example.movieapp_backend.services.TvshowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.example.movieapp_backend.utilities.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@RestController
@RequestMapping("/api/shows")

public class TvshowsController {

    private final TvshowsService tvshowsService;
    @Autowired
    public TvshowsController(TvshowsService tvshowsService) {
        this.tvshowsService = tvshowsService;
    }

    @GetMapping
    public ResponseEntity<List<Tvshowsmodel>> getAllTvshows(){
        List<Tvshowsmodel> shows = tvshowsService.getAllTvshows();
        return ResponseEntity.ok(shows);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Tvshowsmodel> getShowById(@PathVariable String id) {
        Tvshowsmodel movie = tvshowsService.getShowById(id);
        if (movie != null) {
            movie.setViews(movie.getViews() + 1);
            tvshowsService.updateViewCount(id, movie);
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/featured")
    public ResponseEntity<Object> getFeaturedMovies() {
        List<Tvshowsmodel> movies = tvshowsService.getFeaturedShows();
        return ResponseUtil.createApiResponse("Success", movies);
    }

}
