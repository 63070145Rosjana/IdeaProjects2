package com.example.week5;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer01 {
    @RabbitListener(queues = "Mobile")
    public void pow2Consumer(int num){
        System.out.println("pow2Consumer : "+ (num*num));
    }
}
