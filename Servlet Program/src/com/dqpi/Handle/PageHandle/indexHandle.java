package com.dqpi.Handle.PageHandle;

import com.dqpi.Handle.UserDao.imp_course;
import com.dqpi.Handle.UserDao.imp_login;
import com.dqpi.Handle.UserDaoInterface.UserDaoI;

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
            account = new String(account.getBytes("iso-8859-1"), "utf-8");
            password = new String(password.getBytes("iso-8859-1"), "utf-8");
            UserDaoI userDaoI = new imp_login();
            list = userDaoI.login(account, password);
            if (list.get(0).equals("d")) {
                session.setAttribute("message", "登陆成功！");
            } else {
                session.setAttribute("message", "登陆失败！");
            }
            session.setAttribute("key", list.get(0));
            session.setAttribute("value", list.get(1));
            session.setAttribute("account", account);
            session.setAttribute("password", password);
            resp.sendRedirect("exam/exam_2_2/output1.jsp");

        } else if (opera.equals("personMessage")) {
            //个人信息界面处理
            String account = (String) session.getAttribute("account");
            String password = (String) session.getAttribute("password");

            //登陆判断
            if (account == null || password == null || !account.equals("lrl") || !password.equals("123")) {
                System.out.println("请先登陆！");
                resp.sendRedirect("exam/exam_2_2/index.jsp");
            } else {
                list = dataMatch(req, resp);
                if (list.get(0).equals("e")) {
                    session.setAttribute("message", "登陆成功！");
                } else {
                    session.setAttribute("message", "登陆失败！");
                }
                session.setAttribute("key", list.get(0));
                session.setAttribute("value", list.get(1));
                session.setAttribute("name", list.get(2));
                session.setAttribute("sex", list.get(3));
                session.setAttribute("age", list.get(4));
                resp.sendRedirect("exam/exam_2_2/output2.jsp");
            }

        } else if (opera.equals("selectCourse")) {
            //选课信息处理
            String account = (String) session.getAttribute("account");
            String password = (String) session.getAttribute("password");

            //登陆判断
            if (account == null || password == null || !account.equals("lrl") || !password.equals("123")) {
                System.out.println("请先登陆！");
                resp.sendRedirect("exam/exam_2_2/index.jsp");
            } else {
                String[] course = req.getParameterValues("course");
                if (course != null) {//解决数组不存在--500错误
                    for (String value : course) {
                        String temp = new String(value.getBytes("iso-8859-1"), "utf-8");
                    }
                    UserDaoI userDaoI = new imp_course();
                    list = userDaoI.Course(course);
                    if (list.get(0).equals("c")) {
                        session.setAttribute("message", "选课成功！");
                    } else {
                        session.setAttribute("message", "选课失败！");
                    }
                    session.setAttribute("key", list.get(0));
                    session.setAttribute("value", list.get(1));
                    session.setAttribute("course", course);
                    resp.sendRedirect("exam/exam_2_2/output3.jsp");
                } else {
                    session.setAttribute("message", "选课失败！");
                    session.setAttribute("key", "a");
                    session.setAttribute("value", "你没有选择课程,请选择至少1门课程!");
                    resp.sendRedirect("exam/exam_2_2/output3.jsp");
                }
            }
        } else {
            //异常处理
            System.out.println("输入有误！");
        }
    }

    private static List<String> dataMatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> list = new ArrayList<>();
        String name = req.getParameter("name");
        name = new String(name.getBytes("iso-8859-1"), "utf-8");
        String age = req.getParameter("age");
        age = new String(age.getBytes("iso-8859-1"), "utf-8");
        String sex = req.getParameter("sex");
        sex = new String(sex.getBytes("iso-8859-1"), "utf-8");
        if (name.equals("") || sex.equals("") || age.equals("")) {
            list.add("a");
            list.add("个人信息表中存在空值！");
            list.add(name);
            list.add(sex);
            list.add(age);
        } else if (!name.equals("李润霖")) {
            list.add("b");
            list.add("姓名输入不正确！");
            list.add(name);
            list.add(sex);
            list.add(age);
        } else if (!sex.equals("男")) {
            list.add("c");
            list.add("性别输入不正确！");
            list.add(name);
            list.add(sex);
            list.add(age);
        } else if (!age.equals("20")) {
            list.add("d");
            list.add("年龄输入不正确！");
            list.add(name);
            list.add(sex);
            list.add(age);
        } else {
            list.add("e");
            list.add("输入成功！");
            list.add(name);
            list.add(sex);
            list.add(age);
        }
        return list;
    }
}
