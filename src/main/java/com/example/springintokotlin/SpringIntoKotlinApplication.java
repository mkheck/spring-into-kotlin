package com.example.springintokotlin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringIntoKotlinApplication {
	@Bean
    CommandLineRunner demoData(DuckRepository duckRepository) {
	    return args -> {
            Arrays.asList("Mallard", "Long-tailed duck", "Northern Shoveler", "Gadwall")
                    .stream()
                    .map(Duck::new)
                    .forEach(duck -> {
                        duckRepository.save(duck);
                        System.out.println(duck);
                    });
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringIntoKotlinApplication.class, args);
    }
}
