package com.dqpi.Handle.Dao;

import com.dqpi.Handle.UserDaoInterface.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dqpi.Util.DBManager;

public class imp_login implements UserDao {
    @Override
    public List<String> login(int id, String account, String pwd) {
        DBManager dbmanager = new DBManager();//建立数据库
        List<String> listSQL = new ArrayList<>();//存放从数据库取出的数据的集合
        String sql = "SELECT * FROM t_login WHERE id =" + id;//sql语句
        ResultSet rs = dbmanager.executeQuery(sql);//传入数据库并获取数据存入该数据集
        List<String> list = new ArrayList<>();//页面转移数据
        try {
            while (rs.next()) {
                listSQL.add(rs.getString("account"));
                System.out.println(listSQL.get(0));
                listSQL.add(rs.getString("password"));
                System.out.println(listSQL.get(1));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        dbmanager.dbmClose();
        // System.out.println(rs.getString("name"));
        // System.out.println(rs.getString("password"));
        if (account.equals("") || pwd.equals("")) {
            list.add("a");
            list.add("账号密码存在空值！\n请重新登陆！");
        } else if (!account.equals(listSQL.get(0))) {
            System.out.println("账号错误！");
            list.add("b");
            list.add("账号错误！");
        } else if (!pwd.equals(listSQL.get(1))) {
            System.out.println("密码错误！");
            list.add("c");
            list.add("密码错误！");
        } else {
            System.out.println("登陆成功！");
            list.add("d");
            list.add("登陆成功！");
        }
        return list;
    }

    @Override
    public List<String> Course(String[] course, int id) {
        return null;
    }

    @Override
    public List<String> message(String name, String sex, String age, int id) {
        return null;
    }
}
