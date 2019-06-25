package com.zl.person;

import com.alibaba.fastjson.JSONObject;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * 规则以传入参数的组合模式的方式执行
 */
public class PersonTest {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("PersonKS");

        Student student = new Student();
        student.setAge(25);
        student.setCertNo("123456");
        student.setName("zhouliang");

        Doctor doctor = new Doctor();
        doctor.setAge(25);
        doctor.setCertNo("123456");
        doctor.setName("zhouliang");

        SameOne sameOne = new SameOne();
        sameOne.setName("zhouliang");
        SameOne sameOne1 = new SameOne();
        sameOne1.setName("yangxiaoxiao");

        kieSession.insert(student);
        kieSession.insert(doctor);
        kieSession.insert(sameOne);
        kieSession.insert(sameOne1);

        int count = kieSession.fireAllRules();
        System.out.println("count is => " + count);
        kieSession.dispose();

        System.out.println("person info is : " + JSONObject.toJSONString(sameOne));
        System.out.println("person info is : " + JSONObject.toJSONString(sameOne1));

    }
}
