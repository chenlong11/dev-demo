package cn.ksource.domain.response;


import cn.ksource.constants.ExConstants;

import java.util.HashMap;

/**
 * Created by chenlong
 * Date：2018/7/31
 * time：10:31
 */
public class ResponseResult {

    private Integer status;

    private String msg;

    private Object data;

    {
        this.status = ExConstants.SUCESS;
        this.msg = "操作成功";
        this.data = new HashMap();
    }

    public ResponseResult() {
    }

    public ResponseResult(Object data) {
        this.setData(data);
    }

    public ResponseResult(Integer code, String msg) {
        this.setStatus(code);
        this.setMsg(msg);
    }

    public ResponseResult(Integer code, String msg, Object data) {
        this.setStatus(code);
        this.setMsg(msg);
        this.setData(data);
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
