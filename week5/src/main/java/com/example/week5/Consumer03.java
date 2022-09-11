package com.example.week5;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer03 {

    @RabbitListener(queues = "TV")
    public void queueTV(String name){ System.out.println("In TV Queue : "+ name);}

    @RabbitListener(queues = "Computer")
    public void queueCom(String name){ System.out.println("In Computer Queue : "+ name);}

    @RabbitListener(queues = "Mobile")
    public void queueMobile(String name){System.out.println("In Mobile Queue : "+ name);}
}
