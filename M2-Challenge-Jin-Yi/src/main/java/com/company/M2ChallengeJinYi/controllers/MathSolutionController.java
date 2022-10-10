package com.company.M2ChallengeJinYi.controllers;

import com.company.M2ChallengeJinYi.models.MathSolution;
import io.swagger.v3.core.util.Json;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.webjars.NotFoundException;

import javax.validation.Valid;


@RestController
public class MathSolutionController {


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Integer calculateSum(@RequestBody @Valid MathSolution mathSolution){

        return mathSolution.add();
    }


    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Integer calculateDifference(@RequestBody @Valid MathSolution mathSolution){

        return mathSolution.subtract();
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Integer calculateProduct(@RequestBody @Valid MathSolution mathSolution){

        return mathSolution.multiply();
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Integer calculateQuotient(@RequestBody @Valid MathSolution mathSolution){
        if(mathSolution.getOperand2() == 0){
            throw new IllegalArgumentException("Zero cannot be denominator");
        }
        return mathSolution.divide();
    }

}
