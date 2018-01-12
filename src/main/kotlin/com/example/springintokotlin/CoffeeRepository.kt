package com.example.springintokotlin

import org.springframework.data.repository.CrudRepository

interface CoffeeRepository : CrudRepository<Coffee, String> {
    fun findByType(type: String): Coffee
}
