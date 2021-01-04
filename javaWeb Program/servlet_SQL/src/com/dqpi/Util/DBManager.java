package com.dqpi.Util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import com.mysql.jdbc.Statement;

public class DBManager {
    Connection con;//建立数据库连接
    ResultSet rs = null;//建立数据集
    Statement stmt = null;//一个在已连数据库的基础上传送sql语句的一个中介？
    String driver = "com.mysql.jdbc.Driver";//数据库驱动
    String url = "jdbc:mysql://localhost:3306/db_servlet?characterEncoding=utf8";//各种数据库的连接串
    String user = "root";//数据库账号
    String password = "";//数据库密码

    public DBManager() {
        // TODO Auto-generated constructor stub
        this.con = this.getConnection();
    }

    /*
     * 作为连接数据库类的使用
     */
    private Connection getConnection() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动错误！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获得连接错误！");
        }
        return con;
    }

    /*
     * 查询操作
     */
    public ResultSet executeQuery(String sql) {
        try {
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("执行的SQL错误");
        }
        return rs;
    }

    /*
     * CUD操作
     */
    public int executeUpdate(String sql) {
        int cont = 0;
        try {
            stmt = (Statement) con.createStatement();
            cont = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("SQL执行CUD错误");
        }
        return cont;
    }

    /*
     * 关闭资源
     */
    public void dbmClose() {
        try {
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("关闭资源失败！");
        }
    }
}
