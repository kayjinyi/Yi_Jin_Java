package com.company.M2ChallengeJinYi.controllers;

import com.company.M2ChallengeJinYi.models.MathSolution;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Object mapper = new ObjectMapper();
    private MathSolution mathSolutionT;
    @Before
    public void setUp(){
        mathSolutionT = new MathSolution();
    }
//testing POST /add
//    @Test
//    public void shouldReturnAdditionOnPostRequest() throws Exception {
//
//        // ARRANGE
//        MathSolution mathSolution = new MathSolution();
//        mathSolution.setOperand1(2);
//        mathSolution.setOperand2(3);
//        mathSolution.setOperations("add");
//        mathSolution.setAnswer(5);
//        // Convert Java Object to JSON.
//        String inputJson = mapper.writeValueAsString(mathSolution);
//
////        String outputJson = mapper.writeValueAsString(5);
//
//        // ACT
//        mockMvc.perform(
//                        post("/add")                            // Perform the POST request.
//                                .content(inputJson)                           // Set the request body.
//                                .contentType(MediaType.APPLICATION_JSON)      // Tell the server it's in JSON format.
//                )
//                .andDo(print())                                // Print results to console.
//                .andExpect(status().isCreated());             // ASSERT (status code is 201)
////                .andExpect(content().json(outputJson));
//    }

//    @Test
//    public void shouldReturn422StatusCodeIfRequestBodyIsInvalid() throws Exception {
//        Record inputRecord = new Record();
//        inputRecord.setArtist("William Joel");
//        inputRecord.setAlbum("The Stranger");
//        inputRecord.setId(2);
//
//        String inputJson = mapper.writeValueAsString(inputRecord);
//
//        mockMvc.perform(
//                        put("/records/2")
//                                .content(inputJson)
//                                .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andDo(print())
//                .andExpect(status().isUnprocessableEntity());
//    }

//testing POST /subtract
    //testing POST /multiply
    //testing POST /divide

}