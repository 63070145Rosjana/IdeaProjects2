package com.example.week5part2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
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
    @RabbitListener(queues = "GetQueue")
    public Sentence getSentences() {
        return this.sentences;
    }
}
