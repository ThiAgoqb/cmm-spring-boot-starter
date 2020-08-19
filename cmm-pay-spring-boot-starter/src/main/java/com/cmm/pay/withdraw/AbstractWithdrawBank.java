package com.cmm.pay.withdraw;

import com.cmm.pay.withdraw.dto.*;

public abstract class AbstractWithdrawBank {

    public abstract String getCurrentBankCode();

    protected abstract WithdrawResultDTO withdraw(WithdrawDTO withdrawDTO) throws Exception;


    protected abstract WithdrawQueryResultDTO query(WithdrawQueryDTO withdrawQueryDTO) throws Exception;


    protected abstract WithdrawBalanceResultDTO getBalance(WithdrawBalanceDTO withdrawBalanceDTO) throws Exception;

    protected abstract WithdrawNoticeResultDTO notice(WithdrawNoticeDTO feedbackDTO) throws Exception;
}
