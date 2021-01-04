<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/6/15
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>页面传递</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action="userservlet" method="get">
    <input type="hidden" name="operate" value="updateQuery">
    &nbsp;&nbsp;i&nbsp;&nbsp;d：<input type="text" name="id" readonly value="<%=request.getParameter("id")%>"><br>
    姓名：<input type="text" name="name" value="<%=request.getParameter("name")%>"><br>
    密码：<input type="text" name="password" value="<%=request.getParameter("password")%>"><br>
    <input type="submit" value="修改">
</form>

</body>
</html>
