package com.sushi.androidemo.View.ViewHolders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sushi.androidemo.R;

public class JokeViewHolder extends RecyclerView.ViewHolder { private final TextView wordItemView;

    private JokeViewHolder(View itemView) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.jokeItem);
    }

    public void bind(String text) {
        wordItemView.setText(text);
    }

    public static JokeViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.joke_item, parent, false);
        return new JokeViewHolder(view);
    }
}
