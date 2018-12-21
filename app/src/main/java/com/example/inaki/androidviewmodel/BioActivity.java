package com.example.inaki.androidviewmodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class BioActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_bio);

        TextView bio = findViewById(R.id.tv_bio);
        TextView real_name = findViewById(R.id.tv_hero_realName);
        bio.setMovementMethod(new ScrollingMovementMethod());

        Intent ii = getIntent();
        Bundle b = ii.getExtras();

        if(b!=null)
        {
            String biograph =(String) b.get("bio");
            String realName = (String) b.get("realname");

            bio.setText(biograph);
            real_name.setText(realName);
        }




    }
}
