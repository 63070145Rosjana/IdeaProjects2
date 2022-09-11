package com.example.week5;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publisher02 {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping(value = "/pow3/{num}", method = RequestMethod.GET)
    public String pow2(@PathVariable("num") int num){
        NumMessage n = new NumMessage(num);
        System.out.println("Publisher In : " + n.getNum());
        rabbitTemplate.convertAndSend("MydirectExchange","mobile",n);
        return "Success";
    }

}
