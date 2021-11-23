package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Lyrics {

    @JsonProperty("lyrics")
    private String text;

    public Lyrics() {}

    public Lyrics(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
