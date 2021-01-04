<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="userservlet" method="post" name="f1">
    <input type="hidden" name="up" value="login">
    <p>请输入你的姓名：
        <input type="text" name="name">
        <br>
    <p>请输入你的密码：
        <input type="password" name="password" >
        <br>
        <input type="submit" name="submit" value="登录">
</form>
<br>
<form action="userservlet" method="post" name="f2">
    <input type="hidden" name="up" value="on">
    <p>请输入你的年龄：
        <input type="text" name="age">
        <br>
    <p>请输入你的性别：
        <input type="text" name="sex" >
        <br>
        <input type="submit" name="submit" value="提交">
</form>
</body>
</html>