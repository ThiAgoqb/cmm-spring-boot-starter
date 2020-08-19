package com.cmm.pay.refund.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RefundNoticeResultDTO implements Serializable {
    private Integer code; //1:成功,-1:失败
    private String msg;
    private String tradeNo;
    private Long refundSerialNo;
}
