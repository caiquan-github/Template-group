package cn.kwon.exception.loan;

import cn.kwon.exception.base.BaseException;
import cn.kwon.exception.base.ExplicableErrorCode;

//资产管理异常
public class LoanManageException extends BaseException {
    public LoanManageException() {
        super();
    }

    public LoanManageException(ExplicableErrorCode errorCode, Object... args) {
        super(errorCode, args);
    }

    public LoanManageException(ExplicableErrorCode errorCode) {
        super(errorCode);
    }

}

