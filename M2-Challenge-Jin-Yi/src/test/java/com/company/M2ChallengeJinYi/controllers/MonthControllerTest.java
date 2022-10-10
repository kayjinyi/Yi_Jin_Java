package com.company.M2ChallengeJinYi.controllers;

import com.company.M2ChallengeJinYi.models.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.platform.commons.function.Try;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthController.class)
public class MonthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    // 1. testing GET /month/{monthNumber} for successful response
    @Test
    public void shouldReturnMonthByNumber() throws Exception{

        Month outputMonth = new Month(5, "May");

        String outputJson = mapper.writeValueAsString(outputMonth);


        mockMvc.perform(get("/month/5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
    // 2. testing GET /month/{monthNumber} input out of range
//    Try record
//    public void shouldReturn404StatusCodeIfRecordNotFound() throws Exception {
//        mockMvc.perform(get("/month/-1"))
//                .andDo(print())
//                .andExpect(status().isUnprocessableEntity());
//    }
//    public void shouldReturn404StatusCodeIfRecordNotFound2() throws Exception {
//        mockMvc.perform(get("/month/15"))
//                .andDo(print())
//                .andExpect(status().isUnprocessableEntity());
//    }


// 3. testing GET /randomMonth MockMVC test for successful response.
    @Test
    public void shouldReturnRandomMonth() throws Exception {

    // ARRANGE and ACT
    mockMvc.perform(get("/randomMonth"))
            .andDo(print())
            .andExpect(status().isOk());
    }
// 4. Months are served at random.see folder models/MonthTest
}