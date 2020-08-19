package com.cmm.pay.withdraw.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class WithdrawNoticeDTO implements Serializable {
    private String bankCode;
    private String bankAccount;
    private String bankAccountName;
    private String response;
    private String traceId;
}
