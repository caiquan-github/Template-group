public class TestMain {
    public static void main(String[] args) {
        ex3();
        System.out.println("test");
    }


    public static String ex1(){
        throw new BaseException(LoanManageErrorCode.REPAY_PRINCIPAL_IS_NEGATIVE,"错误值1");
    }

    public static String ex2(){
        throw new BaseException(LoanManageErrorCode.REPAY_PRINCIPAL_IS_GREATER_THAN_PRINCIPAL,"错误值1","错误值2");
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
