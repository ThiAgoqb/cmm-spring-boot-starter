package com.cmm.pay.recharge.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class RechargeQueryResultDTO implements Serializable {
    private Integer code = 0;
    private String msg = "";
    private Long rechargeSerialNo; //充值流水号
    private String agentSerialNo; //支付商返回流水号
    private BigDecimal money = new BigDecimal(0); //支付金额
    private Date successTime;
    private String extensionJson;

}
