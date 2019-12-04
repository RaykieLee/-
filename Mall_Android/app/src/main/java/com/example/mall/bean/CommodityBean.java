package com.example.mall.bean;

public class CommodityBean {

    String CommodityImage;  // 图片
    String name;            //名字
    String CommodityContent; //副标题
    String sales_volume; // 销量
    String money;  // 价格

    public CommodityBean(String commodityImage, String name, String commodityContent, String sales_volume, String money) {
        CommodityImage = commodityImage;
        this.name = name;
        CommodityContent = commodityContent;
        this.sales_volume = sales_volume;
        this.money = money;
    }

    public String getCommodityImage() {
        return CommodityImage;
    }

    public void setCommodityImage(String commodityImage) {
        CommodityImage = commodityImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommodityContent() {
        return CommodityContent;
    }

    public void setCommodityContent(String commodityContent) {
        CommodityContent = commodityContent;
    }

    public String getSales_volume() {
        return sales_volume;
    }

    public void setSales_volume(String sales_volume) {
        this.sales_volume = sales_volume;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
