package com.cmm.pay.refund.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class RefundQueryResultDTO implements Serializable {
    private Integer code = 0;
    private String msg = "";
    private Long refundSerialNo; //退款流水号
    private String agentSerialNo; //第三方退款返回流水号
    private BigDecimal money = new BigDecimal(0); //退款金额
    private Date successTime;
    private String extensionJson;
}
