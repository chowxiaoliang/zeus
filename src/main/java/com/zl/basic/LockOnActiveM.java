package com.zl.basic;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class LockOnActiveM {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("BasicKS");

        LockOnActive lockOnActive = new LockOnActive("zhouliang", 13);
        kieSession.insert(lockOnActive);
        kieSession.fireAllRules();
    }
}
