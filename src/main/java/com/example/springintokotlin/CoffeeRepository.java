package com.example.springintokotlin;

import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {
    Coffee findByType(String type);
}
