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
    //��ʼ����̬����
    book booka = new book();
    booka.setBookName("Java�̳�");
    book bookb = new book();
    bookb.setBookName("���ݿ�ԭ��");
    book bookc = new book();
    bookc.setBookName("����ϵͳ");
    book bookd = new book();
    bookd.setBookName("C���Խ̳�");
    arr.add(booka);
    arr.add(bookb);
    arr.add(bookc);
    arr.add(bookd);
    //���ղ�������������session������,����ת��
    String[] bookName = request.getParameterValues("choice");
    if (bookName != null) {
        for (int j = 0; j < bookName.length; j++) {
            bookName[j] = new String(bookName[j].getBytes("iso-8859-1"), "gb2312");
        }
    }
    //��ȡ��session�����е��鼮����
    ArrayList arrS = (ArrayList) session.getAttribute("arr");
    if (arrS != null) {// ���session�е�arrS��Ϊ�գ�˵���Ѿ�ѡ�����鼮������ʼ����arr��ֵ
        arr = arrS;
    }
    //���û�ѡ����鼮������arr�е��鼮����ѭ���Աȣ�����������
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
