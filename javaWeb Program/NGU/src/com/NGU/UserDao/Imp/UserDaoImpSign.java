package com.NGU.UserDao.Imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.NGU.Moduel.Sign;
import com.NGU.UserDao.Interface.SignDAOI;
import com.NGU.Util.DBManager;

public class UserDaoImpSign implements SignDAOI {
    private int no;//员工编号
    private String name;//员工姓名
    private String sex;//性别
    private String dept;//所在部门
    private String time;//时间
    private int statues;//当天是否已签到
    DBManager db = new DBManager();

    public UserDaoImpSign() {
    }

    public UserDaoImpSign(String no, String time, int statues) {// 普通用户签到
        this.no = Integer.parseInt(no);
        this.time = time;
        this.statues = statues;
    }


    public List<Sign> read() {/*查看全部考勤表信息*/
        List<Sign> list = new ArrayList<>();
        String sql = "SELECT t_sign.no,wtime,wstatues,pname,psex,pdept FROM t_sign,t_person WHERE t_sign.no=t_person.no";
        list = select(sql);
        db.dbmclose();
        return list;
    }

    public List<Sign> read(int no) {/*按编号查看考勤表信息*/
        List<Sign> list = new ArrayList<>();
        String sql = "SELECT t_sign.no,wtime,wstatues,pname,psex,pdept FROM t_sign,t_person WHERE t_sign.no=t_person.no AND t_sign.no=" + no;
        list = select(sql);
        db.dbmclose();
        return list;
    }

    public int readstatues(int no, String time) {/*普通用户登录时查看自己当天签到状态*/
        List<Sign> list = new ArrayList<>();
        String sql = "SELECT t_sign.no,wtime,wstatues,pname,psex,pdept FROM t_sign,t_person WHERE t_sign.no=t_person.no AND t_sign.no=" + no + " and wtime='" + time + "'";
        list = select(sql);
        db.dbmclose();
        int statues;
        if (list.size() == 0) {
            statues = -1;//-1表示该同学当天考勤表数据缺失
        } else {
            statues = list.get(0).getStatues();
        }
        return statues;
    }

    public List<Sign> update(String no, String time, int statues) {
        List<Sign> list = new ArrayList<>();
        String sql = "";
        if (statues == 0) {
            sql = "UPDATE t_sign SET wstatues=1 WHERE NO=" + no + " AND wtime='" + time + "'";
            System.out.print(sql);
        } else if (statues == 1) {
            sql = "UPDATE t_sign SET wstatues=0 WHERE NO=" + no + " AND wtime='" + time + "'";
        }
        int num = db.executeUpdate(sql);// 数据库有多少行的受到变化
        if (num != 0) {// 数据库元组修改失败，数据库的行变化为0，否则为不为0的正整数
            System.out.println("数据更新成功！");
            sql = "SELECT t_sign.no,wtime,wstatues,pname,psex,pdept FROM t_sign,t_person WHERE t_sign.no=t_person.no";

            // 查询
            ResultSet rs = db.executeQuery(sql);
            try {
                while (rs.next()) {
                    Sign sign = new Sign();
                    sign.setNo(rs.getInt("no"));
                    sign.setName(rs.getString("pname"));
                    sign.setSex(rs.getString("psex"));
                    sign.setDept(rs.getString("pdept"));
                    sign.setTime(rs.getString("wtime"));
                    sign.setStatues(Integer.parseInt(rs.getString("wstatues")));
                    list.add(sign);
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

    public List<Sign> select(String sql) {// 查询指定no的所有字段
        List<Sign> list = new ArrayList<>();
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Sign sign = new Sign();
                sign.setNo(rs.getInt("no"));
                sign.setName(rs.getString("pname"));
                sign.setSex(rs.getString("psex"));
                sign.setDept(rs.getString("pdept"));
                sign.setTime(rs.getString("wtime"));
                sign.setStatues(Integer.parseInt(rs.getString("wstatues")));
                list.add(sign);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("结果集没有值");
        }
        db.dbmclose();
        return list;
    }

    public void insertintosign(int no, String time) {
        String sql = "INSERT INTO t_sign(NO,wtime,wstatues) SELECT " + no + ",'" + time + "',0 FROM DUAL WHERE NOT EXISTS (SELECT NO,wtime FROM t_sign WHERE NO=" + no + " AND wtime='" + time + "')";
        db.executeUpdate(sql);
    }
}
