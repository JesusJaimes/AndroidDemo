package com.sushi.androidemo.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sushi.androidemo.Model.Joke;

import java.util.List;

public class SavedJokesViewModel extends ViewModel {
    private MutableLiveData<List<Joke>> jokes=new MutableLiveData<>();

    public LiveData<List<Joke>> getJokes() {
        return jokes;
    }
}
