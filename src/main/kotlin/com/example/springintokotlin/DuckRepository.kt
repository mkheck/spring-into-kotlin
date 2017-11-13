package com.example.springintokotlin

import org.springframework.data.repository.CrudRepository

interface DuckRepository : CrudRepository<Duck, String> {
    fun findByType(type: String): Duck
}
