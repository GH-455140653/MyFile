<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/6/24
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.NGU.Moduel.Person" %>
<%@page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>员工信息管理</title>
    <style>
        body {
            background-color: #F8F8FF;
        }

        .btn {
            font-size: 20px;
            padding: 10px;
        }
    </style>
    <script>
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

        /*批量删除  */
        function deleAll(Obj) {
            var check = document.getElementsByName(Obj);
            var len = check.length;
            var noAll = ""
            for (var i = 1; i < len; i++) {
                if (check[i].checked) {
                    noAll[i] = check[i].value;
                    noAll = noAll + check[i].value + ",";
                }
            }
            if(noAll===""){
                alert("请先进行选择");
            }else{
                window.location.href = "<%=basePath %>servlet?key=deletePerson&noAll=" + noAll;
            }
        }

        /*校验是否全由数字组成 */
        function isNo(str) {
            var reg = /^[0-9]*$/;   /*定义验证表达式*/
            return reg.test(str);     /*进行验证*/
        }

        /*校验输入内容为中英文*/
        function isName(str) {
            var reg = /^[a-zA-Z\u4e00-\u9fa5]+$/;
            return reg.test(str);
        }

        /*修改*/
        function change(no) {
            var v;
            var t = prompt("请输入你要修改的员工信息:");
            if (t === "员工姓名" || t === "所在部门" || t === "年龄" || t === "性别" || t === "电话" || t === "底薪") {
                var value = prompt("输入新的信息:");
                if (value !== "") {
                    if (t === "员工姓名") {
                        if (!isName(value)) {
                            alert("员工姓名填写不合法！");
                        } else {
                            v = "Pname";
                        }
                    } else if (t === "所在部门") {
                        if (value === "销售部" || value === "技术部" || value === "财务部" || value === "后勤部" || value === "人力资源部") {
                            v = "Pdept";
                        } else {
                            alert("输入不合法！");
                        }

                    } else if (t === "年龄") {
                        if (!isNo(value)) {
                            alert("年龄只能输入数字");
                        } else if (!(value >= 18 && value <= 65)) {
                            alert("员工年龄只能在18-65岁之间");
                        } else {
                            v = "Page";
                        }
                    } else if (t === "性别") {
                        if (value === "男" || value === "女") {
                            v = "Psex";
                        } else {
                            alert("性别输入不合法");
                        }

                    } else if (t === "电话") {
                        if (!isNo(value)) {
                            alert("电话只能输入数字");
                        } else if (value.length !== 11) {
                            alert("电话号码长度不正确");
                        } else {
                            v = "Ptele";
                        }
                    } else if (t === "底薪") {
                        if (!isNo(value)) {
                            alert("底薪只能输入数字");
                        } else {
                            v = "Psalary";
                        }
                    }
                    window.location.href = "<%=basePath %>servlet?key=updatePerson&type=" + v + "&value=" + value + "&no=" + no;
                } else {
                    alert("新信息不能为空!")
                }
            } else {
                alert("不能为空或输入有误");
            }
        }

        /*上一页*/
        function uppage(index) {
            if (index === 0) {
                alert("已经是第一页");
            } else {
                index = parseInt(index - 5);
                window.location.href = "<%=basePath %>NGU/Person.jsp?index=" + index;
            }
        }

        /*下一页*/
        function downpage(index, len) {
            if (index + 4 >= len) {
                alert("已经是最后一页！");
            } else {
                index = parseInt(index + 5);
                window.location.href = "<%=basePath %>NGU/Person.jsp?index=" + index;
            }
        }

        /*查询员工信息*/
        function searchInfo(){
            var text=document.getElementById("searchInfo").value;
            var obj=document.getElementById("selectDept");
            for(i=0;i<obj.length;i++) {//下拉框的长度就是它的选项数.

                if(obj[i].selected===true) {

                    var select=obj[i].value;//获取当前选择项的值.　　
                }
            }
            var regPos = /^\d+(\.\d+)?$/; //非负浮点数
            var regNeg = /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/; //负浮点数
            if(regPos.test(text) || regNeg.test(text)){
                if(text!=null && select!=="按所在部门查询"){
                    window.location.href="<%=basePath %>servlet?key=searchPerson&no="+text+"&dept="+select;
                }else{
                    alert("输入查询条件不完整!");
                }
            }else{
                alert("员工编号未输入或输入内容不合法！");
            }
        }

        function toMain() {
            window.location.href = "<%=basePath %>NGU/admin.jsp";
        }

        function searchAll() {
            window.location.href = "<%=basePath %>NGU/Person.jsp";
        }
    </script>
</head>
<body>
<center style="font-size: 20px;margin-bottom: 2%">
    <h1>员工个人信息表</h1>
    <fieldset style="width: 40%">
        <span class="input1" style="text-align: center">
            <label for="searchInfo">请输入你需要查询的员工编号:</label>
            <input type="text" name="searchInfo" id="searchInfo" value="">
        </span>

        <span class="select1">
        <select id="selectDept" name="selectDept">
            <option selected="selected" value="按所在部门查询">按所在部门查询</option>
            <option value="销售部">销售部</option>
            <option value="后勤部">宣传部</option>
            <option value="财务部">财务部</option>
            <option value="技术部">技术部</option>
            <option value="人力资源部">人力资源部</option>
        </select>
    </span>
        <span class="button1">
        <button type="button" onclick="searchInfo()" class="btn">查询</button>
    </span>
        <form action="servlet" method="post">
            <input type="hidden" name="key" value="personInfo">
            <input type="submit" value="查询全部" class="btn">
            <input type="button" value="删除" onclick="deleAll('boxname')" class="btn">
            <input type="button" value="返回主界面" onclick="toMain()" class="btn">
        </form>

    </fieldset>
</center>
<!-- 分页  -->
<%
    ArrayList list = (ArrayList) session.getAttribute("personlist");
    int index = 0;
    if (!"".equals((String) request.getParameter("index"))) {
        index = Integer.parseInt((String) request.getParameter("index"));
    }
    int end = 0;
    int len = 0;
    if (!list.equals(null)) {
        if (index + 4 >= list.size() - 1) {
            end = list.size() - 1;
        } else {
            end = index + 4;
        }
        len = list.size() - 1;
    }
%>

<table width="70%" border="1" cellpadding="0" cellspacing="1" align="center">
    <tr height="50px" bgcolor="#ffe4c4">
        <td align="center" width="5%">
            <input type="checkbox" name="boxname" id="all" onclick="cli('boxname')" value="checkbox"/>
        </td>
        <td align="center">员工编号</td>
        <td align="center">员工姓名</td>
        <td align="center">所在部门</td>
        <td align="center">年龄</td>
        <td align="center">性别</td>
        <td align="center">电话</td>
        <td align="center">底薪</td>
        <td align="center">修改</td>
    </tr>

    <%
        for (int i = index; i <= end; i++) {
            Person pers = (Person) list.get(i);
    %>
    <tr>
        <td bgcolor="d3eaef" align="center"><input type="checkbox" name="boxname" value="<%=pers.getNo() %>"/></td>
        <td bgcolor="d3eaef" align="center"><%=pers.getNo() %>
        </td>
        <td bgcolor="d3eaef" align="center"><%=pers.getName() %>
        </td>
        <td bgcolor="d3eaef" align="center"><%=pers.getDept() %>
        </td>
        <td bgcolor="d3eaef" align="center"><%=pers.getAge() %>
        </td>
        <td bgcolor="d3eaef" align="center"><%=pers.getSex() %>
        </td>
        <td bgcolor="d3eaef" align="center"><%=pers.getTele() %>
        </td>
        <td bgcolor="d3eaef" align="center"><%=pers.getSalary() %>
        </td>
        <td bgcolor="d3eaef" align="center">
            <input type="button" value="修改" onclick="change(<%=pers.getNo() %>)">
        </td>
    </tr>
    <%} %>
</table>
<div style="margin-top: 2%;text-align: center;">
    <input type="button" value="上一页" onclick="uppage(<%=index%>)" class="btn">
    <input type="button" value="下一页" onclick="downpage(<%=index %>,<%=len%>)" class="btn">
</div>

</body>
</html>
