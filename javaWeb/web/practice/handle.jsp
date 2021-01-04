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
    <title>处理</title>
</head>
<body>
<%
    String account = request.getParameter("Account");
    String password = request.getParameter("Password");
    if (account.equals("lrl") && password.equals("123")) {
        response.sendRedirect("true");
    } else {
        response.sendRedirect("false");
    }
%>
</body>
</html>
