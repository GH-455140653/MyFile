package com.dqpi.Handle.Dao;

import com.dqpi.Handle.UserDaoInterface.UserDao;
import com.dqpi.Util.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class imp_message implements UserDao {
    @Override
    public List<String> login(int id, String account, String pwd) {
        return null;
    }

    @Override
    public List<String> Course(String[] course, int id) {
        return null;
    }

    @Override
    public List<String> message(String name, String sex, String age, int id) {
        List<String> list = new ArrayList<>();
        DBManager dbmanager = new DBManager();
        if (name.equals("") || sex.equals("") || age.equals("")) {
            list.add("a");
            list.add("个人信息表中存在空值！");
            list.add(name);
            list.add(sex);
            list.add(age);
        } else {
            list.add("e");
            list.add("插入成功！");

            //打开数据库--插入操作
            ResultSet rs = read(id, dbmanager);//该次查询遍历表，判断需要插入的值的id是否已存在
            try {
                boolean flag = true;//标识变量法
                while (rs.next()) {
                    if (rs.getString("id") != null) {
                        list.clear();//清除集合，除去上面因素干扰
                        list.add("a");
                        list.add("需要插入的信息已存在于数据库！");
                        list.add(name);
                        list.add(sex);
                        list.add(age);
                        flag = false;
                    }
                }
                if (flag) {
                    insert(id, name, sex, age, dbmanager);//向数据库插入数据
                    rs = read(id, dbmanager);//该次查询用于输出需要的数据
                    while (rs.next()) {
                        list.add(rs.getString("name"));
                        list.add(rs.getString("sex"));
                        list.add(rs.getString("age"));
                    }
                }
                dbmanager.dbmClose();//关闭数据库
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("获取数据库数据失败！");
            }
        }
        return list;
    }

    private ResultSet read(int id, DBManager dbmanager) {
        String sql = "select * from t_message where id=" + id;
        ResultSet rs = dbmanager.executeQuery(sql);
        return rs;
    }

    private void insert(int id, String name, String sex, String age, DBManager dbmanager) {
        String sql_insert = "insert into t_message values(" + id + ",'" + name + "','" + sex + "','" + age + "')";
        dbmanager.executeUpdate(sql_insert);//执行插入操作，结果返回条数
    }
}
