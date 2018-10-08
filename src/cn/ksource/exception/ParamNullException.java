package cn.ksource.exception;


import cn.ksource.constants.ExceptionConstants;

/**
 * Created by chenlong
 * Date：2018/7/31
 * time：11:04
 */
public class ParamNullException extends BaseException{

    private static final Integer code = ExceptionConstants.PARAM_NULL;

    public ParamNullException() {
    }

    public ParamNullException(String msg) {
        super(msg);
    }


    public Integer getCode() {
        return code;
    }

}
