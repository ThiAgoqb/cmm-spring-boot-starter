package com.cmm.rule.impl;

import com.cmm.common.ComConstant;
import com.cmm.rule.AbstractRule;
import org.springframework.stereotype.Component;

@Component
public class Md100Rule extends AbstractRule {
    @Override
    public String getRuleName() {
        return ComConstant.MD100;
    }

    @Override
    public String calculationRule(Object field, String methodName) {
        if (field instanceof Number) {
            Long num = (Long) field;
            return String.valueOf(num /100 % 10);
        }
        throw new RuntimeException("field字段类型错误,此参数必须为数字类型，执行的方法为："+methodName);
    }
}
