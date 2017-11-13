package com.example.springintokotlin;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ducks")
public class DuckController {
    private final DuckRepository duckRepository;

    public DuckController(DuckRepository duckRepository) {
        this.duckRepository = duckRepository;
    }

    @GetMapping
    public Iterable<Duck> getAllDucks() {
        return duckRepository.findAll();
    }

    @GetMapping("/{id}")
    public Duck getDuckById(@PathVariable String id) {
        return duckRepository.findOne(id);
    }

    @GetMapping("/search")
    public Duck getDuckByType(@RequestParam(required = false) String type) {
        if (type == null) {
            return duckRepository.findAll().iterator().next();
        } else {
            return duckRepository.findByType(type);
        }
    }
}
