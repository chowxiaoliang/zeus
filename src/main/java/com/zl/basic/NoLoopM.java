package com.zl.basic;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

public class NoLoopM {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("BasicKS");

        NoLoop noLoop = new NoLoop("score", 10);
        FactHandle factHandle = kieSession.insert(noLoop);
        kieSession.fireAllRules();

        kieSession.dispose();
    }
}
