package com.example.springintokotlin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringIntoKotlinApplication {
    @Bean
    CommandLineRunner demoData(CoffeeRepository coffeeRepository) {
        return args -> {
            Arrays.asList("Espresso Roast", "Sumatra", "Pike Place", "Seattle Blend", "Kaldi")
                    .stream()
                    .map(type -> new Coffee(null, type))
                    .forEach(coffeeRepository::save);

            coffeeRepository.findAll().forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringIntoKotlinApplication.class, args);
    }
}
