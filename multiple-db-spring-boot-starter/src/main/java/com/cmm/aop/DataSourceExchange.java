package com.cmm.aop;


import com.cmm.annotation.MultipleDataSource;
import com.cmm.rule.AbstractRule;
import com.cmm.rule.RuleProxy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class DataSourceExchange {

    @Autowired
    private RuleProxy ruleProxy;

    @Autowired
    private Map<Object, Object> dataSources;

    @Pointcut(value = "@annotation(com.cmm.annotation.MultipleDataSource)")
    public void pint(){}

    @Before(value = "pint()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        MultipleDataSource annotation = AnnotationUtils.findAnnotation(method, MultipleDataSource.class);
        if (annotation != null) {
            if (StringUtils.isNotBlank(annotation.field())) {
                String changeDBName = getChangeDBName(signature, annotation, joinPoint.getArgs());
                Object hasDataSource = dataSources.get(changeDBName);
                if (hasDataSource == null) {
                    throw new IllegalArgumentException("获取数据源配置失败当前暂无"+changeDBName+"的数据源配置");
                }
                log.info("切换数据源 dataSource：{}, 当前执行的方法method：{}", changeDBName, method.getName());
                DataSourceHolder.setTargetDSName(changeDBName);
            }
        }

    }

    @After(value = "pint()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String targetDBName = DataSourceHolder.getTargetDBName();
        DataSourceHolder.removeTargetDBName();
        log.info("移除数据源 dataSource：{}, 当前执行的方法method：{}", targetDBName, method.getName());
    }

    public String getChangeDBName(MethodSignature signature, MultipleDataSource annotation, Object[] args) {
        String[] parameterNames = signature.getParameterNames();
        String dbName = annotation.db();
        String rule = annotation.rule();
        String field = annotation.field();
        int index = ArrayUtils.indexOf(parameterNames, field);
        Object num = args[index];
        String methodName = signature.getMethod().getName();
        AbstractRule abstractRule = ruleProxy.getAbstractRule(rule, methodName);
        String dbIndex = abstractRule.calculationRule(num, methodName);
        return dbName.concat(dbIndex);
    }

}
