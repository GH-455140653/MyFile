package com.dqpi.Handle.UserDao;

import com.dqpi.Handle.UserDaoInterface.UserDaoI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dqpi.Util.DBManager;

public class imp_login implements UserDaoI {
    @Override
    public List<String> login(String account, String pwd) {
        DBManager dbmanager = new DBManager();
        List<String> listSQL = new ArrayList<>();
        String sql = "SELECT * FROM t_login WHERE id =33";
        ResultSet rs = dbmanager.executeQuery(sql);
        List<String> list = new ArrayList<>();
        try {
            while (rs.next()) {
                listSQL.add(rs.getString("account"));
                listSQL.add(rs.getString("password"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        dbmanager.dbmclose();
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
    public List<String> Course(String[] course) {
        return null;
    }
}
