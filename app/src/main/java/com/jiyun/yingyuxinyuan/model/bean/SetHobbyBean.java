package com.jiyun.yingyuxinyuan.model.bean;

import java.util.List;

/**
 * Created by ASUS on 2018/05/04.
 */

public class SetHobbyBean {
    @Override
    public String toString() {
        return "SetHobbyBean{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    /**
     * code : 0
     * data : {"colleges":[{"id":1,"name":"中央音乐学院","page":1,"rows":20,"sortord":1},{"id":2,"name":"中央美术学院","page":1,"rows":20,"sortord":2},{"id":3,"name":"中央戏剧学院","page":1,"rows":20,"sortord":3},{"id":4,"name":"北京电影学院","page":1,"rows":20,"sortord":4},{"id":5,"name":"北京舞蹈学院","page":1,"rows":20,"sortord":5},{"id":6,"name":"鲁迅美术学院","page":1,"rows":20,"sortord":6},{"id":7,"name":"上海戏剧学院","page":1,"rows":20,"sortord":7},{"id":8,"name":"中国戏曲学院","page":1,"rows":20,"sortord":8},{"id":9,"name":"南京艺术学院","page":1,"rows":20,"sortord":9},{"id":10,"name":"四川美术学院","page":1,"rows":20,"sortord":10},{"id":11,"name":"四川音乐学院","page":1,"rows":20,"sortord":11},{"id":12,"name":"沈阳音乐学院","page":1,"rows":20,"sortord":12},{"id":14,"name":"中国音乐学院","page":1,"rows":20,"sortord":13},{"id":15,"name":"中央工艺美术学院","page":1,"rows":20},{"id":16,"name":"北京师范大学","page":1,"rows":20},{"id":17,"name":"山西工商学院","page":1,"rows":20},{"id":19,"name":"武汉音乐学院","page":1,"rows":20},{"id":20,"name":"中南民族大学","page":1,"rows":20},{"id":21,"name":"河北传媒学院","page":1,"rows":20},{"id":23,"name":"陕西师范大学","page":1,"rows":20},{"id":25,"name":"西安培华学院","page":1,"rows":20},{"id":26,"name":"北京现代音乐学院","page":1,"rows":20},{"id":27,"name":"中国传媒大学","page":1,"rows":20}],"majors":[{"id":1,"intro":"声乐，是指用人声演唱的音乐形式。声乐是以人的声带为主，配合口腔、舌头、鼻腔作用于气息，发出的悦耳的、连续性、有节奏的声音。按音域的高低和音色的差异，可以分为女高音、女中音、女低音和男高音、男中音、男低音。每一种人声的音域，大约为二个八度。","name":"声乐","pId":0,"page":1,"photo":"http://qiniu.5roo.com/396dbe91-a8a1-4ee9-8109-6192ed734e28.jpg","rows":20,"sortord":4,"thumbPhoto":"http://qiniu.5roo.com/6babe952-5b9e-4849-b80b-8dda43b8d18e.jpg"},{"id":2,"intro":"编导就是编和导，从编导从事的工作性质来看编可理解为：编写、编撰、编排、编辑、编剧等；导可理解为：引导、指导、领导、导向、导播、导演等。所以，从字面理解编导就是即能编又能导的复合型人才和职业。编导，是广播电视行业一个专有名词。","name":"编导","pId":0,"page":1,"photo":"http://qiniu.5roo.com/0165e0e7-c1de-4152-a40e-cc24f69e5dd8.jpg","rows":20,"sortord":3,"thumbPhoto":"http://qiniu.5roo.com/f36379b2-244c-4d88-bac8-0c810450aca2.jpg"},{"id":5,"intro":"空乘的职业生涯可分为四个阶段：普通舱乘务员、两舱乘务员、区域乘务长、主任乘务长。一般学员在完成相应的业务培训后，可担当普通舱乘务员。随着飞行小时数的增加，个人资历的提升，通过相应的考核，可提升为两舱/头等舱乘务员。头等舱乘务员考核期满后，可担当区域乘务长，成绩优秀的区域乘务长经过考评委员会严格的考评后，可担当主任乘务长，并可以独立带班执行国际航班以及首长专机任务。","name":"空乘","pId":0,"page":1,"photo":"http://qiniu.5roo.com/51704c36-37c1-4e61-b2e5-1a26787d6146.jpg","rows":20,"sortord":2,"thumbPhoto":"http://qiniu.5roo.com/e1d72592-e986-43c1-a740-ba082857f531.jpg"},{"id":6,"intro":"表演专业属于一级艺术学科，表演专业旨在培养具有一定的基本理论素养，并具备和掌握表演艺术的基本理论和基本技巧，能够在戏剧、戏曲、电影、电视和舞蹈等表演中独立完成不同人物形象创作的高级专门人才。 ","name":"表演","pId":0,"page":1,"photo":"http://qiniu.5roo.com/b93a8ea1-93ea-4100-8c5a-97165222d71f.jpg","rows":20,"sortord":8,"thumbPhoto":"http://qiniu.5roo.com/0a726477-248b-45a9-8ebe-7378497c8bc3.jpg"},{"id":7,"intro":"美术专业为美术史论、美术教育领域培养教学和科研，美术评论和编辑、艺术管理和博物馆等方面的高级专门人才，学生毕业后能从事美术教育、美术研究、文博艺术管理、新闻出版等方面的工作。","name":"美术","pId":0,"page":1,"photo":"http://qiniu.5roo.com/171c4295-cc47-42f6-a116-6f1ae046e192.jpg","rows":20,"sortord":6,"thumbPhoto":"http://qiniu.5roo.com/0d717efd-47be-4d36-b897-e92849fc743a.jpg"},{"id":27,"intro":"器乐是相对于声乐而言，完全使用乐器演奏而不用人声或者人声处于附属地位的音乐。演奏的乐器可以包括所有种类的弦乐器、木管乐器、铜管乐器和打击乐器，有的器乐曲也应用部分人声作为效果，但部分作曲家有时也加入一些人声，例如《贝多芬第九交响曲》的《欢乐颂》合唱部分，但总的来说交响曲属于器乐而不属于声乐。","name":"器乐","pId":0,"page":1,"photo":"http://qiniu.5roo.com/208dac4e-40f9-489d-a076-002b9a0580e4.jpg","rows":20,"sortord":0,"thumbPhoto":"http://qiniu.5roo.com/9d7bccc5-f406-4c22-ba5f-526162d22a6e.jpg"},{"id":32,"intro":"舞蹈表演的任务是，以其掌握的舞蹈动作、造型和技巧能力，结合音乐和美术等艺术手段，将作品的思想内容转化为可视可感的舞蹈形象。","name":"舞蹈表演","pId":0,"page":1,"photo":"http://qiniu.5roo.com/6e5ba2d0-5b9d-4ca9-bdc4-8fc51b2bea58.jpg","rows":20,"sortord":7,"thumbPhoto":"http://qiniu.5roo.com/292a419e-b0c1-4bca-a5eb-231e38764c10.jpg"},{"id":33,"intro":"舞蹈（舞剧）作品创作、排练和演出过程中的组织者和领导者。其专业特点是\u201c编\u201d和\u201c导\u201d的紧密结合和高度统一。","name":"舞蹈编导","pId":0,"page":1,"photo":"http://qiniu.5roo.com/20a288d7-0cc4-4d82-b98c-2867cdb1877d.jpg","rows":20,"sortord":0,"thumbPhoto":"http://qiniu.5roo.com/a22a0027-c1bf-4ec7-add0-4358e04ceed1.jpg"},{"id":44,"intro":"","name":"戏剧文学","pId":0,"page":1,"photo":"http://qiniu.5roo.com/9815ffee-eb42-44b0-b2a9-40af5eff7a13.jpg","rows":20,"sortord":0,"thumbPhoto":"http://qiniu.5roo.com/0df65e98-2240-475a-8165-696678caf0f7.jpg"},{"id":49,"intro":"播音与主持艺术在我国是一个新兴专业，随着文化产业的飞速发展，播音主持人职业将成为未来就业领域的热点和亮点。目前，全国有播音主持专业院校达到600所以上，以中国传媒大学、浙江传媒学院、中国传媒大学南广学院、山西传媒学院、上海戏剧学院等为代表的全国播音主持专业院校每年培养数千播音主持人才。播音专业目标是培养具备广播电视新闻传播、语言文学等能力，能担任广播电视播音与节目主持工作的复合型应用语言学高级专门人才。","name":"播音主持","pId":0,"page":1,"photo":"http://qiniu.5roo.com/e60fd444-7aba-4fe8-a743-c8091edac48e.jpg","rows":20,"sortord":5,"thumbPhoto":"http://qiniu.5roo.com/f51013b1-b0b3-4ad7-b69b-b4fc52e8a3aa.jpg"},{"id":50,"intro":"","name":"其他","pId":0,"page":1,"photo":"http://qiniu.5roo.com/ff211529-c4f9-4fcb-982b-c9c52dc8ff10.jpg","rows":20,"sortord":1,"thumbPhoto":"http://qiniu.5roo.com/81a4d784-0438-46ee-a264-0ae24043bbd7.jpg"}]}
     * message : 成功
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        private List<CollegesBean> colleges;
        private List<MajorsBean> majors;

        @Override
        public String toString() {
            return "DataBean{" +
                    "colleges=" + colleges +
                    ", majors=" + majors +
                    '}';
        }

        public List<CollegesBean> getColleges() {
            return colleges;
        }

        public void setColleges(List<CollegesBean> colleges) {
            this.colleges = colleges;
        }

        public List<MajorsBean> getMajors() {
            return majors;
        }

        public void setMajors(List<MajorsBean> majors) {
            this.majors = majors;
        }

        public static class CollegesBean {
            @Override
            public String toString() {
                return "CollegesBean{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", page=" + page +
                        ", rows=" + rows +
                        ", sortord=" + sortord +
                        '}';
            }

            /**
             * id : 1
             * name : 中央音乐学院
             * page : 1
             * rows : 20
             * sortord : 1
             */

            private int id;
            private String name;
            private int page;
            private int rows;
            private int sortord;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

            public int getSortord() {
                return sortord;
            }

            public void setSortord(int sortord) {
                this.sortord = sortord;
            }
        }

        public static class MajorsBean {
            @Override
            public String toString() {
                return "MajorsBean{" +
                        "id=" + id +
                        ", intro='" + intro + '\'' +
                        ", name='" + name + '\'' +
                        ", pId=" + pId +
                        ", page=" + page +
                        ", photo='" + photo + '\'' +
                        ", rows=" + rows +
                        ", sortord=" + sortord +
                        ", thumbPhoto='" + thumbPhoto + '\'' +
                        '}';
            }

            /**
             * id : 1
             * intro : 声乐，是指用人声演唱的音乐形式。声乐是以人的声带为主，配合口腔、舌头、鼻腔作用于气息，发出的悦耳的、连续性、有节奏的声音。按音域的高低和音色的差异，可以分为女高音、女中音、女低音和男高音、男中音、男低音。每一种人声的音域，大约为二个八度。
             * name : 声乐
             * pId : 0
             * page : 1
             * photo : http://qiniu.5roo.com/396dbe91-a8a1-4ee9-8109-6192ed734e28.jpg
             * rows : 20
             * sortord : 4
             * thumbPhoto : http://qiniu.5roo.com/6babe952-5b9e-4849-b80b-8dda43b8d18e.jpg
             */

            private int id;
            private String intro;
            private String name;
            private int pId;
            private int page;
            private String photo;
            private int rows;
            private int sortord;
            private String thumbPhoto;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPId() {
                return pId;
            }

            public void setPId(int pId) {
                this.pId = pId;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public int getRows() {
                return rows;
            }

            public void setRows(int rows) {
                this.rows = rows;
            }

            public int getSortord() {
                return sortord;
            }

            public void setSortord(int sortord) {
                this.sortord = sortord;
            }

            public String getThumbPhoto() {
                return thumbPhoto;
            }

            public void setThumbPhoto(String thumbPhoto) {
                this.thumbPhoto = thumbPhoto;
            }
        }
    }
}
