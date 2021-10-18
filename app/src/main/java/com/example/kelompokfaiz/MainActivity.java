package com.example.kelompokfaiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import com.example.kelompokfaiz.rest.ApiEndpoint;
import com.example.kelompokfaiz.rest.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private MovieAdapter movieAdapter;
    private SearchView searchView;
    ApiEndpoint endpoint;
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
        movieAdapter = new MovieAdapter(results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(movieAdapter);
    }

    private void getDataFromApi(){
        ApiService.endpoint().getMovie()
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
}