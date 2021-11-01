package com.example.kelompokfaiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private final String TAG = "DetailActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String image = getIntent().getStringExtra("intent_image");
        String title = getIntent().getStringExtra("intent_title");
        String deskripsi = getIntent().getStringExtra("intent_deskripsi");
        getSupportActionBar().setTitle(title);
        Picasso.get()
                .load(image)
                .into((ImageView) findViewById(R.id.imgDetailMovie));
    }
}