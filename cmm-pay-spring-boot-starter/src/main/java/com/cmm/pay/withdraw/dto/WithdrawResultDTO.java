package com.cmm.pay.withdraw.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WithdrawResultDTO implements Serializable {
    private Integer code;//打款状态
    private String msg = "";
    private String brandSerialNo;//品牌打款流水号
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date submitTime;//提交时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date withdrawTime;//打款时间
    private String withdrawComment;//打款描述
}
