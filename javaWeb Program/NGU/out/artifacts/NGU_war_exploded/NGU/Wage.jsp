<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/6/24
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.sun.xml.internal.txw2.Document" %>
<%@page import="javax.jws.soap.SOAPBinding.Use" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.NGU.Moduel.Salary" %>
<%@page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>查询全部考勤信息</title>
    <script>
        function $(id) {
            return document.getElementById(id);
        }

        function up(index) {/*上一页*/
            if (index == 0) ;
            else {
                index = parseInt(index - 5);
                window.location.href = "<%=basePath %>NGU/Wage.jsp?index=" + index;
            }
        }

        function down(index, l) {/*下页*/
            if (index + 4 >= l) ;
            else {
                index = parseInt(index + 5);
                window.location.href = "<%=basePath %>NGU/Wage.jsp?index=" + index;
            }
        }

        function back() {/*返回管理员主界面*/
            window.location.href = "<%=basePath %>NGU/admin.jsp";
        }
    </script>
    <style>
        body {
            background-color: #F8F8FF;
        }

        .btn {
            font-size: 20px;
            padding: 10px;
        }
    </style>
</head>
<body>
<%

    ArrayList list = (ArrayList) session.getAttribute("listsalary");
    int index = 0;
    int iii = Integer.parseInt(request.getParameter("index"));
    if (!" ".equals(iii)) {
        index = iii;
    }
    int end = 0, len = 0;
    if (!list.equals(null)) {
        if (index + 4 >= list.size() - 1) {
            end = list.size() - 1;
        } else {
            end = index + 4;
        }
        len = list.size() - 1;
    }
%>


<center>
    <h1>员工当月工资表</h1>
    <fieldset style="font-size: 20px;width: 20%;margin-bottom: 2%">
        <form action="servlet" method="post">
            <input type="hidden" name="key" value="searchwageby"><!-- 隐藏域 -->
            请选择员工编号：
            <select name="wagebyno">
                <option>-请选择-</option>
                <%
                    ArrayList a = new ArrayList();
                    for (int i = 0; i < list.size(); i++) {
                        if (!a.contains(((Salary) list.get(i)).getNo())) {
                            a.add(((Salary) list.get(i)).getNo());
                        }
                    }
                    for (int i = 0; i < a.size(); i++) {
                %>
                <option value="<%=a.get(i) %>"><%=a.get(i) %>
                </option>
                <%
                    }
                %>
            </select>
            <input type="submit" value="查询" class="btn">
        </form>
        <form action="servlet" method="post">
            <input type="hidden" name="key" value="searchwage"><!-- 隐藏域 -->
            <input type="submit" value="查询全部" class="btn">
            <input type="button" value="返回主界面" onclick="back()" class="btn">
        </form>

    </fieldset>


    <table width="100%" border="0" cellpadding="0" cellspacing="1"
           bgcolor="#a8c7ce" style="width: 70%">
        <tr height="50px">
            <td bgcolor="d3eaef" align="center">编号</td>
            <td bgcolor="d3eaef" align="center">姓名</td>
            <td bgcolor="d3eaef" align="center">签到次数</td>
            <td bgcolor="d3eaef" align="center">员工总工资</td>

        </tr>
        <%
            for (int i = index; i <= end; i++) {
                Salary salary = (Salary) list.get(i);

        %>

        <tr>
            <td bgcolor="d3eaef" align="center"><input type="hidden" id="no" readonly><%=salary.getNo() %>
            </td>
            <td bgcolor="d3eaef" align="center"><input type="hidden" id="name" readonly><%=salary.getName() %>
            </td>
            <td bgcolor="d3eaef" align="center"><input type="hidden" id="SignDayTimes"
                                                       readonly><%=salary.getSignDayTimes() %>
            </td>
            <td bgcolor="d3eaef" align="center"><input type="hidden" id="salary" readonly><%=salary.getSalary() %>
            </td>
            </td>
        </tr>
        <%}%>
        <tr align="center">
            <td colspan="4">
                <input type="button" value="上一页" onclick="up(<%=index%>)" class="btn">
                <input type="button" value="下一页" onclick="down(<%=index %>,<%=len%>)" name="aa" class="btn">
            </td>
        </tr>

    </table>
</center>
<br/>
<br/>
</body>
</html>
