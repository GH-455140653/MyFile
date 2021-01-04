package com.dqpi.Dao.imp;

import com.dqpi.Dao.UserDao;

public class Userdaoimp1 implements UserDao {

    @Override
    public boolean checked(String name, String pws) {
        String myname = "李润霖";
        String mypass = "123";
        if (myname.equals(name)) {
            if (mypass.equals(pws)) {
                return true;
            } else {
                System.out.println("密码错误错误");
                return false;
            }
        } else {
            System.out.println("账号错误");
            return false;
        }
    }
}
