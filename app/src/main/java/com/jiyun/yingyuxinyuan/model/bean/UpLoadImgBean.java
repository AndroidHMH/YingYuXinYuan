package com.jiyun.yingyuxinyuan.model.bean;

/**
 * Created by asus on 2018/5/7.
 */

public class UpLoadImgBean {

    /**
     * code : 0
     * message : 成功
     * data : {"fileName":"http://qiniu.5roo.com/2480115f-befd-4cb3-8f90-58c5038d51e2.txt"}
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
        /**
         * fileName : http://qiniu.5roo.com/2480115f-befd-4cb3-8f90-58c5038d51e2.txt
         */

        private String fileName;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
    }
}
