package com.example.springintokotlin

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/coffees")
class CoffeeController(private val coffeeRepository: CoffeeRepository) {

    @GetMapping
    fun allDucks() = coffeeRepository.findAll()

    @GetMapping("/{id}")
    fun getDuckById(@PathVariable id: String) = coffeeRepository.findById(id)

    @GetMapping("/search")
    fun getDuckByType(@RequestParam type: String?) = if (type == null) {
        coffeeRepository.findAll().iterator().next()
    } else {
        coffeeRepository.findByType(type)
    }
}
