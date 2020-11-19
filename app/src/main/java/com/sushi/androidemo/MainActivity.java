package com.sushi.androidemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonNext;
    Button buttonSave;
    Button buttonGoSaves;
    TextView tvJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpButtons();
        setUpTextViews();
    }

    public void setUpButtons(){
        buttonNext = findViewById(R.id.next);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                changeJoke();
            }
        });

        buttonSave = findViewById(R.id.save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                saveJoke();
            }
        });

        buttonGoSaves = findViewById(R.id.goSaves);
        buttonGoSaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                showSavedJoke();
            }
        });
    }

    public void setUpTextViews(){
        tvJoke = findViewById(R.id.joke);
    }

    public void changeJoke(){
        if(tvJoke.getText().equals("HOLA MUNDO mi amigo del alma")){
            tvJoke.setText("HOLA MUNDO");
        }else{
            tvJoke.setText("HOLA MUNDO mi amigo del alma");
        }
        Log.e("text size", ""+tvJoke.getTextSize());
    }

    public void saveJoke(){

    }

    public void showSavedJoke(){

    }
}