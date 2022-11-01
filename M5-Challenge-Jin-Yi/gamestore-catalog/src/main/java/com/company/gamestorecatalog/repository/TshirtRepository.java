package com.company.gamestorecatalog.repository;


import com.company.gamestorecatalog.model.Tshirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TshirtRepository extends JpaRepository<Tshirt, Long> {
    List<Tshirt> findTShirtByColor(String color);
    List<Tshirt> findTShirtBySize(String size);
}
