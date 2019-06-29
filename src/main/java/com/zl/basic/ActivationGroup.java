package com.zl.basic;

public class ActivationGroup {

    private int groupId;

    private String name;

    private String content;

    public ActivationGroup(){}

    public ActivationGroup(int groupId, String name, String content){
        this.groupId = groupId;
        this.name = name;
        this.content = content;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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
