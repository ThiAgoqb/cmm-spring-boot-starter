package com.cmm.pay.recharge.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class RechargeNoticeResultDTO implements Serializable {
    private String msg;
    private int code;
    private Long rechargeSerialNo;
    private String agentSerialNo;
    private BigDecimal money;
    private Date successTime;
    private String extensionJson;
}
