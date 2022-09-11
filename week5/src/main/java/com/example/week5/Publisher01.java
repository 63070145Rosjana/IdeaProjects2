package com.example.week5;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publisher01 {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/pow2/{num}", method = RequestMethod.GET)
    public String pow2(@PathVariable("num") int num){
        System.out.println("Publisher In : " + num );
        rabbitTemplate.convertAndSend("MydirectExchange","mobile",num);
        return "Success";
    }
}
