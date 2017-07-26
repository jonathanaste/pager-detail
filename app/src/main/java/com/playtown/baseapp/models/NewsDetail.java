package com.playtown.baseapp.models;


import java.io.Serializable;

public class NewsDetail implements Serializable {

    private int id;
    private String title;
    private String date;
    private String category;
    private String preview;
    private String content;
    private String ago;

    public NewsDetail(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getPreview() {
        return preview;
    }

    public String getContent() {
        return content;
    }

    public String getAgo() {
        return ago;
    }
}
