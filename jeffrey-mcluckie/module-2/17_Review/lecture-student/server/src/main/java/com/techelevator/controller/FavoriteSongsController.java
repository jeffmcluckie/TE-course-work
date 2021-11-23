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
@RequestMapping("/song")
@PreAuthorize("isAuthenticated()")
public class FavoriteSongsController {

    private FavoriteSongDao favoriteSongDao;

    public FavoriteSongsController(FavoriteSongDao favoriteSongDao){
        this.favoriteSongDao = favoriteSongDao;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<FavoriteSong> getAllFavorites(Principal principal){
        List<FavoriteSong> list = new ArrayList<>();
        list = favoriteSongDao.getAllSongs(principal.getName());
        return list;
    }
}
