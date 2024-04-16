package com.example.movieapp_backend.services;

import com.example.movieapp_backend.models.Episodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService {

    @Autowired
    private final EpisodeRepository episodeRepository;

    public EpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }
    public List<Episodes> getAllEpisodes(){
        return episodeRepository.findAll();
    }

}
