package com.company.gamestorecatalog.repository;


import com.company.gamestorecatalog.model.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ConsoleRepository extends JpaRepository<Console, Long> {
    List<Console> findConsoleByManufacturer(String manufacturer);
}
