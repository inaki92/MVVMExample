package com.example.inaki.androidviewmodel;

import com.example.inaki.androidviewmodel.Data.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = "https://www.simplifiedcoding.net/demos/";

    @GET("marvel/")
    Call<List<Hero>> getHeroes();
}
