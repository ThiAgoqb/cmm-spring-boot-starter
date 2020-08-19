package com.cmm.pay.withdraw.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class WithdrawDTO implements Serializable {
    private String traceId;
    private Long withdrawSerialNo;//提款流水号
    private Integer brandId;//品牌Id
    private String brandSerialNo;//品牌流水号
    private BigDecimal money;//提款金额
    private String realName;//真实姓名
    private String bankCode;//银行Code
    private String bankName;//银行名称
    private String bankCardNo;//银行卡号
    private String bankCardCityCode;//银行所在城市code
    private String bankCardCityName;//银行卡所在城市名称
    private String payBankCode;//付款银行code
    private String brandNoticeUrl;//品牌通知地址
    private String payBankAccount;//付款银行
    private String bankAccountName;
}
