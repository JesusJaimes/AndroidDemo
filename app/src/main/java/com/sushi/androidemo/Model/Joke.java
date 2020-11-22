package com.sushi.androidemo.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "joke_table")
public class Joke {
    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name = "joke")
    private String text;

    public Joke(String id, String text) {
        this.text = text;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
