package com.sushi.androidemo.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface JokeDao {
    @Query("SELECT * FROM joke_table")
    LiveData<List<Joke>> getAll();


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Joke joke);

    @Delete
    void delete(Joke joke);
}


