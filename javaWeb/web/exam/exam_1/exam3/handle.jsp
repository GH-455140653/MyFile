<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/5/22
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>信息处理</title>
</head>
<body>
<%!
    boolean flag = true;
%>

<%
    if (request.getParameter("name") != null) {
        flag = true;
    }
    if (flag) {
        String name = request.getParameter("name");
        name = new String(name.getBytes("iso-8859-1"), "utf-8");
        session.setAttribute("Sname", name);
        flag = false;
    }
%>
<div>
    <form action="output.jsp" method="post">
        你的名字：<input type="text" name="name" value="<%out.print(session.getAttribute("Sname"));%>" readonly><br>
        留言标题：<input type="text" name="title"><br>
        留言内容：<br>
        <textarea name="content" id="" cols="33" rows="10"></textarea><br>
        <input type="submit" value="留言">
    </form>
    <a href="output.jsp">查看留言内容</a>
</div>
</body>
</html>
