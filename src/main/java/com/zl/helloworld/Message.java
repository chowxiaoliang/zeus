package com.zl.helloworld;

public class Message {

    public static final int HELLO = 0;

    public static final int GOOD_BYE = 1;

    private String substance;

    private int status;

    public String getSubstance() {
        return substance;
    }

    public void setSubstance(String substance) {
        this.substance = substance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
