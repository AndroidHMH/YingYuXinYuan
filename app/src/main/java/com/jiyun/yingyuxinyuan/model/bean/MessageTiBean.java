package com.jiyun.yingyuxinyuan.model.bean;

import java.util.List;

/**
 * Created by ASUS on 2018/05/10.
 */

public class MessageTiBean {

    /**
     * code : 0
     * message : 成功
     * data : [{"type":"MSG_ORDER","content":"暂无提醒","createDate":1525933589852,"isRead":0},{"type":"MSG_PRAISE","content":"暂无提醒","createDate":1525933589852,"isRead":0},{"type":"MSG_COMMENTS","content":"暂无提醒","createDate":1525933589852,"isRead":0},{"type":"MSG_HOMEWOK","content":"暂无提醒","createDate":1525933589852,"isRead":0},{"type":"MSG_UNIVSTAR","content":"亲爱的用户，恭喜您，注册成功。UnivStar团队与您一起为学业进步而努力！","createDate":1525414298464,"isRead":0},{"type":"MSG_ATTENTION","content":"有新的好友关注了你!","createDate":1525868551575,"isRead":0}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * type : MSG_ORDER
         * content : 暂无提醒
         * createDate : 1525933589852
         * isRead : 0
         */

        private String type;
        private String content;
        private long createDate;
        private int isRead;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public int getIsRead() {
            return isRead;
        }

        public void setIsRead(int isRead) {
            this.isRead = isRead;
        }
    }
}
