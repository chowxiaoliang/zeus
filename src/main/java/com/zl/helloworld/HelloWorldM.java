package com.zl.helloworld;

import com.alibaba.fastjson.JSONObject;
import com.zl.clock.Clock;
import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;

public class HelloWorldM {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("HelloworldKS");

        Message message = new Message();
        message.setSubstance("inner content!");
        message.setStatus(Message.HELLO);
        kieSession.insert(message);

        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println("after executed message is => " + JSONObject.toJSONString(message));
        long endTime = System.currentTimeMillis();
        System.out.println("total time is=" + (endTime - startTime) +"ms");
    }
}
