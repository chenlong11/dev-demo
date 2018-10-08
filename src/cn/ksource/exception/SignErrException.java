package cn.ksource.exception;


import cn.ksource.constants.ExceptionConstants;

/**
 * Created by chenlong
 * Date：2018/8/13
 * time：14:46
 */
public class SignErrException extends BaseException{

    private static final Integer code = ExceptionConstants.INTERFACE_SIGN_ERROR;

    public SignErrException() {
    }

    public SignErrException(String msg) {
        super(msg);
    }


    public Integer getCode() {
        return code;
    }

}
