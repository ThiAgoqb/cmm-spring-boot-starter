package com.cmm.pay.recharge;

import com.cmm.pay.base.BaseAbstractAgent;
import com.cmm.pay.recharge.dto.*;

public abstract class AbstractRechargeAgent extends BaseAbstractAgent {

    public abstract RechargeResultDTO recharge(RechargeDTO recharge) throws Exception;

    public abstract RechargeQueryResultDTO query(RechargeQueryDTO query) throws Exception;

    public abstract RechargeNoticeResultDTO notice(RechargeNoticeResultDTO notice) throws Exception;

}
