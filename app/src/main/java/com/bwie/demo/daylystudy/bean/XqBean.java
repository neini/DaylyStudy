package com.bwie.demo.daylystudy.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/6.
 */

public class XqBean {

    /**
     * datalist : [{"cid":"5663","course_tname":"蔡岩","course_name":"蔡岩烘焙食品（一）","course_price":"5.00","course_pic":"http://img.dianfu.net/img/20161216/3d07f30fc00e2a2dd1309c5a97e2caba.jpg","course_paycount":"1","school_name":"优学教育"},{"cid":"5664","course_tname":"蔡岩","course_name":"蔡岩烘焙食品（二）","course_price":"5.00","course_pic":"http://img.dianfu.net/img/20161216/2baf9688a15aca9cccacfdc8c9043cce.jpg","course_paycount":"0","school_name":"优学教育"},{"cid":"2505","course_tname":"唐光富,郑邦均","course_name":"西式甜点教学之芝士蛋糕","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20150928/37de80a599a35758e9eafa5dcb21d070.jpg","course_paycount":"704","school_name":"东华众辰"},{"cid":"2502","course_tname":"唐光富,郑邦均","course_name":"西式甜点教学之天使蛋糕","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20150928/e56d48c908f2de935834236dbf76e747.jpg","course_paycount":"635","school_name":"东华众辰"},{"cid":"2500","course_tname":"唐光富,郑邦均","course_name":"西式甜点教学之提拉米苏","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20150928/5b25c435673f08dd9451906b9204b381.jpg","course_paycount":"973","school_name":"东华众辰"},{"cid":"2504","course_tname":"唐光富,郑邦均","course_name":"西式甜点教学之抹茶慕斯","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20150928/87e574a0e040e50b3408a03ceefb7022.jpg","course_paycount":"984","school_name":"东华众辰"},{"cid":"2501","course_tname":"唐光富,郑邦均","course_name":"西式甜点教学之牛油曲奇饼、戚风水果蛋糕","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20150928/5565e34b1e73fcc9238c854dfa3266df.jpg","course_paycount":"170","school_name":"东华众辰"},{"cid":"2503","course_tname":"唐光富,郑邦均","course_name":"西式甜点教学之草莓慕斯蛋糕","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20150928/2c24bd0f51ea8bf1931cd6d104a45bbf.jpg","course_paycount":"174","school_name":"东华众辰"},{"cid":"2495","course_tname":"唐光富,郑邦均","course_name":"西式甜点教学","course_price":"0.00","course_pic":"http://img.dianfu.net/img/20150928/8d2d0f352b01c9444ee839553e60db1b.jpg","course_paycount":"223","school_name":"东华众辰"}]
     * count : 9
     * limit : 10
     * curpage : 1
     */

    private int count;
    private int limit;
    private int curpage;
    private List<DatalistBean> datalist;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCurpage() {
        return curpage;
    }

    public void setCurpage(int curpage) {
        this.curpage = curpage;
    }

    public List<DatalistBean> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<DatalistBean> datalist) {
        this.datalist = datalist;
    }

    public static class DatalistBean {
        /**
         * cid : 5663
         * course_tname : 蔡岩
         * course_name : 蔡岩烘焙食品（一）
         * course_price : 5.00
         * course_pic : http://img.dianfu.net/img/20161216/3d07f30fc00e2a2dd1309c5a97e2caba.jpg
         * course_paycount : 1
         * school_name : 优学教育
         */

        private String cid;
        private String course_tname;
        private String course_name;
        private String course_price;
        private String course_pic;
        private String course_paycount;
        private String school_name;

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getCourse_tname() {
            return course_tname;
        }

        public void setCourse_tname(String course_tname) {
            this.course_tname = course_tname;
        }

        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
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

        public String getCourse_paycount() {
            return course_paycount;
        }

        public void setCourse_paycount(String course_paycount) {
            this.course_paycount = course_paycount;
        }

        public String getSchool_name() {
            return school_name;
        }

        public void setSchool_name(String school_name) {
            this.school_name = school_name;
        }
    }
}
