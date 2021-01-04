package com.NGU.UserDao.Imp;

import com.NGU.Moduel.User;
import com.NGU.UserDao.Interface.UserDAOI;
import com.NGU.Util.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpLogin implements UserDAOI {
    private int no;
    private String password;
    private String password_sure;
    private int authority;
    DBManager db = new DBManager();

    public UserDaoImpLogin(String no, String password, String authority) {//登录

        this.no = Integer.parseInt(no);
        this.password = password;
        this.authority = Integer.parseInt(authority);
    }

    public UserDaoImpLogin(String no, String psw) {//密码修改
        this.no = Integer.parseInt(no);
        this.password = psw;
    }

    @Override
    public List<User> read() {
        List<User> list = new ArrayList<>();
        String sql;
        if (authority == 1) {
            sql = "SELECT t_person.no,PASSWORD,authority,Pname FROM t_person,t_login WHERE t_login.no=t_person.no AND authority=1 AND t_person.no=" + no;
        } else {
            sql = "SELECT t_person.no,PASSWORD,authority,Pname FROM t_person,t_login WHERE t_login.no=t_person.no AND authority=0 AND t_person.no=" + no;
        }
        list = select(sql);
        db.dbmclose();

        if (list.size() != 0) {
            if (!checkMessage(list.get(0).getNo(), list.get(0).getPassword())) {
                list.clear();
            }
        }
        return list;
    }

    @Override
    public List<User> update() {
        List<User> list = new ArrayList<>();

        //修改
        String sql = "update t_login set password='" + password + "' where no=" + no;
        int num = db.executeUpdate(sql);//数据库有多少行的受到变化
        if (num != 0) {//数据库元组修改失败，数据库的行变化为0，否则为不为0的正整数
            System.out.println("数据更新成功！");
            sql = "select no,authority from t_login where no=" + no;

            //查询
            ResultSet rs = db.executeQuery(sql);
            try {
                while (rs.next()) {
                    User user = new User();
                    user.setNo(rs.getInt("no"));
                    user.setAuthority(rs.getInt("authority"));
                    list.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("结果集没有值");
            }
        } else {
            System.out.println("数据更新失败！");
        }
        db.dbmclose();
        return list;
    }

    public boolean checkMessage(int no, String password) {
//        return no == this.no && password.equals(this.password);
        if (no == this.no && password.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }

    public List<User> select(String sql) {//查询指定no的所有字段
        List<User> list = new ArrayList<>();
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                User user = new User();
                user.setNo(rs.getInt("no"));
                user.setPassword(rs.getString("password"));
                user.setAuthority(authority);
                user.setName(rs.getString("Pname"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("结果集没有值");
        }
        db.dbmclose();
        return list;
    }
}
