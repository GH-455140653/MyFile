<%@ page import="jdk.nashorn.internal.ir.RuntimeNode" %>
<%@ page import="org.omg.CORBA.Request" %><%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/5/19
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String sex = request.getParameter("sex");
    String age = request.getParameter("age");
    String pwd = request.getParameter("password");
    String pwd_sure = request.getParameter("password_sure");
    String[] hobby = request.getParameterValues("hobby");
    String province = request.getParameter("province");
    boolean key = false;
    if (name.equals("")) {
        out.print("姓名不能为空");
    } else if (sex == null) {
        out.print("性别不能不选");
    } else if (age.equals("")) {
        out.print("请输入你的年龄");
    } else if (pwd.equals("")) {
        out.print("请输入密码");
    } else if (province.equals("")) {
        out.print("请选择你所在的省份");
    } else if (hobby == null) {
        out.print("请选择至少一个兴趣爱好");
    } else if (pwd_sure.equals("")) {
        out.print("确认密码未输入");
    } else if (!pwd.equals(pwd_sure)){
        out.print("两次密码输入不一致！");
    }else {
        key = true;
    }
    if (key) {
        RequestDispatcher rd = request.getRequestDispatcher("output.jsp");
        rd.forward(request, response);
    }
%>
</body>
</html>
