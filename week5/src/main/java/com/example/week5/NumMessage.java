package com.example.week5;

import java.io.Serializable;

public class NumMessage implements Serializable {
    private int num;



    public void setNum(int num) {
        this.num = num;
    }
    public int getNum() {
        return this.num;
    }
    public NumMessage(){

    }
    public NumMessage(int num){
        this.setNum(num);
    }
}
