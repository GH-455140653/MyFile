<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/5/19
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="handle.jsp" method="post">
    <table>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>
                <input type="radio" name="sex" value="男" class="sex">男
                <input type="radio" name="sex" value="女" class="sex">女
            </td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input type="text" name="age" id="age"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td>密码确认:</td>
            <td><input type="password" name="password_sure" id="pwd"></td>
        </tr>
        <tr>
            <td>爱好:</td>
            <td>
                <input type="checkbox" name="hobby" value="篮球" class="checked">篮球
                <input type="checkbox" name="hobby" value="足球" class="checked">足球
                <input type="checkbox" name="hobby" value="音乐" class="checked">音乐
            </td>
        </tr>
        <tr>
            <td>所在省份：</td>
            <td>
                <select name="province" id="selectBox">
                    <option value="null" disabled selected="selected">请选择你身在的省份</option>
                    <option value="广东">广东</option>
                    <option value="黑龙江">黑龙江</option>
                    <option value="吉林">吉林</option>
                    <option value="辽宁">辽宁</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="注册" id="sub">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
