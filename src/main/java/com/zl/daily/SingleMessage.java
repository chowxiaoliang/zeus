package com.zl.daily;

public class SingleMessage extends AlarmMessage {

    private String message;

    public SingleMessage(String message){
        this.message = message;
    }

    @Override
    public String say(String content){
        System.out.println("today message is => " + content);
        return "success!";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
