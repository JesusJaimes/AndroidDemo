package com.sushi.androidemo.ViewModel;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.sushi.androidemo.Model.Joke;
import com.sushi.androidemo.Repositories.JokeRepository;
import java.util.List;

public class JokeListViewModel extends AndroidViewModel {
    private final LiveData<List<Joke>> allJokes;
    JokeRepository repository ;


    public JokeListViewModel(Application application) {
        super(application);
        this.repository = new JokeRepository(application);
        this.allJokes = repository.getAllJokes();
    }

    public LiveData<List<Joke>> getAllJokes() { return allJokes; }

}
