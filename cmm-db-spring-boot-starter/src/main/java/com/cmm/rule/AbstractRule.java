package com.cmm.rule;

public abstract class AbstractRule {

    public abstract String getRuleName();


    public abstract String calculationRule(Object field, String methodName);
}
