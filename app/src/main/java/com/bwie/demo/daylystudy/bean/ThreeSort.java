package com.bwie.demo.daylystudy.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */

public class ThreeSort {

    /**
     * menu : {"id":"1","category_name":"多彩生活","category_fid":"0","category_order":"1","category_status":"1","category_lever":"1","category_p":null,"category_ishot":"2"}
     * nodes : [{"menu2":{"id":"1","category_name":"全部"},"nodes2":[{"menu3":{"id":"1","category_name":"全部","category_ffid":"1"}}]},{"menu2":{"id":"69","category_name":"美食","category_fid":"1","category_order":"1","category_status":"1","category_lever":"2","category_p":null,"category_ishot":"2"},"nodes2":[{"menu3":{"id":"69","category_name":"全部","category_ffid":"1"}},{"menu3":{"id":"70","category_name":"烘焙","category_fid":"69","category_order":"0","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"1","category_ffid":"1"}},{"menu3":{"id":"71","category_name":"烹饪","category_fid":"69","category_order":"0","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"1","category_ffid":"1"}},{"menu3":{"id":"325","category_name":"调酒","category_fid":"69","category_order":"129","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"1","category_ffid":"1"}},{"menu3":{"id":"326","category_name":"咖啡","category_fid":"69","category_order":"130","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"2","category_ffid":"1"}}]},{"menu2":{"id":"191","category_name":"婚恋讲堂","category_fid":"1","category_order":"3","category_status":"1","category_lever":"2","category_p":null,"category_ishot":"2"},"nodes2":[{"menu3":{"id":"191","category_name":"全部","category_ffid":"1"}},{"menu3":{"id":"203","category_name":"恋爱","category_fid":"191","category_order":"32","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"2","category_ffid":"1"}}]},{"menu2":{"id":"9","category_name":"形象塑造","category_fid":"1","category_order":"4","category_status":"1","category_lever":"2","category_p":null,"category_ishot":"2"},"nodes2":[{"menu3":{"id":"9","category_name":"全部","category_ffid":"1"}},{"menu3":{"id":"44","category_name":"美妆美发","category_fid":"9","category_order":"0","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"1","category_ffid":"1"}},{"menu3":{"id":"45","category_name":"服饰","category_fid":"9","category_order":"0","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"1","category_ffid":"1"}},{"menu3":{"id":"48","category_name":"美甲","category_fid":"9","category_order":"0","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"1","category_ffid":"1"}}]},{"menu2":{"id":"284","category_name":"文化艺术","category_fid":"1","category_order":"90","category_status":"1","category_lever":"2","category_p":null,"category_ishot":"2"},"nodes2":[{"menu3":{"id":"284","category_name":"全部","category_ffid":"1"}},{"menu3":{"id":"285","category_name":"绘画","category_fid":"284","category_order":"91","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"1","category_ffid":"1"}},{"menu3":{"id":"287","category_name":"乐理","category_fid":"284","category_order":"93","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"2","category_ffid":"1"}},{"menu3":{"id":"288","category_name":"声乐","category_fid":"284","category_order":"94","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"1","category_ffid":"1"}},{"menu3":{"id":"289","category_name":"影视","category_fid":"284","category_order":"95","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"1","category_ffid":"1"}},{"menu3":{"id":"339","category_name":"书法","category_fid":"284","category_order":"143","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"2","category_ffid":"1"}},{"menu3":{"id":"341","category_name":"国学","category_fid":"284","category_order":"145","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"2","category_ffid":"1"}},{"menu3":{"id":"345","category_name":"器乐","category_fid":"284","category_order":"149","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"2","category_ffid":"1"}},{"menu3":{"id":"348","category_name":"易学","category_fid":"284","category_order":"152","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"2","category_ffid":"1"}}]},{"menu2":{"id":"346","category_name":"街访","category_fid":"1","category_order":"150","category_status":"1","category_lever":"2","category_p":null,"category_ishot":"2"},"nodes2":[{"menu3":{"id":"346","category_name":"全部","category_ffid":"1"}},{"menu3":{"id":"347","category_name":"端午节","category_fid":"346","category_order":"151","category_status":"1","category_lever":"3","category_p":null,"category_ishot":"2","category_ffid":"1"}}]}]
     */

    private MenuBean menu;
    private List<NodesBean> nodes;

    public MenuBean getMenu() {
        return menu;
    }

    public void setMenu(MenuBean menu) {
        this.menu = menu;
    }

    public List<NodesBean> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodesBean> nodes) {
        this.nodes = nodes;
    }

    public static class MenuBean {
        /**
         * id : 1
         * category_name : 多彩生活
         * category_fid : 0
         * category_order : 1
         * category_status : 1
         * category_lever : 1
         * category_p : null
         * category_ishot : 2
         */

        private String id;
        private String category_name;
        private String category_fid;
        private String category_order;
        private String category_status;
        private String category_lever;
        private Object category_p;
        private String category_ishot;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getCategory_fid() {
            return category_fid;
        }

        public void setCategory_fid(String category_fid) {
            this.category_fid = category_fid;
        }

        public String getCategory_order() {
            return category_order;
        }

        public void setCategory_order(String category_order) {
            this.category_order = category_order;
        }

        public String getCategory_status() {
            return category_status;
        }

        public void setCategory_status(String category_status) {
            this.category_status = category_status;
        }

        public String getCategory_lever() {
            return category_lever;
        }

        public void setCategory_lever(String category_lever) {
            this.category_lever = category_lever;
        }

        public Object getCategory_p() {
            return category_p;
        }

        public void setCategory_p(Object category_p) {
            this.category_p = category_p;
        }

        public String getCategory_ishot() {
            return category_ishot;
        }

        public void setCategory_ishot(String category_ishot) {
            this.category_ishot = category_ishot;
        }
    }

    public static class NodesBean {
        /**
         * menu2 : {"id":"1","category_name":"全部"}
         * nodes2 : [{"menu3":{"id":"1","category_name":"全部","category_ffid":"1"}}]
         */

        private Menu2Bean menu2;
        private List<Nodes2Bean> nodes2;

        public Menu2Bean getMenu2() {
            return menu2;
        }

        public void setMenu2(Menu2Bean menu2) {
            this.menu2 = menu2;
        }

        public List<Nodes2Bean> getNodes2() {
            return nodes2;
        }

        public void setNodes2(List<Nodes2Bean> nodes2) {
            this.nodes2 = nodes2;
        }

        public static class Menu2Bean {
            /**
             * id : 1
             * category_name : 全部
             */

            private String id;
            private String category_name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }
        }

        public static class Nodes2Bean {
            /**
             * menu3 : {"id":"1","category_name":"全部","category_ffid":"1"}
             */

            private Menu3Bean menu3;

            public Menu3Bean getMenu3() {
                return menu3;
            }

            public void setMenu3(Menu3Bean menu3) {
                this.menu3 = menu3;
            }

            public static class Menu3Bean {
                /**
                 * id : 1
                 * category_name : 全部
                 * category_ffid : 1
                 */

                private String id;
                private String category_name;
                private String category_ffid;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getCategory_name() {
                    return category_name;
                }

                public void setCategory_name(String category_name) {
                    this.category_name = category_name;
                }

                public String getCategory_ffid() {
                    return category_ffid;
                }

                public void setCategory_ffid(String category_ffid) {
                    this.category_ffid = category_ffid;
                }
            }
        }
    }
}
