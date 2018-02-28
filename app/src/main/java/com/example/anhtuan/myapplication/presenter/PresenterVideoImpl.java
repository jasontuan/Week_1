package com.example.anhtuan.myapplication.presenter;

import android.support.annotation.NonNull;

import com.example.anhtuan.myapplication.api.MovieApi;
import com.example.anhtuan.myapplication.contract.IView;
import com.example.anhtuan.myapplication.contract.PresenterVideo;
import com.example.anhtuan.myapplication.model.ListVideo;
import com.example.anhtuan.myapplication.model.Video;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterVideoImpl implements PresenterVideo {

    private IView iView;
    private List<Video> videoList;

    public PresenterVideoImpl(IView iView) {
        this.iView = iView;
        this.videoList = new ArrayList<>();
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    @Override
    public void getDataVideo(MovieApi movieApi, int movie_id) {
        String api_key = "a07e22bc18f5cb106bfe4cc1f83ad8ed";
        Call<ListVideo> call = movieApi.getAllVideos(movie_id, api_key);
        call.enqueue(new Callback<ListVideo>() {
            @Override
            public void onResponse(@NonNull Call<ListVideo> call, @NonNull Response<ListVideo> response) {
                if (response.body() != null) {
                    videoList.addAll(response.body().getVideos());
                }
                iView.showDataMovieSuccess();
            }

            @Override
            public void onFailure(@NonNull Call<ListVideo> call, @NonNull Throwable t) {
                iView.showDataMovieFail();
            }
        });
    }
}
