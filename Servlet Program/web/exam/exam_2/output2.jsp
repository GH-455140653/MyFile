<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/5/29
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>个人信息表单输出</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
    String message = (String) session.getAttribute("message");
    String name = (String) session.getAttribute("name");
    String sex = (String) session.getAttribute("sex");
    String age = (String) session.getAttribute("age");
    if (message.equals("个人信息匹配成功！")) {
        out.println(message + "<br>");
        out.println("您的姓名为：" + name + "<br>");
        out.println("您的性别为：" + sex + "<br>");
        out.println("您的年龄为：" + age + "<br>");
    } else {
        out.println(message);
    }
%>
</body>
</html>
