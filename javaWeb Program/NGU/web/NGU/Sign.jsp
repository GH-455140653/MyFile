<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/6/24
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.NGU.Moduel.Sign" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>考勤信息管理</title>
    <script>
        function $(id) {
            return document.getElementById(id);
        }

        /*修改确定  */
        function confirmit() {
            if (confirm("是否确定修改该员工当天的签到状态？")) {
                alert("修改成功");
                return true;
            } else {
                return false;
            }
        }

        /*上一页*/
        function up(index) {
            if (index == 0) ;
            else {
                index = parseInt(index - 5);
                window.location.href = "<%=basePath%>NGU/Sign.jsp?index=" + index;
            }
        }

        /*下页*/
        function down(index, l) {
            if (index + 4 >= l) ;
            else {
                index = parseInt(index + 5);
                window.location.href = "<%=basePath%>NGU/Sign.jsp?index=" + index;
            }
        }

        /*返回管理员主界面*/
        function back() {
            window.location.href = "<%=basePath%>NGU/admin.jsp";
        }
    </script>
    <style>
        body {
            background-color: #F8F8FF;
        }

        #out {
            font-size: 20px;
            padding: 10px;
        }

        .btn {
            font-size: 20px;
            padding: 10px;
        }

        fieldset {
            width: 40%;
        }

        legend {
            font-size: 20px;
            margin-top: 2%;
            font-family: 隶书;
        }
    </style>
</head>
<body>
<%

    ArrayList list = (ArrayList) session.getAttribute("listsign");
    int index = 0;
    int iii = Integer.parseInt(request.getParameter("index"));
    if (!" ".equals(iii)) {
        index = iii;
    }
    int end = 0, len = 0;
    if (!list.equals(null)) {
        /*out.println("list有东西");*/
        if (index + 4 >= list.size() - 1) {
            end = list.size() - 1;
            /*out.println("*-*-*-/*-"+end);*/
        } else {
            end = index + 4;
            /*out.println("*-*-*-/*-"+end);*/
        }
        len = list.size() - 1;
        /*out.println("*-6666666*-"+len);*/
    }
%>
<div>
    <input type="button" id="out" value="退出子系统" onclick="back()">
</div>
<center>
    <fieldset>
        <legend align="left">选择性查询</legend>
        <form action="servlet" method="post">

            <input type="hidden" name="key" value="searchsignby">
            <font size="+2" face="宋体">按编号查询：</font>
            <select name="signbyno" style="height: 30px">
                <option value="-1">-请选择你需要查询的员工编号-</option>
                <%
                    ArrayList a = new ArrayList();
                    for (int i = 0; i < list.size(); i++) {
                        if (!a.contains(((Sign) list.get(i)).getNo())) {
                            a.add(((Sign) list.get(i)).getNo());
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
            <input type="hidden" name="key" value="searchsign"><!-- 隐藏域 -->
            <input type="submit" value="查询全部" class="btn">
        </form>
    </fieldset>
</center>

<center>
    <h1>员工考勤信息表</h1>
</center>
<table width="70%" align="center" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
    <tr height="50px" bgcolor="#ffe4c4">
        <td align="center">编号</td>
        <td align="center">姓名</td>
        <td align="center">性别</td>
        <td align="center">所在部门</td>
        <td align="center">日期</td>
        <td align="center">签到状态</td>
        <td align="center">操作</td>

    </tr>
    <%
        for (int i = index; i <= end; i++) {
            Sign sign = (Sign) list.get(i);
            String statues=null;
            if (sign.getStatues() == 0) {
                statues = "未签到";
            } else if (sign.getStatues() == 1) {
                statues = "已签到";
            }
    %>

    <tr>
        <td bgcolor="#C1FFC1" align="center"><input type="hidden" id="no" readonly><%=sign.getNo() %>
        </td>
        <td bgcolor="#C1FFC1" align="center"><input type="hidden" id="time" readonly> <%=sign.getName() %>
        </td>
        <td bgcolor="#C1FFC1" align="center"><input type="hidden" id="statues" readonly><%=sign.getSex() %>
        </td>
        <td bgcolor="#C1FFC1" align="center"><input type="hidden" id="name" readonly><%=sign.getDept() %>
        </td>
        <td bgcolor="#C1FFC1" align="center"><input type="hidden" id="sex" readonly><%=sign.getTime() %>
        </td>
        <td bgcolor="#C1FFC1" align="center"><input type="hidden" id="dept" readonly><%=statues %>
        </td>
        <td bgcolor="#C1FFC1" align="center">
            <a onclick="return confirmit()"
               href="servlet?key=signupdate&signupdateno=<%=sign.getNo() %>&signupdatetime=<%=sign.getTime() %>&signupdatestatues=<%=sign.getStatues() %>">
                修改
            </a>
        </td>
    </tr>
    <%}%>
</table>
<center style="margin-top: 1%">
    <input type="button" value="上一页" onclick="up(<%=index%>)" class="btn" style="margin-right: 20px">
    <input type="button" value="下一页" onclick="down(<%=index %>,<%=len%>)" name="aa" class="btn"
           style="margin-left: 20px">
</center>

</body>
</html>
