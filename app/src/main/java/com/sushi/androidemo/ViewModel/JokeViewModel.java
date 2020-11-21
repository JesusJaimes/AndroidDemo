package com.sushi.androidemo.ViewModel;


import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sushi.androidemo.Model.Joke;
import com.sushi.androidemo.Rspositories.JokeRopository;

public class JokeViewModel extends ViewModel {

    private MutableLiveData<Joke> joke;
    private JokeRopository repository;

    public void init(Context context){
        if(joke!=null){
            return;
        }
        repository = JokeRopository.getInstance();
        joke = repository.getJoke(context);
    }

    public LiveData<Joke> getJoke(){
        return joke;
    }

    public void changeJoke(Context context){
        joke = repository.getJoke(context);
    }

    public void saveJoke(){

    }

    public void setNewJoke(){

    }
}
