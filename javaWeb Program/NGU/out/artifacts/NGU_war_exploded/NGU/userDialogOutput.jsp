<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/6/24
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.NGU.Moduel.Dialog" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.NGU.Moduel.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>输出</title>
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
<input type="submit" value="退出子系统" onclick="back()" class="btn">
<h1 align="center">员工留言信息表</h1>
<%
    ArrayList list = (ArrayList) session.getAttribute("list_dialog");
    ArrayList list_login = (ArrayList) session.getAttribute("list_login");
    User user = (User) list_login.get(0);
    int No = user.getNo();
%>
<table width="70%" border="0" cellpadding="0" cellspacing="1" align="center">
    <tr height="50px">
        <td bgcolor="#ffe4c4" align="center" width="10%">
            <input type="checkbox" name="boxname" id="all" onclick="cli('boxname')" value="checkbox"/>
        </td>
        <td bgcolor="#ffe4c4" align="center" width="10%">留言编号</td>
        <td bgcolor="#ffe4c4" align="center" width="10%">员工编号</td>
        <td bgcolor="#ffe4c4" align="center" width="10%">员工姓名</td>
        <td bgcolor="#ffe4c4" align="center" width="40%">留言内容</td>
        <td bgcolor="#ffe4c4" align="center" width="10%">修改</td>
        <td bgcolor="#ffe4c4" align="center" width="10%">删除</td>
    </tr>
</table>
<table width="70%" border="0" cellpadding="0" cellspacing="1" id="blocks" align="center">
    <%
        for (int i = 0; i < list.size(); i++) {
            Dialog dialog = (Dialog) list.get(i);
    %>
    <tr height="75px">
        <%if (No == dialog.getNo()) {%>
        <td bgcolor="#C1FFC1" align="center" width="10%">
            <input type="checkbox" name="boxname" value="<%=dialog.getDno()%>"/></td>
        <%} else {%>
        <td bgcolor="#C1FFC1" align="center" width="10%">X</td>
        <%} %>
        <td bgcolor="#C1FFC1" align="center" width="10%"><%=dialog.getDno() %>
        </td>
        <td bgcolor="#C1FFC1" align="center" width="10%"><%=dialog.getNo() %>
        </td>
        <td bgcolor="#C1FFC1" align="center" width="10%"><%=dialog.getName() %>
        </td>
        <td bgcolor="#C1FFC1" width="40%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=dialog.getMessage() %>
        </td>
        <%if (No == dialog.getNo()) {%>
        <td bgcolor="#C1FFC1" align="center" width="10%"><input type="button" value="修改"
                                                                onclick="change(<%=dialog.getDno() %>)">
        </td>
        <td bgcolor="#C1FFC1" align="center" width="10%"><input type="button" value="删除"
                                                                onclick="deleteMessage(<%=dialog.getDno()%>)">
        </td>
        <%} else {%>
        <td bgcolor="#C1FFC1" align="center" width="10%">X</td>
        <td bgcolor="#C1FFC1" align="center" width="10%">X</td>
        <%} %>
    </tr>
    <%} %>
    <tr>
        <td align="center">
            <input type="submit" value="批量删除" onclick="deleAll('boxname')" class="btn">
        </td>
        <td align="center">
            <input type="submit" value="查询本人" onclick="readMine(<%=No%>)" class="btn">
        </td>
        <td align="center">
            <input type="submit" value="查询全部" onclick="readAllDialog()" class="btn">
        </td>
        <td colspan="4"></td>
    </tr>
</table>


<div id="pagiDiv" align="center" style="font-size: 20px;margin-top: 2%">
    <span id="spanFirst">首页</span>
    <span id="spanPre">上一页</span>
    <span id="spanNext">下一页</span>
    <span id="spanLast">尾页</span>
    第 <span id="spanPageNum"></span>页/
    共<span id="spanTotalPage"></span>页
</div>
<script type="text/javascript">
    /*删除留言  */
    function deleteMessage(dno) {
        window.location.href = "<%=basePath%>servlet?dno=" + dno + "&key=delete";
    }

    /*修改*/
    function change(dno) {
        var value = prompt("输入新的留言内容:");
        if (value === "") {
            alert("新信息不能为空!")
        } else {
            window.location.href = "<%=basePath%>servlet?dno=" + dno + "&key=update&message=" + value;
        }
    }

    /*查询全部留言  */
    function readAllDialog() {
        window.location.href = "<%=basePath%>servlet?key=readAllDialog";
    }

    /* 全选 */
    function cli(Obj) {
        var collid = document.getElementById("all")
        var coll = document.getElementsByName(Obj)
        if (collid.checked) {
            for (var i = 1; i < coll.length; i++)
                coll[i].checked = true;
        } else {
            for (i = 1; i < coll.length; i++)
                coll[i].checked = false;
        }
    }

    function deleAll(Obj) {
        var check = document.getElementsByName(Obj);
        var len = check.length;
        var idAll = ""
        for (var i = 1; i < len; i++) {
            if (check[i].checked) {
                idAll[i] = check[i].value;
                idAll = idAll + check[i].value + ",";
            }
        }
        window.location.href = "<%=basePath%>servlet?idAll=" + idAll + "&key=deleteAll";
    }


    /*查询本人留言 */
    function readMine(No) {
        window.location.href = "<%=basePath%>servlet?key=readMine&no=" + No;
    }

    /*返回  */
    function back() {
        window.location.href = "<%=basePath%>servlet?key=back";
    }

    var theTable = document.getElementById("blocks");
    var totalPage = document.getElementById("spanTotalPage");
    var pageNum = document.getElementById("spanPageNum");


    var spanPre = document.getElementById("spanPre");
    var spanNext = document.getElementById("spanNext");
    var spanFirst = document.getElementById("spanFirst");
    var spanLast = document.getElementById("spanLast");


    var numberRowsInTable = theTable.rows.length - 1;
    var pageSize = 5;
    var page = 1;


    //下一页
    function next() {
        hideTable();
        currentRow = pageSize * page;
        maxRow = currentRow + pageSize;
        if (maxRow > numberRowsInTable) maxRow = numberRowsInTable;
        for (var i = currentRow; i < maxRow; i++) {
            theTable.rows[i].style.display = '';
        }
        page++;
        if (maxRow === numberRowsInTable) {
            nextText();
            lastText();
        }
        showPage();
        preLink();
        firstLink();
    }


    //上一页
    function pre() {
        hideTable();
        page--;
        currentRow = pageSize * page;
        maxRow = currentRow - pageSize;
        if (currentRow > numberRowsInTable) currentRow = numberRowsInTable;
        for (var i = maxRow; i < currentRow; i++) {
            theTable.rows[i].style.display = '';
        }
        if (maxRow === 0) {
            preText();
            firstText();
        }
        showPage();
        nextLink();
        lastLink();
    }

    //第一页
    function first() {
        hideTable();
        page = 1;
        for (var i = 0; i < pageSize; i++) {
            theTable.rows[i].style.display = '';
        }
        showPage();
        preText();
        nextLink();
        lastLink();
    }


    //最后一页
    function last() {
        hideTable();
        page = pageCount();
        currentRow = pageSize * (page - 1);
        for (var i = currentRow; i < numberRowsInTable; i++) {
            theTable.rows[i].style.display = '';
        }
        showPage();
        preLink();
        nextText();
        firstLink();
    }

    function hideTable() {
        for (var i = 0; i < numberRowsInTable; i++) {
            theTable.rows[i].style.display = 'none';
        }
    }

    function showPage() {
        pageNum.innerHTML = page;
    }

    //总共页数
    function pageCount() {
        var count = 0;
        if (numberRowsInTable % pageSize !== 0) count = 1;
        return parseInt(numberRowsInTable / pageSize) + count;
    }

    //显示链接
    function preLink() {
        spanPre.innerHTML = "<a href='javascript:pre();'>上一页</a>";
    }

    function preText() {
        spanPre.innerHTML = "上一页";
    }

    function nextLink() {
        spanNext.innerHTML = "<a href='javascript:next();'>下一页</a>";
    }

    function nextText() {
        spanNext.innerHTML = "下一页";
    }

    function firstLink() {
        spanFirst.innerHTML = "<a href='javascript:first();'>首页</a>";
    }

    function firstText() {
        spanFirst.innerHTML = "首页";
    }

    function lastLink() {
        spanLast.innerHTML = "<a href='javascript:last();'>尾页</a>";
    }

    function lastText() {
        spanLast.innerHTML = "尾页";
    }


    //隐藏表格
    function hide() {
        for (var i = pageSize; i < numberRowsInTable; i++) {
            theTable.rows[i].style.display = 'none';
        }
        totalPage.innerHTML = pageCount();
        pageNum.innerHTML = '1';
        nextLink();
        lastLink();
    }

    hide();
</script>
</body>
</html>

