package com.example.movieapp_backend.services;

import com.example.movieapp_backend.models.MoviesModel;
import com.example.movieapp_backend.models.Tvshowsmodel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TvshowsRepository extends MongoRepository<Tvshowsmodel, String> {
    List<Tvshowsmodel> findByFeatured(boolean featured);
    // Custom queries if needed
    List<Tvshowsmodel> findByTitleContainingIgnoreCase(String keyword);
}
