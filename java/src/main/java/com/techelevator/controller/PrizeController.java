package com.techelevator.controller;

import com.techelevator.dao.PrizeDao;
import com.techelevator.dao.PrizeWinnerDao;
import com.techelevator.dao.ReadingActivityDao;
import com.techelevator.model.Books;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.techelevator.model.Prize;


@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class PrizeController {

    private ReadingActivityDao readingActivityDao;
    private PrizeDao prizeDao;
    private PrizeWinnerDao prizeWinnerDao;

    public PrizeController(ReadingActivityDao readingActivityDao, PrizeDao prizeDao, PrizeWinnerDao prizeWinnerDao) {
        this.readingActivityDao = readingActivityDao;
        this.prizeDao = prizeDao;
        this.prizeWinnerDao = prizeWinnerDao;
    }

//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(path = "/prize", method = RequestMethod.POST)
//    public Prize prize (@RequestBody Prize newPrize) {
//        Prize prizeActivity = prizeDao.createPrize(newPrize);
//        if (prizeActivity == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to locate Reading Activity.");
//        } else {
//            return prizeActivity;
//        }
//    }
}
