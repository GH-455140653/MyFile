package com.dqpi.Util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import com.mysql.jdbc.Statement;

public class DBManager {
    Connection con;
    ResultSet rs = null;
    Statement stmt = null;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/db_servlet?characterEncoding=utf8";
    String user = "root";
    String password = "";

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
            if (!con.equals(null)) {
                System.out.println("数据库连接成功");
            } else {
                System.out.println("数据库连接失败！");
            }
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
    public void dbmclose() {
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
