package com.example.movieapp_backend.services;

import com.example.movieapp_backend.models.Episodes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends MongoRepository<Episodes, String> {
//    List<Episodes> findBySeasonId(String id);
}
