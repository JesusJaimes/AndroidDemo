package com.sushi.androidemo.View.Adapters;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.sushi.androidemo.Model.Joke;
import com.sushi.androidemo.View.ViewHolders.JokeViewHolder;


public class JokesListAdapter extends ListAdapter<Joke, JokeViewHolder> {

    public JokesListAdapter(@NonNull DiffUtil.ItemCallback<Joke> diffCallback) {
        super(diffCallback);
    }

    @Override
    public JokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return JokeViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(JokeViewHolder holder, int position) {
        Joke current = getItem(position);
        holder.bind(current.getText());
    }

    public static class JokeDiff extends DiffUtil.ItemCallback<Joke> {

        @Override
        public boolean areItemsTheSame(@NonNull Joke oldItem, @NonNull Joke newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Joke oldItem, @NonNull Joke newItem) {
            return oldItem.getText().equals(newItem.getText());
        }
    }
}