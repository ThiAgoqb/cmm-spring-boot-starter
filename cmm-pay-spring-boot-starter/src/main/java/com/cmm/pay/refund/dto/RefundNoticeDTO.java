package com.cmm.pay.refund.dto;

import com.cmm.pay.recharge.dto.RechargeNoticeMerchantDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RefundNoticeDTO implements Serializable {
    private String traceId;
    private Integer agentId;
    private String agentName;//支付商名称
    private String noticeStr;
    // 到账通知中如果有商户号，则放在此
    private String merchantNo;
    private List<RechargeNoticeMerchantDTO> merchantList;
}
