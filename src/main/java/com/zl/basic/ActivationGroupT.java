package com.zl.basic;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class ActivationGroupT {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("BasicKS");

        ActivationGroup activationGroup = new ActivationGroup(10, "unknowTest", "content");
        kieSession.insert(activationGroup);
        String name = kieSession.getAgenda().getActivationGroup("test").getName();
        System.out.println("name is =" + name);
        kieSession.fireAllRules();
    }
}
