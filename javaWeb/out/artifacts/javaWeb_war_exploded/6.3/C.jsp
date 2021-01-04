<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/5/12
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>100以外</title>
</head>
<body>
<%
    String num = request.getParameter("num");
    out.println(num+"不是100以内的数！");
%>
</body>
</html>
