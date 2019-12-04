package com.example.mall.bean;

public class MessageListBean {

    String messageImage;
    String name;

    String messageContent;

    public MessageListBean(String messageImage, String name, String messageContent, String data, String messageNum) {
        this.messageImage = messageImage;
        this.name = name;
        this.messageContent = messageContent;
        this.data = data;
        this.messageNum = messageNum;
    }

    String data;

    String messageNum;

    public String getMessageImage() {
        return messageImage;
    }

    public void setMessageImage(String messageImage) {
        this.messageImage = messageImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(String messageNum) {
        this.messageNum = messageNum;
    }


}
