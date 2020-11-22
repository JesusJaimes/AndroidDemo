package com.sushi.androidemo.Repositories;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.sushi.androidemo.Model.Joke;
import com.sushi.androidemo.Model.JokeDao;
import com.sushi.androidemo.Utils.AppDatabase;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JokeRepository {

    private JokeDao jokeDao;
    private LiveData<List<Joke>> allJokes;

    public JokeRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        jokeDao = db.jokeDao();
        allJokes = jokeDao.getAll();
    }

    public void setNewJoke (final MutableLiveData<Joke> joke, Context context){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://icanhazdadjoke.com";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            joke.setValue(new Joke(response.getString("id"), response.getString("joke")));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            joke.setValue(new Joke("none", "error :("));
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                joke.setValue(new Joke("none", "error :("));
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Accept", "application/json");
                return params;
            }
        };
        queue.add(jsonObjectRequest);
    }

    public LiveData<List<Joke>> getAllJokes() {
        return allJokes;
    }

    public void insert(Joke joke) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            jokeDao.insert(joke);
        });
    }

}
