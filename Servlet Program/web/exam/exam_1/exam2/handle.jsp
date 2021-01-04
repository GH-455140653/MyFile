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
    <title>处理</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String sex = request.getParameter("sex");
    String age = request.getParameter("age");
    String[] hobby = request.getParameterValues("hobby");
    String province = request.getParameter("province");
    boolean key = false;
    if (name.equals("")) {
        out.print("姓名不能为空");
    } else if (sex == null) {
        out.print("性别不能不选");
    } else if (age.equals("")) {
        out.print("请输入你的年龄");
    } else if (province.equals("")) {
        out.print("请选择你所在的省份");
    } else if (hobby == null) {
        out.print("请选择至少一个兴趣爱好");
    } else {
        key = true;
        sex = new String(sex.getBytes("iso-8859-1"), "utf-8");
    }
    if (key) {
        if (sex.equals("男")) {
            RequestDispatcher rd = request.getRequestDispatcher("moutput.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("woutput.jsp");
            rd.forward(request, response);
        }
    }
%>
</body>
</html>
