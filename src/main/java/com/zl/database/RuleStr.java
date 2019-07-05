package com.zl.database;

public class RuleStr {

    public static final String RULE_STR = "package com.zl.drl.database;\n" +
            "\n" +
            "import com.zl.database.Boy\n" +
            "dialect  \"mvel\"\n" +
            "\n" +
            "rule \"RuleStr\"\n" +
            "    when\n" +
            "        $B : Boy(age > 18, name == \"zhouliang\")\n" +
            "    then\n" +
            "        System.out.println($B.getSex());\n" +
            "end\n";
}
