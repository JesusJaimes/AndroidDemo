package com.sushi.androidemo.Model;

public class Joke {
    private String id;
    private String text;

    public Joke(String id, String text) {
        this.text = text;
        this.id = id;
    }

    public Joke() {

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
