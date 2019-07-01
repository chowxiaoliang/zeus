package com.zl.dynamic;

import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class RuleCompiler {

    private static final Logger logger = LoggerFactory.getLogger(RuleCompiler.class);

    public void createOrRefreshDrlInMemory(List<String> drlStringList){
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();

        for(String drlStr : drlStringList){
            Resource resource = kieServices.getResources().newByteArrayResource(drlStr.getBytes());
            resource.setResourceType(ResourceType.DRL);
            resource.setSourcePath("123112");
            kieFileSystem.write(resource);
        }

        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        ReleaseId releaseId = kieModule.getReleaseId();
//        ReleaseId releaseId = kieServices.getRepository().getDefaultReleaseId();
        System.out.println("releaseid=" + releaseId);
        if (kieBuilder.getResults().hasMessages(Message.Level.ERROR)) {
            logger.error("create rule in kieFileSystem Error{}", kieBuilder.getResults());
            System.out.println(kieBuilder.getResults());
        }

        KieContainer kieContainer = kieServices.newKieContainer(releaseId) ;
        KieBase kieBase = kieContainer.getKieBase();
        KieSession kieSession = kieBase.newKieSession();

        People people = new People();
        people.setName("zhouliang");
        people.setCertNo("7654321");
        people.setMobile("15872151893");

        kieSession.insert(people);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    public String applyRuleTemplate(Map<String, Object> prepareData){
        ObjectDataCompiler objectDataCompiler = new ObjectDataCompiler();
        return objectDataCompiler.compile(Arrays.asList(prepareData), Thread.currentThread().getContextClassLoader().getResourceAsStream("com.zl.drl/dynamics/DynamicTemplateOne.drl"));
    }

    public Map<String, Object> prepareData(List<RuleDto> ruleDtoList){
        Map<String, Object> resultData = new HashMap<String, Object>(16);

        for(RuleDto ruleDto : ruleDtoList){
            resultData.put("eventType", ruleDto.getEventType());
            resultData.put("content", ruleDto.getContent());
            resultData.put("condition", ruleDto.getCondition());
            resultData.put("ruleId", ruleDto.getRuleId());
            resultData.put("multi", ruleDto.getMulti());
            resultData.put("setMethod", ruleDto.getSetMethod());
        }
        return resultData;
    }

    public List<RuleDto> getActivityRulesList(){
        List<RuleDto> resultList = new ArrayList<RuleDto>();

        RuleDto ruleDtoOne = new RuleDto();
        ruleDtoOne.setEventType("People");
        ruleDtoOne.setContent("7654321");
        ruleDtoOne.setCondition("name == \"zhouliang\"");
        ruleDtoOne.setRuleId("rule 01");
        ruleDtoOne.setSetMethod("setName");

        resultList.add(ruleDtoOne);
        return resultList;
    }
}
