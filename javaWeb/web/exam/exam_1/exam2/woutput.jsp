<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/5/19
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>女士</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    name = new String(name.getBytes("iso-8859-1"), "utf-8");
    out.print("欢迎您，" + name + "女士。");

%>
<form action="">
    <table style="text-align: center" border="1">
        <tr>
            <td>姓名</td>
            <td>
                <%
                    out.print(name);
                %>
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <%
                    String sex = request.getParameter("sex");
                    sex = new String(sex.getBytes("iso-8859-1"), "utf-8");
                    out.print(sex);
                %>
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>
                <%
                    String age = request.getParameter("age");
                    age = new String(age.getBytes("iso-8859-1"), "utf-8");
                    out.print(age);
                %>
            </td>
        </tr>
        <tr>
            <td>所在省份</td>
            <td>
                <%
                    String province = request.getParameter("province");
                    province = new String(province.getBytes("iso-8859-1"), "utf-8");
                    out.print(province);
                %>

            </td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                <%
                    String[] hobby = request.getParameterValues("hobby");
                    for (String value : hobby) {
                        String temp = new String(value.getBytes("ISO-8859-1"), "utf-8");
                        out.print(temp + ",");
                    }
                %>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
