package com.sushi.androidemo.ViewModel;


import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.sushi.androidemo.Model.Joke;
import com.sushi.androidemo.Repositories.JokeRepository;

import java.util.List;

public class JokeViewModel extends AndroidViewModel {

    private MutableLiveData<Joke> joke;
    private final LiveData<List<Joke>> allJokes;
    JokeRepository repository ;


    public JokeViewModel(Application application) {
        super(application);
        this.repository = new JokeRepository(application);
        this.joke = new MutableLiveData<>();
        this.allJokes = repository.getAllJokes();
    }

    public LiveData<Joke> getJoke() {
        return this.joke;
    }

    public void setNewJoke(Context context){
        this.repository.setNewJoke(joke, context);
    }

    public LiveData<List<Joke>> getAllJokes() { return allJokes; }

    public void saveJoke(){
        Joke joke = this.joke.getValue();
        this.repository.insert(joke);
    }
}
