package com.techelevator.controller;

import com.techelevator.dao.ReadingActivityDao;
import com.techelevator.model.ReadingActivity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ReadingActivityController {

    private ReadingActivityDao readingActivityDao;

    public ReadingActivityController(ReadingActivityDao readingActivityDao) {
        this.readingActivityDao = readingActivityDao;
    }

    /**
     *
     * Return Reading Activity
     * @param id reading activity id
     * @return reading activity information
     */
    @RequestMapping(path = "/reading_activity/{id}", method = RequestMethod.GET)
    public ReadingActivity get(@PathVariable int id) {
        ReadingActivity readingActivity = readingActivityDao.getReadingActivity(id);
            if (readingActivity == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to locate Reading Activity.");
            } else {
                return readingActivity;
            }
        }

}
