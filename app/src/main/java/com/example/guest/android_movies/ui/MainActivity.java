package com.example.guest.android_movies.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.guest.android_movies.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.editText) EditText mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void loadMovieActivity(View v) {
        Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
        String title = mTitle.getText().toString();
        intent.putExtra("title", title);
        startActivity(intent);
    }
}
//// TODO: 12/1/16 kljashdjkfh  
