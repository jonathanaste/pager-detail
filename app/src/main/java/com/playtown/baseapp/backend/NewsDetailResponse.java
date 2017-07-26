package com.playtown.baseapp.backend;


import com.playtown.baseapp.models.NewsDetail;

import java.util.ArrayList;

public class NewsDetailResponse {
    private NewsDetail post_detail;
    private ArrayList<NewsDetail> related_detail;

    public ArrayList<NewsDetail> getData() {
        ArrayList<NewsDetail> newsDetails = new ArrayList<>();
        newsDetails.add(post_detail);
        newsDetails.addAll(related_detail);
        return newsDetails;
    }
}
