package com.example.lab.api;

import com.example.lab.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {
    @GET("photos")
    Call<List<Photo>> getPhotos();
}
