<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/5/27
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输出界面</title>
</head>
<body>
<%
    String msg = (String) session.getAttribute("msg");
    String username = (String) session.getAttribute("name");
    String pws = (String) session.getAttribute("pws");
    out.println("<br><br>你的登录结果是：" + msg);
    if (msg.equals("登录成功")) {
        out.println("<br><br>你的账号是：" + username);
        out.println("<br><br>你的密码是：" + pws);
    }
%>
</body>
</html>
