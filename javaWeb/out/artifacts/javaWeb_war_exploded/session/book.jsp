<%@ page language="java" import="java.util.*" pageEncoding="gb2312" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'input.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>
<body>
请选择您要购买的书籍：
<FORM action="<%=path %>/session/handle.jsp" method=post name=form>
    <input type="checkbox" name="choice" value="Java教程">Java教程
    <input type="checkbox" name="choice" value="数据库原理">数据库原理
    <input type="checkbox" name="choice" value="操作系统">操作系统
    <input type="checkbox" name="choice" value="C语言教程">C语言教程
    <input type="checkbox" name="choice" value="JSP">JSP教程
    <br/>
    <INPUT TYPE="submit" value="添加到购物车" name="submit">
</FORM>
<a href="<%=path %>/session/count.jsp">查看购物车</a>

</body>

</html>
