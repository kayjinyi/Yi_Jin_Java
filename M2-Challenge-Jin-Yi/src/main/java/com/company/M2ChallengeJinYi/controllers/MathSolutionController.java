package com.company.M2ChallengeJinYi.controllers;

import com.company.M2ChallengeJinYi.models.MathSolution;
import io.swagger.v3.core.util.Json;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.webjars.NotFoundException;

import javax.validation.Valid;


@RestController
public class MathSolutionController {

    private static MathSolution mathSolution= new MathSolution();

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int calculateSum(@RequestBody @Valid int operand1, int operand2){

        return mathSolution.add(operand1, operand2);
    }

}
