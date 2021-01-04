<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/6/24
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.NGU.Moduel.Advice" %>
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
<h1 align="center">这个是反馈的结果页面</h1>
<%
    ArrayList list = (ArrayList) session.getAttribute("list_advice");
    ArrayList list_login = (ArrayList) session.getAttribute("list_login");
    User user = (User) list_login.get(0);
    int No = user.getNo();
%>
<table width="70%" border="0" cellpadding="0" cellspacing="1" align="center">
    <tr height="50px">
        <td bgcolor="d3eaef" align="center" width="105px">
            <input type="checkbox" name="boxname" id="all" onclick="cli('boxname')" value="checkbox"/>
        </td>
        <td bgcolor="d3eaef" align="center" width="10%">反馈编号</td>
        <td bgcolor="d3eaef" align="center" width="10%">员工编号</td>
        <td bgcolor="d3eaef" align="center" width="10%">员工姓名</td>
        <td bgcolor="d3eaef" align="center" width="10%">员工电话</td>
        <td bgcolor="d3eaef" align="center" width="40%">反馈内容</td>
        <td bgcolor="d3eaef" align="center" width="10%">删除</td>
    </tr>
</table>
<table width="70%" border="0" cellpadding="0" cellspacing="1" id="blocks" align="center">
    <%
        for (int i = 0; i < list.size(); i++) {
            Advice advice = (Advice) list.get(i);
    %>
    <tr>
        <td bgcolor="#EED8AE" align="center">
            <input type="checkbox" name="boxname" value="<%=advice.getSno()%>"/>
        </td>
        <td bgcolor="#EED8AE" align="center" width="10%"><%=advice.getSno() %>
        </td>
        <td bgcolor="#EED8AE" align="center" width="10%"><%=advice.getNo() %>
        </td>
        <td bgcolor="#EED8AE" align="center" width="10%"><%=advice.getName() %>
        </td>
        <td bgcolor="#EED8AE" align="center" width="10%"><%=advice.getTele() %>
        </td>
        <td bgcolor="#EED8AE" width="40%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=advice.getMessage() %>
        </td>
        <td bgcolor="#EED8AE" align="center" width="10%">
            <a href="servlet?Sno=<%=advice.getSno()%>&key=deleteAdvice">删除
            </a>
        </td>
    </tr>
    <%} %>
    <tr>
        <td>
            <center>
                <input type="submit" value="批量删除" onclick="deleAll('boxname')" class="btn">
            </center>
        </td>
        <td colspan="4">
        </td>
        <td colspan="1">
            <center>
                <label for="readByno" style="margin-right: 5%;font-size: 20px">编号:</label>
                <input type="text" value="" size="5" id="readByno" style="width: 200px;height: 30px;margin-right: 5%"
                       placeholder="请输入员工编号">
                <input type="submit" value="查询" onclick=" readByNo()" class="btn">
            </center>
        </td>
        <td>
            <input type="submit" value="查询全部" onclick="readAllAdvice()" class="btn">
        </td>
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

    /*查询全部留言  */
    function readAllAdvice() {
        window.location.href = "<%=basePath%>servlet?key=readAllAdvice";
    }

    /* 全选 */
    function cli(Obj) {
        var collid = document.getElementById("all")
        var coll = document.getElementsByName(Obj)
        if (collid.checked) {
            for (var i = 1; i < coll.length; i++)
                coll[i].checked = true;
        } else {
            for (var i = 1; i < coll.length; i++)
                coll[i].checked = false;
        }
    }

    /*批量删除  */
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
        window.location.href = "<%=basePath%>servlet?idAll=" + idAll + "&key=deleteAllAdvice";
    }


    /*校验是否全由数字组成 */
    function isNo(str) {
        var reg = /^[0-9]*$/;   /*定义验证表达式*/
        return reg.test(str);     /*进行验证*/
    }

    /*按员工编号查询留言  */
    function readByNo() {
        var no = document.getElementById("readByno").value;
        if (no == "") {
            alert("员工编号不能为空!\n请先在你点击查询按钮时先输入员工编号！");
        } else {
            if (isNo(no) === true) {
                window.location.href = "<%=basePath%>servlet?key=readByNoAdvice&no=" + no;
            } else {
                alert("请输入数字!\n员工编号是由数字组成的！");
            }
        }
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
        if (maxRow == numberRowsInTable) {
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
        if (maxRow == 0) {
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
        if (numberRowsInTable % pageSize != 0) count = 1;
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

