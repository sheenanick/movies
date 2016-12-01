package com.example.guest.android_movies.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guest.android_movies.R;

import butterknife.Bind;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.button) Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadMovieActivity(View v) {
        Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
        startActivity(intent);
    }
}
