<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/5/12
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理</title>
</head>
<body>
数据处理页面<br/>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    if (num >= 100) {
%>
<jsp:forward page="C.jsp"/>
<% } else {%>
<jsp:forward page="B.jsp"/>
<%}%>


</body>
</html>
