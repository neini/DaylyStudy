package com.bwie.demo.daylystudy.bean;

/**
 * Created by ${薛亚南}
 * on 2017/1/17 16：07.
 */

public class TopicInfoTopBean {
    /**
     * code : 200
     * msg : 请求成功
     * data : {"nid":"6","n_title":"学霸挑战","n_brief":"月球探险点这里！好礼相送！","n_small_img":"http://img.dianfu.net/img/20160628/07ba9393f52ef5bfe3541b84bdb80f49.jpg","n_big_img":"http://img.dianfu.net/img/20160628/b5cd189ae8a43c86d10f9523e778301f.jpg","n_icon":"1","n_user_count":"422","n_post_count":"184","n_praise_count":"355","n_replay_count":"300","n_order":"1","n_status":"1","n_ctime":null,"is_commend":"0","isjoin":0}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * nid : 6
         * n_title : 学霸挑战
         * n_brief : 月球探险点这里！好礼相送！
         * n_small_img : http://img.dianfu.net/img/20160628/07ba9393f52ef5bfe3541b84bdb80f49.jpg
         * n_big_img : http://img.dianfu.net/img/20160628/b5cd189ae8a43c86d10f9523e778301f.jpg
         * n_icon : 1
         * n_user_count : 422
         * n_post_count : 184
         * n_praise_count : 355
         * n_replay_count : 300
         * n_order : 1
         * n_status : 1
         * n_ctime : null
         * is_commend : 0
         * isjoin : 0
         */

        private String nid;
        private String n_title;
        private String n_brief;
        private String n_small_img;
        private String n_big_img;
        private String n_icon;
        private String n_user_count;
        private String n_post_count;
        private String n_praise_count;
        private String n_replay_count;
        private String n_order;
        private String n_status;
        private Object n_ctime;
        private String is_commend;
        private int isjoin;

        public String getNid() {
            return nid;
        }

        public void setNid(String nid) {
            this.nid = nid;
        }

        public String getN_title() {
            return n_title;
        }

        public void setN_title(String n_title) {
            this.n_title = n_title;
        }

        public String getN_brief() {
            return n_brief;
        }

        public void setN_brief(String n_brief) {
            this.n_brief = n_brief;
        }

        public String getN_small_img() {
            return n_small_img;
        }

        public void setN_small_img(String n_small_img) {
            this.n_small_img = n_small_img;
        }

        public String getN_big_img() {
            return n_big_img;
        }

        public void setN_big_img(String n_big_img) {
            this.n_big_img = n_big_img;
        }

        public String getN_icon() {
            return n_icon;
        }

        public void setN_icon(String n_icon) {
            this.n_icon = n_icon;
        }

        public String getN_user_count() {
            return n_user_count;
        }

        public void setN_user_count(String n_user_count) {
            this.n_user_count = n_user_count;
        }

        public String getN_post_count() {
            return n_post_count;
        }

        public void setN_post_count(String n_post_count) {
            this.n_post_count = n_post_count;
        }

        public String getN_praise_count() {
            return n_praise_count;
        }

        public void setN_praise_count(String n_praise_count) {
            this.n_praise_count = n_praise_count;
        }

        public String getN_replay_count() {
            return n_replay_count;
        }

        public void setN_replay_count(String n_replay_count) {
            this.n_replay_count = n_replay_count;
        }

        public String getN_order() {
            return n_order;
        }

        public void setN_order(String n_order) {
            this.n_order = n_order;
        }

        public String getN_status() {
            return n_status;
        }

        public void setN_status(String n_status) {
            this.n_status = n_status;
        }

        public Object getN_ctime() {
            return n_ctime;
        }

        public void setN_ctime(Object n_ctime) {
            this.n_ctime = n_ctime;
        }

        public String getIs_commend() {
            return is_commend;
        }

        public void setIs_commend(String is_commend) {
            this.is_commend = is_commend;
        }

        public int getIsjoin() {
            return isjoin;
        }

        public void setIsjoin(int isjoin) {
            this.isjoin = isjoin;
        }
    }
}
