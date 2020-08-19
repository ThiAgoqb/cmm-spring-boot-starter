package com.cmm.pay.withdraw.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class WithdrawBalanceDTO implements Serializable {
    private String traceId;
    private String payBankAccount;
    private String bankAccountName;//打款银行名称
}
