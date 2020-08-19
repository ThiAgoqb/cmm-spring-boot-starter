package com.cmm.pay.refund.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RefundResultDTO implements Serializable {
    private Integer code; //退款状态
    private String msg;
    private String tradeNo;
    private Long refundSerialNo;
}
