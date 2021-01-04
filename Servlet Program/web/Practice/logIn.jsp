<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/5/27
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
</head>
<body>
<form action="userlogin" method="post" name="f1">
    <p>请输入你的姓名：
        <input type="text" name="name">
        <br>
    <p>请输入你的密码：
        <input type="password" name="password">
        <br>
        <input type="submit" name="submit" value="登录">
</form>
</body>
</html>
