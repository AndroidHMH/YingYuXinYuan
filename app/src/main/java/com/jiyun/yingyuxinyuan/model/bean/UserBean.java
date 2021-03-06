package com.jiyun.yingyuxinyuan.model.bean;

/**
 * Created by asus on 2018/5/10.
 */

public class UserBean {

    /**
     * code : 0
     * message : 成功
     * data : {"id":929,"page":1,"rows":20,"pid":0,"salt":"7855684035909223","nickname":"阿萨德","realname":null,"photo":"http://qiniu.5roo.com/ff7166b5-b4a2-4c88-a886-a0c986f060cd.jpg","images":null,"intro":null,"details":null,"mobile":"13552463977","psw":"f7fa8725d352a61584a48a03d3235879d108f9fa2242eb39","email":null,"sex":0,"birthday":1524153600000,"country":null,"province":null,"city":null,"area":null,"address":null,"userType":1,"post":null,"college":null,"major":null,"skilled":null,"ip":null,"lastTime":1525949302000,"createDate":1525920213000,"idcardFront":null,"idcardBack":null,"teachCard":null,"isauth":0,"identityAuthTime":null,"pushHome":0,"sortTime":1525920213000,"openid":null,"unionid":"","qqUid":"","sinaUid":"","status":0,"topTime":null,"videoPath":null,"beanAmount":0,"openidMini":null,"openidWx":null,"flag":null,"weight":0}
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
         * id : 929
         * page : 1
         * rows : 20
         * pid : 0
         * salt : 7855684035909223
         * nickname : 阿萨德
         * realname : null
         * photo : http://qiniu.5roo.com/ff7166b5-b4a2-4c88-a886-a0c986f060cd.jpg
         * images : null
         * intro : null
         * details : null
         * mobile : 13552463977
         * psw : f7fa8725d352a61584a48a03d3235879d108f9fa2242eb39
         * email : null
         * sex : 0
         * birthday : 1524153600000
         * country : null
         * province : null
         * city : null
         * area : null
         * address : null
         * userType : 1
         * post : null
         * college : null
         * major : null
         * skilled : null
         * ip : null
         * lastTime : 1525949302000
         * createDate : 1525920213000
         * idcardFront : null
         * idcardBack : null
         * teachCard : null
         * isauth : 0
         * identityAuthTime : null
         * pushHome : 0
         * sortTime : 1525920213000
         * openid : null
         * unionid :
         * qqUid :
         * sinaUid :
         * status : 0
         * topTime : null
         * videoPath : null
         * beanAmount : 0
         * openidMini : null
         * openidWx : null
         * flag : null
         * weight : 0
         */

        private int id;
        private int page;
        private int rows;
        private int pid;
        private String salt;
        private String nickname;
        private Object realname;
        private String photo;
        private Object images;
        private Object intro;
        private Object details;
        private String mobile;
        private String psw;
        private Object email;
        private int sex;
        private long birthday;
        private Object country;
        private Object province;
        private Object city;
        private Object area;
        private Object address;
        private int userType;
        private Object post;
        private Object college;
        private Object major;
        private Object skilled;
        private Object ip;
        private long lastTime;
        private long createDate;
        private Object idcardFront;
        private Object idcardBack;
        private Object teachCard;
        private int isauth;
        private Object identityAuthTime;
        private int pushHome;
        private long sortTime;
        private Object openid;
        private String unionid;
        private String qqUid;
        private String sinaUid;
        private int status;
        private Object topTime;
        private Object videoPath;
        private int beanAmount;
        private Object openidMini;
        private Object openidWx;
        private Object flag;
        private int weight;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Object getRealname() {
            return realname;
        }

        public void setRealname(Object realname) {
            this.realname = realname;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public Object getImages() {
            return images;
        }

        public void setImages(Object images) {
            this.images = images;
        }

        public Object getIntro() {
            return intro;
        }

        public void setIntro(Object intro) {
            this.intro = intro;
        }

        public Object getDetails() {
            return details;
        }

        public void setDetails(Object details) {
            this.details = details;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPsw() {
            return psw;
        }

        public void setPsw(String psw) {
            this.psw = psw;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public Object getCountry() {
            return country;
        }

        public void setCountry(Object country) {
            this.country = country;
        }

        public Object getProvince() {
            return province;
        }

        public void setProvince(Object province) {
            this.province = province;
        }

        public Object getCity() {
            return city;
        }

        public void setCity(Object city) {
            this.city = city;
        }

        public Object getArea() {
            return area;
        }

        public void setArea(Object area) {
            this.area = area;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public Object getPost() {
            return post;
        }

        public void setPost(Object post) {
            this.post = post;
        }

        public Object getCollege() {
            return college;
        }

        public void setCollege(Object college) {
            this.college = college;
        }

        public Object getMajor() {
            return major;
        }

        public void setMajor(Object major) {
            this.major = major;
        }

        public Object getSkilled() {
            return skilled;
        }

        public void setSkilled(Object skilled) {
            this.skilled = skilled;
        }

        public Object getIp() {
            return ip;
        }

        public void setIp(Object ip) {
            this.ip = ip;
        }

        public long getLastTime() {
            return lastTime;
        }

        public void setLastTime(long lastTime) {
            this.lastTime = lastTime;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public Object getIdcardFront() {
            return idcardFront;
        }

        public void setIdcardFront(Object idcardFront) {
            this.idcardFront = idcardFront;
        }

        public Object getIdcardBack() {
            return idcardBack;
        }

        public void setIdcardBack(Object idcardBack) {
            this.idcardBack = idcardBack;
        }

        public Object getTeachCard() {
            return teachCard;
        }

        public void setTeachCard(Object teachCard) {
            this.teachCard = teachCard;
        }

        public int getIsauth() {
            return isauth;
        }

        public void setIsauth(int isauth) {
            this.isauth = isauth;
        }

        public Object getIdentityAuthTime() {
            return identityAuthTime;
        }

        public void setIdentityAuthTime(Object identityAuthTime) {
            this.identityAuthTime = identityAuthTime;
        }

        public int getPushHome() {
            return pushHome;
        }

        public void setPushHome(int pushHome) {
            this.pushHome = pushHome;
        }

        public long getSortTime() {
            return sortTime;
        }

        public void setSortTime(long sortTime) {
            this.sortTime = sortTime;
        }

        public Object getOpenid() {
            return openid;
        }

        public void setOpenid(Object openid) {
            this.openid = openid;
        }

        public String getUnionid() {
            return unionid;
        }

        public void setUnionid(String unionid) {
            this.unionid = unionid;
        }

        public String getQqUid() {
            return qqUid;
        }

        public void setQqUid(String qqUid) {
            this.qqUid = qqUid;
        }

        public String getSinaUid() {
            return sinaUid;
        }

        public void setSinaUid(String sinaUid) {
            this.sinaUid = sinaUid;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getTopTime() {
            return topTime;
        }

        public void setTopTime(Object topTime) {
            this.topTime = topTime;
        }

        public Object getVideoPath() {
            return videoPath;
        }

        public void setVideoPath(Object videoPath) {
            this.videoPath = videoPath;
        }

        public int getBeanAmount() {
            return beanAmount;
        }

        public void setBeanAmount(int beanAmount) {
            this.beanAmount = beanAmount;
        }

        public Object getOpenidMini() {
            return openidMini;
        }

        public void setOpenidMini(Object openidMini) {
            this.openidMini = openidMini;
        }

        public Object getOpenidWx() {
            return openidWx;
        }

        public void setOpenidWx(Object openidWx) {
            this.openidWx = openidWx;
        }

        public Object getFlag() {
            return flag;
        }

        public void setFlag(Object flag) {
            this.flag = flag;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
