package cn.ksource.exception;


import cn.ksource.constants.ExceptionConstants;

/**
 * Created by chenlong
 * Date：2018/8/13
 * time：14:46
 */
public class AccountAuthErrException extends BaseException{

    private static final Integer code = ExceptionConstants.ACCOUNT_AUTH_ERR;

    public AccountAuthErrException() {
    }

    public AccountAuthErrException(String msg) {
        super(msg);
    }


    public Integer getCode() {
        return code;
    }

}
