package com.zl.basic;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;

public class AgendaFilterM {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("BasicKS");

        AgendaFilterD agendaFilterD = new AgendaFilterD(200, "AgendaGroupFilterO", "content");
        kieSession.insert(agendaFilterD);
        kieSession.fireAllRules(agendaFilterD);
        kieSession.dispose();
    }
}
