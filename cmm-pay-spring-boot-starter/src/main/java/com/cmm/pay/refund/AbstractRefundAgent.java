package com.cmm.pay.refund;

import com.cmm.pay.base.BaseAbstractAgent;
import com.cmm.pay.refund.dto.*;

public abstract class AbstractRefundAgent extends BaseAbstractAgent {

    public abstract RefundResultDTO refund(RefundDTO refundDTO) throws Exception;

    public abstract RefundResultDTO notice(RefundNoticeDTO refundFeedbackDTO) throws Exception;

    public abstract RefundQueryResultDTO refundQuery(RefundQueryDTO refundQueryDTO) throws Exception;
}
