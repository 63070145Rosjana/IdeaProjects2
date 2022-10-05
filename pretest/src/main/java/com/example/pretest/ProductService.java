package com.example.pretest;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    @RabbitListener(queues = "AddProductQueue")
    public Product addProduct( MultiValueMap<String, String> n){
        Map<String, String> d = n.toSingleValueMap();
        Double num1 = Double.valueOf(String.valueOf(d.get("pdc")));
        Double num2 = Double.valueOf(d.get("pdpro"));
        Double num3 = Double.valueOf(d.get("pdprice"));
        String name = d.get("name");
        Product pd = new Product(null, name, num1, num2, num3);
        repository.save(pd);
        return null;
    }
}
