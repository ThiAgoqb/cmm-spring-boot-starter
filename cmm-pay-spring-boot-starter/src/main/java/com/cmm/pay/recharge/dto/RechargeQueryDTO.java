package com.cmm.pay.recharge.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RechargeQueryDTO implements Serializable {
    private String traceId;
    private Integer agentId;
    private String agentName;//支付商名称
    private String merchantCode;//商户code
    private String md5Key;//密钥
    private String rsaPublicKey = "";
    private String rsaPrivateKey = "";
    private String desKey = "";
    private Long rechargeSerialNo; //充值流水号
    private String agentSerialNo; //支付商返回流水号
    private String agentQueryUrl; //支付商查询URL
}
