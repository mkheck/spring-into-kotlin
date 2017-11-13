package com.example.springintokotlin;

import org.springframework.data.repository.CrudRepository;

public interface DuckRepository extends CrudRepository<Duck, String> {
    Duck findByType(String type);
}
