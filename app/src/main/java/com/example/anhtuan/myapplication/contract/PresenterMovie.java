package com.example.anhtuan.myapplication.contract;

import com.example.anhtuan.myapplication.api.MovieApi;

public interface PresenterMovie {

    void getDataMovie(MovieApi movieApi, int page);
}
