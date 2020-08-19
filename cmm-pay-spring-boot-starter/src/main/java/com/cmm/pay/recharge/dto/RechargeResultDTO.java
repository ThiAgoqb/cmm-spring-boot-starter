package com.cmm.pay.recharge.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
@Data
public class RechargeResultDTO implements Serializable {
    private Integer code; //1:成功,-1:失败
    private String msg;
    private Long rechargeSerialNo;//充值流水号
    private Integer payModule;//交易模式 1:交易号发起，2：表单发起，3：token令牌发起，4：url发起
    private String tradeNo; //交易号
    private String url;
    private JSONObject token;// token令牌信息
    private String requestForm;// 表单信息
    private Integer webview;//是否需要webview,1是,0否
    private String agentCode;//真实的支付方式
    private Integer useWeb = 0;//是否使用web支付 1使用 0不使用
    private String webUrl;//使用中间页返回中间页url
    private String openId;//微信公众号支付使用
}
