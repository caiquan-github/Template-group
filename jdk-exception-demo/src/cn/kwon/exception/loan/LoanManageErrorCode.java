package cn.kwon.exception.loan;

import cn.kwon.exception.base.ExplicableErrorCode;

// 贷款管理错误代码
public enum LoanManageErrorCode implements ExplicableErrorCode {
    REPAY_PRINCIPAL_IS_GREATER_THAN_PRINCIPAL("repay principal (%s) is greater than principal (%s)"),

    REPAY_PRINCIPAL_IS_NEGATIVE("repay principal (%s) is negative")
    ;


    LoanManageErrorCode(String msg){
       this.msg=msg;
    }

    String msg;

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public String getCode() {
        return this.name();
    }
}
