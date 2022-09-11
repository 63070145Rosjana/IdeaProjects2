package com.example.week5;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service

public class SentenceConsumer {
    protected Sentence sentences = new Sentence();
    @RabbitListener(queues = "GoodWordQueue")
    public void addGoodSentence(String s){
        this.sentences.goodSentences.add(s);
//        for (String sentence: sentences.goodSentences) {
//            System.out.println("In addGoodSentence Method: "+ sentence);
//        }
       System.out.println("In addGoodSentence Method: "+ sentences.goodSentences);
    }

    @RabbitListener(queues = "BadWordQueue")
    public void addBadSentence(String s){
        this.sentences.badSentences.add(s);
//        for (String sentence: sentences.badSentences) {
//            System.out.println("In addBadSentence Method: "+ sentence);
//        }
        System.out.println("In addBadSentence Method: "+ sentences.badSentences);
    }





}
