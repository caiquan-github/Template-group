package cn.kwon.exception.base;

import java.util.StringJoiner;

//通用异常
public class BaseException extends RuntimeException{

    protected ExplicableErrorCode errorCode;

    protected Object[] args;
    public BaseException(){

    }

    public BaseException(ExplicableErrorCode errorCode,Object... args){
        this.errorCode=errorCode;
        this.args=args;
    }

    public BaseException(ExplicableErrorCode errorCode){
        this.errorCode=errorCode;

    }

    public BaseException(Object... args){
        this.args=args;
    }

    public String getErrorMsg(){
        if (errorCode==null){
            return null;
        }
        return String.format(errorCode.getMsg(),this.args);
    }

    @Override
    public String toString() {
        return new StringJoiner("，")
                .add("["+this.getClass().getSimpleName()+"]")
                .add("ErrorCode=["+errorCode+"]")
                .add("Msg=["+String.format(errorCode.getMsg(),this.args)+"]")
                .toString();
    }
    @Override
    public String getMessage(){
        return toString();
    }
}
