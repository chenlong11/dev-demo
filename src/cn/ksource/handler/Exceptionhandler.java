package cn.ksource.handler;

import cn.ksource.constants.ExceptionConstants;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.exception.*;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    private String ParamExceptionHandler(HttpServletRequest req, HttpServletResponse resp ,Exception e) {
        //打印日志
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        log.error(sw.toString());

        if (!(req.getHeader("accept").contains("application/json")//非异步请求
                || (req.getHeader("X-Requested-With")!= null && req.getHeader("X-Requested-With").contains("XMLHttpRequest")))){
            return "/500";
        } else {
            try {
                PrintWriter writer = resp.getWriter();
                writer.write(JSON.toJSONString(new ResponseResult(ExceptionConstants.SERVER_ERR, "服务器异常")));
                writer.flush();
                return null;
            } catch (IOException io) {
                io.printStackTrace();
                return null;
            }
        }
    }

}
