package com.NGU.Moduel;

public class Dialog {
    private int no;// 员工编号
    private int Dno;// 留言编号
    private String message;// 留言内容
    private String name;//员工姓名

    public Dialog() {

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getDno() {
        return Dno;
    }

    public void setDno(int dno) {
        Dno = dno;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
