package com.jiyun.yingyuxinyuan.model.bean;

/**
 * Created by ASUS on 2018/05/04.
 */

public class PhoneResginAllBean {

    /**
     * code : 0
     * message : 成功
     * data : {"nickname":"9166072","mobile":null,"photo":null,"id":726,"token":"eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJ6bm5qOXYiLCJzdWIiOiI3MjYiLCJleHAiOjE1MjYwMTA1MTgsImlhdCI6MTUyNTQwNTcxOH0.ygMZ0HQ647cXgDSfNcC0EAYfujVd3Vp8Yu1v598JUswBr6FFlmXY75SWF-9MLPIdlVK6MorSP2YYPPk910Nq_A"}
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
         * nickname : 9166072
         * mobile : null
         * photo : null
         * id : 726
         * token : eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJ6bm5qOXYiLCJzdWIiOiI3MjYiLCJleHAiOjE1MjYwMTA1MTgsImlhdCI6MTUyNTQwNTcxOH0.ygMZ0HQ647cXgDSfNcC0EAYfujVd3Vp8Yu1v598JUswBr6FFlmXY75SWF-9MLPIdlVK6MorSP2YYPPk910Nq_A
         */

        private String nickname;
        private Object mobile;
        private Object photo;
        private int id;
        private String token;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
            this.mobile = mobile;
        }

        public Object getPhoto() {
            return photo;
        }

        public void setPhoto(Object photo) {
            this.photo = photo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
