package com.example.movieapp_backend.services;

import com.example.movieapp_backend.models.Episodes;
import com.example.movieapp_backend.models.MoviesModel;
import com.example.movieapp_backend.models.Seasons;
import com.example.movieapp_backend.models.Tvshowsmodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TvshowsService {
    @Autowired
    private final TvshowsRepository tvshowsRepository;

        public TvshowsService(TvshowsRepository tvshowsRepository) {
        this.tvshowsRepository = tvshowsRepository;
    }
    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    public List<Tvshowsmodel> getAllTvshows(){
        return tvshowsRepository.findAll();
    }

    public Tvshowsmodel getShowById(String id) {
        Optional<Tvshowsmodel> show = tvshowsRepository.findById(id);
        return show.orElse(null);
    }

    public List<Tvshowsmodel> getFeaturedShows() {
        return tvshowsRepository.findByFeatured(true);
    }

    public void updateViewCount(String id, Tvshowsmodel show) {
        tvshowsRepository.save(show);
    }
    public List<Tvshowsmodel> searcShowsByTitle(String keyword) {
        return tvshowsRepository.findByTitleContainingIgnoreCase(keyword);
    }
}
