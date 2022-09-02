package com.example.firstservice;

import org.springframework.web.bind.annotation.*;

@RestController
public class math {
    @RequestMapping(value = "add/{num1}/{num2}", method = RequestMethod.GET)
    public double myAdd(@PathVariable("num1") String num1, @PathVariable("num2") String num2){
        double d = Double.valueOf(num1);
        double d2 = Double.valueOf(num2);
        return  d+d2;
    }
    @RequestMapping(value = "minus/{num1}/{num2}", method = RequestMethod.GET)
    public double myMinus(@PathVariable("num1") String num1, @PathVariable("num2") String num2){
        double d = Double.valueOf(num1);
        double d2 = Double.valueOf(num2);
        return  d-d2;
    }
    @RequestMapping(value = "multiply", method = RequestMethod.GET)
    public double myMultiply(@RequestParam("num1") String num1, @RequestParam("num2") String num2){
        double d = Double.valueOf(num1);
        double d2 = Double.valueOf(num2);
        return  d*d2;
    }
    @RequestMapping(value = "divide", method = RequestMethod.GET)
    public double myDivide(@RequestParam("num1") String num1, @RequestParam("num2") String num2){
        double d = Double.valueOf(num1);
        double d2 = Double.valueOf(num2);
        return  d/d2;
    }
}
