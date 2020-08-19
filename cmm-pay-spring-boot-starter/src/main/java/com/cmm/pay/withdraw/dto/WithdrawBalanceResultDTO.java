package com.cmm.pay.withdraw.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class WithdrawBalanceResultDTO implements Serializable {
    private Integer code;
    private String msg = "";
    private BigDecimal balance;
}