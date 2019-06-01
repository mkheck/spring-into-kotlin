package com.thehecklers.coffeeservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {
    private final CoffeeRepository repo;

    public CoffeeController(CoffeeRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    Iterable<Coffee> getAllCoffees() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    Coffee getCoffeeById(@PathVariable String id) {
        return repo.findById(id).get();
    }

    @GetMapping("/search")
    Coffee searchForCoffee(@RequestParam(required = false) String name) {
        if (name == null) {
            return repo.findAll().iterator().next();
        } else {
            return repo.findByName(name);
        }
    }
}
