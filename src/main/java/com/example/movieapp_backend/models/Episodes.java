package com.example.movieapp_backend.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "episodes")
public class Episodes {

    @Id
    private String id;
    private String title;
    private int episodeNumber;
    private String description;
    private String titleImg;
    private String bgImg;
    private String previewImg;
    private String video;
    private String length;
    private boolean active;
    private int views;

    // Constructors, getters, setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int episodeNumber() {
        return episodeNumber;
    }

    public void episodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}