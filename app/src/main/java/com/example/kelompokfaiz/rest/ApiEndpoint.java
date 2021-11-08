package com.example.kelompokfaiz.rest;

import com.example.kelompokfaiz.MainModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndpoint {
    /*"3/movie/popular?api_key=0dde3e9896a8c299d142e214fcb636f8&language=en-US&page=1"*/
    @GET("3/movie/{category}")
    Call<MainModel> getMovie(
            @Path("category") String category,
            @Query("api_key") String api_key,
            @Query("languange") String languange,
            @Query("page") int page
    );

    @GET("3/search/movie")
    Call<MainModel>getQuery(
            @Query("api_key") String api_key,
            @Query("languange") String languange,
            @Query("query") String query,
            @Query("page") int page
    );

}
