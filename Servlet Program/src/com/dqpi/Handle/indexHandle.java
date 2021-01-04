package com.dqpi.Handle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet(
//        urlPatterns = {"/com.dqpi.Handle.indexHandle"},
//        name = "userHandle"
//)

public class indexHandle extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opera = req.getParameter("opera");
        opera = new String(opera.getBytes("iso-8859-1"), "utf-8");
        HttpSession session = req.getSession();
        if (opera.equals("login")) {
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            String message;
            loginHandle loginhandle = new loginHandle(name, password);
            if ((message = loginhandle.isNull()) != null) {
                session.setAttribute("message", message);
                resp.sendRedirect("exam/exam_2/output1.jsp");
            } else {
                message = loginhandle.checked();
                password = new String(password.getBytes("iso-8859-1"), "utf-8");
                name = new String(name.getBytes("iso-8859-1"), "utf-8");
                session.setAttribute("name", name);
                session.setAttribute("password", password);
                session.setAttribute("message", message);
                resp.sendRedirect("exam/exam_2/output1.jsp");
            }
        } else if (opera.equals("personMessage")) {
            String name = req.getParameter("name");
            String sex = req.getParameter("sex");
            String age = req.getParameter("age");
            String message;
            if ((message = isNull(name, sex, age)) == null) {
                name = new String(name.getBytes("iso-8859-1"), "utf-8");
                sex = new String(sex.getBytes("iso-8859-1"), "utf-8");
                age = new String(age.getBytes("iso-8859-1"), "utf-8");
                message = checked(name, sex, age);
                session.setAttribute("message", message);
                session.setAttribute("name", name);
                session.setAttribute("sex", sex);
                session.setAttribute("age", age);
                resp.sendRedirect("exam/exam_2/output2.jsp");
            } else {
                session.setAttribute("message", message);
                resp.sendRedirect("exam/exam_2/output2.jsp");
            }
        } else if (opera.equals("selectCourse")) {
            String[] course = req.getParameterValues("course");
            courseHandle courseandle = new courseHandle();
            String message;
            if ((message = courseandle.isNull(course)) == null) {
                for (String value : course) {
                    String temp = new String(value.getBytes("iso-8859-1"), "utf-8");
                }
                message = courseandle.checked(course);
                session.setAttribute("message", message);
                session.setAttribute("course", course);
                resp.sendRedirect("exam/exam_2/output3.jsp");
            } else {
                session.setAttribute("message", message);
                resp.sendRedirect("exam/exam_2/output3.jsp");
            }
        } else {
            System.out.println("输入有误！");
        }
    }

    private String checked(String name, String sex, String age) throws ServletException, IOException {
        String message;
        if (name.equals("") || sex.equals("") || age.equals("")) {
            return "姓名、年龄或者性别存在空值，请认真填写上述输入框！";
        } else if (!name.equals("李润霖")) {
            message = "姓名匹配失败！";
        } else if (!sex.equals("男")) {
            message = "性别匹配失败！";
        } else if (!age.equals("20")) {
            message = ("年龄匹配失败！");
        } else {
            message = "个人信息匹配成功！";
        }
        return message;
    }

    private String isNull(String name, String sex, String age) {
        if (name == null || sex == null || age == null) {
            return "姓名、年龄或者性别存在空值，请认真填写上述输入框！";
        } else {
            return null;
        }
    }
}
