package com.NGU.UserDao.Imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.NGU.Moduel.Dialog;
import com.NGU.UserDao.Interface.DialogDAOI;
import com.NGU.Util.DBManager;


public class UserDaoImpDialog implements DialogDAOI {
    private int no;
    private int dno;
    private String name;
    private String message;

    public UserDaoImpDialog(String dno) {
        this.dno = Integer.parseInt(dno);
    }

    public UserDaoImpDialog(int no) {
        this.no = no;
    }

    public UserDaoImpDialog() {

    }

    public UserDaoImpDialog(String dno, int no, String name, String message) {
        this.no = no;
        this.dno = Integer.parseInt(dno);
        this.name = name;
        this.message = message;
    }

    public UserDaoImpDialog(String no, String message) {
        this.no = Integer.parseInt(no);
        this.message = message;
    }

    @Override
    public List<Dialog> read() {                     //查询留言
        DBManager db = new DBManager();
        List<Dialog> list = new ArrayList<>();
        String sql;
        sql = "select t_dialog.no ,Dno,Dmessage,Pname from t_dialog,t_person where t_dialog.no=t_person.no";
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Dialog dialog = new Dialog();
                dialog.setNo(rs.getInt("no"));
                dialog.setDno(rs.getInt("Dno"));
                dialog.setMessage(rs.getString("Dmessage"));
                dialog.setName(rs.getString("Pname"));
                list.add(dialog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("结果集没有值");
        }
        db.dbmclose();
        return list;
    }

    public void delete() {                  //删除
        DBManager db = new DBManager();
        String sql = "delete from t_dialog where Dno = " + dno;
        db.executeUpdate(sql);
    }

    public List<Dialog> readByDno() {                //根据编号查询
        DBManager db = new DBManager();
        List<Dialog> list = new ArrayList<>();
        String sql = "select t_dialog.no ,Dno,Dmessage,Pname from t_dialog,t_person where t_dialog.no=t_person.no and Dno=" + dno;
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Dialog dialog = new Dialog();
                dialog.setNo(rs.getInt("no"));
                dialog.setDno(rs.getInt("Dno"));
                dialog.setMessage(rs.getString("Dmessage"));
                dialog.setName(rs.getString("Pname"));
                list.add(dialog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("结果集没有值ֵ");
        }
        db.dbmclose();
        return list;
    }

    @Override
    public List<Dialog> update() {                  //更新留言
        List<Dialog> list = new ArrayList<>();
        DBManager db = new DBManager();
        String sql = "update t_dialog set Dmessage='" + message + "' where Dno=" + dno;
        int num = db.executeUpdate(sql);
        if (num != 0) {
            list = read();
        } else {
            System.out.println("更新失败!");
        }
        return list;
    }

    @Override
    public List<Dialog> readMaxDno() {             //查询最大留言编号
        DBManager db = new DBManager();
        List<Dialog> list = new ArrayList<>();
        String sql;
        sql = "select MAX(dno) as Dno from t_dialog";
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Dialog dialog = new Dialog();
                dialog.setDno(rs.getInt("Dno"));
                list.add(dialog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("结果集没有值");
        }
        db.dbmclose();
        return list;
    }

    @Override
    public List<Dialog> create() {
        DBManager db = new DBManager();
        List<Dialog> list = new ArrayList<>();
        List<Dialog> listReadMaxDno = readMaxDno();
        dno = listReadMaxDno.get(0).getDno() + 1;
        String sql = "insert into t_dialog values('" + no + "','" + dno + "','" + message + "')";
        db.executeUpdate(sql);
        list = read();
        return list;
    }

    @Override
    public List<Dialog> readByno() {
        DBManager db = new DBManager();
        List<Dialog> list = new ArrayList<>();
        String sql = "select t_dialog.no ,Dno,Dmessage,Pname from t_dialog,t_person where t_dialog.no=t_person.no and t_dialog.no=" + no;
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Dialog dialog = new Dialog();
                dialog.setNo(rs.getInt("no"));
                dialog.setDno(rs.getInt("Dno"));
                dialog.setMessage(rs.getString("Dmessage"));
                dialog.setName(rs.getString("Pname"));
                list.add(dialog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("结果集没有值ֵ");
        }
        db.dbmclose();
        return list;
    }
}
