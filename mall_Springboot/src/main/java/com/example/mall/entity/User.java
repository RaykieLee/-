package com.example.mall.entity;

import java.sql.Date;

public class User {
    Date registration_date;
    String name;
    String sex;
    String tel;
    String adress;
    String state;
    String password;
    String headsculpture;

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadsculpture() {
        return headsculpture;
    }

    public void setHeadsculpture(String headsculpture) {
        this.headsculpture = headsculpture;
    }

//INSERT INTO `shopping`.`user`(`id`, `name`, `sex`, `tel`, `address`, `state`, `registration_date`, `account`, `password`, `headsculpture`) VALUES (2, 'asdsad', 'asdasd', 'asdasd', 'asdasdasd', 'asdas', '2019-11-14 15:31:30', 'dasdasd', 'asdasdasd', 'asdasd');
}
