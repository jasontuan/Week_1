package com.example.anhtuan.myapplication.api;

import com.example.anhtuan.myapplication.model.ListResult;
import com.example.anhtuan.myapplication.model.ListVideo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
    String BASE_URL = "https://api.themoviedb.org/3/";

    @GET("movie/popular")
    Call<ListResult> getAllMovie(@Query("api_key") String api_key, @Query("page") int page);

    @GET("movie/{movie_id}/videos")
    Call<ListVideo> getAllVideos(@Path("movie_id") int movie_id, @Query("api_key") String api_key);
}

