package com.sushi.androidemo.Rspositories;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sushi.androidemo.Model.Joke;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JokeRopository {

    public static JokeRopository instance;
    private Joke newJoke = new Joke();

    public static JokeRopository getInstance() {
        if(instance == null){
            instance = new JokeRopository();
        }
        return instance;
    }

    public MutableLiveData<Joke> getJoke(Context context){
        setJoke(context);
        MutableLiveData<Joke> joke = new MutableLiveData<>();
        joke.setValue(newJoke);
        return joke;
    }

    private void setJoke(Context context){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://icanhazdadjoke.com";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.e("response", response.toString());
                            Log.e("id", response.get("id").toString());
                            Log.e("joke", response.getString("joke"));
                            newJoke.setText(response.getString("joke"));
                            newJoke.setId(response.getString("id"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            newJoke.setText("error joke :(");
                            newJoke.setId("none");
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        newJoke.setText("error joke :(");
                        newJoke.setId("none");
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
}
