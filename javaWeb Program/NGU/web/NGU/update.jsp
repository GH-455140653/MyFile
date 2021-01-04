<%@page import="com.NGU.Moduel.Dialog" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="<%=basePath%>">
    <title>表单数据修改</title>
</head>
<body>
<form action="servlet" method="post">
    <input type="hidden" name="key" value="Upform">
    <%
        ArrayList list = (ArrayList) session.getAttribute("list_dialog");
        Dialog dialog = (Dialog) list.get(0);
    %>
    留言编号:<input type="text" value="<%=dialog.getDno()%>" name="Dno" readonly/><br>
    员工编号:<input type="text" value="<%=dialog.getNo()%>" name="No" readonly/><br>
    员工姓名:<input type="text" value="<%=dialog.getName()%>" name="Name" readonly/><br>
    留言内容:<textarea rows="3" cols="20" name="Message" maxlength="50"><%=dialog.getMessage()%></textarea><br>
    <button type="submit">确认修改</button>
    <button type="reset">重置</button>
</form>
</body>
</html>