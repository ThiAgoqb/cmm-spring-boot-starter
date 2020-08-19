package com.cmm.pay.withdraw.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class WithdrawQueryDTO implements Serializable {
    private String traceId;
    private Integer brandId;
    private String brandSerialNo;//品牌流水号
    private Long withdrawSerialNo;//提款流水号；
    private BigDecimal money;
    private String bankName;
    private String payBankCode;
    private String bankAccountName;
    private String noticeUrl;
    private String payBankAccount;
    private Date submitTime;
}
