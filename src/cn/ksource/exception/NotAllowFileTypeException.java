package cn.ksource.exception;


import cn.ksource.constants.ExceptionConstants;

/**
 * Created by chenlong
 * Date：2018/8/13
 * time：14:46
 */
public class NotAllowFileTypeException extends BaseException{

    private static final Integer code = ExceptionConstants.NOT_ALLOW_FILETYPE;

    public NotAllowFileTypeException() {
    }

    public NotAllowFileTypeException(String msg) {
        super(msg);
    }


    public Integer getCode() {
        return code;
    }

}
