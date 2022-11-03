package com.company.gamestorecatalog.controller;

import com.company.gamestorecatalog.model.Console;
import com.company.gamestorecatalog.repository.ConsoleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsoleRepository consoleRepository;
    private ObjectMapper mapper = new ObjectMapper();
    private Console console1;
    private Console console2;
    private Console console3;
    private Console inputConsole;
    private String console1Json;
    private List<Console> allConsoles;
    private List<Console> sameManufacturerConsoles;

    @Before
    public void setUp() throws Exception{
        console1 = new Console(1l, "PS 5", "Sony", "64 GB", "AMD Zen 2", 499.99, 1);
        console2 = new Console(2l, "Xbox One", "Microsoft", "64 GB", "AMD Radeon", 499.99, 1);
        console3 = new Console(3l, "PS 4", "Sony", "32 GB", "Intel i5", 325.99, 2);
        inputConsole = new Console();
        allConsoles = new ArrayList<>();
        allConsoles.add(console1);
        allConsoles.add(console2);
        allConsoles.add(console3);
        sameManufacturerConsoles = new ArrayList<>();
        sameManufacturerConsoles.add(console1);
        sameManufacturerConsoles.add(console3);
        console1Json = mapper.writeValueAsString(console1);
    }

    @Test
    public void shouldReturn200WhenRetrievingAnExistingConsole() throws Exception {
        // Arrange
        doReturn(Optional.of(console1)).when(consoleRepository).findById(1l);

        // Act
        mockMvc.perform(
                        get("/console/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect((content().json(console1Json)));
    }


    @Test
    public void shouldReturn201WhenCreatingANewConsole() throws Exception {
        // Arrange
        inputConsole.setModel("PS 5");
        inputConsole.setManufacturer("Sony");
        inputConsole.setMemoryAmount("64 GB");
        inputConsole.setProcessor("AMD Zen 2");
        inputConsole.setPrice(499.99);
        inputConsole.setQuantity(1);
        String inputJson = mapper.writeValueAsString(inputConsole);
        String outputJson = mapper.writeValueAsString(console1);
        doReturn(console1).when(consoleRepository).save(inputConsole);

        // Act
        mockMvc.perform(
                        post("/console")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated()) // Assert that it return 201 CREATED
                .andExpect(content().json(outputJson)); // Assert expected output
    }

    @Test
    public void shouldReturnAllConsolesAnd200() throws Exception {
        // Arrange
        String outputJson = mapper.writeValueAsString(allConsoles);
        doReturn(allConsoles).when(consoleRepository).findAll();

        // Act
        mockMvc.perform(
                        get("/console"))
                .andDo(print())
                .andExpect(status().isOk()) // Assert return is 200 OK
                .andExpect(content().json(outputJson)); // Assert should return all consoles
    }

    @Test
    public void shouldReturnConsoleWithSameManufacturerAnd200() throws Exception {
        // Arrange
        String outputJson = mapper.writeValueAsString(sameManufacturerConsoles);
        doReturn(sameManufacturerConsoles).when(consoleRepository).findConsoleByManufacturer("sony");

        // Act
        mockMvc.perform(
                        get("/console/manufacturer/sony"))
                .andDo(print())
                .andExpect(status().isOk()) // Assert return is 200 OK
                .andExpect(content().json(outputJson)); // will return consoles with made the the specified manufacturer
    }

    @Test
    public void shouldReturnNoContentWhenUpdatingAConsoleAnd204() throws Exception {
        // Arrange
        inputConsole.setId(1l);
        inputConsole.setModel("PS 5");
        inputConsole.setManufacturer("Sony");
        inputConsole.setMemoryAmount("64 GB");
        inputConsole.setProcessor("AMD Zen 2");
        inputConsole.setPrice(499.99);
        inputConsole.setQuantity(1);
        String inputJson = mapper.writeValueAsString(inputConsole);
        String outputJson = mapper.writeValueAsString(console1);
        doReturn(console1).when(consoleRepository).save(inputConsole);

        // Act
        mockMvc.perform (
                        put("/console")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent()); // Assert return 204 NO_CONTENT
    }

    @Test
    public void shouldReturn204WhenDeletingAnExistingConsole() throws Exception {
        // Arrange
        doReturn(Optional.ofNullable(console1)).when(consoleRepository).findById(1l);

        // Act
        mockMvc.perform(
                        delete("/console/1"))
                .andDo(print())
                .andExpect(status().isNoContent()); // Assert return 204 NO_CONTENT
    }
    @Test
    public void shouldReturn404WhenDeletingNonExistingConsole() throws Exception {
        // Arrange
        doReturn(Optional.ofNullable(null)).when(consoleRepository).findById(134l);

        // Act
        mockMvc.perform(
                        delete("/console/134"))
                .andDo(print())
                .andExpect(status().isNotFound()); // Assert return 404 NOT_FOUND
    }

}