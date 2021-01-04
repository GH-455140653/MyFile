package practice.inter.def;

import practice.inter.door;

public class door1 implements door {
    @Override
    public boolean checked(String name, String password) {
        String myname = "李润霖";
        String mypass = "123";
        if (myname.equals(name)) {
            if (mypass.equals(password)) {
                return true;
            } else {
                System.out.println("密码错误");
                return false;
            }
        } else {
            System.out.println("账号错误");
            return false;
        }
    }
}
