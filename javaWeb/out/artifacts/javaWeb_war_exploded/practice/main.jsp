<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/5/19
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
</head>
<body>
<%
    String name = request.getParameter("name");
    String sex = request.getParameter("sex");
    String age = request.getParameter("age");
    out.print("姓名为：" + name + ",性别为：" + sex + "，年龄为：" + age);
%>
</body>
</html>
