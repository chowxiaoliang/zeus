package com.zl.BusPass;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

public class BadBusPassT {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("BadBusPassKS");

        Person person = new Person("zhouliang", 15);
        FactHandle factHandle = kieSession.insert(person);
        kieSession.fireAllRules();

        person.setAge(16);
        kieSession.update(factHandle, person);
        kieSession.fireAllRules();

        person.setAge(10);
        kieSession.update(factHandle, person);
        kieSession.fireAllRules();

        kieSession.dispose();
    }
}
