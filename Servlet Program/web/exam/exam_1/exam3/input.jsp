<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/5/22
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<style>
    .btn {
        height: 30px;
        width: 60px;
        margin: 10px 0 0 30px;
    }
</style>
<body>
<div style="text-align: center;margin: 20%">
    <form action="handle.jsp" method="post" onsubmit="return judge()">
        账号：<input type="text" name="name" id="account"><br>
        密码：<input type="password" name="pwd" id="password"><br>
        <input type="submit" value="登陆" class="btn">
        <input type="reset" value="清空" class="btn" onclick="resetion()" style="margin-left: 20px">
    </form>
    <script>
        function resetion() {
            alert("清除成功！")
        }

        function judge() {
            var username = document.getElementById("account").value;
            var pwd = document.getElementById("password").value;
            if (username === "") {
                alert("账号不能为空！");
                return false;
            } else if (pwd === "") {
                alert("密码不能为空！");
                return false;
            } else {
                alert("登陆成功！")
                return true;
            }
        }
    </script>
</div>

</body>
</html>
