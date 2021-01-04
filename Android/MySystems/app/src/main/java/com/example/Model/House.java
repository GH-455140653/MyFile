package com.example.Model;

public class House {
    private int uid;//住房人id
    private int hid;//房间号（id）
    private String size;//房型

    private String userDate;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDate() {
        return userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "House{" +
                "uid=" + uid +
                ", hid=" + hid +
                ", size='" + size + '\'' +
                ", userDate='" + userDate + '\'' +
                ", userDame='" + userName + '\'' +
                '}';
    }

    public String customerString() {
        return "房间号：" + hid + "\n房间型号：" + size + "\n住客姓名：" + userName;
    }
}
