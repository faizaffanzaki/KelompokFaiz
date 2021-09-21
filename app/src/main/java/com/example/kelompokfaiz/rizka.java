package com.example.kelompokfaiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class rizka extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rizka);
        int SPLASH_SCREEN_TIME = 5000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(rizka.this, MainActivity.class);
                rizka.this.startActivity(intent);
                rizka.this.finish();
            }
        }, SPLASH_SCREEN_TIME);
    }
}