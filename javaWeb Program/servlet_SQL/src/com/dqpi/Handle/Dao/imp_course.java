package com.dqpi.Handle.Dao;

import com.dqpi.Handle.UserDaoInterface.UserDao;
import com.dqpi.Util.DBManager;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class imp_course implements UserDao {

    @Override
    public List<String> login(int id, String account, String pwd) {
        return null;
    }

    @Override
    public List<String> Course(String[] course, int id) {
        try {
            List<String> listSQL = new ArrayList<>();
            course = courseHandle(course);
            //打开数据库
            DBManager dbmanager = new DBManager();
            ResultSet rs = read(id, dbmanager);
            //读取数据库内容，判断需要写入的值是否存在
            if (rs.next()) {
                if (rs.getString("id") != null) {
                    update(course, dbmanager, id);//更新已有数据
                }
            } else {
                insert(course, dbmanager, id);//插入新行
            }

            //数据库读出写入的集合
            rs = read(id, dbmanager);
            while (rs.next()) {
                listSQL.add(rs.getString("course_0"));
                listSQL.add(rs.getString("course_1"));
                listSQL.add(rs.getString("course_2"));
                listSQL.add(rs.getString("course_3"));
                listSQL.add(rs.getString("course_4"));
            }
            for (int i = 0; i < listSQL.size(); i++) {
                if (listSQL.get(i) != null) {
                    course[i] = listSQL.get(i);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("数组转码出错！");
        } catch (SQLException e1) {
            e1.printStackTrace();
            System.out.println("获取数据库数据错误！");
        }

        List<String> list = new ArrayList<>();
        if (course.length < 2) {
            list.add("b");
            list.add("课程选择少于2门！<br>已选课程为：");
        } else {
            list.add("c");
            list.add("已选课程为：");
        }
        return list;
    }

    private String[] courseHandle(String[] course) throws IOException {
        String[] str = new String[course.length];
        for (int i = 0; i < course.length; i++) {
            String temp = new String(course[i].getBytes("iso-8859-1"), "utf-8");
            str[i] = temp;
        }
        return str;
    }

    private ResultSet read(int id, DBManager dbmanager) {
        String sql = "select * from t_course where id=" + id;//查询目前已有数据
        ResultSet rs = dbmanager.executeQuery(sql);
        return rs;
    }

    private void insert(String[] course, DBManager dbmanager, int id) {
        String sql = "insert into t_course (id) values(" + id + ")";//清空数据库已有数据
        dbmanager.executeUpdate(sql);
        for (int i = 0; i < course.length; i++) {
            String sql_update = "update t_course set course_" + i + "='" + course[i] + "' where id=" + id;
            dbmanager.executeUpdate(sql_update);//执行插入操作，结果返回条数
        }
    }

    private void update(String[] course, DBManager dbmanager, int id) {
        String sql_clear = "update t_course set course_0=null,course_1=null,course_2=null,course_3=null where id=33";
        dbmanager.executeUpdate(sql_clear);//执行插入操作，结果返回条数
        for (int i = 0; i < course.length; i++) {
            String sql_update = "update t_course set course_" + i + "='" + course[i] + "' where id=" + id;
            dbmanager.executeUpdate(sql_update);//执行插入操作，结果返回条数
        }
    }

    @Override
    public List<String> message(String name, String sex, String age, int id) {
        return null;
    }
}
