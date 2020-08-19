package com.cmm.rule;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RuleProxy implements InitializingBean {

    @Autowired
    private List<AbstractRule> rules;

    public AbstractRule getAbstractRule(String ruleName, String methodName) {
        AbstractRule abstractRule = ruleMaps.get(ruleName);
        if (abstractRule == null) {
            throw new RuntimeException("未匹配到相应的路由规则,rule参数非法："+ ruleName + "， 当前执行的方法method：" + methodName);
        }
        return abstractRule;
    }

    private Map<String, AbstractRule> ruleMaps = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        rules.forEach(r-> ruleMaps.put(r.getRuleName(), r));
    }
}
