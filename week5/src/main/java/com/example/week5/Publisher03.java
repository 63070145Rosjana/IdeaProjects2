package com.example.week5;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publisher03 {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping(value = "/queueUp/{name}", method = RequestMethod.GET)
    public String queueUp(@PathVariable("name") String name){
        System.out.println("Publisher In : " + name );
//        rabbitTemplate.convertAndSend("MyFanoutExchange","orange.computer.ant.tv",name);

        rabbitTemplate.convertAndSend("MyTopicExchange","orange.computer.ant.tv",name);
        return "Success";
    }
}
