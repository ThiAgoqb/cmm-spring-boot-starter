package com.cmm.pay.recharge.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class RechargeDTO  implements Serializable {
    private String traceId;
    private Long rechargeSerialNo;
    private String agentName;//支付商名称
    private Integer brandId;//品牌Id
    private String brandSerialNo;//品牌流水号
    private Integer agentId;//代理商Id
    private String channelCode;//第三方支付code，weixin,zhifubao,QQ
    private BigDecimal money;//支付金额
    private String realName;//用户真实姓名
    private String idCardNumber;//用户身份证号
    private String ip;//ip
    private String userId;//用户Id;
    private String platformCode;//平台名称，android，iPhone，h5mobile
    private String merchantCode;//商户code
    private String appName; // // app名称
    private String extension; // 扩展字段 json {\"clientInfo\":\"com.cwvs.jdd\"}
    private String noticeExtension;//到账通知扩展参数
    private String md5Key;//密钥
    private String rsaPublicKey = "";
    private String rsaPrivateKey = "";
    private String desKey = "";
    private String noticeAsyncUrl; //到账通知异步地址
    private String noticeSyncUrl; //到账通知同步地址
    private String agentUrl; //支付商请求URL
    private String agentQueryUrl; //支付商查询URL
}
