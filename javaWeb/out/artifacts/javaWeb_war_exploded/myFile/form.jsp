<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>First</title>
</head>
<body>
<h1>输出一个5行4列的表格</h1>
<%
    out.println("<table width='800' border='1'>");
    for (int i = 1; i <= 5; i++) {
        out.println("<tr>");
        for (int j = 1; j <= 4; j++) {
            out.println("<td>第" + i + "行第" + j + "列的单元格</td>");
        }
        out.println("</tr>");
    }
    out.println("</table>");
%>
<h1>输出一个5行4列的表格</h1>
<table width="800" border="1">
    <%for (int i = 1; i <= 5; i++) { %>
    <tr>
        <%for (int j = 1; j <= 4; j++) {%>
        <td>第<%out.println(i); %>行第<%out.println(j); %>列的单元格</td>
        <%} %>
    </tr>
    <% }%>
</table>
<h1>输出一个5行4列的表格</h1>
<table width="800" border="1">
    <%
        for (int i = 1; i < 5; i++) {
            if (i % 2 != 0) {
    %>
    <tr bgcolor="yellow">
            <% }else{%>
    <tr><%} %>
        <%for (int j = 1; j <= 4; j++) {%>
        <td>第<%=i %>行第<%=j %>列的单元格</td>
        <%} %>
    </tr>
    <% }%>
</table>

</body>
</html>