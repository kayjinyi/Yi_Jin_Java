package com.company.M2ChallengeJinYi.controllers;

import com.company.M2ChallengeJinYi.models.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class MonthController {
    private static List<Month> MonthList = new ArrayList<>(Arrays.asList(
            new Month(1, "January"),
            new Month(2, "February"),
            new Month(3, "March"),
            new Month(4, "April"),
            new Month(5, "May"),
            new Month(6, "June"),
            new Month(7, "July"),
            new Month(8, "August"),
            new Month(9, "September"),
            new Month(10, "October"),
            new Month(11, "November"),
            new Month(12, "December")

    ));

    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Month getMonth(@PathVariable @Valid  int monthNumber){
        Month returnedMonth = null;

        for(Month month: MonthList) {
            if (month.getNumber() == monthNumber) {
                returnedMonth = month;
                break;
            }
        }
        if (returnedMonth == null) {
            throw new IllegalArgumentException("There are only 12 months");
        }

        return returnedMonth;
    }

    @RequestMapping(value = "/randomMonth", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Month getRandomMonth(){
        Month monthRandom = new Month();
        int randomMonthGot = monthRandom.randomMonth();
        Month returnedMonth = null;

        for(Month month: MonthList) {
            if (month.getNumber() == randomMonthGot) {
                returnedMonth = month;
                break;
            }
        }

        if (returnedMonth == null) {
            throw new IllegalArgumentException("Months not found");
        }
        return returnedMonth;
    }

}
