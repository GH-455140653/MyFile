package com.dqpi.Handle.PageHandle;

import com.dqpi.Handle.Dao.imp_course;
import com.dqpi.Handle.Dao.imp_login;
import com.dqpi.Handle.Dao.imp_message;
import com.dqpi.Handle.UserDaoInterface.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet(
//        urlPatterns = {"/com.dqpi.Handle.indexHandle"},
//        name = "userHandle"
//)

public class indexHandle extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opera = req.getParameter("opera");
        opera = new String(opera.getBytes("iso-8859-1"), "utf-8");
        List<String> list;
        HttpSession session = req.getSession();
        if (opera.equals("login")) {
            //登陆页面处理
            String account = req.getParameter("account");
            String password = req.getParameter("password");
            int id = Integer.parseInt(req.getParameter("id"));
            account = new String(account.getBytes("iso-8859-1"), "utf-8");
            password = new String(password.getBytes("iso-8859-1"), "utf-8");
            UserDao userDao = new imp_login();
            list = userDao.login(id, account, password);
            if (list.get(0).equals("d")) {
                session.setAttribute("message", "登录成功！");
                session.setAttribute("flag", "已经登录");
                session.setAttribute("id", id);//将获取来的id设为session变量
            } else {
                session.setAttribute("message", "登陆失败！");
            }
            session.setAttribute("key", list.get(0));
            session.setAttribute("value", list.get(1));
            session.setAttribute("account", account);
            session.setAttribute("password", password);
            resp.sendRedirect("exam/output1.jsp");

        } else if (opera.equals("personMessage")) {
            //个人信息界面处理
            String account = (String) session.getAttribute("account");
            String password = (String) session.getAttribute("password");
            String flag = (String) session.getAttribute("flag");

            //登陆判断
            if (account == null || password == null || flag == null) {
                System.out.println("请先登录！");
                resp.sendRedirect("exam/index.jsp");
            } else {
                String name = req.getParameter("name");
                name = new String(name.getBytes("iso-8859-1"), "utf-8");
                String age = req.getParameter("age");
                age = new String(age.getBytes("iso-8859-1"), "utf-8");
                String sex = req.getParameter("sex");
                sex = new String(sex.getBytes("iso-8859-1"), "utf-8");
                int id = (int) session.getAttribute("id");
                UserDao userDao = new imp_message();
                list = userDao.message(name, sex, age, id);
                if (list.get(0).equals("e")) {
                    session.setAttribute("message", "个人信息成功插入数据库！");
                } else {
                    session.setAttribute("message", "个人信息插入数据库失败！");
                }
                session.setAttribute("key", list.get(0));
                session.setAttribute("value", list.get(1));
                session.setAttribute("name", list.get(2));
                session.setAttribute("sex", list.get(3));
                session.setAttribute("age", list.get(4));
                resp.sendRedirect("exam/output2.jsp");
            }

        } else if (opera.equals("selectCourse")) {
            //选课信息处理
            String account = (String) session.getAttribute("account");
            String password = (String) session.getAttribute("password");
            String flag = (String) session.getAttribute("flag");

            //登陆判断
            if (account == null || password == null || flag == null) {
                System.out.println("请先登录！");
                resp.sendRedirect("exam/index.jsp");
            } else {
                String[] course = req.getParameterValues("course");
                if (course != null) {//解决数组不存在--500错误
                    int id = (int) session.getAttribute("id");
                    UserDao userDao = new imp_course();
                    list = userDao.Course(course,id);
                    if (list.get(0).equals("c")) {
                        session.setAttribute("message", "选课成功！");
                    } else {
                        session.setAttribute("message", "选课失败！");
                    }
                    session.setAttribute("key", list.get(0));
                    session.setAttribute("value", list.get(1));
                    session.setAttribute("course", course);
                    resp.sendRedirect("exam/output3.jsp");
                } else {
                    session.setAttribute("message", "选课失败！");
                    session.setAttribute("key", "a");
                    session.setAttribute("value", "你没有选择课程,请选择至少1门课程!");
                    resp.sendRedirect("exam/output3.jsp");
                }
            }
        } else {
            //异常处理
            System.out.println("输入有误！");
        }
    }
}
