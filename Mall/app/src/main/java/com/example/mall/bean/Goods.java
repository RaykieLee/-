package com.example.mall.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Goods  {

    /**
     * attribute : 0
     * date : 1579698921000
     * details : 壹乐园计划以儿童发展为核心目标，通过音乐教室、游乐设施和多功能运动场的改造，以及儿童服务站运营等手段，因地制宜的开
     * goodsSkuList : [{"goodsid":0,"id":0,"inventorycount":5,"pic":"","price":120,"spec":"[\"黑色\",\"80g\"]"},{"goodsid":0,"id":1,"inventorycount":100,"price":120,"spec":"[\"红色\",\"80g\"]"},{"goodsid":0,"id":2,"inventorycount":100,"price":120,"spec":"[\"黑色\",\"40g\"]"},{"goodsid":0,"id":3,"inventorycount":100,"price":120,"spec":"[\"红色\",\"40g\"]"}]
     * goodsSpecList : [{"goodsid":0,"id":0,"specname":"颜色","spervalue":"[\"黑色\",\"红色\"]"},{"goodsid":0,"id":1,"specname":"克重","spervalue":"[\"80g\",\"40g\"]"}]
     * id : 0
     * imageid : [4,2,1]
     * name : 抖音网红床上可爱型黄色公主款四件套学生宿舍床单1.5被套三件套
     * price : 79
     * salesvolume : 125
     * store : 华军家纺工厂店
     * storeid : 1
     */

    private String attribute;
    private Date date;
    private String details;
    private int id;
    private String imageid;
    private String name;
    private int price;
    private int salesvolume;
    private String store;
    private int storeid;
    private List<GoodsSkuListBean> goodsSkuList;
    private List<GoodsSpecListBean> goodsSpecList;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSalesvolume() {
        return salesvolume;
    }

    public void setSalesvolume(int salesvolume) {
        this.salesvolume = salesvolume;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public int getStoreid() {
        return storeid;
    }

    public void setStoreid(int storeid) {
        this.storeid = storeid;
    }

    public List<GoodsSkuListBean> getGoodsSkuList() {
        return goodsSkuList;
    }

    public void setGoodsSkuList(List<GoodsSkuListBean> goodsSkuList) {
        this.goodsSkuList = goodsSkuList;
    }

    public List<GoodsSpecListBean> getGoodsSpecList() {
        return goodsSpecList;
    }

    public void setGoodsSpecList(List<GoodsSpecListBean> goodsSpecList) {
        this.goodsSpecList = goodsSpecList;
    }

    public static class GoodsSkuListBean {
        /**
         * goodsid : 0
         * id : 0
         * inventorycount : 5
         * pic :
         * price : 120.0
         * spec : ["黑色","80g"]
         */

        private int goodsid;
        private int id;
        private int inventorycount;
        private String pic;
        private double price;
        private String spec;

        public int getGoodsid() {
            return goodsid;
        }

        public void setGoodsid(int goodsid) {
            this.goodsid = goodsid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getInventorycount() {
            return inventorycount;
        }

        public void setInventorycount(int inventorycount) {
            this.inventorycount = inventorycount;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public List<String> getSpec() {
            return new Gson().fromJson(spec,new TypeToken<List<String>>() {}.getType());
        }

        public void setSpec(String spec) {
            this.spec = spec;
        }
    }

    public static class GoodsSpecListBean {
        /**
         * goodsid : 0
         * id : 0
         * specname : 颜色
         * spervalue : ["黑色","红色"]
         */

        private int goodsid;
        private int id;
        private String specname;
        private String spervalue;

        public int getGoodsid() {
            return goodsid;
        }

        public void setGoodsid(int goodsid) {
            this.goodsid = goodsid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSpecname() {
            return specname;
        }

        public void setSpecname(String specname) {
            this.specname = specname;
        }

        public List<String> getSpervalue() {

            return new Gson().fromJson(spervalue,new TypeToken<List<String>>() {}.getType());
        }

        public void setSpervalue(String spervalue) {
            this.spervalue = spervalue;
        }
    }
}