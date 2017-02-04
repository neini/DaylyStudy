package com.bwie.demo.daylystudy.bean;

import java.util.List;

/**
 * Created by ${薛亚南}
 * on 2017/1/15 20：46.
 */

public class HotTitleBean {

    /**
     * code : 200
     * msg : 请求成功
     * data : [{"tid":"77","name":"星座","status":"1","ishot":"1","sort":"2","isrecommend":"1","recommend_sort":"2","ctime":"1466753392","hottopic":"0"},{"tid":"98","name":"健身","status":"1","ishot":"1","sort":"1","isrecommend":"1","recommend_sort":"1","ctime":"1467117856","hottopic":"0"},{"tid":"110","name":"穿搭","status":"1","ishot":"1","sort":"1","isrecommend":"1","recommend_sort":"1","ctime":"1467201978","hottopic":"0"},{"tid":"111","name":"吐槽","status":"1","ishot":"1","sort":"1","isrecommend":"1","recommend_sort":"1","ctime":"1467203112","hottopic":"0"},{"tid":"76","name":"美妆","status":"1","ishot":"1","sort":"1","isrecommend":"1","recommend_sort":"1","ctime":"1466753300","hottopic":"0"},{"tid":"86","name":"冷知识","status":"1","ishot":"1","sort":"0","isrecommend":"1","recommend_sort":"0","ctime":"1466753543","hottopic":"0"},{"tid":"79","name":"手作","status":"1","ishot":"1","sort":"0","isrecommend":"1","recommend_sort":"0","ctime":"1466753448","hottopic":"0"},{"tid":"68","name":"音乐","status":"1","ishot":"0","sort":"0","isrecommend":"1","recommend_sort":"0","ctime":"1467354890","hottopic":"0"},{"tid":"89","name":"摄影","status":"1","ishot":"1","sort":"0","isrecommend":"1","recommend_sort":"0","ctime":"1466753589","hottopic":"0"},{"tid":"80","name":"烘焙","status":"1","ishot":"1","sort":"0","isrecommend":"1","recommend_sort":"0","ctime":"1466753463","hottopic":"0"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * tid : 77
         * name : 星座
         * status : 1
         * ishot : 1
         * sort : 2
         * isrecommend : 1
         * recommend_sort : 2
         * ctime : 1466753392
         * hottopic : 0
         */

        private String tid;
        private String name;
        private String status;
        private String ishot;
        private String sort;
        private String isrecommend;
        private String recommend_sort;
        private String ctime;
        private String hottopic;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIshot() {
            return ishot;
        }

        public void setIshot(String ishot) {
            this.ishot = ishot;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getIsrecommend() {
            return isrecommend;
        }

        public void setIsrecommend(String isrecommend) {
            this.isrecommend = isrecommend;
        }

        public String getRecommend_sort() {
            return recommend_sort;
        }

        public void setRecommend_sort(String recommend_sort) {
            this.recommend_sort = recommend_sort;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getHottopic() {
            return hottopic;
        }

        public void setHottopic(String hottopic) {
            this.hottopic = hottopic;
        }
    }
}
