<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="<%=basePath%>NGU/css/login.css">
</head>
<body>
<%
    String no = "";
    String message = request.getParameter("msg");
    if (message != null) {
        if (message.equals("flag")) {
            no = request.getParameter("no");
%>
<script>alert("密码修改成功！\n请重新登录！")</script>
<script>var checkSelect =<%=request.getParameter("authority")%>;</script>
<%} else if (message.equals("error")) {%>
<script>alert("账号或密码错误\n请重新登录！")</script>
<%
        }
    }
%>
<h1>NGU人事工资管理系统</h1>
<div align="center">
    <div id="img"><img src="<%=basePath%>NGU/images/login.png" alt=""></div>
    <fieldset>
        <legend>登录 | LOGIN</legend>
        <form id="form_login" method="post" action="servlet" onsubmit="return formSubmit()">
            <input type="hidden" name="key" value="login">
            账号：<input id="account" type="text" name="name" placeholder="请输入账号"
                      value="<%if (message!=null){out.write(no);}%>">
            <p></p>
            密码：<input id="password" type="password" name="password" placeholder="请输入密码">
            <p></p>
            权限：<input type="radio" class="radio" name="authority" value="1" id="admin">管理员
            <input type="radio" class="radio" name="authority" value="0" id="user">普通用户
            <p></p>
            验证码：<input id="number" type="text" name="verify">
            <div id="verifyNum">点我验证</div>
            <p></p><!--拼接后的验证码-->
            <input type="submit" class="btn" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" class="btn" value="重置">
        </form>
    </fieldset>
</div>

<%--表单判空--%>
<script>
    function formSubmit() {
        var account = document.getElementById("account");
        var password = document.getElementById("password")
        var radio = document.getElementsByClassName("radio");
        var num = document.getElementById("number");
        var code = document.getElementById("verifyNum");

        /*校验是否全由数字组成 */
        function isNo(str) {
            var reg = /^[0-9]*$/;   /*定义验证表达式*/
            return reg.test(str);     /*进行验证*/
        }

        //验证码验证
        if (num.value !== code.innerHTML) {
            // alert(typeof (code.innerText));
            if (code.innerText === "点我验证") {
                alert("请点击验证码（点我验证）")
            } else {
                alert("验证码输入错误");
                num.select();
            }
            return false;
        } else {
            if (account.value === "" || password.value === "" || num.value === "" || (radio[0].checked === false && radio[1].checked === false)) {
                alert("请完整填写表单内容！")
                if (account.value === "") {
                    account.focus();
                } else if (password.value === "") {
                    password.focus();
                } else if (num.value === "") {
                    num.focus()
                } else {
                    alert("请选择你的身份！");
                }
                return false
            } else {
                if (isNo(account.value) === true) {
                    return true;
                } else {
                    alert("账号只能输入数字！")
                    account.select();
                    return false;
                }
            }
        }
    }
</script>
<%--验证码生成--%>
<script>
    var code_box = document.getElementById("verifyNum");

    function refreshCode() {
        var code = '0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM',//62个字符 随机选择4位
            char = '',
            result = '';
        for (var i = 0; i < 4; i++) {
            //随机选择一位  （0,61） 写出0到61的随机的索引数字
            var code_index = Math.round(Math.random() * 61);
            //得到随机的索引  取出随机地字符
            char = code[code_index];
            //随机取出的字符 存在几个相同重复的问题 ，而且对于字母，不能区分大小写。
            // 避免重复的思路是：取出字符之后,和最后的result对比一下，看看里边是不是已经存在了，如果存在本次循环就终止，进行下一次
            if (result.toUpperCase().indexOf(char.toUpperCase()) > -1)
                //indexOf() == -1 说明结果里边没有要找的字符 那么 > -1 就是 里边有重复的字符
            {
                i--;
                //为什么会 --？ 因为如果条件成立，那么本轮循环就结束进行下一轮循环（自然i就加1了），那么本轮本应该取出的字符就没有了
                //到最后会少一个字符 缺席
                continue;//终止本轮循环 进行下一轮
            }
            result += char;
        }
        code_box.innerHTML = result;
        // document.getElementById("number").value = result;
    }

    //点击事件
    code_box.onclick = refreshCode;
</script>
<%--单选选中--%>
<script>
    if (checkSelect === 1) {
        document.getElementById("admin").checked = true;
    } else {
        document.getElementById("user").checked = true;
    }
</script>

</body>
</html>