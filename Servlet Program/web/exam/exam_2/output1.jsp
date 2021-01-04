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
    <title>登陆表单输出</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
    String message = (String) session.getAttribute("message");
    String name = (String) session.getAttribute("name");
    String password = (String) session.getAttribute("password");
    if (message.equals("登陆成功！")) {
        out.println(message + "<br>");
        out.println("您的账号为：" + name + "<br>");
        out.println("您的密码为：" + password + "<br>");
    } else {
        out.println(message);
    }
%>
</body>
</html>
