package com.zl.basic;

public class Global {

    private int globalId;

    private String name;

    private String content;

    public Global(){}

    public Global(int globalId, String name, String content){
        this.globalId = globalId;
        this.name = name;
        this.content = content;
    }

    public int getGlobalId() {
        return globalId;
    }

    public void setGlobalId(int globalId) {
        this.globalId = globalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
