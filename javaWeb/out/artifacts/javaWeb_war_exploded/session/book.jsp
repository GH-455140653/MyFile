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
��ѡ����Ҫ������鼮��
<FORM action="<%=path %>/session/handle.jsp" method=post name=form>
    <input type="checkbox" name="choice" value="Java�̳�">Java�̳�
    <input type="checkbox" name="choice" value="���ݿ�ԭ��">���ݿ�ԭ��
    <input type="checkbox" name="choice" value="����ϵͳ">����ϵͳ
    <input type="checkbox" name="choice" value="C���Խ̳�">C���Խ̳�
    <input type="checkbox" name="choice" value="JSP">JSP�̳�
    <br/>
    <INPUT TYPE="submit" value="��ӵ����ﳵ" name="submit">
</FORM>
<a href="<%=path %>/session/count.jsp">�鿴���ﳵ</a>

</body>

</html>
