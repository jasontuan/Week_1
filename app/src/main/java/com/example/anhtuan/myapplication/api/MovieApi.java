package com.example.anhtuan.myapplication.api;

import com.example.anhtuan.myapplication.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {
    String BASE_URL = "https://api.themoviedb.org/3/";

    @GET("movie/popular")
    Call<Example> getAllMovie(@Query("api_key") String api_key, @Query("page") int page);
}
