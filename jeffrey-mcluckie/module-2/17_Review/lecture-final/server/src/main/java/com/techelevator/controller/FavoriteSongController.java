package com.techelevator.controller;

import com.techelevator.dao.FavoriteSongDao;
import com.techelevator.model.FavoriteSong;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
// All request paths in this controller will start with /song
@RequestMapping("/song")

// All requests to this controller must be authenticated, unless noted on the request below
@PreAuthorize("isAuthenticated()")
public class FavoriteSongController {

    private FavoriteSongDao favoriteSongDao;

    public FavoriteSongController(FavoriteSongDao favoriteSongDao){
        this.favoriteSongDao = favoriteSongDao;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    // Spring sets up the Principal for us, because we pass it into our request method
    // We don't have to do anything else for this to work (no annotation on principal)
    public List<FavoriteSong> getAllFavorites(Principal principal) {

        // If you wanted to do custom exceptions, could do that here, but
        // doesn't really make sense for this GET all
        return favoriteSongDao.getAllSongs(principal.getName());
    }
}
