package cn.ksource.exception;

/**
 * Created by chenlong
 * Date：2018/7/31
 * time：11:11
 */
public class BaseException extends RuntimeException {

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }


}
