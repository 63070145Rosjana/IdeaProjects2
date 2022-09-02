package com.example.firstservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestAPI {
    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public String helloWorld(){
        return "Hello World";
    }


}
