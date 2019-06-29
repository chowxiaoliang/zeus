package com.zl.basic;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class GlobalM {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("BasicKS");

        Message message = new MyMessage();
        Global global = new Global(100, "global", "global content");
        kieSession.insert(global);
        kieSession.setGlobal("message", message);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
