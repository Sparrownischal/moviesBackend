package com.example.movieapp_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "seasons")
public class Seasons {

    @Id
    private String id;
    private String tvShowId;
    private int number;
    private String title;
    private String description;
    private String titleImg;
    private String bgImg;
    private String previewImg;

    // Reference to episodes
//    @DBRef
//    private List<Episodes> episodes;

    //getters, setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTvShowId() {
        return tvShowId;
    }

    public void setTvShowId(String tvShowId) {
        this.tvShowId = tvShowId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int number() {
        return number;
    }

    public void number(int number) {
        this.number = number;
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg;
    }

    public String getBgImg() {
        return bgImg;
    }

    public void setBgImg(String bgImg) {
        this.bgImg = bgImg;
    }

    public String getPreviewImg() {
        return previewImg;
    }

    public void setPreviewImg(String previewImg) {
        this.previewImg = previewImg;
    }
//    public List<Episodes> getEpisodes(){
//        return episodes;
//    }
//
//    public void setEpisodes(List<Episodes> episodes) {
//        this.episodes = episodes;
//    }
}