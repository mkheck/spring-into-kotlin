package com.example.springintokotlin

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

import java.util.Arrays

@SpringBootApplication
class SpringIntoKotlinApplication {
    @Bean
    fun demoData(duckRepository: DuckRepository) = CommandLineRunner {
        listOf("Mallard", "Long-tailed duck", "Northern Shoveler", "Gadwall")
                .stream()
                .map { Duck(type = it) }
                .forEach {
                    duckRepository.save(it)
                    println(it)
                }
    }
}

fun main(args: Array<String>) {
    runApplication<SpringIntoKotlinApplication>(*args)
}
