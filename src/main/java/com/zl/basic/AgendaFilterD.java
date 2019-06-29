package com.zl.basic;

import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

public class AgendaFilterD implements AgendaFilter {

    private int agendaId;

    private String name;

    private String content;

    public AgendaFilterD(String name){
        this.name = name;
    }

    public boolean accept(Match match) {
        if(match.getRule().getName().equalsIgnoreCase(name)){
            return true;
        }
        return false;
    }
}
