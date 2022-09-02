package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(value = "getChange/{num1}", method = RequestMethod.GET)
    public Integer getChange(@PathVariable("num1") Integer num1){
        Integer d = num1;
        return  d;
    }
}
