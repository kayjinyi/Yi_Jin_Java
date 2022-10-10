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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();
    private MathSolution mathSolution;

    @Before
    public void setUp(){
        mathSolution = new MathSolution();
    }
//testing POST /add
    @Test
    public void shouldReturnAdditionOnPostRequest() throws Exception {

        // ARRANGE
        mathSolution.setOperand1(2);
        mathSolution.setOperand2(3);
        mathSolution.setAnswer(5);
        String inputJson = mapper.writeValueAsString(mathSolution);

        // ACT
        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)      // Tell the server it's in JSON format.
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isCreated());// ASSERT (status code is 201)

    }
//
//    @Test
//    public void shouldReturn422StatusCodeIfRequestBodyIsInvalid() throws Exception {
//
//
//        String inputJson = mapper.writeValueAsString(mathSolution);
//
//        mockMvc.perform(
//                        put("/add")
//                                .content(mathSolution("a",2))
//                                .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andDo(print())
//                .andExpect(status().isUnprocessableEntity());
//    }

//testing POST /subtract
    @Test
    public void shouldReturnDifferenceOnPostRequest() throws Exception {

        // ARRANGE
        mathSolution.setOperand1(2);
        mathSolution.setOperand2(3);
        mathSolution.setAnswer(-1);
        String inputJson = mapper.writeValueAsString(mathSolution);

        // ACT
        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)      // Tell the server it's in JSON format.
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isCreated());// ASSERT (status code is 201)

    }
    //testing POST /multiply
    @Test
    public void shouldReturnProductOnPostRequest() throws Exception {

        // ARRANGE
        mathSolution.setOperand1(2);
        mathSolution.setOperand2(3);
        mathSolution.setAnswer(6);
        String inputJson = mapper.writeValueAsString(mathSolution);

        // ACT
        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)      // Tell the server it's in JSON format.
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isCreated());// ASSERT (status code is 201)

    }
    //testing POST /divide
    @Test
    public void shouldReturnQuotientOnPostRequest() throws Exception {

        // ARRANGE
        mathSolution.setOperand1(2);
        mathSolution.setOperand2(3);
        mathSolution.setAnswer(0);
        String inputJson = mapper.writeValueAsString(mathSolution);

        // ACT
        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)      // Tell the server it's in JSON format.
                )
                .andDo(print())                                // Print results to console.
                .andExpect(status().isCreated());// ASSERT (status code is 201)

    }
    @Test
    public void shouldReturn422StatusCodeIfDenominatorIsZero() throws Exception {

        mathSolution.setOperand1(9);
        mathSolution.setOperand2(0);
        String inputJson = mapper.writeValueAsString(mathSolution);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

}