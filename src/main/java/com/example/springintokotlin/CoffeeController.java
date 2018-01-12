package com.example.springintokotlin;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {
    private final CoffeeRepository coffeeRepository;

    public CoffeeController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @GetMapping
    public Iterable<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Coffee getCoffeeById(@PathVariable String id) {
        return coffeeRepository.findOne(id);
    }

    @GetMapping("/search")
    public Coffee getCoffeeByType(@RequestParam(required = false) String type) {
        if (type == null) {
            return coffeeRepository.findAll().iterator().next();
        } else {
            return coffeeRepository.findByType(type);
        }
    }
}
