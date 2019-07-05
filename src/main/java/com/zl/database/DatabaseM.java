package com.zl.database;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class DatabaseM {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseM.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        System.out.println(RuleStr.RULE_STR);

        Resource resource = kieServices.getResources().newByteArrayResource(RuleStr.RULE_STR.getBytes());
        resource.setResourceType(ResourceType.DRL);
//        resource.setSourcePath("4234234");
        resource.setTargetPath(UUID.randomUUID().toString());
        kieFileSystem.write(resource);


        /**
         * 耗时比较久的地方 start 1500ms左右
         */
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        if (kieBuilder.getResults().hasMessages(Message.Level.ERROR)) {
            logger.error("create rule in kieFileSystem Error{}", kieBuilder.getResults());
            System.out.println(kieBuilder.getResults());
        }
        /**
         * 耗时比较久的地方 end 1500ms左右
         */


        /**
         * 耗时100ms左右 start
         */
        ReleaseId releaseId = kieModule.getReleaseId();
        KieContainer kieContainer = kieServices.newKieContainer(releaseId);
        KieBase kieBase = kieContainer.getKieBase();
        KieSession kieSession = kieBase.newKieSession();
        /**
         * 耗时100ms左右 end
         */

        Boy boy = new Boy("zhouliang", "male", 20);
        FactHandle factHandle = kieSession.insert(boy);
        int n = kieSession.fireAllRules();

        System.out.println("executed rules=" + n);
        kieSession.dispose();
        long endTime = System.currentTimeMillis();
        System.out.println("end time is " + (endTime-startTime) + "ms");
    }
}
