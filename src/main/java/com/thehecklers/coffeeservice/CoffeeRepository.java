package com.thehecklers.coffeeservice;

import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {
    Coffee findByName(String name);
}
