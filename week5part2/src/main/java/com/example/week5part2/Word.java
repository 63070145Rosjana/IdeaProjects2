package com.example.week5part2;

import java.util.ArrayList;

public class Word {
    public ArrayList<String> badWords = new ArrayList<>();
    public ArrayList<String> goodWords = new ArrayList<>();
    public Word(){
        badWords.add("fuck");
        badWords.add("olo");
        goodWords.add("happy");
        goodWords.add("enjoy");
        goodWords.add("life");
    }
}
