package com.example.pretest;

import org.springframework.stereotype.Service;

@Service
public class CalculatorPriceService {

   public Double getPrice(Double ProductCost, Double ProductProfit){
       Double productPrice = ProductCost+ProductProfit;
       return productPrice;
   }
}
