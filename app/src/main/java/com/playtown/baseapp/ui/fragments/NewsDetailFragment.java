package com.playtown.baseapp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.playtown.baseapp.R;
import com.playtown.baseapp.models.NewsDetail;

import static com.playtown.baseapp.utils.Constants.BASE_POST_URL;
import static com.playtown.baseapp.utils.Constants.NEWS_DETAIL;

public class NewsDetailFragment extends Fragment {

    private WebView webView;
    private NewsDetail newsDetail;


    public static Fragment newInstance(NewsDetail newsDetail) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(NEWS_DETAIL, newsDetail);
        NewsDetailFragment fragment = new NewsDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.newsDetail = (NewsDetail) getArguments().getSerializable(NEWS_DETAIL);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initListeners();
        setupViews();
    }

    private void setupViews() {
        webView.loadUrl(BASE_POST_URL + newsDetail.getId());
    }

    private void initListeners() {

    }

    private void initViews(View view) {
        webView = (WebView) view.findViewById(R.id.webview);
    }
}
