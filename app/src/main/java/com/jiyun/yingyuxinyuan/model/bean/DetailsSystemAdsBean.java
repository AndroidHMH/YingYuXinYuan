package com.jiyun.yingyuxinyuan.model.bean;

/**
 * Created by asus on 2018/5/8.
 */

public class DetailsSystemAdsBean {

    /**
     * code : 0
     * message : 成功
     * data : {"address":"北京市朝阳区曹八里1号院6号楼","coverImg":"http://qiniu.5roo.com/40a30523-0b69-4073-a453-38cf02349a68.jpg","endDate":1521966600000,"collegeIds":"14","reservationNum":50,"mobile":"12545856848","isReservation":0,"title":"4天，32课时，轻松拿音基教师资格证","courseContent":"<p align=\"center\"><img src=\"http://qiniu.5roo.com/7ada936e-6c40-4af3-b93e-53b0f345a01a.jpg\" style=\"max-width:100%;\"><br><\/p><p align=\"center\"><img src=\"http://qiniu.5roo.com/d653744e-3c26-4c94-9dae-637c6d913133.jpg\" style=\"max-width:100%;\"><br><\/p><p><img src=\"http://qiniu.5roo.com/60cdf010-c5bb-4051-a1e5-736e11b3af35.jpg\" style=\"max-width:100%;\"><br><\/p>","majorIds":"1","subscribeNum":20,"price":1730,"id":61,"favorite":0,"startDate":1521855000000,"courseVideoPath":""}
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
         * address : 北京市朝阳区曹八里1号院6号楼
         * coverImg : http://qiniu.5roo.com/40a30523-0b69-4073-a453-38cf02349a68.jpg
         * endDate : 1521966600000
         * collegeIds : 14
         * reservationNum : 50
         * mobile : 12545856848
         * isReservation : 0
         * title : 4天，32课时，轻松拿音基教师资格证
         * courseContent : <p align="center"><img src="http://qiniu.5roo.com/7ada936e-6c40-4af3-b93e-53b0f345a01a.jpg" style="max-width:100%;"><br></p><p align="center"><img src="http://qiniu.5roo.com/d653744e-3c26-4c94-9dae-637c6d913133.jpg" style="max-width:100%;"><br></p><p><img src="http://qiniu.5roo.com/60cdf010-c5bb-4051-a1e5-736e11b3af35.jpg" style="max-width:100%;"><br></p>
         * majorIds : 1
         * subscribeNum : 20
         * price : 1730
         * id : 61
         * favorite : 0
         * startDate : 1521855000000
         * courseVideoPath :
         */

        private String address;
        private String coverImg;
        private long endDate;
        private String collegeIds;
        private int reservationNum;
        private String mobile;
        private int isReservation;
        private String title;
        private String courseContent;
        private String majorIds;
        private int subscribeNum;
        private double price;
        private int id;
        private int favorite;
        private long startDate;
        private String courseVideoPath;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCoverImg() {
            return coverImg;
        }

        public void setCoverImg(String coverImg) {
            this.coverImg = coverImg;
        }

        public long getEndDate() {
            return endDate;
        }

        public void setEndDate(long endDate) {
            this.endDate = endDate;
        }

        public String getCollegeIds() {
            return collegeIds;
        }

        public void setCollegeIds(String collegeIds) {
            this.collegeIds = collegeIds;
        }

        public int getReservationNum() {
            return reservationNum;
        }

        public void setReservationNum(int reservationNum) {
            this.reservationNum = reservationNum;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getIsReservation() {
            return isReservation;
        }

        public void setIsReservation(int isReservation) {
            this.isReservation = isReservation;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCourseContent() {
            return courseContent;
        }

        public void setCourseContent(String courseContent) {
            this.courseContent = courseContent;
        }

        public String getMajorIds() {
            return majorIds;
        }

        public void setMajorIds(String majorIds) {
            this.majorIds = majorIds;
        }

        public int getSubscribeNum() {
            return subscribeNum;
        }

        public void setSubscribeNum(int subscribeNum) {
            this.subscribeNum = subscribeNum;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getFavorite() {
            return favorite;
        }

        public void setFavorite(int favorite) {
            this.favorite = favorite;
        }

        public long getStartDate() {
            return startDate;
        }

        public void setStartDate(long startDate) {
            this.startDate = startDate;
        }

        public String getCourseVideoPath() {
            return courseVideoPath;
        }

        public void setCourseVideoPath(String courseVideoPath) {
            this.courseVideoPath = courseVideoPath;
        }
    }
}
