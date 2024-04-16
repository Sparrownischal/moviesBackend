package com.example.movieapp_backend.services;

import com.example.movieapp_backend.models.Seasons;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonService {

    private final SeasonRepository seasonRepository;


    public SeasonService(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    public List<Seasons> getAllSeasons(){
        return seasonRepository.findAll();
    }
}
