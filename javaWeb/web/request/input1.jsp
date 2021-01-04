<%@ page language="java" import="java.util.*,java.net.*" pageEncoding="gb2312" %>
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
<%--  <%
    String message = request.getParameter("message");
    if(message!=null){
    message = URLDecoder.decode(message);
    out.println("<h1>"+message+"</h1>");
    }
  %> --%>
<form action="<%=path%>/request/output1.jsp" method="get">
    姓名：<input type="text" name="name" value=""/>
    年龄：<input type="text" name="age" value=""/>
    <input type="radio" name="sex" value="男">男
    <input type="radio" name="sex" value="女">女
    <input type="submit" value="提交"/>
</form>

</body>
</html>
