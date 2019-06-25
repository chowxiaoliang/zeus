package com.zl.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DynamicMain {

    public static void main(String[] args) {
        String url = DynamicMain.class.getClassLoader().getResource("").getPath();
        System.out.println("current class path is =>" + url);

        String urlT = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println("current class path is =>" + urlT);
        RuleCompiler ruleLoad = new RuleCompiler();
        List<RuleDto> ruleDtoList = ruleLoad.getActivityRulesList();

        Map<String, Object> map = ruleLoad.prepareData(ruleDtoList);

        final String ruleTemplate = ruleLoad.applyRuleTemplate(map);
        System.out.println(ruleTemplate);

        List<String> templateList = new ArrayList<String>();
        templateList.add(ruleTemplate);

        ruleLoad.createOrRefreshDrlInMemory(templateList);

    }
}
