package com.bwie.demo.daylystudy.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by johpo on 2017/2/7 0007.
 */

public class   MuLuBean  implements Serializable {

    /**
     * code : 200
     * data : [{"id":"1745","step_name":"乐曲课","step_course_id":"691","step_order":"3","nodes":[{"seid":"8355","sections_name":"乐曲课一：《我和你》","sections_chid":"1745","sections_des":"","sections_isfree":"2","sections_sort":"1","vtime":500904},{"seid":"8356","sections_name":"乐曲课二：《龙的传人》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"2","vtime":460224},{"seid":"15353","sections_name":"乐曲课三：《欢乐颂》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"3","vtime":603000},{"seid":"15354","sections_name":"乐曲课四：《斯卡波罗集市》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"4","vtime":811120},{"seid":"15355","sections_name":"乐曲课五：《匆匆那年》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"5","vtime":711320},{"seid":"15356","sections_name":"乐曲课六：《后会无期》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"6","vtime":681840},{"seid":"15357","sections_name":"乐曲课七：《致爱丽丝》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"7","vtime":702160},{"seid":"15358","sections_name":"乐曲课八：《天空之城》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"8","vtime":604400},{"seid":"15359","sections_name":"乐曲课九：《鸿雁》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"9","vtime":839480},{"seid":"15360","sections_name":"乐曲课十：《summer》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"10","vtime":989440}]},{"id":"4039","step_name":"乐理课","step_course_id":"691","step_order":"4","nodes":[{"seid":"18141","sections_name":"乐理课一：认识键盘、五线谱及三种音符","sections_chid":"4039","sections_des":"","sections_isfree":"1","sections_sort":"1","vtime":606560},{"seid":"18144","sections_name":"乐理课二：认识常见音符","sections_chid":"4039","sections_des":"","sections_isfree":"1","sections_sort":"2","vtime":606480},{"seid":"18147","sections_name":"乐理课三：拍号与音符的结合","sections_chid":"4039","sections_des":"","sections_isfree":"1","sections_sort":"3","vtime":743600},{"seid":"18150","sections_name":"乐理课四：学习音程与和弦","sections_chid":"4039","sections_des":"","sections_isfree":"1","sections_sort":"4","vtime":548960},{"seid":"18153","sections_name":"乐理课五：认识变音记号，学习常见的调","sections_chid":"4039","sections_des":"","sections_isfree":"1","sections_sort":"5","vtime":522920}]},{"id":"4043","step_name":"十分钟学钢琴","step_course_id":"691","step_order":"5","nodes":[{"seid":"18161","sections_name":"1分钟宣传片","sections_chid":"4043","sections_des":"","sections_isfree":"2","sections_sort":"1","vtime":59414},{"seid":"18164","sections_name":"腾讯专访：刘洁老师十分钟带你实现钢琴梦","sections_chid":"4043","sections_des":"","sections_isfree":"2","sections_sort":"2","vtime":1194840},{"seid":"18168","sections_name":"新浪教育专访：发现钢琴演奏的万种风情","sections_chid":"4043","sections_des":"","sections_isfree":"2","sections_sort":"3","vtime":445520},{"seid":"18175","sections_name":"新华教育独家专访：十分钟学钢琴是天方夜谭还是真的呢？","sections_chid":"4043","sections_des":"","sections_isfree":"2","sections_sort":"4","vtime":564504},{"seid":"18183","sections_name":"新浪高端访谈：氧气美女老师带你十分钟学钢琴","sections_chid":"4043","sections_des":"","sections_isfree":"2","sections_sort":"5","vtime":527616}]}]
     * msg :
     * course_name : 十分钟学钢琴
     */

    private int code;
    private String msg;
    private String course_name;
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

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1745
         * step_name : 乐曲课
         * step_course_id : 691
         * step_order : 3
         * nodes : [{"seid":"8355","sections_name":"乐曲课一：《我和你》","sections_chid":"1745","sections_des":"","sections_isfree":"2","sections_sort":"1","vtime":500904},{"seid":"8356","sections_name":"乐曲课二：《龙的传人》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"2","vtime":460224},{"seid":"15353","sections_name":"乐曲课三：《欢乐颂》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"3","vtime":603000},{"seid":"15354","sections_name":"乐曲课四：《斯卡波罗集市》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"4","vtime":811120},{"seid":"15355","sections_name":"乐曲课五：《匆匆那年》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"5","vtime":711320},{"seid":"15356","sections_name":"乐曲课六：《后会无期》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"6","vtime":681840},{"seid":"15357","sections_name":"乐曲课七：《致爱丽丝》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"7","vtime":702160},{"seid":"15358","sections_name":"乐曲课八：《天空之城》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"8","vtime":604400},{"seid":"15359","sections_name":"乐曲课九：《鸿雁》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"9","vtime":839480},{"seid":"15360","sections_name":"乐曲课十：《summer》","sections_chid":"1745","sections_des":"","sections_isfree":"1","sections_sort":"10","vtime":989440}]
         */

        private String id;
        private String step_name;
        private String step_course_id;
        private String step_order;
        private List<NodesBean> nodes;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStep_name() {
            return step_name;
        }

        public void setStep_name(String step_name) {
            this.step_name = step_name;
        }

        public String getStep_course_id() {
            return step_course_id;
        }

        public void setStep_course_id(String step_course_id) {
            this.step_course_id = step_course_id;
        }

        public String getStep_order() {
            return step_order;
        }

        public void setStep_order(String step_order) {
            this.step_order = step_order;
        }

        public List<NodesBean> getNodes() {
            return nodes;
        }

        public void setNodes(List<NodesBean> nodes) {
            this.nodes = nodes;
        }

        public static class NodesBean {
            /**
             * seid : 8355
             * sections_name : 乐曲课一：《我和你》
             * sections_chid : 1745
             * sections_des :
             * sections_isfree : 2
             * sections_sort : 1
             * vtime : 500904
             */

            private String seid;
            private String sections_name;
            private String sections_chid;
            private String sections_des;
            private String sections_isfree;
            private String sections_sort;
            private int vtime;

            public String getSeid() {
                return seid;
            }

            public void setSeid(String seid) {
                this.seid = seid;
            }

            public String getSections_name() {
                return sections_name;
            }

            public void setSections_name(String sections_name) {
                this.sections_name = sections_name;
            }

            public String getSections_chid() {
                return sections_chid;
            }

            public void setSections_chid(String sections_chid) {
                this.sections_chid = sections_chid;
            }

            public String getSections_des() {
                return sections_des;
            }

            public void setSections_des(String sections_des) {
                this.sections_des = sections_des;
            }

            public String getSections_isfree() {
                return sections_isfree;
            }

            public void setSections_isfree(String sections_isfree) {
                this.sections_isfree = sections_isfree;
            }

            public String getSections_sort() {
                return sections_sort;
            }

            public void setSections_sort(String sections_sort) {
                this.sections_sort = sections_sort;
            }

            public int getVtime() {
                return vtime;
            }

            public void setVtime(int vtime) {
                this.vtime = vtime;
            }
        }
    }
}
