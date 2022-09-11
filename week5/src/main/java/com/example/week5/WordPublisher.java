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

}
