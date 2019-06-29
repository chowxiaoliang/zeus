package com.zl.basic;

import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

public class AgendaFilterD implements AgendaFilter {

    private int groupId;

    private String name;

    private String content;

    public AgendaFilterD(int groupId, String name, String content){
        this.groupId = groupId;
        this.name = name;
        this.content = content;
    }

    public boolean accept(Match match) {
        if(match.getRule().getName().equalsIgnoreCase(name)){
            System.out.println("current rule name is =>" + name);
            return true;
        }
        return false;
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
