package com.company.gamestorecatalog.repository;

import org.springframework.stereotype.Repository;
import com.company.gamestorecatalog.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
   List<Game> findAllGameByStudio(String studio);
   List<Game> findAllGameByEsrbRating(String esrbRating);
   List<Game> findAllGameByTitle(String title);
}
