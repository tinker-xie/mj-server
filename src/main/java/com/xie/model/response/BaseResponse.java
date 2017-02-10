package com.xie.model.response;

import java.util.Date;

/**
 * Created by xie on 16/12/12.
 */
public class BaseResponse {
    private final static int SUCCESS_CODE = 0;
    private final static int FAIL_CODE = -1;
    private final static String SUCCESS_MESSAGE = "ok";
    private final static String FAIL_MESSAGE = "fail";

    private int code;
    private String msg;
    private Date timestamp;
    private Object data;

    public BaseResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.timestamp = new Date();
        this.data = data;
    }

    public static BaseResponse ok(Object data) {
        return new BaseResponse(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static BaseResponse ok() {
        return new BaseResponse(SUCCESS_CODE, SUCCESS_MESSAGE, null);
    }

    public static BaseResponse fail(Object data) {
        return new BaseResponse(FAIL_CODE, FAIL_MESSAGE, data);
    }

    public static BaseResponse fail() {
        return new BaseResponse(FAIL_CODE, FAIL_MESSAGE, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
