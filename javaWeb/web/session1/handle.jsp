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
<%
    ArrayList arr = new ArrayList();
    //初始化动态数组
    book booka = new book();
    booka.setBookName("Java教程");
    book bookb = new book();
    bookb.setBookName("数据库原理");
    book bookc = new book();
    bookc.setBookName("操作系统");
    book bookd = new book();
    bookd.setBookName("C语言教程");
    arr.add(booka);
    arr.add(bookb);
    arr.add(bookc);
    arr.add(bookd);
    //接收参数，并放置在session对象中,进行转码
    String[] bookName = request.getParameterValues("choice");
    if (bookName != null) {
        for (int j = 0; j < bookName.length; j++) {
            bookName[j] = new String(bookName[j].getBytes("iso-8859-1"), "gb2312");
        }
    }
    //获取到session对象中的书籍数据
    ArrayList arrS = (ArrayList) session.getAttribute("arr");
    if (arrS != null) {// 如果session中的arrS不为空，说明已经选择了书籍，将初始化的arr赋值
        arr = arrS;
    }
    //将用户选择的书籍数组与arr中的书籍进行循环对比，并增加数量
    if (bookName != null) {
        for (int i = 0; i < arr.size(); i++) {
            book book2 = (book) arr.get(i);
            for (int j = 0; j < bookName.length; j++) {
                if (book2.getBookName().equals(bookName[j])) {
                    book2.setBookNum(book2.getBookNum() + 1);
                }
            }
        }
    }


    session.setAttribute("arr", arr);
    response.sendRedirect("count.jsp");
%>
</body>

</html>
