package cn.kwon.exception.loan;


import cn.kwon.exception.base.ExplicableErrorCode;

//资产管理  断言工具
public class LoanManageAssert {
    public static void isTrue(boolean expression, LoanManageErrorCode errorCode, Object... args) {
        if (!expression) {
            throw new LoanManageException(errorCode, args);
        }
    }

    //相等
    public static void isEquals(Integer num1, Integer num2, LoanManageErrorCode errorCode) {
        if (num1.compareTo(num2) != 0) {
            throw new LoanManageException(errorCode, num1, num2);
        }
    }

    //小于或等于
    public static void isLessThanOrEqualTo(Integer num1, Integer num2, LoanManageErrorCode errorCode){
        if (num1.compareTo(num2) <= 0) {
            throw new LoanManageException(errorCode, num1, num2);
        }

    }


    public static void main(String[] args) {
        LoanManageAssert.isEquals(1,1, LoanManageErrorCode.REPAY_PRINCIPAL_IS_NEGATIVE);
        LoanManageAssert.isLessThanOrEqualTo(1,1, LoanManageErrorCode.REPAY_PRINCIPAL_IS_GREATER_THAN_PRINCIPAL);
    }
}
