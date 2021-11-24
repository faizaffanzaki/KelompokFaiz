package com.example.kelompokfaiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

public class FavoriteActivity extends AppCompatActivity {
    private RecyclerView rv;
    private FavoriteAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        rv=findViewById(R.id.rvMov);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        getFavData();
    }
    private void getFavData(){
        List<FavoriteList>favoriteLists=MainActivity.favoriteDatabase.favoriteDao().getFavoriteData();

        adapter=new FavoriteAdapter(favoriteLists,getApplicationContext());
        rv.setAdapter(adapter);
    }
}