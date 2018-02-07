package com.example.anhtuan.myapplication.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.anhtuan.myapplication.api.MovieApi;
import com.example.anhtuan.myapplication.contract.PresenterMovie;
import com.example.anhtuan.myapplication.model.Example;
import com.example.anhtuan.myapplication.model.Result;
import com.example.anhtuan.myapplication.contract.IView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterMovieImpl implements PresenterMovie {

    private IView iView;
    private List<Result> resultList;

    public PresenterMovieImpl(IView iView) {
        this.iView = iView;
        this.resultList = new ArrayList<>();
    }

    public List<Result> getResultList() {
        return resultList;
    }

    @Override
    public void getDataMovie(MovieApi movieApi, int page) {
        String api_key = "a07e22bc18f5cb106bfe4cc1f83ad8ed";
        Call<Example> call = movieApi.getAllMovie(api_key, page);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(@NonNull Call<Example> call, @NonNull Response<Example> response) {
                Log.d("TAGA", response.body().getResults().size() + "");
                if (response.body() != null) {
                    resultList.addAll(response.body().getResults());
                }
                iView.showDataMovieSuccess();
            }

            @Override
            public void onFailure(@NonNull Call<Example> call, @NonNull Throwable t) {
                iView.showDataMovieFail();
            }
        });
    }
}
