<%@ page language="java" import="java.util.*,a.b.c.*" pageEncoding="gb2312" %>
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
    ArrayList arr = (ArrayList) session.getAttribute("arr");
    if (arr == null) {
        out.println("���ﳵ�Ѿ�����ջ�����δѡ���κ��鼮��");
    } else {
        for (int i = 0; i < arr.size(); i++) {
            book book2 = (book) arr.get(i);
            out.println(book2.getBookName() + "(" + book2.getBookNum() + "��)");
            out.println("&nbsp");
        }
    }

%>
<br><br><br><br>���ӵ�book.jsp��ҳ��,���������鼮��
<A HREF="<%=path %>/session1/book.jsp">��ӭȥbook.jsp��</A> <BR><BR>
<A HREF="<%=path %>/session1/deleteAll.jsp">��չ��ﳵ</A>
</body>

</html>
