package com.company.gamestorecatalog.controller;


import com.company.gamestorecatalog.exception.ResponseStatusException;
import com.company.gamestorecatalog.model.Tshirt;
import com.company.gamestorecatalog.repository.TshirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tshirt")
public class TShirtController {

    @Autowired
    TshirtRepository tshirtRepository;
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getAllTshirt() {
        return tshirtRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tshirt getTshirt(@PathVariable Long id) {
        Optional<Tshirt> returnVal = tshirtRepository.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "tShirtId '" + id + "' does not exist");
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Tshirt addTshirt(@RequestBody @Valid Tshirt tshirt) {
        return tshirtRepository.save(tshirt);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTshirt(@RequestBody @Valid Tshirt tshirt) {
        tshirtRepository.save(tshirt);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable Long id) {
        Optional<Tshirt> shirt = tshirtRepository.findById(id);
        if(shirt.isPresent()) {
            tshirtRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "tShirtId '" + id + "' does not exist");
        }
    }

    @GetMapping("/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getAllTshirtByColor(@PathVariable String color) {
        return tshirtRepository.findTShirtByColor(color);
    }

    @GetMapping("/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getAllTshirtBySize(@PathVariable String size) {
        return tshirtRepository.findTShirtBySize(size);
    }
}
