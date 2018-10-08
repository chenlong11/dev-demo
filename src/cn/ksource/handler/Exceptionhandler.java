package cn.ksource.handler;

import cn.ksource.constants.ExceptionConstants;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by chenlong
 * Date：2018/6/30
 * time：23:58
 */

@ControllerAdvice
@Slf4j
public class Exceptionhandler {


    @ExceptionHandler(value = ParamNullException.class)
    @ResponseBody
    private ResponseResult ParamNullExceptionHandler(HttpServletRequest req, ParamNullException e) {
        log.info("发生异常 code: {} , msg : {}", e.getCode(), e.getMessage());
        return new ResponseResult(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = ParamErrException.class)
    @ResponseBody
    private ResponseResult ParamErrExceptionHandler(HttpServletRequest req, ParamErrException e) {
        log.error("发生异常 code: {} , msg : {}", e.getCode(), e.getMessage());
        return new ResponseResult(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = SignErrException.class)
    @ResponseBody
    private ResponseResult SignErrExceptionHandler(HttpServletRequest req, SignErrException e) {
        log.error("发生异常 code: {} , msg : {}", e.getCode(), e.getMessage());
        return new ResponseResult(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = AuthCodeErrException.class)
    @ResponseBody
    private ResponseResult AuthCodeErrExceptionHandler(HttpServletRequest req, AuthCodeErrException e) {
        log.error("发生异常 code: {} , msg : {}", e.getCode(), e.getMessage());
        return new ResponseResult(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = AccountAuthErrException.class)
    @ResponseBody
    private ResponseResult AccountAuthErrExceptionHandler(HttpServletRequest req, AccountAuthErrException e) {
        log.error("发生异常 code: {} , msg : {}", e.getCode(), e.getMessage());
        return new ResponseResult(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private ResponseResult ParamExceptionHandler(HttpServletRequest req, Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        log.error(sw.toString());
        return new ResponseResult(ExceptionConstants.SERVER_ERR, "服务器异常");
    }

}
