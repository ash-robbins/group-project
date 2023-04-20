package com.techelevator.controller;

import com.techelevator.dao.PrizeDao;
import com.techelevator.dao.PrizeWinnerDao;
import com.techelevator.dao.ReadingActivityDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Books;
import com.techelevator.model.WinningUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.techelevator.model.Prize;

import javax.validation.Valid;
import java.security.Principal;


@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class PrizeController {

    private ReadingActivityDao readingActivityDao;
    private PrizeDao prizeDao;
    private PrizeWinnerDao prizeWinnerDao;
    private UserDao userDao;

    public PrizeController(ReadingActivityDao readingActivityDao, PrizeDao prizeDao, PrizeWinnerDao prizeWinnerDao, UserDao userDao) {
        this.readingActivityDao = readingActivityDao;
        this.prizeDao = prizeDao;
        this.prizeWinnerDao = prizeWinnerDao;
        this.userDao = userDao;
    }

    //************************ THIS METHOD DECLARES THE WINNER IN PAGES OF FAMILY MEMBERS OF A USER *****************************

    @RequestMapping(path="/prizewinner", method=RequestMethod.GET)
    public WinningUserDto getWinnerFamilyMember(Principal principal){
        int loggedInUserId = userDao.findIdByUsername(principal.getName());
        return prizeWinnerDao.selectWinningFamilyMember(loggedInUserId);
    }









    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/prize", method = RequestMethod.POST)
    public Prize prize (@RequestBody Prize newPrize) {
        Prize prizeActivity = prizeDao.createPrize(newPrize);
        if (prizeActivity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to locate Reading Activity.");
        } else {
            return prizeActivity;
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
     * update prize
     * @param prize
     * @param id prize id
     * @return updated prize
     */
    @RequestMapping(path = "update/prize/{id}", method = RequestMethod.PUT)
    public Prize updatePrize(@Valid @RequestBody Prize prize, @PathVariable int id) {
        Prize updatedPrize = prizeDao.editPrize(prize, id);
        if (updatedPrize == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prize not found.");
        } else {
            return updatedPrize;
        }
    }

    /**
     *
     * deletes prize by pride id
     * @param id prize id
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "delete/prize/{id}", method = RequestMethod.DELETE)
    public void deletePrize(@PathVariable int id) {
        prizeDao.removePrize(id);
    }
}
