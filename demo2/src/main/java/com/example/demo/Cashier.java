package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(value = "getChange/{num1}", method = RequestMethod.GET)
    public  Change getChange(@PathVariable("num1") Integer num1){
        Integer d = num1;
        Integer keep;
        Change a = new Change();
        a.setB1000( Integer.valueOf(d/1000));
        keep = d%1000;
        a.setB500( Integer.valueOf(keep/500));
        keep = keep%500;
        a.setB100( Integer.valueOf(keep/100));
        keep = keep%100;
        a.setB20( Integer.valueOf(keep/20));
        keep = keep%20;
        a.setB10( Integer.valueOf(keep/10));
        keep = keep%10;
        a.setB5( Integer.valueOf(keep/5));
        a.setB1( Integer.valueOf(keep%5));
//        a.setB1(Integer.valueOf(d));
        return a;
    }
}
