package com.thehecklers.coffeeservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class CoffeeServiceApplication {
    @Bean
    CommandLineRunner demo(CoffeeRepository repo) {
        return args -> {
            repo.deleteAll();

            Arrays.asList("Kaldi Coffee", "Philz Coffee", "Blue Bottle Coffee")
                    .stream()
                    .map(name -> new Coffee(name))
                    .forEach(coffee -> repo.save(coffee));


            repo.findAll().forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(CoffeeServiceApplication.class, args);
    }
}
