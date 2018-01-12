package com.example.springintokotlin

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringIntoKotlinApplication {
    @Bean
    fun demoData(coffeeRepository: CoffeeRepository) = CommandLineRunner {
        listOf("Espresso Roast", "Sumatra", "Pike Place", "Seattle Blend", "Kaldi")
                .stream()
                .map { Coffee(type = it) }
                .forEach { coffeeRepository.save(it) }

        coffeeRepository.findAll().forEach { println(it) }
    }
}

fun main(args: Array<String>) {
    runApplication<SpringIntoKotlinApplication>(*args)
}
