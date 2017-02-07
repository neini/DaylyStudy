package com.bwie.demo.daylystudy.bean;

import java.util.List;



/**
 * Created by johpo on 2017/1/15 0015.
 */

public class DianJiBean {

    /**
     * status : 200
     * showtype : 2
     * desc : 秋天已到，寒意来袭。华服只能抵御身体的寒冷，亲手为他织一件围巾吧，温暖他的心！
     * toppic : http://img.dianfu.net/img/20160823/01abf9ba29731fb58c5fdf41401d5e8e.jpg
     * dataList : [{"title":"织围巾","list":[{"cid":"5252","course_name":"小白淘屋编织教程之围巾1","course_paycount":"69","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/969c5e55b2e36be90521783a0a4aeaeb.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5253","course_name":"小白淘屋编织教程之围巾2 ","course_paycount":"22","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/736114a71745f29dc8d29a39beba1569.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5254","course_name":"小白淘屋编织教程之围巾3","course_paycount":"42","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/5c3d2bf16fe2fe70c2bf808b9425e27b.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5256","course_name":"小白淘屋编织教程之围巾4","course_paycount":"22","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/9358142affa76b81eafff43f878ba446.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5258","course_name":"小白淘屋编织教程之围巾5","course_paycount":"31","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/64e63b835dd35279c7bd9149b5a6f753.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5259","course_name":"小白淘屋编织教程之围巾6","course_paycount":"22","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/f37a0b04578881f12a635a5f986621ea.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5260","course_name":"小白淘屋编织教程之围巾7","course_paycount":"31","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/91b0c532c00efe398bb1050cf65c43aa.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5247","course_name":"小白淘屋编织教程之围巾8","course_paycount":"39","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/e88eba6d7e34019fc82f64619e5787f0.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5250","course_name":"小白淘屋编织教程之围巾9","course_paycount":"23","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/382870913e61821720593a6dff0c72c4.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5266","course_name":"小白淘屋编织教程之围巾10","course_paycount":"63","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/8f5c0ffd1e029beed931b9433a7e41ee.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5290","course_name":"小白淘屋编织教程之围巾11","course_paycount":"98","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/2762e96490231de209e67150ec7c4bb0.jpg","sid":"109","school_name":"小白淘屋"}]}]
     */

    private int status;
    private String showtype;
    private String desc;
    private String toppic;
    private List<DataListBean> dataList;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getShowtype() {
        return showtype;
    }

    public void setShowtype(String showtype) {
        this.showtype = showtype;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getToppic() {
        return toppic;
    }

    public void setToppic(String toppic) {
        this.toppic = toppic;
    }

    public List<DataListBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBean> dataList) {
        this.dataList = dataList;
    }

    public static class DataListBean {
        /**
         * title : 织围巾
         * list : [{"cid":"5252","course_name":"小白淘屋编织教程之围巾1","course_paycount":"69","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/969c5e55b2e36be90521783a0a4aeaeb.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5253","course_name":"小白淘屋编织教程之围巾2 ","course_paycount":"22","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/736114a71745f29dc8d29a39beba1569.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5254","course_name":"小白淘屋编织教程之围巾3","course_paycount":"42","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/5c3d2bf16fe2fe70c2bf808b9425e27b.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5256","course_name":"小白淘屋编织教程之围巾4","course_paycount":"22","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/9358142affa76b81eafff43f878ba446.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5258","course_name":"小白淘屋编织教程之围巾5","course_paycount":"31","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/64e63b835dd35279c7bd9149b5a6f753.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5259","course_name":"小白淘屋编织教程之围巾6","course_paycount":"22","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/f37a0b04578881f12a635a5f986621ea.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5260","course_name":"小白淘屋编织教程之围巾7","course_paycount":"31","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/91b0c532c00efe398bb1050cf65c43aa.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5247","course_name":"小白淘屋编织教程之围巾8","course_paycount":"39","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/e88eba6d7e34019fc82f64619e5787f0.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5250","course_name":"小白淘屋编织教程之围巾9","course_paycount":"23","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/382870913e61821720593a6dff0c72c4.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5266","course_name":"小白淘屋编织教程之围巾10","course_paycount":"63","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/8f5c0ffd1e029beed931b9433a7e41ee.jpg","sid":"109","school_name":"小白淘屋"},{"cid":"5290","course_name":"小白淘屋编织教程之围巾11","course_paycount":"98","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20160804/2762e96490231de209e67150ec7c4bb0.jpg","sid":"109","school_name":"小白淘屋"}]
         */

        private String title;
        private List<ListBean> list;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * cid : 5252
             * course_name : 小白淘屋编织教程之围巾1
             * course_paycount : 69
             * course_price : 0.00
             * course_pic : http://img.dianfu.net/img/20160804/969c5e55b2e36be90521783a0a4aeaeb.jpg
             * sid : 109
             * school_name : 小白淘屋
             */

            private String cid;
            private String course_name;
            private String course_paycount;
            private String course_price;
            private String course_pic;
            private String sid;
            private String school_name;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getCourse_name() {
                return course_name;
            }

            public void setCourse_name(String course_name) {
                this.course_name = course_name;
            }

            public String getCourse_paycount() {
                return course_paycount;
            }

            public void setCourse_paycount(String course_paycount) {
                this.course_paycount = course_paycount;
            }

            public String getCourse_price() {
                return course_price;
            }

            public void setCourse_price(String course_price) {
                this.course_price = course_price;
            }

            public String getCourse_pic() {
                return course_pic;
            }

            public void setCourse_pic(String course_pic) {
                this.course_pic = course_pic;
            }

            public String getSid() {
                return sid;
            }

            public void setSid(String sid) {
                this.sid = sid;
            }

            public String getSchool_name() {
                return school_name;
            }

            public void setSchool_name(String school_name) {
                this.school_name = school_name;
            }
        }
    }
}

