package com.example.pretest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorPriceController {
    @Autowired
    private CalculatorPriceService calculatorPriceService;

    @RequestMapping(value = "/getPrice/{cost}/{profit}", method = RequestMethod.GET)
    public Double serviceGetProduct(@PathVariable("cost") Double ProductCost, @PathVariable("profit") Double ProductProfit ){
        Double num = calculatorPriceService.getPrice(ProductCost, ProductProfit);
        System.out.println(num);
        return num;
    }
}

