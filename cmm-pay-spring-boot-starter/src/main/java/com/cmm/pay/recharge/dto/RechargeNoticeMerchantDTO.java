package com.cmm.pay.recharge.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RechargeNoticeMerchantDTO implements Serializable {
    private String merchantCode;
    private String merchantName;
    private String md5key;
    private String rsaPublicKey = "";
    private String rsaPrivateKey = "";
    private String desKey = "";
}