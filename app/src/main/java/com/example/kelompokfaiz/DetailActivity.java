package com.example.kelompokfaiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private final String TAG = "DetailActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();


        String title = intent.getStringExtra(MovieAdapter.EXTRA_MESSAGE1);
        String overview = intent.getStringExtra(MovieAdapter.EXTRA_MESSAGE2);
        String poster = intent.getStringExtra(MovieAdapter.EXTRA_MESSAGE3);

/*
        Log.d(TAG,"Title : " + title);
        Log.d(TAG,"Overview : " + overview);
        Log.d(TAG,"Poster : " + poster);
*/


        TextView title1 = findViewById(R.id.tvDetailTitle);
        title1.setText(title);

        TextView overview1 = findViewById(R.id.tvDetailDescription);
        overview1.setText(overview);

        ImageView poster1 = findViewById(R.id.imgDetailMovie);
        Glide.with(this).load("https://image.tmdb.org/t/p/w185/"+ poster).into(poster1);

        if (getSupportActionBar()!= null){
            getSupportActionBar().setTitle(title);
        }
    }
}