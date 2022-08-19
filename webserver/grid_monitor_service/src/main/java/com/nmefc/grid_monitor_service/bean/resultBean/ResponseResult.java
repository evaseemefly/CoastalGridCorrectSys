package com.nmefc.grid_monitor_service.bean.resultBean;

import java.util.Date;

/**
 * @author ：LiFei
 * @description：
 * @date ：2020/4/10 9:09
 */
public class ResponseResult<T> {
    private String code;

    private String msg;

    private boolean succeed;

    private Date serverTime;

    private T result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
