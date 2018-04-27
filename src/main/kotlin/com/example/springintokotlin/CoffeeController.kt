package com.example.springintokotlin

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/coffees")
class CoffeeController(private val coffeeRepository: CoffeeRepository) {

    @GetMapping
    fun allCoffees() = coffeeRepository.findAll()

    @GetMapping("/{id}")
    fun getCoffeeById(@PathVariable id: String) =
        coffeeRepository.findById(id)

    @GetMapping("/search")
    fun getCoffeeByType(@RequestParam type: String?) = type?.let {
        coffeeRepository.findByType(it)
    } ?: coffeeRepository.findAll().first()
}
