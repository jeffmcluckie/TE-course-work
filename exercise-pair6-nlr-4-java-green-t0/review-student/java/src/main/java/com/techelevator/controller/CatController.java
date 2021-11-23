package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public CatCard getRandomCard() {
        CatCard catCard = new CatCard();
//        List<CatCard> cardList = catCardDao.list();
//        catCard.setCatCardId((long) (cardList.size() + 1));

        CatFact catFact = catFactService.getFact();
        catCard.setCatFact(catFact.getText());
        CatPic catPic = catPicService.getPic();
        catCard.setImgUrl(catPic.getFile());
        return catCard;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CatCard> getAllCatCards() {return catCardDao.list();}

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CatCard getCatCardByID(@PathVariable long id) throws CatCardNotFoundException {
        return catCardDao.get(id);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public void saveCardToCollection(@Valid @RequestBody CatCard catCard) {catCardDao.save(catCard);}

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateCard(@PathVariable long id, @Valid @RequestBody CatCard catCard) throws CatCardNotFoundException {
        catCardDao.update(id, catCard);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteCard(@PathVariable long id) throws CatCardNotFoundException {
        catCardDao.delete(id);
    }
}


