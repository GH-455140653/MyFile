package com.NGU.UserDao.Imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.NGU.Moduel.Person;
import com.NGU.UserDao.Interface.PersonDAOI;
import com.NGU.Util.DBManager;

public class UserDaoImpPerson implements PersonDAOI {
    @Override
    public List<Person> read() {
        DBManager db = new DBManager();
        List<Person> l1 = new ArrayList<>();
        String sql = "select * from t_person";
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Person p1 = new Person();
                p1.setNo(rs.getInt("no"));
                p1.setName(rs.getString("Pname"));
                p1.setAge(rs.getInt("Page"));
                p1.setSalary(rs.getString("Psalary"));
                p1.setSex(rs.getString("Psex"));
                p1.setDept(rs.getString("Pdept"));
                p1.setTele(rs.getString("Ptele"));
                l1.add(p1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("没有结果集");
        }
        db.dbmclose();
        return l1;
    }

    @Override
    public List<Person> search(String no, String dept) {
        DBManager db = new DBManager();
        List<Person> l2 = new ArrayList<>();
        String sql = "";
        int num = Integer.parseInt(no);
        sql = "select * from t_person where Pdept=" + "'" + dept + "' and no=" + num;
        //}
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Person p1 = new Person();
                p1.setNo(rs.getInt("no"));
                p1.setName(rs.getString("Pname"));
                p1.setAge(rs.getInt("Page"));
                p1.setSalary(rs.getString("Psalary"));
                p1.setSex(rs.getString("Psex"));
                p1.setDept(rs.getString("Pdept"));
                p1.setTele(rs.getString("Ptele"));
                l2.add(p1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("没有结果集");
        }
        db.dbmclose();
        return l2;
    }

    @Override
    public void delete(String no) {
        int num = Integer.parseInt(no);
        DBManager db = new DBManager();
        String sql = "delete from t_person where no=" + num;
        db.executeUpdate(sql);
    }

    @Override
    public void update(String type, String value, String no) {

        try {
            value = new String(value.getBytes("ISO-8859-1"), "utf-8");
            type = new String(type.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBManager db = new DBManager();
        String sql = "update t_person set " + type + "='" + value + "' where no=" + no;
        db.executeUpdate(sql);
    }

    @Override
    public void insert(String no, String name, String dept, String age, String sex, String salary, String tel) {
        try {
            name = new String(name.getBytes("ISO-8859-1"), "utf-8");
            dept = new String(dept.getBytes("ISO-8859-1"), "utf-8");
            sex = new String(sex.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBManager db = new DBManager();
        String sql = "INSERT INTO t_person VALUES(" + no + ",'" + name + "'," + age + ",'" + sex + "'," + salary + ",'" + dept + "'," + tel + ")";
        String sql2 = "insert into t_login values('" + no + "','123','0')";
        db.executeUpdate(sql);
        db.executeUpdate(sql2);
    }

    @Override
    public List<Person> change(String no, String name, String dept, String age, String sex, String tel) {
        try {
            name = new String(name.getBytes("ISO-8859-1"), "utf-8");
            dept = new String(dept.getBytes("ISO-8859-1"), "utf-8");
            sex = new String(sex.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBManager db = new DBManager();
        String sql = "update t_person set Pname='" + name + "',Page='" + age + "',Psex='" + sex + "',Pdept='" + dept + "',Ptele='" + tel + "' where no=" + no;
        db.executeUpdate(sql);
        List<Person> l1 = new ArrayList<>();
        String sql2 = "select Pname,Psex,Page,Pdept,Ptele,Psalary from t_person where no=" + no;
        ResultSet rs = db.executeQuery(sql2);
        try {
            while (rs.next()) {
                Person p1 = new Person();
                p1.setName(rs.getString("Pname"));
                p1.setSex(rs.getString("Psex"));
                p1.setAge(rs.getInt("Page"));
                p1.setDept(rs.getString("Pdept"));
                p1.setTele(rs.getString("Ptele"));
                p1.setSalary(rs.getString("Psalary"));
                l1.add(p1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("没有结果集");
        }
        db.dbmclose();
        return l1;
    }

    @Override
    public List<Person> lookInfo(String no) {
        DBManager db = new DBManager();
        List<Person> l1 = new ArrayList<>();
        String sql = "select Pname,Psex,Page,Pdept,Ptele,Psalary from t_person where no=" + no;
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                Person p1 = new Person();
                p1.setName(rs.getString("Pname"));
                p1.setSex(rs.getString("Psex"));
                p1.setAge(rs.getInt("Page"));
                p1.setDept(rs.getString("Pdept"));
                p1.setTele(rs.getString("Ptele"));
                p1.setSalary(rs.getString("Psalary"));
                l1.add(p1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("没有结果集");
        }
        db.dbmclose();
        return l1;
    }

    @Override
    public void writeTxt(String path, String name, String sex, String age, String dept, String tel) {
        FileWriter fw;
        try {
            fw = new FileWriter(path + "\\information.txt");//建立filewrite对象，并实例化
            fw.write("姓名:" + name + "\n");
            fw.write("性别:" + sex + "\n");
            fw.write("年龄:" + age + "\n");
            fw.write("所在部门:" + dept + "\n");
            fw.write("电话:" + tel + "\n");
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void download(String path, HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
        //获取服务器文件
        File file = new File(path + "\\information.txt");

        InputStream ins = new FileInputStream(file);
        /* 设置文件ContentType类型，这样设置，会自动判断下载文件类型 */
        response.setContentType("multipart/form-data");
        /* 设置文件头：最后一个参数是设置下载文件名 */
        response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
        try {
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[1024];
            int len;
            while ((len = ins.read(b)) > 0) {
                os.write(b, 0, len);
            }
            os.flush();
            os.close();
            ins.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public List<Integer> readno() {/*查看员工表的编号*/
        DBManager db = new DBManager();
        List<Integer> list = new ArrayList<>();
        String sql = "SELECT NO FROM t_person";
        list = select(sql);
        return list;
    }

    public List<Integer> select(String sql) {// 查询指定no的所有字段
        DBManager db = new DBManager();
        List<Integer> list = new ArrayList<>();
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                list.add(rs.getInt("no"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("结果集没有值");
        }
        return list;
    }
}
