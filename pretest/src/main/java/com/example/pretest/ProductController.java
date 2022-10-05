package com.example.pretest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean serviceAddProduct(@RequestBody MultiValueMap<String, String> n){
        Map<String, String> d = n.toSingleValueMap();
        rabbitTemplate.convertAndSend("ProductExchange","add", d);
        return true;
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean serviceUpdateProduct(@RequestBody MultiValueMap<String, String> n){
        Map<String, String> d = n.toSingleValueMap();
        rabbitTemplate.convertAndSend("ProductExchange","update", d);
        return true;
    }
}
