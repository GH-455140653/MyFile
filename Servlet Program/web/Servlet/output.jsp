<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<font size="3">这个是结果页面</font>
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