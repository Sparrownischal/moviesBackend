package com.example.movieapp_backend.services;

import com.example.movieapp_backend.models.MoviesModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<MoviesModel, String> {
    // Define custom methods if needed
    List<MoviesModel> findByFeatured(boolean featured);
    List<MoviesModel> findByTitleContainingIgnoreCase(String keyword);
}
