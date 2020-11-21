package com.sushi.androidemo.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.sushi.androidemo.R;

public class SavedJokesActivity extends AppCompatActivity {

    RecyclerView jokesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_jokes);

        jokesList.findViewById(R.id.jokes_list);
        jokesList.setLayoutManager(new LinearLayoutManager(this));
        jokesList.setAdapter(new SavedJokesAdapter());


    }
}