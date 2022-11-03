package com.company.gamestorecatalog.controller;

import com.company.gamestorecatalog.exception.ResponseStatusException;
import com.company.gamestorecatalog.model.Tshirt;
import com.company.gamestorecatalog.repository.TshirtRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TShirtController.class)

public class TShirtControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TshirtRepository tshirtRepository;

    private ObjectMapper mapper = new ObjectMapper();

    private Tshirt inputTshirt1;
    private Tshirt outputTshirt1;
    private Tshirt inputTshirt2;
    private Tshirt outputTshirt2;
    private Tshirt inputTshirt3;
    private Tshirt outputTshirt3;

    private List<Tshirt> tshirtList;
    private List<Tshirt> tshirtListByColor;
    private List<Tshirt> tshirtListBySize;

    private String inputJson;
    private String outputJson;

    @Before
    public void setUp() throws Exception {
        inputTshirt1 = new Tshirt(null,"XS", "red", "Plain", 20.00, 100);
        outputTshirt1 = new Tshirt(1l,"XS", "red", "Plain", 20.00, 100);

        inputTshirt2 = new Tshirt(null,"M", "white", "Nike Logo", 30.00, 100);
        outputTshirt2 = new Tshirt(31l,"M", "white", "Nike Logo", 30.00, 100);

        inputTshirt3 = new Tshirt(null,"XS", "white", "Prada", 150.00, 100);
        outputTshirt3 = new Tshirt(101l,"XS", "white", "Prada", 150.00, 100);

        tshirtList = new ArrayList<>(Arrays.asList(
                outputTshirt1,
                outputTshirt2,
                outputTshirt3
        ));

        tshirtListByColor = new ArrayList<>(Arrays.asList(
                outputTshirt2,
                outputTshirt3
        ));

        tshirtListBySize = new ArrayList<>(Arrays.asList(
                outputTshirt1,
                outputTshirt3
        ));
    }

    // ------------ MockMVC test for successful response ---------------
    // -----------------------------------------------------------------

    @Test
    public void shouldReturnOneTshirtAfterPostMethod() throws Exception {
        doReturn(outputTshirt2).when(tshirtRepository).save(inputTshirt2);

        inputJson = mapper.writeValueAsString(inputTshirt2);
        outputJson = mapper.writeValueAsString(outputTshirt2);

        mockMvc.perform(post("/tshirt")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturnAllTshirts() throws Exception {
        doReturn(tshirtList).when(tshirtRepository).findAll();
        outputJson = mapper.writeValueAsString(tshirtList);

        mockMvc.perform(get("/tshirt"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturnOneTshirt() throws Exception {
        doReturn(Optional.of(outputTshirt2)).when(tshirtRepository).findById(31l);
        outputJson = mapper.writeValueAsString(outputTshirt2);

        mockMvc.perform(get("/tshirt/31"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldUpdateTshirtAfterPutMethod() throws Exception {
        inputJson = mapper.writeValueAsString(inputTshirt1);

        mockMvc.perform(put("/tshirt")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteTshirtAfterDeleteMethod() throws Exception {
        doReturn(Optional.ofNullable(outputTshirt1)).when(tshirtRepository).findById(1l);

        mockMvc.perform(
                        delete("/tshirt/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

//    @Test
//    public void shouldReturnAllTshirtsByColor() throws Exception {
//        doReturn(tshirtListByColor).when(tshirtRepository).findTShirtByColor("white");
//        outputJson = mapper.writeValueAsString(tshirtListByColor);
//
//        mockMvc.perform(get("/t-shirt/color/white"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json(outputJson));
//    }

    @Test
    public void shouldReturnAllTshirtsBySize() throws Exception {
        doReturn(tshirtListBySize).when(tshirtRepository).findTShirtBySize("XS");
        outputJson = mapper.writeValueAsString(tshirtListBySize);

        mockMvc.perform(get("/tshirt/size/XS"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

//     -------------- MockMVC test for invalid request -----------------
//     -----------------------------------------------------------------
    @Test
    public void shouldReturn422ForInvalidInputForTshirtModel() throws Exception {
        Map<String, String> inputMap = new HashMap<>();
        String inputMapJson;

        inputMap.put("size", "XS");
        inputMap.put("color", "red");
        inputMap.put("description", "Plain");
        inputMap.put("quantity", "a");
        inputMap.put("price", "-2.00");

        inputMapJson = mapper.writeValueAsString(inputMap);

        mockMvc.perform(post("/tshirt")
                        .content(inputMapJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturn422ForMissingInputForTshirtModel() throws Exception {
        inputTshirt1.setSize(null);

        inputJson = mapper.writeValueAsString(inputTshirt1);

        mockMvc.perform(post("/tshirt")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }


}