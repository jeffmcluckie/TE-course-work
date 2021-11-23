package com.techelevator.services;

import com.techelevator.model.Lyrics;

public interface LyricsService {

    // Note: Using a Lyrics object for return even though it is just a String for
    // extensibility later and abstraction.
    Lyrics getLyrics(String artist, String songTitle);
}
