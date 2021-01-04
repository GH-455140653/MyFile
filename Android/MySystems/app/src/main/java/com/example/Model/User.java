package com.example.Model;

/**
 *租客个人信息表
 */
public class User {
    private int id;//租客Id
    private String sex;//租客性别
    private String name;//租客姓名
    private String address;//租客地址
    private String date;//入住时间
    private String tel;//租客电话
    private String idNUm;//租客身份证

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIdNUm() {
        return idNUm;
    }

    public void setIdNUm(String idNUm) {
        this.idNUm = idNUm;
    }

    @Override
    public String toString() {
        return "姓名：" + name + "\n性别：" + sex + "\n联系电话：" + tel + "\n身份证号：" + idNUm + "\n入住时间：" + date + "\n籍贯：" + address;
    }
}
