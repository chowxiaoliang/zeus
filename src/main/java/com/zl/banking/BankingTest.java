package com.zl.banking;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

public class BankingTest {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("BankingKS");

//        int one = 1;
        int two = 2;
        Number[] number = new Number[]{two};
        for(Number number1 : number){
            kieSession.insert(number1);
        }
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
