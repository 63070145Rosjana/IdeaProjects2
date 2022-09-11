package com.example.week5part2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class WordPublisher {
    protected Word words = new Word();
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/addBad/{s}", method = RequestMethod.GET)
    public ArrayList<String> addBadWord(@PathVariable("s") String s){
        this.words.badWords.add(s);
        return words.badWords;
    }
    @RequestMapping(value = "/delBad/{s}", method = RequestMethod.DELETE)
    public ArrayList<String> deleteBadWord(@PathVariable("s") String s){
        String keep = "";
        for (String word: words.badWords) {
            System.out.println(word);
            if (word.equals(s)) {
                keep = word;
            }
        }
        this.words.badWords.remove(keep);
        return words.badWords;
    }
    @RequestMapping(value = "/addGood/{s}", method = RequestMethod.GET)
    public ArrayList<String> addGoodWord(@PathVariable("s") String s){
        this.words.goodWords.add(s);
        return words.goodWords;
    }
    @RequestMapping(value = "/delGood/{s}", method = RequestMethod.DELETE)
    public ArrayList<String> deleteGoodWord(@PathVariable("s") String s){
        String keep = "";
        for (String word: words.goodWords) {
            System.out.println(word);
            if (word.equals(s)) {
                keep = word;

            }
        }
        this.words.goodWords.remove(keep);
        return words.goodWords;
    }
    @RequestMapping(value = "/proof/{sentence}", method = RequestMethod.GET)
    public String proofSentence(@PathVariable("sentence") String s){
        String keepgood = "false";
        String keepbad = "false";
        //ให้เป็นtrue
        for (String word: words.goodWords) {
            boolean isFound = s.contains(word);
            keepgood= String.valueOf(isFound);
            if(keepgood == String.valueOf(true)){
                break;
            }
        }
        for (String word: words.badWords) {
            boolean isFound = s.contains(word);
            keepbad = String.valueOf(isFound);
            if(keepbad == String.valueOf(true)){
                break;
            }
        }
        if(keepgood.equals("true") && keepbad.equals("false")){
            rabbitTemplate.convertAndSend("DirectExchange","good",s);
            return "Found Good Word";
        }
        else if(keepgood.equals("false") && keepbad.equals("true")){
            rabbitTemplate.convertAndSend("DirectExchange","bad",s);
            return "Found Bad Word";
        }
        else if(keepgood.equals("true") && keepbad.equals("true")){
            rabbitTemplate.convertAndSend("FanoutExchange","",s);
            return "Found Bad & Good Word";
        }

        return keepgood;
    }

}
