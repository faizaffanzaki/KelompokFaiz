package com.example.kelompokfaiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import androidx.appcompat.widget.SearchView;

import android.view.MenuItem;
import android.widget.Toast;

import com.example.kelompokfaiz.rest.ApiEndpoint;
import com.example.kelompokfaiz.rest.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    String API_KEY = "0dde3e9896a8c299d142e214fcb636f8";
    String CATEGORY = "popular";
    String LANGUANGE = "en-US";
    int page = 1;

    private MovieAdapter movieAdapter;
    private SearchView searchView;
    private RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
        setupRecylerView();
        getDataFromApi();


    }

    private void setupView(){
        recyclerView = findViewById(R.id.rvMovie);
    }

    private void setupRecylerView(){
        List<MainModel.Result> results = new ArrayList<>();
        movieAdapter = new MovieAdapter(this, results, new MovieAdapter.OnAdapterListener() {
            @Override
            public void onClick(MainModel.Result result) {
                //              Toast.makeText(MainActivity.this, result.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("intent_image", result.getPoster_path());
                intent.putExtra("intent_title", result.getTitle());
                intent.putExtra("intent_deskripsi", result.getOverview());
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(movieAdapter);
    }

    private void getDataFromApi(){
        ApiService.endpoint().getMovie(CATEGORY,API_KEY,LANGUANGE,page)
                .enqueue(new Callback<MainModel>() {
                    @Override
                    public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                        if (response.isSuccessful()){
                            List<MainModel.Result> results = response.body().getResults();
                            Log.d(TAG, results.toString());
                            movieAdapter.setData(results);
                        }

                    }

                    @Override
                    public void onFailure(Call<MainModel> call, Throwable t) {
                        Log.d(TAG, t.toString());

                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() > 1){
                    ApiService.endpoint().getQuery(API_KEY,LANGUANGE,newText,page)
                            .enqueue(new Callback<MainModel>() {
                                @Override
                                public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                                    if (response.isSuccessful()){
                                        List<MainModel.Result> results = response.body().getResults();
                                        Log.d(TAG, results.toString());
                                        movieAdapter.setData(results);
                                    }

                                }

                                @Override
                                public void onFailure(Call<MainModel> call, Throwable t) {
                                    Log.d(TAG, t.toString());

                                }
                            });
                }
                return true;
            }
        });
        getMenuInflater().inflate(R.menu.mode, menu);
        // Change the label of the menu based on the state of the app.
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Check if the correct item was clicked
        if (item.getItemId() == R.id.night_mode) {
        }
        if (item.getItemId() == R.id.night_mode) {
            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //Set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
// Recreate the activity for the theme change to take effect.
            recreate();
        }
        return true;
    }
}