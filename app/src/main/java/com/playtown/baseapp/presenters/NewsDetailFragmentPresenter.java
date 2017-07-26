package com.playtown.baseapp.presenters;

import com.playtown.baseapp.BaseApplication;
import com.playtown.baseapp.backend.CustomObserver;
import com.playtown.baseapp.backend.NewsDetailResponse;
import com.playtown.baseapp.models.NewsDetail;
import com.playtown.baseapp.utils.ResponseErrorType;
import com.playtown.baseapp.views.NewsDetailFragmentView;

public class NewsDetailFragmentPresenter extends BasePresenter<NewsDetailFragmentView> {

    private CustomObserver<NewsDetailResponse> observer = new CustomObserver<NewsDetailResponse>() {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
        }

        @Override
        public void onNoInternetConnection() {
            mvpView.onError(ResponseErrorType.noInternetConnection);
        }

        @Override
        public void onUnknownError() {
            mvpView.onError(ResponseErrorType.uknownError);
        }

        @Override
        public void onTimeOut() {
            mvpView.onError(ResponseErrorType.timeOut);
        }

        @Override
        public void onHttpErrorCode(int errorCode, String meg) {
            mvpView.onHttpError(errorCode, meg);
        }

        @Override
        public void onNext(NewsDetailResponse news) {

            mvpView.onDataUpdate(news.getData());
        }
    };

    public void getNewsDetail(int newsId) {
        if (newsId != -1) {
            compositeSubscription.add(BaseApplication.requestController.getNewsDetail(newsId).subscribe(observer));
        } else {
            mvpView.onError(ResponseErrorType.uknownError);
        }
    }

}
