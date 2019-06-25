package com.zl.daily;

public abstract class AlarmMessage implements Message {


    public String say(String content){
        System.out.println("message type is alarm!");
        return "success!";
    }
}
