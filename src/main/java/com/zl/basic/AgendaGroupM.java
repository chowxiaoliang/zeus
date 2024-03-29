package com.zl.basic;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class AgendaGroupM {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("BasicKS");

        AgendaGroup agendaGroup = new AgendaGroup(50, "AgendaTest", "content");
        kieSession.insert(agendaGroup);
        kieSession.getAgenda().getAgendaGroup("official").setFocus();
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
