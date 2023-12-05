package com.dee.countriesinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CountriesInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountriesInfoApplication.class, args);
    }

}
