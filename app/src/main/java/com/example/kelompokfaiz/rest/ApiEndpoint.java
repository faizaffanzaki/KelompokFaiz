package com.example.kelompokfaiz.rest;

import com.example.kelompokfaiz.MainModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
    @GET("3/movie/popular?api_key=0dde3e9896a8c299d142e214fcb636f8&language=en-US&page=1")
    Call<MainModel> getMovie();
}
