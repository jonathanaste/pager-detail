package com.playtown.baseapp.views;


import com.playtown.baseapp.backend.NewsDetailResponse;
import com.playtown.baseapp.models.NewsDetail;
import com.playtown.baseapp.utils.ResponseErrorType;

import java.util.ArrayList;

public interface NewsDetailFragmentView extends MvpView {

    void onError(ResponseErrorType responseErrorType);

    void onHttpError(int errorCode, String meg);

    void onDataUpdate(ArrayList<NewsDetail> news);

}
