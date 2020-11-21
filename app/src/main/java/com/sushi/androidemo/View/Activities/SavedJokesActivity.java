package com.sushi.androidemo.View.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.sushi.androidemo.Model.Joke;
import com.sushi.androidemo.R;
import com.sushi.androidemo.View.Adapters.SavedJokesAdapter;
import com.sushi.androidemo.ViewModel.SavedJokesViewModel;

import java.util.ArrayList;
import java.util.List;

public class SavedJokesActivity extends AppCompatActivity {

    Button buttonGoBack;
    RecyclerView jokesList;
    SavedJokesViewModel savedJokesViewModel;
    LinearLayoutManager linearLayoutManager;
    SavedJokesAdapter savedJokesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_jokes);
        setUpButtons();
        initJokeList();
        initSavedJokesViewModel();
    }

    public void setUpButtons() {
        buttonGoBack = findViewById(R.id.goBack);
    }

    public void initJokeList(){
        jokesList = findViewById(R.id.jokes_list);
        linearLayoutManager = new LinearLayoutManager(this);
        savedJokesAdapter = new SavedJokesAdapter(this, new ArrayList<Joke>());
        jokesList.setLayoutManager(linearLayoutManager);
        jokesList.setAdapter(savedJokesAdapter);
    }

    public void initSavedJokesViewModel(){
        savedJokesViewModel = new ViewModelProvider(this).get(SavedJokesViewModel.class);
        savedJokesViewModel.getJokes().observe(this, new Observer<List<Joke>>() {
            @Override
            public void onChanged(List<Joke> jokes) {
                savedJokesAdapter.notifyDataSetChanged();
            }
        });
    }
}