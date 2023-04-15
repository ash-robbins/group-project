package com.techelevator.controller;

import com.techelevator.dao.PrizeDao;
import com.techelevator.dao.PrizeWinnerDao;
import com.techelevator.dao.ReadingActivityDao;
import com.techelevator.model.Prize;
import com.techelevator.model.PrizeWinner;
import com.techelevator.model.ReadingActivity;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@PreAuthorize("isAuthenticated()")
public class ReadingActivityController {

    private ReadingActivityDao readingActivityDao;
    private PrizeDao prizeDao;
    private PrizeWinnerDao prizeWinnerDao;

    public ReadingActivityController(ReadingActivityDao readingActivityDao, PrizeDao prizeDao, PrizeWinnerDao prizeWinnerDao) {
        this.readingActivityDao = readingActivityDao;
        this.prizeDao = prizeDao;
        this.prizeWinnerDao = prizeWinnerDao;
    }

    /**
     *
     *
     * Return Reading Activity
     * @param id reading activity id
     * @return reading activity information
     */
    @RequestMapping(path = "/reading_activity/{id}", method = RequestMethod.GET)
    public ReadingActivity getActivity(@PathVariable int id) {
        ReadingActivity readingActivity = readingActivityDao.getReadingActivity(id);
            if (readingActivity == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to locate Reading Activity.");
            } else {
                return readingActivity;
            }
        }

    /**
     *
     *
     * Return Reading Activity By Book
      * @param bookId book id
     * @return reading information
     */
//     @RequestMapping(path = "/reading_activity/{id}", method = RequestMethod.GET)
//     public ReadingActivity getActivityByBook(@PathVariable int bookId) {
//        ReadingActivity readingActivity = readingActivityDao.getReadingActivityByBookId(bookId);
//        if (readingActivity == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to locate Reading Activity for this Book.");
//        } else {
//            return readingActivity;
//        }
//     }

    /**
     *
     *
     * Return Prize
      * @param id prize id
     * @return prize information
     */
    @RequestMapping(path = "/prize/{id}", method = RequestMethod.GET)
    public Prize getPrize(@PathVariable int id) {
        Prize prize = prizeDao.getPrize(id);
        if (prize == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prize not found.");
        } else {
            return prize;
        }
    }

    /**
     *
     *
     * @param id prize winner id
     * @return prize winner information
     */

    @RequestMapping(path = "/prize_winner{id}", method = RequestMethod.GET)
    public PrizeWinner getWinner(@PathVariable int id) {
        PrizeWinner prizeWinner = prizeWinnerDao.getPrizeWinner(id);
        if (prizeWinner == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prize Winner not found.");
        } else {
            return prizeWinner;
        }
    }
}
