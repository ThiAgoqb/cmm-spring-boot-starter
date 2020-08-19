package com.cmm.pay.refund.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class RefundDTO implements Serializable {
    private String traceId;
    private Long rechargeSerialNo;//充值流水
    private Long refundSerialNo;//退款流水
    private Integer brandId;//品牌Id
    private String agentName;//支付商名称
    private String brandSerialNo;//品牌流水号
    private Integer agentId;//代理商Id
    private String channelCode;//第三方支付code，weixin,zhifubao,QQ
    private BigDecimal payMoney;
    private BigDecimal money;//支付金额
    private String realName;//用户真实姓名
    private String idCardNumber;//用户身份证号
    private String ip;//ip
    private String userId;//用户Id;
    private String platformCode;//平台名称，android，iPhone，h5mobile
    private String merchantCode;//商户code
    @JSONField(serialize = false)
    private String appName; // // app名称
    @JSONField(serialize = false)
    private String extension; // 扩展字段 json {\"clientInfo\":\"com.cwvs.jdd\"}
    @JSONField(serialize = false)
    private String noticeExtension;//到账通知扩展参数
    //拓展信息
    @JSONField(serialize = false)
    private String md5Key;//密钥
    @JSONField(serialize = false)
    private String rsaPublicKey = "";
    @JSONField(serialize = false)
    private String rsaPrivateKey = "";
    @JSONField(serialize = false)
    private String desKey = "";
    @JSONField(serialize = false)
    private String noticeAsyncUrl; //到账通知异步地址
    @JSONField(serialize = false)
    private String noticeSyncUrl; //到账通知同步地址
    @JSONField(serialize = false)
    private String agentUrl; //支付商请求URL
    @JSONField(serialize = false)
    private String agentQueryUrl; //支付商查询URL
}
