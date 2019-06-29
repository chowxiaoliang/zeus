package com.zl.basic;

public class MyMessage implements Message {

    public MyMessage(){}

    public MyMessage(String message){

    }
    public void printMessage(String message) {
        System.out.println("print message is: " + message);
    }
}
