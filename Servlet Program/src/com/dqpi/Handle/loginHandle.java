package com.dqpi.Handle;

import java.io.IOException;

public class loginHandle {
    private String name;
    private String password;

    loginHandle(String name, String psw) {
        this.name = name;
        this.password = psw;
    }

    public String checked() throws IOException {
        password = new String(password.getBytes("iso-8859-1"), "utf-8");
        name = new String(name.getBytes("iso-8859-1"), "utf-8");
        if (name.equals("") || password.equals("")) {
            return "账号和密码存在空值！";
        } else if (!name.equals("lrl")) {
            return "账号匹配错误！";
        } else if (!password.equals("123456")) {
            return "密码匹配错误！";
        } else {
            return "登陆成功！";
        }
    }

    public String isNull() {
        if (name == null || password == null) {
            return "账号和密码存在空值！";
        } else {
            return null;
        }
    }
}
