package cn.ksource.exception;


import cn.ksource.constants.ExceptionConstants;

/**
 * Created by chenlong
 * Date：2018/8/13
 * time：14:46
 */
public class AuthCodeErrException extends BaseException{

    private static final Integer code = ExceptionConstants.AUTH_CODE_ERR;

    public AuthCodeErrException() {
    }

    public AuthCodeErrException(String msg) {
        super(msg);
    }


    public Integer getCode() {
        return code;
    }

}
