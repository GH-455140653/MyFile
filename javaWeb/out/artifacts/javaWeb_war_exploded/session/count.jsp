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
<FONT Size=5> �����ǹ��ﳵ���ʴ�</FONT>
<%
    out.println("<br><br>���ﳵ�е���Ʒ��<br><br>");
    //session.removeAttribute("book");//��ʱ����ʾû��ѡ���κ��鼮
    //session.invalidate();//��ʱ������쳣
    String[] book = (String[]) session.getAttribute("book");
    if (book == null) {
        out.println("����û��ѡ���κ��鼮��");
    } else {
        for (String s : book) {
            String temp = new String(s.getBytes("ISO-8859-1"), "GB2312");
            out.println(temp + "&nbsp");
        }
    }
%>
<br><br><br><br>���ӵ�book.jsp��ҳ��,���������鼮��
<A HREF="<%=path %>/session/book.jsp">��ӭȥbook.jsp��</A> <BR>
</body>

</html>
