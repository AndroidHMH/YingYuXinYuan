package com.jiyun.yingyuxinyuan.model.bean;

/**
 * Created by ASUS on 2018/05/04.
 */

public class PhoneResginYzmBean {
    /**
     * code : 0
     * message : 验证码已发送
     * data : {}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
    }
}
