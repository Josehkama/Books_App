package com.example.test1.models;

public class Books {


    private String title;

    public Books(String title, String category, String description, int thumbnail) {
        this.title = title;
        this.category = category;
        this.description = description;
        Thumbnail = thumbnail;
    }

    private String category;
    private String description;


    private int Thumbnail;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }


}
