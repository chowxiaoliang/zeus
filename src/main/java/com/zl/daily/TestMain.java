package com.zl.daily;

public class TestMain {

    public static void main(String[] args) {

        Message message = new SingleMessage("weather is very well!");
        message.say("interface invoke!");

        AlarmMessage alarmMessage = new SingleMessage("good");
        alarmMessage.say("abstract invoke!");

    }
}
