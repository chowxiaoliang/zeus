package com.zl.clock;

import com.zl.helloworld.Message;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class ClockTest {

    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("HelloworldKS");

        Clock clock = new Clock();
        clock.setHour(12);
        clock.setMinute(40);
        clock.setSecond(60);

        Clock clock1 = new Clock();
        clock1.setHour(32);
        clock1.setMinute(32);
        clock1.setSecond(0);

        kSession.insert(clock1);
        kSession.fireAllRules();
        kSession.dispose();


    }
}
