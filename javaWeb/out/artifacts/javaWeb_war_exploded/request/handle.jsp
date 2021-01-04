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
<%
    String name = request.getParameter("name");
    String course = request.getParameter("course");
    if (course.equals("java")) {
        //跳转到java.jsp
        RequestDispatcher rd = request.getRequestDispatcher("java.jsp");
        //request.setAttribute("name",name);
        //session.setAttribute("name",name);
        //客户端跳转,发起了新的请求
        response.sendRedirect("java.jsp");

    } else if (course.equals("net")) {

        RequestDispatcher rd = request.getRequestDispatcher("net.jsp");
        request.setAttribute("name", name);
        rd.forward(request, response);
    }
%>

</body>
</html>
