package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.repository.SmartphoneRepository;
import com.example.service.SmartphoneService;


@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public SmartphoneService smartphoneService(SmartphoneRepository repository) {
        return new SmartphoneService();
    }
    
}

