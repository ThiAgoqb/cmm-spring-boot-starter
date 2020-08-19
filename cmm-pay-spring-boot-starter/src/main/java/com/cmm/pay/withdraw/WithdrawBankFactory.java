package com.cmm.pay.withdraw;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class WithdrawBankFactory implements InitializingBean {
    @Autowired(required = false)
    private List<AbstractWithdrawBank> withdrawBanks;

    Map<String, AbstractWithdrawBank> bankMap = new HashMap<>();

    public AbstractWithdrawBank getWithdrawBankProxy(String bankCode) {
        AbstractWithdrawBank abstractWithdrawBank = bankMap.get(bankCode);
        if (abstractWithdrawBank == null) {
            throw new IllegalArgumentException(String.format("[WithdrawBank初始化失败]找不到实现:%s", bankCode));
        }
        return abstractWithdrawBank;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        if (CollectionUtils.isEmpty(withdrawBanks))
            return;
        withdrawBanks.forEach(r->bankMap.put(r.getCurrentBankCode(), r));
    }
}
