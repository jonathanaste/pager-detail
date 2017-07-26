package com.playtown.baseapp.ui.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.playtown.baseapp.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Intent intent = new Intent(this, PagerDetailActivity.class);
        startActivity(intent);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void setupViews() {

    }
}
