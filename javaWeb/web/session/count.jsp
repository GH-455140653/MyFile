<%@ page language="java" import="java.util.*" pageEncoding="gb2312" %>
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
<FONT Size=5> 这里是购物车结帐处</FONT>
<%
    out.println("<br><br>购物车中的商品：<br><br>");
    //session.removeAttribute("book");//此时将显示没有选择任何书籍
    //session.invalidate();//此时会出现异常
    String[] book = (String[]) session.getAttribute("book");
    if (book == null) {
        out.println("您还没有选择任何书籍！");
    } else {
        for (String s : book) {
            String temp = new String(s.getBytes("ISO-8859-1"), "GB2312");
            out.println(temp + "&nbsp");
        }
    }
%>
<br><br><br><br>连接到book.jsp的页面,继续购买书籍：
<A HREF="<%=path %>/session/book.jsp">欢迎去book.jsp！</A> <BR>
</body>

</html>
