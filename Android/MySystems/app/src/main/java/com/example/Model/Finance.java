package com.example.Model;

public class Finance {
    private int Hid;//房间号
    private int Uid;//住客id
    private String userName;//住客姓名
    private String date;//报表年月
    private float Electricity;//当月电费
    private float Water;//当月水费
    private float Ele;//实用电度
    private float lastEle;//上月电度
    private float nowEle;//当月电度
    private float preEle;//电费单价（元/度）
    private float Wat;//实用水方
    private float lastWat;//上月水方
    private float nowWat;//当月水方
    private float preWat;//水费单价(元/方)
    private float netRant;//网费
    private float houseRant;//房租
    private float summary;//当月合计

    public float getNetRant() {
        return netRant;
    }

    public void setNetRant(float netRant) {
        this.netRant = netRant;
    }

    public float getHouseRant() {
        return houseRant;
    }

    public void setHouseRant(float houseRant) {
        this.houseRant = houseRant;
    }

    public float getSummary() {
        return summary;
    }

    public void setSummary(float summary) {
        this.summary = summary;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getHid() {
        return Hid;
    }

    public void setHid(int hid) {
        Hid = hid;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getElectricity() {
        return Electricity;
    }

    public void setElectricity(float electricity) {
        Electricity = electricity;
    }

    public float getWater() {
        return Water;
    }

    public void setWater(float water) {
        Water = water;
    }

    public float getEle() {
        return Ele;
    }

    public void setEle(float ele) {
        Ele = ele;
    }

    public float getLastEle() {
        return lastEle;
    }

    public void setLastEle(float lastEle) {
        this.lastEle = lastEle;
    }

    public float getNowEle() {
        return nowEle;
    }

    public void setNowEle(float nowEle) {
        this.nowEle = nowEle;
    }

    public float getPreEle() {
        return preEle;
    }

    public void setPreEle(float preEle) {
        this.preEle = preEle;
    }

    public float getWat() {
        return Wat;
    }

    public void setWat(float wat) {
        Wat = wat;
    }

    public float getLastWat() {
        return lastWat;
    }

    public void setLastWat(float lastWat) {
        this.lastWat = lastWat;
    }

    public float getNowWat() {
        return nowWat;
    }

    public void setNowWat(float nowWat) {
        this.nowWat = nowWat;
    }

    public float getPreWat() {
        return preWat;
    }

    public void setPreWat(float preWat) {
        this.preWat = preWat;
    }
}
