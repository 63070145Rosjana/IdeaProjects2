package com.example.lab8testservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Lab8TestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab8TestServiceApplication.class, args);
    }

}
