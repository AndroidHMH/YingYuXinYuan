package com.jiyun.yingyuxinyuan.model.bean;

/**
 * Created by asus on 2018/5/4.
 */

public class LoginBean {

    /**
     * code : 1
     * message : cid为空
     * data : {"nickname":"y","mobile":"15035394318","photo":"http://qiniu.5roo.com/b554f0021b9e48a3865fc5edac32a7f7.jpg","id":735,"token":"eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJvNnNicnUiLCJzdWIiOiI3MzUiLCJleHAiOjE1MjYwOTQ4NTMsImlhdCI6MTUyNTQ5MDA1M30.efuP__lRCFvr0lAK3ydqEF2FT8tjFCfKvGd1VWsrfUfk4fFvU9Q4unGB-P0-g3Nq4AYe2qF5YwLULy4UhkrlPQ"}
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
         * nickname : y
         * mobile : 15035394318
         * photo : http://qiniu.5roo.com/b554f0021b9e48a3865fc5edac32a7f7.jpg
         * id : 735
         * token : eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJvNnNicnUiLCJzdWIiOiI3MzUiLCJleHAiOjE1MjYwOTQ4NTMsImlhdCI6MTUyNTQ5MDA1M30.efuP__lRCFvr0lAK3ydqEF2FT8tjFCfKvGd1VWsrfUfk4fFvU9Q4unGB-P0-g3Nq4AYe2qF5YwLULy4UhkrlPQ
         */

        private String nickname;
        private String mobile;
        private String photo;
        private int id;
        private String token;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
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
