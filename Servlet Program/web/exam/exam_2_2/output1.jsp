<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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
    String key = (String) session.getAttribute("key");
%>
<h1>
    你的登陆结果是：<%=session.getAttribute("message")%>
</h1>
<%
    if (key.equals("d")) {%>
<p>
    你的账号为：<%=session.getAttribute("account")%>
</p>
<p>
    你的密码为：<%=session.getAttribute("password")%>
</p>
<%} else {%>
<p>
    <%=session.getAttribute("value")%>
</p>
<%}%>

</body>
</html>
