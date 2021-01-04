<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/5/29
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>选择课程表单输出</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
    String[] course = (String[]) session.getAttribute("course");
    String message = (String) session.getAttribute("message");
    for (String value : course) {
        String temp = new String(value.getBytes("iso-8859-1"), "utf-8");
        value = temp;
    }
    if (message.equals("请选择课程！")) {
        out.println("<h1>选课失败！</h1><br>");
        out.println("你没有选择课程,请选择至少为1门课程");
    } else if (message.equals("选课太少！")) {
        out.println("<h1>选课失败！</h1><br>");
        out.println("课程选择小于2门！<br>");
        out.println("已选课程：<br>");
        for (String value : course) {
            String temp = new String(value.getBytes("iso-8859-1"), "utf-8");
            out.println(temp + "");
        }
    } else {
        out.println("<h1>选课成功！</h1><br>");
        out.println("已选课程：<br>");
        for (String value : course) {
            String temp = new String(value.getBytes("iso-8859-1"), "utf-8");
            out.println(temp + "");
        }
    }
%>
</body>
</html>
