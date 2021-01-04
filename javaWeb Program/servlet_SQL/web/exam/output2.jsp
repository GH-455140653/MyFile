<%--
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
    <title>个人信息表单输出</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<%
    String key = (String) session.getAttribute("key");
%>
<h1>
    你的登录结果是：<%=session.getAttribute("message")%>
</h1>
<%
    if (key.equals("e")) {%>
<p>
    你的姓名为：<%=session.getAttribute("name")%>
</p>
<p>
    你的性别为：<%=session.getAttribute("sex")%>
</p>
<p>
    你的年龄为：<%=session.getAttribute("age")%>
</p>
<%} else {%>
<p>
    <%=session.getAttribute("value")%>
</p>
<%}%>

</body>
</html>
