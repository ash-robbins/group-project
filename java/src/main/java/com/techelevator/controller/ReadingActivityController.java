package com.techelevator.controller;

import com.techelevator.dao.PrizeDao;
import com.techelevator.dao.PrizeWinnerDao;
import com.techelevator.dao.ReadingActivityDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Prize;
import com.techelevator.model.PrizeWinner;
import com.techelevator.model.ReadingActivity;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class ReadingActivityController {

    private ReadingActivityDao readingActivityDao;
    private PrizeDao prizeDao;
    private PrizeWinnerDao prizeWinnerDao;
    private UserDao userDao;

    public ReadingActivityController(ReadingActivityDao readingActivityDao, PrizeDao prizeDao, PrizeWinnerDao prizeWinnerDao, UserDao userDao) {
        this.readingActivityDao = readingActivityDao;
        this.prizeDao = prizeDao;
        this.prizeWinnerDao = prizeWinnerDao;
        this.userDao = userDao;
    }

    /**
     *
     *add reading activity
     *
     * @param readingActivity
     * @return
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/addReadingActivity", method = RequestMethod.POST)
    public ReadingActivity addReadingActivity(@Valid @RequestBody ReadingActivity readingActivity) {
        return readingActivityDao.createReadingActivity(readingActivity);
    }

    /**
     *
     *
     * Return Reading Activity
     * @param id reading activity id
     * @return reading activity information
     */
    @RequestMapping(path = "/books/reading_activity/{id}", method = RequestMethod.GET)
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
     @RequestMapping(path = "/reading_activity/books/{book_id}", method = RequestMethod.GET)
     public ReadingActivity getActivityByBook(@PathVariable int bookId) {
        ReadingActivity readingActivity = readingActivityDao.getReadingActivityByBookId(bookId);
        if (readingActivity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to locate Reading Activity for this Book.");
        } else {
            return readingActivity;
        }
     }

    /**
     *
     * return list of logged users reading activity
     *
     * @param principal
     * @return
     */
    @RequestMapping(path = "reading_activity/list", method = RequestMethod.GET)
     public List<ReadingActivity> listReadingActivityByLoggedInUser(Principal principal) {
         int loggedInUserId = userDao.findIdByUsername(principal.getName());
         List<ReadingActivity> readingList = readingActivityDao.getReadingActivitiesByUserId(loggedInUserId);
         if (readingList == null) {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reading Activity List not found.");
         } else {
             return readingList;
         }
     }
     

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

<<<<<<< HEAD
    // add put method to update reading activity ...
}
=======

    /**

     Create Prize
     @param prize the prize to create
     @return the created prize
     */
    @RequestMapping(path = "/prize", method = RequestMethod.POST)
    public Prize createPrize(@RequestBody Prize prize) {
        Prize createdPrize = prizeDao.createPrize(prize);
        if (createdPrize == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating prize.");
        } else {
            return createdPrize;
        }
    }
    /**

     Delete Prize
     @param id the id of the prize to delete
     */
    @RequestMapping(path = "/prize/{id}", method = RequestMethod.DELETE)
    public void removePrize(@PathVariable int id) {
        boolean success = prizeDao.removePrize(id);
        if (!success) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prize not found.");
        }

    }
}
>>>>>>> 010f8f658a8697bb9574cd5c181b5e126ef822f3
