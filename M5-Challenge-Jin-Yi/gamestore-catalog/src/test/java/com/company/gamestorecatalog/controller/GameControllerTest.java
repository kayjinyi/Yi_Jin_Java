package com.company.gamestorecatalog.controller;

import com.company.gamestorecatalog.model.Game;
import com.company.gamestorecatalog.repository.GameRepository;
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

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameRepository gameRepo;
    private ObjectMapper mapper = new ObjectMapper();
    private Game game1;
    private String game1Json;
    private String game2Json;
    private List<Game> allGames = new ArrayList<>();
    private List<Game> allGames2 = new ArrayList<>();
    private String allGamesJson;
    private String allGamesJson2;

    @Before
    public void setup() throws Exception {
        game1 = new Game();
        game1.setId(1l);
        game1.setTitle("starArcade");
        game1.setEsrbRating("TEEN");
        game1.setDescription("space game for star citizen");
        game1.setPrice(15.99);
        game1.setStudio("dreamWorks");
        game1.setQuantity(200);

        game1Json = mapper.writeValueAsString(game1);

        Game game2 = new Game();
        game2.setId(2l);
        game2.setTitle("photoEditing");
        game2.setEsrbRating("TEEN");
        game2.setDescription("photo editing");
        game2.setPrice(14.99);
        game2.setStudio("Soul");
        game2.setQuantity(200);

        game2Json = mapper.writeValueAsString(game2);
        Game game3 = new Game();
        game3.setId(3l);
        game3.setTitle("photoEditing");
        game3.setEsrbRating("TEEN");
        game3.setDescription("photo editing");
        game3.setPrice(14.99);
        game3.setStudio("Soul");
        game3.setQuantity(200);

        game2Json = mapper.writeValueAsString(game2);

        allGames.add(game1);
        allGames.add(game2);
        allGames.add(game3);

        allGames2.add(game2);
        allGames2.add(game3);
        allGamesJson = mapper.writeValueAsString(allGames);
        allGamesJson2 = mapper.writeValueAsString(allGames2);
    }

    @Test
    public void shouldCreateNewGameOnPostingRequest() throws Exception {
        Game inputGame = new Game();
        inputGame.setId(1l);
        inputGame.setTitle("starArcade");
        inputGame.setEsrbRating("TEEN");
        inputGame.setDescription("space game for star citizen");
        inputGame.setPrice(15.99);
        inputGame.setStudio("dreamWorks");
        inputGame.setQuantity(200);
        String inputGameJson = mapper.writeValueAsString(inputGame);

        doReturn(game1).when(gameRepo).save(inputGame);

        mockMvc.perform(
                        post("/game")
                                .content(inputGameJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().json(game1Json));
    }

    @Test
    public void shouldReturnGameById() throws Exception {
        doReturn(Optional.of(game1)).when(gameRepo).findById(1l);

        ResultActions result = mockMvc.perform(
                        get("/game/1")
                )
                .andExpect(status().isOk())
                .andExpect((content().json(game1Json)));
    }


    @Test
    public void shouldReturnAllGames() throws Exception {

        doReturn(allGames).when(gameRepo).findAll();

        mockMvc.perform(
                        get("/game")
                )
                .andExpect(status().isOk())
                .andExpect(content().json(allGamesJson));
    }

    @Test
    public void shouldUpdateReturn204StatusCode() throws Exception {
        mockMvc.perform(
                        put("/game")
                                .content(game2Json)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
        // Arrange
        doReturn(Optional.ofNullable(game1)).when(gameRepo).findById(1l);

        // Act
        mockMvc.perform(
                        delete("/game/1"))
                .andDo(print())
                .andExpect(status().isNoContent()); // Assert return 204 NO_CONTENT

    }

    @Test
    public void shouldReturnAllGameByStudio() throws Exception {
        doReturn(allGames2).when(gameRepo).findAllGameByStudio("Soul");

        mockMvc.perform(
                        get("/game/studio/Soul"))
                .andExpect(status().isOk())
                .andExpect(content().json(allGamesJson2)
                );
    }

    @Test
    public void shouldReturnAllGameByEsrbRating() throws Exception {
        doReturn(allGames2).when(gameRepo).findAllGameByEsrbRating("TEEN");

        mockMvc.perform(
                        get("/game/esrbRating/TEEN"))
                .andExpect(status().isOk())
                .andExpect(content().json(allGamesJson2)
                );
    }

    @Test
    public void shouldReturnAllGameByTITLE() throws Exception {
        doReturn(allGames2).when(gameRepo).findAllGameByTitle("starArcade");

        mockMvc.perform(
                        get("/game/title/starArcade"))
                .andExpect(status().isOk())
                .andExpect(content().json(allGamesJson2)
                );

    }
}