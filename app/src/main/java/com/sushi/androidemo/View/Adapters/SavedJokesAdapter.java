package com.sushi.androidemo.View.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sushi.androidemo.Model.Joke;
import com.sushi.androidemo.R;

import java.util.ArrayList;

public class SavedJokesAdapter extends RecyclerView.Adapter<SavedJokesAdapter.SavedJokesViewHolder>  {

    private ArrayList<Joke> jokes;
    private Context context;

    public SavedJokesAdapter(Context context, ArrayList<Joke> jokes) {
        this.jokes = jokes;
        this.context = context;
    }

    public static class SavedJokesViewHolder extends RecyclerView.ViewHolder {
        public View itemJoke;

        public SavedJokesViewHolder(View item) {
            super(item);
            this.itemJoke = item;
        }
    }


    @NonNull
    @Override
    public SavedJokesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View jokeItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.joke_item, parent, false);
        return new SavedJokesViewHolder(jokeItem);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedJokesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
