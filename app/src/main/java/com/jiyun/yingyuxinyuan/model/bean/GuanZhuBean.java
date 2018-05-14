package com.jiyun.yingyuxinyuan.model.bean;

import java.util.List;

/**
 * Created by ASUS on 2018/05/13.
 */

public class GuanZhuBean {

    /**
     * code : 0
     * message : 成功
     * data : {"pageNum":1,"pageSize":20,"size":6,"startRow":1,"endRow":6,"total":6,"pages":1,"list":[{"intro":null,"nickname":"hy3098626581","photo":"http://qiniu.5roo.com/5c777c24-869b-409e-8b5d-5ce07b836ec0.jpg","attention":2,"attentionId":731,"userType":1,"realname":null},{"intro":null,"nickname":"你好","photo":null,"attention":1,"attentionId":931,"userType":1,"realname":null},{"intro":"台词教师","nickname":"张芮瑜","photo":"http://qiniu.5roo.com/c4856415-a044-48bd-b94a-be12a248f330.jpg","attention":1,"attentionId":110,"userType":3,"realname":"张芮瑜"},{"intro":"表演届泰斗","nickname":"李苒苒","photo":"http://qiniu.5roo.com/806d2c15-cef8-411f-8ead-2822c3581787.jpg","attention":1,"attentionId":262,"userType":4,"realname":"李苒苒"},{"intro":null,"nickname":"你好","photo":null,"attention":1,"attentionId":931,"userType":1,"realname":null},{"intro":"台词教师","nickname":"陈雅韩","photo":"http://qiniu.5roo.com/34b06db1-bcfa-4370-b7c7-dbf74e48eec9.jpg","attention":1,"attentionId":459,"userType":3,"realname":"陈雅韩"}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
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
         * pageNum : 1
         * pageSize : 20
         * size : 6
         * startRow : 1
         * endRow : 6
         * total : 6
         * pages : 1
         * list : [{"intro":null,"nickname":"hy3098626581","photo":"http://qiniu.5roo.com/5c777c24-869b-409e-8b5d-5ce07b836ec0.jpg","attention":2,"attentionId":731,"userType":1,"realname":null},{"intro":null,"nickname":"你好","photo":null,"attention":1,"attentionId":931,"userType":1,"realname":null},{"intro":"台词教师","nickname":"张芮瑜","photo":"http://qiniu.5roo.com/c4856415-a044-48bd-b94a-be12a248f330.jpg","attention":1,"attentionId":110,"userType":3,"realname":"张芮瑜"},{"intro":"表演届泰斗","nickname":"李苒苒","photo":"http://qiniu.5roo.com/806d2c15-cef8-411f-8ead-2822c3581787.jpg","attention":1,"attentionId":262,"userType":4,"realname":"李苒苒"},{"intro":null,"nickname":"你好","photo":null,"attention":1,"attentionId":931,"userType":1,"realname":null},{"intro":"台词教师","nickname":"陈雅韩","photo":"http://qiniu.5roo.com/34b06db1-bcfa-4370-b7c7-dbf74e48eec9.jpg","attention":1,"attentionId":459,"userType":3,"realname":"陈雅韩"}]
         * prePage : 0
         * nextPage : 0
         * isFirstPage : true
         * isLastPage : true
         * hasPreviousPage : false
         * hasNextPage : false
         * navigatePages : 8
         * navigatepageNums : [1]
         * navigateFirstPage : 1
         * navigateLastPage : 1
         * firstPage : 1
         * lastPage : 1
         */

        private int pageNum;
        private int pageSize;
        private int size;
        private int startRow;
        private int endRow;
        private int total;
        private int pages;
        private int prePage;
        private int nextPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private int navigatePages;
        private int navigateFirstPage;
        private int navigateLastPage;
        private int firstPage;
        private int lastPage;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public int getNavigateFirstPage() {
            return navigateFirstPage;
        }

        public void setNavigateFirstPage(int navigateFirstPage) {
            this.navigateFirstPage = navigateFirstPage;
        }

        public int getNavigateLastPage() {
            return navigateLastPage;
        }

        public void setNavigateLastPage(int navigateLastPage) {
            this.navigateLastPage = navigateLastPage;
        }

        public int getFirstPage() {
            return firstPage;
        }

        public void setFirstPage(int firstPage) {
            this.firstPage = firstPage;
        }

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBean {
            /**
             * intro : null
             * nickname : hy3098626581
             * photo : http://qiniu.5roo.com/5c777c24-869b-409e-8b5d-5ce07b836ec0.jpg
             * attention : 2
             * attentionId : 731
             * userType : 1
             * realname : null
             */

            private Object intro;
            private String nickname;
            private String photo;
            private int attention;
            private int attentionId;
            private int userType;
            private Object realname;

            public Object getIntro() {
                return intro;
            }

            public void setIntro(Object intro) {
                this.intro = intro;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public int getAttention() {
                return attention;
            }

            public void setAttention(int attention) {
                this.attention = attention;
            }

            public int getAttentionId() {
                return attentionId;
            }

            public void setAttentionId(int attentionId) {
                this.attentionId = attentionId;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public Object getRealname() {
                return realname;
            }

            public void setRealname(Object realname) {
                this.realname = realname;
            }
        }
    }
}
