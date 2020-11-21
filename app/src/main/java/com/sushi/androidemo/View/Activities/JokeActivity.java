package com.sushi.androidemo.View.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sushi.androidemo.Model.Joke;
import com.sushi.androidemo.R;
import com.sushi.androidemo.ViewModel.JokeViewModel;

public class JokeActivity extends AppCompatActivity {

    Button buttonNext;
    Button buttonSave;
    Button buttonOpenSaveJokes;
    TextView tvJoke;
    JokeViewModel jokeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        setUpButtons();
        setUpTextViews();
        initJokeViewModel();
    }

    public void setUpButtons(){
        buttonNext = findViewById(R.id.next);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                jokeViewModel.changeJoke(getApplication());
            }
        });

        buttonSave = findViewById(R.id.save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                jokeViewModel.saveJoke();
            }
        });

        buttonOpenSaveJokes = findViewById(R.id.openSaveJokes);
        buttonOpenSaveJokes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                openSavedJokes();
            }
        });
    }

    public void setUpTextViews(){
        tvJoke = findViewById(R.id.joke);
    }

    public void initJokeViewModel(){
        jokeViewModel = new ViewModelProvider(this).get(JokeViewModel.class);
        jokeViewModel.init(this);
        final Observer<Joke> joke = new Observer<Joke>(){
            @Override
            public void onChanged(Joke joke) {
                Log.e("joke", "-------"+joke.getText());
                tvJoke.setText(joke.getText());
            }
        };
        jokeViewModel.getJoke().observe(this, joke);
    }

    public void openSavedJokes(){
        Intent intent = new Intent(this, SavedJokesActivity.class);
        startActivity(intent);
    }
}