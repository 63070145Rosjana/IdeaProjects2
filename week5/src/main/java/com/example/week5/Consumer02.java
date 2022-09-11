//package com.example.week5;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class Consumer02 {
//    @RabbitListener(queues = "Mobile")
//    public void pow2Consumer(NumMessage num){
//        int n = num.getNum();
//        System.out.println("pow2Consumer : "+ (n*n));
//    }
//}
