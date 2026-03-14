package com.carrentals.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CarrentalsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarrentalsServiceApplication.class, args);
    }
}