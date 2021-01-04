package com.example.Model;

/**
 * 用户账号表
 */
public class Account {
    private int id;//用户Id
    private String account;//用户账号
    private String password;//用户密码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
