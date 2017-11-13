package com.example.springintokotlin

import org.springframework.web.bind.annotation.*

import java.util.Optional

@RestController
@RequestMapping("/ducks")
class DuckController(private val duckRepository: DuckRepository) {

    @GetMapping
    fun allDucks() = duckRepository.findAll()

    @GetMapping("/{id}")
    fun getDuckById(@PathVariable id: String) = duckRepository.findById(id)

    @GetMapping("/search")
    fun getDuckByType(@RequestParam type: String?) = if (type == null) {
        duckRepository.findAll().iterator().next()
    } else {
        duckRepository.findByType(type)
    }
}
