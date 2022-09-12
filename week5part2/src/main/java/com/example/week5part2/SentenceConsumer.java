package com.example.week5part2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class SentenceConsumer {
    protected Sentence sentences = new Sentence();
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public Sentence senn;

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
//        rabbitTemplate.convertAndSend("DirectExchange","getqueue", "");

        System.out.println(this.sentences);
//        return null;
        return sentences;
    }
}
