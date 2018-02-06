package com.example.anhtuan.myapplication.presenter;

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

/**
 * Created by ANH TUAN on 2/5/2018.
 */

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
    public void getDataMovie(MovieApi movieApi) {
        Call<Example> call = movieApi.getAllMovie("a07e22bc18f5cb106bfe4cc1f83ad8ed");
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.body() != null) {
                    resultList.addAll(response.body().getResults());
                }
                iView.showDataMovieSuccess();
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                iView.showDataMovieFail();
            }
        });
    }
}
