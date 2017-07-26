package com.playtown.baseapp.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.playtown.baseapp.R;
import com.playtown.baseapp.models.NewsDetail;
import com.playtown.baseapp.presenters.NewsDetailFragmentPresenter;
import com.playtown.baseapp.ui.adapters.ViewPagerAdapter;
import com.playtown.baseapp.ui.fragments.NewsDetailFragment;
import com.playtown.baseapp.utils.ResponseErrorType;
import com.playtown.baseapp.views.NewsDetailFragmentView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.view.View.GONE;

public class PagerDetailActivity extends BaseActivity implements NewsDetailFragmentView, ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private NewsDetailFragmentPresenter newsDetailFragmentPresenter;
    private ArrayList<NewsDetail> newsList;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView backdrop;
    private TabLayout tabLayout;
    private View indicatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        newsDetailFragmentPresenter = new NewsDetailFragmentPresenter();
        newsDetailFragmentPresenter.attachMvpView(this);
        newsList = new ArrayList<>();
        initViews();
    }

    @Override
    protected void initViews() {
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        backdrop = (ImageView) findViewById(R.id.backdrop);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_indicator);
        tabLayout.setupWithViewPager(viewPager, true);
        indicatorLayout = findViewById(R.id.indicator_layout);
        newsDetailFragmentPresenter.getNewsDetail(30535);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void setupViews() {

    }

    @Override
    public void onError(ResponseErrorType responseErrorType) {

    }

    @Override
    public void onHttpError(int errorCode, String meg) {

    }

    @Override
    public void onDataUpdate(ArrayList<NewsDetail> news) {
        newsList.clear();
        newsList.addAll(news);
        for (int i = 0; i < newsList.size(); i++) {
            adapter.addFragment(NewsDetailFragment.newInstance(newsList.get(i)));
        }
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(2);
        this.onPageSelected(0);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        collapsingToolbarLayout.setTitle(newsList.get(position).getTitle());
        Picasso.with(this).load(newsList.get(position).getPreview()).into(backdrop);
        if (indicatorLayout.getVisibility() == GONE) {
            indicatorLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
