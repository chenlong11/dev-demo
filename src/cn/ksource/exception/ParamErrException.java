package cn.ksource.exception;


import cn.ksource.constants.ExceptionConstants;

/**
 * Created by chenlong
 * Date：2018/7/31
 * time：10:53
 */
public class ParamErrException extends BaseException{

    private static final Integer code = ExceptionConstants.PARAM_ERR;

    public ParamErrException() {
    }

    public ParamErrException(String msg) {
        super(msg);
    }


    public Integer getCode() {
        return code;
    }

}
