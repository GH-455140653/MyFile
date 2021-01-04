package com.NGU.Moduel;

public class Salary {
    private int no;//员工编号
    private String name;//员工姓名
    private int SignDayTimes;//当月签到天数
    private String salary;//该月月薪

    public Salary() {

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSignDayTimes() {
        return SignDayTimes;
    }

    public void setSignDayTimes(int signDayTimes) {
        SignDayTimes = signDayTimes;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
