package com.sushi.androidemo.View.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                changeJoke();
            }
        });

        buttonSave = findViewById(R.id.save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                saveJoke();
            }
        });

        buttonOpenSaveJokes = findViewById(R.id.openSaveJokes);
        buttonOpenSaveJokes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                openSavedJokesActivity();
            }
        });
    }

    public void setUpTextViews(){
        tvJoke = findViewById(R.id.joke);
    }

    public void initJokeViewModel(){
        jokeViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(JokeViewModel.class);
        jokeViewModel.getJoke().observe(this, joke -> {
            if(joke!=null){
                tvJoke.setText(joke.getText());
            }
        });
        jokeViewModel.setNewJoke(this);
    }

    public void changeJoke(){
        jokeViewModel.setNewJoke(this);
    }

    public void saveJoke(){
        jokeViewModel.saveJoke();
    }

    public void openSavedJokesActivity(){
        Intent intent = new Intent(this, JokesListActivity.class);
        startActivity(intent);
    }
}