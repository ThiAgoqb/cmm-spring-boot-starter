package com.cmm.pay.refund;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RefundAgentFactory implements InitializingBean {
    @Autowired(required = false)
    private List<AbstractRefundAgent> refundAgents;

    Map<Integer, AbstractRefundAgent> refundMaps = new HashMap<>();

    public AbstractRefundAgent getRefundAgentProxy(Integer agentId) {
        AbstractRefundAgent abstractRefundAgent = refundMaps.get(agentId);
        if (abstractRefundAgent == null) {
            throw new IllegalArgumentException(String.format("[RefundAgent初始化失败]找不到实现:%s", agentId));
        }
        return abstractRefundAgent;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (CollectionUtils.isEmpty(refundAgents))
            return;
        refundAgents.forEach(r -> refundMaps.put(r.getCurrentAgentId(), r));
    }
}
