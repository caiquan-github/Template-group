package cn.kwon.exception;

import cn.kwon.exception.base.BaseException;
import cn.kwon.exception.loan.LoanManageErrorCode;
import cn.kwon.exception.loan.LoanManageException;

public class TestMain {
    public static void main(String[] args) {
        ex2();
    }


    public static String ex1(){
        throw new BaseException(LoanManageErrorCode.REPAY_PRINCIPAL_IS_NEGATIVE,"错误值1");
    }

    public static String ex2(){
        throw new LoanManageException(LoanManageErrorCode.REPAY_PRINCIPAL_IS_GREATER_THAN_PRINCIPAL,10,20);
    }


    public static String ex3(){
        try {
            ex1();
        }
        catch (Exception e){
            throw new BaseException(LoanManageErrorCode.REPAY_PRINCIPAL_IS_GREATER_THAN_PRINCIPAL,"自定义",e);
        }
        return "success";
    }
}
