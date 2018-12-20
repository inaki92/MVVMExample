package com.example.inaki.androidviewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.inaki.androidviewmodel.Data.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroViewModel extends ViewModel {

    //DATA THAT WE WILL FETCH ASYNCHRONOUSLY
    private MutableLiveData<List<Hero>> heroList;

    //METHOD TO GET THE DATA
    public LiveData<List<Hero>> getHeroes(){
        //Condition if the list is NULL
        if(heroList == null){
            heroList = new MutableLiveData<List<Hero>>();
            //Loading the data asynchronously from server
            loadHeroes();
        }
        //Returning the list
        return heroList;
    }

    //METHOD TO GET THE JSON DATA FROM API USING RETROFIT
    private void loadHeroes(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);
        Call<List<Hero>> call = api.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                //setting the list to our MutableLiveData
                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });
    }

}
