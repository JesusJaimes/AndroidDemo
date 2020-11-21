package com.sushi.androidemo.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sushi.androidemo.R;

public class SavedJokesAdapter extends RecyclerView.Adapter<SavedJokesAdapter.SavedJokesViewHolder>  {

    private String[] jokes;

    public SavedJokesAdapter(String[] jokes) {
        this.jokes = jokes;
    }

    public static class SavedJokesViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View itemJoke;

        public SavedJokesViewHolder(View item) {
            super(item);
            itemJoke = item;
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
