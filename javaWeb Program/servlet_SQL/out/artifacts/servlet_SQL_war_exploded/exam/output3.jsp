<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/5/29
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>选择课程表单输出</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<%
    String[] course = (String[]) session.getAttribute("course");
%>

<h1>选课结果：<%=session.getAttribute("message")%>
</h1>

<%
    if ((session.getAttribute("key")).equals("a")) {
        out.println("原因：" + session.getAttribute("value"));
    } else {
%>
<p>
    <%
        out.println(session.getAttribute("value"));
        for (String value : course) {
            String temp = new String(value.getBytes("iso-8859-1"), "utf-8");
            out.println(temp + "");
        }
    %>
</p>
<%}%>

</body>
</html>
