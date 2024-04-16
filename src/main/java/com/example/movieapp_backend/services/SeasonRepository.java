package com.example.movieapp_backend.services;

import com.example.movieapp_backend.models.Seasons;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  SeasonRepository extends MongoRepository<Seasons, String> {

    List<Seasons> findByTvShowId(String id);
}
