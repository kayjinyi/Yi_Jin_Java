package com.company.gamestorecatalog.controller;


import com.company.gamestorecatalog.exception.ResponseStatusException;
import com.company.gamestorecatalog.model.Game;
import com.company.gamestorecatalog.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    GameRepository gameRepo;

    @GetMapping()
    public List<Game> getGames(){
        return gameRepo.findAll();
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable Long id){
        Optional<Game> returnVal = gameRepo.findById(id);
        if(returnVal.isPresent()){
            return returnVal.get();
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "gameId '" + id + "' does not exist");
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Game addGame(@RequestBody @Valid Game game){
        return gameRepo.save(game);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody @Valid Game game){
        gameRepo.save(game);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable Long id){
        Optional<Game> game = gameRepo.findById(id);
        if(game.isPresent()) {
            gameRepo.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "gameId '" + id + "' does not exist");
        }
    }

    @GetMapping("/studio/{studio}")
    public List<Game> getGamesByStudio(@PathVariable String studio){
        return gameRepo.findAllGameByStudio(studio);
    }

    @GetMapping("/esrbRating/{esrbRating}")
    public List<Game> getGamesByEsrbRating(@PathVariable String esrbRating){
        return gameRepo.findAllGameByEsrbRating(esrbRating);
    }

    @GetMapping("/title/{title}")
    public List<Game> getGamesByTitle(@PathVariable String title){
        return gameRepo.findAllGameByTitle(title);
    }






}
