package com.example.anhtuan.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ListVideo implements Serializable {

    @SerializedName("results")
    @Expose
    private List<Video> videos = null;

    public List<Video> getVideos() {
        return videos;
    }

}
