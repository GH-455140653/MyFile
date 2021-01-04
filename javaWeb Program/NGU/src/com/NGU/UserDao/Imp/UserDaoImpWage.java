package com.NGU.UserDao.Imp;

import java.util.ArrayList;
import java.util.List;

import com.NGU.Moduel.Salary;
import com.NGU.Moduel.Sign;
import com.NGU.UserDao.Interface.WageDAOI;
import com.NGU.Util.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpWage implements WageDAOI {
    private int no;//员工编号
    private String name;//员工姓名
    private int SignDayTimes;//当月签到天数
    private String salary;//该月月薪
    private int authority; //员工权限
    DBManager db = new DBManager();


    /*获取数据库信息*/
    public List<Salary> readWage() {//
        List<Salary> list = new ArrayList<>();
        String sql;
        sql = "SELECT t_wage.no,t_person.Pname,COUNT(CASE WHEN t_sign.`Wstatues`=1 AND t_sign.`Wtime`BETWEEN CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()),'-','01') AND CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()),'-','31') THEN t_wage.no ELSE NULL END) AS times,t_person.`Psalary`\r\n" +
                "FROM t_person,t_Sign,t_Wage\r\n" +
                "WHERE t_person.`no`=t_sign.`no` AND t_sign.`no`=t_wage.`no` \r\n" +
                "GROUP BY t_sign.`no`";
        list = select(sql);
        db.dbmclose();
        return list;
    }

    /*更改数据库信息*/
    public void changeWage(int no, String sum) {
        int No = no;
        String Sum = sum;
        String sql = "UPDATE t_wage SET Ssalary ='" + Sum + "'WHERE NO=" + no + ";";
        int count = db.executeUpdate(sql);

    }


    /*按编号查看工资表信息*/
    public List<Salary> readby(int no) {
        List<Salary> list = new ArrayList<>();
        String sql = "SELECT t_wage.no,t_person.Pname,COUNT(CASE WHEN t_sign.`Wstatues`=1 AND t_sign.`Wtime`BETWEEN CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()),'-','01') AND CONCAT(YEAR(CURDATE()),'-',MONTH(CURDATE()),'-','31') THEN t_wage.no ELSE NULL END) AS times,t_wage.Ssalary\r\n" +
                "FROM t_person,t_Sign,t_Wage,t_login\r\n" +
                "WHERE t_person.`no`=t_sign.`no` AND t_wage.no=" + no + " AND t_sign.`no`=t_wage.`no`AND t_login.`authority`=0 \r\n" +
                "GROUP BY t_sign.`no`";
        list = selectt(sql);
        db.dbmclose();
        return list;
    }


    /*按编号查看工资表信息的方法*/
    private List<Salary> selectt(String sql) {
        List<Salary> list = new ArrayList<>();
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Salary sa = new Salary();
                sa.setNo(rs.getInt("no"));
                sa.setName(rs.getString("Pname"));
                sa.setSignDayTimes(rs.getInt("times"));
                sa.setSalary(rs.getString("Ssalary"));

                //System.out.print(Sum);
                list.add(sa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("结果集没有值");
        }
        db.dbmclose();
        return list;
    }

    private List<Salary> select(String sql) {
        List<Salary> list = new ArrayList<>();
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Salary sa = new Salary();
                sa.setNo(rs.getInt("no"));
                sa.setName(rs.getString("Pname"));
                sa.setSignDayTimes(rs.getInt("times"));
                /*计算工资*/
                double sum = 0;
                if (rs.getInt("times") >= 29) {
                    sum = Integer.parseInt(rs.getString("Psalary")) * 2;
                } else {
                    double cos = Integer.parseInt(rs.getString("Psalary")) * 0.05 * (30 - rs.getInt("times"));
                    sum = Integer.parseInt(rs.getString("Psalary")) - cos;
                }
                if (sum <= 0) {
                    sum = 0;
                }
                String Sum = "" + sum;
                sa.setSalary(Sum);

                System.out.print(Sum);

                changeWage(rs.getInt("no"), Sum);

                list.add(sa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("结果集没有值");
        }
        db.dbmclose();
        return list;
    }
}
