package com.NGU.UserDao.Imp;

import com.NGU.Moduel.Advice;
import com.NGU.Moduel.Dialog;
import com.NGU.UserDao.Interface.AdviceDAOI;
import com.NGU.Util.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpAdvise implements AdviceDAOI {
    private int no;//员工编号
    private int Sno;//建议条号
    private String name;//员工姓名
    private String tele;//员工联系方式
    private String message;//建议内容
    public UserDaoImpAdvise(String no, String smessage) {
        this.no = Integer.parseInt(no);
        this.message = smessage;
    }

    public UserDaoImpAdvise() {
        // TODO Auto-generated constructor stub
    }

    public UserDaoImpAdvise(String sno) {
        this.Sno = Integer.parseInt(sno);
    }

    public UserDaoImpAdvise(int noInt) {
        this.no = noInt;
    }

    public UserDaoImpAdvise(int no, String smessage) {
        this.no = no;
        this.message = smessage;
    }

    @Override
    public List<Advice> fileInput() {
        return null;
    }

    @Override
    public List<Advice> fileOutput() {
        return null;
    }

    @Override
    public List<Advice> read() {                     //查询留言
        DBManager db = new DBManager();
        List<Advice> list = new ArrayList<>();
        String sql;
        sql = "SELECT t_suggestion.no,Sno,Smessage,Pname,Ptele FROM t_suggestion,t_person WHERE t_suggestion.no=t_person.no";
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Advice advice = new Advice();
                advice.setNo(rs.getInt("no"));
                advice.setSno(rs.getInt("Sno"));
                advice.setName(rs.getString("Pname"));
                advice.setMessage(rs.getString("Smessage"));
                advice.setTele(rs.getString("Ptele"));
                list.add(advice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("结果集没有值");
        }
        db.dbmclose();
        return list;
    }

    @Override
    public List<Advice> readBySno() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Advice> readByno() {
        DBManager db =  new DBManager();
        List<Advice> list = new ArrayList<>();
        String sql = "SELECT t_suggestion.no,Sno,Smessage,Pname,Ptele FROM t_suggestion,t_person WHERE t_suggestion.no=t_person.no AND t_suggestion.no="+no;
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Advice advice = new Advice();
                advice.setNo(rs.getInt("no"));
                advice.setSno(rs.getInt("Sno"));
                advice.setName(rs.getString("Pname"));
                advice.setMessage(rs.getString("Smessage"));
                advice.setTele(rs.getString("Ptele"));
                list.add(advice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("结果集没有值ֵ");
        }
        db.dbmclose();
        return list;
    }

    @Override
    public void delete(){                  //删除
        DBManager db =  new DBManager();
        String sql = "delete from t_suggestion where Sno = "+Sno;
        db.executeUpdate(sql);
    }


    @Override
    public List<Advice> readMaxSno() {             //查询最大反馈编号
        DBManager db = new DBManager();
        List<Advice> list = new ArrayList<>();
        String sql;
        sql = "select MAX(Sno) as Sno from t_suggestion";
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Advice advice = new Advice();
                advice.setSno(rs.getInt("Sno"));
                list.add(advice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("结果集没有值");
        }
        db.dbmclose();
        return list;
    }

    @Override
    public List<Advice> create() {        //创建新反馈
        DBManager db =  new DBManager();
        List<Advice> list = new ArrayList<>();
        List<Advice> listReadMaxSno = readMaxSno();
        Sno = listReadMaxSno.get(0).getSno()+1;
        String sql = "insert into t_suggestion values('"+no+"','"+Sno+"','"+message+"')";
        db.executeUpdate(sql);
        list = read();
        return list;
    }
}
