package com.example.week5;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class WordPublisher {
    protected Word words = new Word();

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

}
