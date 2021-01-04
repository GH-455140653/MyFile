<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/5/29
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>首页</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h3>这个是登陆表单：</h3>
<form action="userhandle" method="post">
    <input type="hidden" name="opera" value="login">
    请输入你的姓名：<input type="text" name="name"><br>
    请输入你的密码：<input type="password" name="password"><br>
    <input type="submit" name="submit" value="登录">
</form>
<h3>这个是个人信息表单：</h3>
<form action="userhandle" method="post">
    <input type="hidden" name="opera" value="personMessage">
    请输入你的姓名：<input type="text" name="name"><br>
    请输入你的性别：<input type="text" name="sex"><br>
    请输入你的年龄：<input type="text" name="age"><br>
    <input type="submit" name="submit" value="提交">
</form>
<h3>这个是选择课程表单：</h3>
<form action="userhandle" method="post">
    <input type="hidden" name="opera" value="selectCourse">
    请输入要选择的课程：<br>
    <input type="checkbox" name="course" value="高数">高数<br>
    <input type="checkbox" name="course" value="Java">Java<br>
    <input type="checkbox" name="course" value="JSP">JSP<br>
    <input type="checkbox" name="course" value="大物">大物<br>
    <input type="submit" name="submit" value="提交">
</form>
</body>
</html>
