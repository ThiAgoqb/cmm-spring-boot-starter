package com.cmm.pay.refund.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RefundQueryDTO implements Serializable {
    private String traceId;
    private Integer agentId;
    private String agentName;//支付商名称
    private String merchantCode;//商户code
    private String md5Key;//密钥
    private String rsaPublicKey = "";
    private String rsaPrivateKey = "";
    private String desKey = "";
    private Long rechargeSerialNo; //充值流水号
    private Long refundSerialNo; //退款流水
    private String agentSerialNo; //第三方退款返回流水号
    private String agentQueryUrl; //退款查询URL
}
