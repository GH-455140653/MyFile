package com.dqpi.UserDao.Imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dqpi.Model.User;
import com.dqpi.UserDao.UserDAOI;
import com.dqpi.Util.DBManager;

public class UserDaoImp implements UserDAOI {


    @Override
    public List<User> add() {
        DBManager db = new DBManager();
        List<User> list = new ArrayList<>();
        String sql = "select * from user";//查询全表
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("结果集没有值");
        }
        db.dbmclose();
        return list;
    }

    @Override
    public void delet(String id) {
        int did = Integer.parseInt(id);
        DBManager db = new DBManager();
        String sql = "delete from user where id = " + did;//删除指定id
        db.executeUpdate(sql);
    }

    @Override
    public void update(String id, String name, String password) {
        int uid = Integer.parseInt(id);
        DBManager db = new DBManager();
        String sql = "update user set name='" + name + "',password='" + password + "' where id=" + uid;
        db.executeUpdate(sql);
    }
}
