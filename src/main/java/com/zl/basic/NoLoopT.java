package com.zl.basic;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class NoLoopT {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("NoLoopKS");

        NoLoop noLoop = new NoLoop("score", 10);
        kieSession.insert(noLoop);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
