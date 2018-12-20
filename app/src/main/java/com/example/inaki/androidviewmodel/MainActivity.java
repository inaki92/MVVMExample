package com.example.inaki.androidviewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.inaki.androidviewmodel.Adapter.HeroesAdapter;
import com.example.inaki.androidviewmodel.Data.Hero;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecycler;
    HeroesAdapter mAdapter;

    List<Hero> heroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycler = findViewById(R.id.recycler_view);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));

        HeroViewModel model = ViewModelProviders.of(this).get(HeroViewModel.class);

        model.getHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroList) {
                mAdapter = new HeroesAdapter(MainActivity.this, heroList);
                mRecycler.setAdapter(mAdapter);
            }
        });
    }
}
