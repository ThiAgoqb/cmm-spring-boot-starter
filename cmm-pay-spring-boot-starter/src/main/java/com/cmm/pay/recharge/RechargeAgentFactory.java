package com.cmm.pay.recharge;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RechargeAgentFactory implements InitializingBean {
    @Autowired(required = false)
    private List<AbstractRechargeAgent> rechargeAgents;

    Map<Integer, AbstractRechargeAgent> agentMaps = new HashMap<>();

    public AbstractRechargeAgent getRechargeAgentProxy(Integer agentId) {
        AbstractRechargeAgent abstractRechargeAgent = agentMaps.get(agentId);
        if (abstractRechargeAgent == null) {
            throw new IllegalArgumentException(String.format("[RechargeAgent初始化失败]找不到实现:%s", agentId));
        }
        return abstractRechargeAgent;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (CollectionUtils.isEmpty(rechargeAgents))
            return;
        rechargeAgents.forEach(r->agentMaps.put(r.getCurrentAgentId(), r));
    }
}
