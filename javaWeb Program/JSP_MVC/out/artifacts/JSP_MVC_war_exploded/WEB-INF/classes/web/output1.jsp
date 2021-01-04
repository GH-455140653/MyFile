<%@page import="com.dqpi.Model.User" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script>
        /* 全选 */
        function cli(Obj) {
            var collid = document.getElementById("all")
            var coll = document.getElementsByName(Obj)
            if (collid.checked) {
                for (var i = 0; i < coll.length; i++)
                    coll[i].checked = true;
            } else {
                for (var i = 0; i < coll.length; i++)
                    coll[i].checked = false;
            }
        }

        /*删除确定  */
        function confirmit() {
            if (confirm("是否确定删除？")) {
                return true;
            } else {
                alert("删除成功")
                return false;
            }
        }

        /*批量删除  */
        function deleAll(Obj) {
            var check = document.getElementsByName(Obj);
            var len = check.length;
            var idAll = ""
            for (var i = 0; i < len; i++) {
                if (check[i].checked) {
                    idAll[i] = check[i].value;
                    idAll = idAll + check[i].value + ",";
                }
            }
            if (idAll !== "") {
                window.location.href = "userservlet?idAll=" + idAll + "&operate=deleteQuery";
            } else {
                alert("请选中需要删除的对象！")
            }
        }

        function page_turn(flag, pagenum, size) {
            if (flag === "next" && pagenum * 5 >= size) {
                alert("已经到最后一页了");
            } else if (flag === "pre" && pagenum === 1) {
                alert("已经到第一页了");
            } else {
                window.location.href = "userservlet?operate=pageTurn&name=" + flag + "&pageNum=" + pagenum;
            }
        }
    </script>
</head>
<body>
<font size="3">这个是登录的结果页面</font>
<%
    ArrayList list = (ArrayList) session.getAttribute("userlist");
    String pageNum = (String) session.getAttribute("pageNum");
    int num = Integer.parseInt(pageNum);
%>

<table width="100%" border="0" cellpadding="0" cellspacing="1"
       bgcolor="#a8c7ce">
    <tr height="50px">
        <td bgcolor="d3eaef" align="center">全选：<input type="checkbox" name="boxname" id="all" onclick="cli('boxname')"
                                                      value="checkbox"/></td>
        <td bgcolor="d3eaef" align="center">id</td>
        <td bgcolor="d3eaef" align="center">姓名</td>
        <td bgcolor="d3eaef" align="center">密码</td>
        <td bgcolor="d3eaef" align="center">修改</td>
    </tr>
    <%
        for (int i = (num - 1) * 5; i < list.size() && i < num * 5; i++) {
            User user = (User) list.get(i);
            int id = user.getId();
            String name = user.getName();
            String password = user.getPassword();
    %>
    <tr>
        <td bgcolor="d3eaef" align="center"><input type="checkbox" name="boxname" value="<%=user.getId()%>"/></td>
        <td bgcolor="d3eaef" align="center"><%=id%>
        </td>
        <td bgcolor="d3eaef" align="center"><%=name%>
        </td>
        <td bgcolor="d3eaef" align="center"><%=password%>
        </td>
        <td bgcolor="d3eaef" align="center"><a href="updateForm.jsp?id=<%=id%>&name=<%=name%>&password=<%=password%>"
        >修改</a>
        </td>
    </tr>
    <%
        }
    %>
    <tr height=" 50px">
        <td>
            <div style="margin-right: 20px;">
                <input type="submit" value="批量删除" onclick="deleAll('boxname')">
                <button id="btn_pre" onclick="page_turn('pre',<%=num%>,<%=list.size()%>)">上一页</button>
                <button id="btn_next" onclick="page_turn('next',<%=num%>,<%=list.size()%>)">下一页</button>
            </div>
        </td>
    </tr>
</table>
<br/>
<br/>
</body>
</html>