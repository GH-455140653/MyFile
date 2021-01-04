<%@ page import="com.NGU.Moduel.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/6/26
  Time: 2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>管理员管理界面</title>
    <link rel="stylesheet" href="NGU/css/adminCenter.css">
</head>
<!--显示当前时间-->
<script type="text/javascript">
    function showTime() {/*文字时钟*/
        var now = new Date();
        var y = now.getFullYear();
        var m = now.getMonth() + 1;
        var d = now.getDate();
        var h = now.getHours();
        var mi = now.getMinutes();
        if (mi < 10) {
            mi = "0" + mi;
        }
        var s = now.getSeconds();
        var str = y + "年" + m + "月" + d + "日 " + h + ":" + mi + ":" + s;
        var timeBox = document.getElementsByClassName("showtime");
        for (var i = 0; i < timeBox.length; i++) {
            timeBox[i].innerHTML = str;
        }
        setTimeout('showTime()', 1000);
    }
</script>
<body onload="showTime()">
<%
    ArrayList list = (ArrayList) session.getAttribute("list_login");
    User user = (User) list.get(0);
    ArrayList list_no = (ArrayList) session.getAttribute("list_no");
%>
<div class="subject" id="subject">
    <!--左边列表-->
    <div class="left">
        <br>
        <h2 align="center">
            <a href="javascript:void(0)" id="r0">NGU人事工资管理系统</a>
        </h2>
        <br>
        <p class="p0">
            员工：<span><%=user.getName()%></span>
        </p>
        <p class="p0">
            <b>管理员</b>
        </p>
        <p class="p0">
            <a href="<%=basePath%>NGU/index.jsp" style="color: #ff4400"><u>退出登录</u></a>
        </p>
        <br>

        <h3>&nbsp;&nbsp;&nbsp;人事管理</h3>
        <p class="p1">
            <a href="javascript:void(0)" id="r1">员工信息管理</a>
        </p>
        <p class="p1">
            <a href="javascript:void(0)" id="r2">员工添加</a>
        </p>
        <br>

        <h3>&nbsp;&nbsp;&nbsp;工资管理</h3>
        <p class="p1">
            <a href="javascript:void(0)" id="g1">查询工资信息</a>
        </p>
        <br>

        <h3>&nbsp;&nbsp;&nbsp;考勤管理</h3>
        <p class="p1">
            <a href="javascript:void(0)" id="k1">查询考勤信息</a>
        </p>
        <br>

        <h3>&nbsp;&nbsp;&nbsp;留言系统</h3>
        <p class="p1">
            <a href="javascript:void(0)" id="l1">留言系统管理</a>
        </p>
        <p class="p1">
            <a href="javascript:void(0)" id="l2">发布公告</a>
        </p>
        <br>

        <h3>&nbsp;&nbsp;&nbsp;个人中心</h3>
        <p class="p1">
            <a href="javascript:void(0)" id="ge1">修改密码</a>
        </p>
        <br>

        <h3>&nbsp;&nbsp;&nbsp;用户意见</h3>
        <p class="p1">
            <a href="javascript:void(0)" id="suggestion">查看意见</a>
        </p>
        <br>
    </div>

    <!--系统简介-->
    <div class="introduce" id="right0">
        <center>
            <h1>欢迎使用NGU人事工资管理系统</h1>
            <br><br>
            <font class="font" color="#2E04BB" size="+3">
                <div class="showtime"></div>
            </font>
            <br><br>
            <fieldset>
                人事工资管理系统是企业单位不可缺少的部分，
                它能够为用户提供充足的信息和的快速的查询方法，所以人事工资管理系统对于众业的用户和管理者来说都是至关重要的。
                人事工资管理系统是企业管理的必备软件，人事管理系统界面设计简朴，具有用户和管理员需要的基本图形化界面元素，
                使不同用户不需要培训，就可以快速掌握该系统的使用方法，极易上手。
            </fieldset>
        </center>
    </div>

    <!--员工信息管理操作界面-->
    <div class="right1" id="right1">
        <h1 style="margin-top: 6%" align="center">欢迎使用员工信息管理系统</h1><br>
        <font size="+3" color="#2E04BB">
            <div class="showtime" align="center"></div>
        </font><br><br>
        <center>
            <fieldset>
                <legend>员工信息系统</legend>
                <p>该子系统是本系统的关键，是对所用员工个人信息进行操作的地方</p>
            </fieldset>
            <form action="servlet" method="post">
                <input type="hidden" name="key" value="personInfo">
                <input type="submit" value="进入员工信息管理系统">
            </form>
        </center>
    </div>

    <!--添加员工操作界面-->
    <script>

        /*校验是否全由数字组成 */
        function isNo(str) {
            var reg = /^[0-9]*$/;   /*定义验证表达式*/
            return reg.test(str);     /*进行验证*/
        }

        function noChange() {
            var list_no = <%=list_no%>;
            var no = document.getElementById("pno");
            for (var i = 0; i < list_no.length; i++) {
                if (parseInt(no.value) === list_no[i]) {
                    no.value = "";
                    alert("该员工编号已经存在！\n请重新输入！");
                    break;
                }
            }
        }

        /*添加员工*/
        function insertP() {
            var no = document.getElementById("pno");
            var name = document.getElementById("pname");
            var age = document.getElementById("page");
            var salary = document.getElementById("psalary");
            var tel = document.getElementById("ptel");
            var deptSelect = document.getElementById("selectD");
            var sexSelect = document.getElementById("selectSex");
            index=deptSelect.selectedIndex;
            if (no.value === "") {
                no.focus();
                alert("员工编号未填写！");
            } else if (!isNo(no.value)) {
                no.select();
                alert("员工编号只能输入数字！")
            } else if (name.value === "") {
                name.focus();
                alert("员工姓名未填写！");
            } else if (age.value === "") {
                age.focus();
                alert("员工年龄未填写！")
            } else if (!isNo(age.value)) {
                age.select();
                alert("员工年龄只能输入数字！")
            } else if (!(age.value >= 18 && age.value <= 65)) {
                age.select();
                alert("员工年龄只能是18-65岁的法定工作年龄！")
            } else if (salary.value === "") {
                salary.focus();
                alert("员工底薪未填写！")
            } else if (!isNo(salary.value)) {
                salary.select();
                alert("底薪只能输入数字！")
            } else if (tel.value === "") {
                tel.focus();
                alert("员工联系电话未填写！")
            } else if (tel.value.length !== 11) {
                alert("手机号应该输入11位数字！")
                tel.select();
            } else if (sexSelect.selectedIndex === 0) {
                alert("员工性别未填写")
            } else if (index === 0) {
                alert("请选择你的部门！")
            } else {
                alert("添加成功！");
                window.location.href = "<%=basePath %>servlet?key=insertPerson&pno=" + no.value + "&pname=" + name.value + "&page=" + age.value + "&psalary=" + salary.value + "&ptel=" + tel.value + "&selectD=" + deptSelect[deptSelect.selectedIndex].value + "&selectSex=" + sexSelect[sexSelect.selectedIndex].value;
            }
        }
    </script>
    <div class="right2" id="right2">
        <div class="form2">
            <center>
                <h1 style="margin-top: 6%">新员工个人信息添加</h1><br>
                <font size="+3" color="#2E04BB">
                    <div class="showtime" align="center"></div>
                </font><br><br>
                <fieldset>
                    <legend>员工信息输入单</legend>
                    <form action="" method="post">
                        员工编号： <input type="text" name="pno" id="pno" value="" onchange="noChange()"><br>
                        <br> 员工姓名： <input type="text" name="pname" id="pname" value=""><br>
                        <br> 所在部门： <select class="select2" name="selectD" id="selectD" style="margin-right: 55px">
                        <option value="请选择你的部门">请选择你的部门</option>
                        <option value="销售部">销售部</option>
                        <option value="后勤部">宣传部</option>
                        <option value="财务部">财务部</option>
                        <option value="技术部">技术部</option>
                        <option value="人力资源部">人力资源部</option>
                    </select><br>
                        <br> 年&emsp;&emsp;龄： <input type="text" name="page" id="page" value=""><br>
                        <br> 性&emsp;&emsp;别： <select class="select2" name="selectSex" id="selectSex"
                                                     style="margin-right: 110px">
                        <option value="请选择">请选择</option>
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select><br>
                        <br> 底&emsp;&emsp;薪： <input type="text" name="psalary" id="psalary" value=""><br>
                        <br> 电&emsp;&emsp;话： <input type="text" name="ptel" id="ptel" value=""><br>
                        <br>
                        <br>
                        <span>
                    <button type="button" value="" class="btn" onclick="insertP()"
                            style="margin: 0 0 20px 25px">确认</button>
                    <input type="reset" class="btn" style="margin-left: 25px">
                </span>
                    </form>
                </fieldset>
            </center>
        </div>
    </div>

    <!--工资管理操作界面-->
    <div id="searchwage" class="searchwage">
        <h1 style="margin-top: 10%" align="center">您好，<%=user.getName()%>管理员</h1><br>
        <font size="+3" color="#2E04BB">
            <div class="showtime" align="center"></div>
        </font><br><br>
        <center>
            <fieldset>
                <legend>工资管理系统</legend>
                <p align="center">欢迎进入工资管理模块</p>
                <p>该模块中您可以查看所有员工的工资信息</p>
                <p>请点击按钮进入模块</p>
            </fieldset>
            <form action="servlet" method="post">
                <input type="hidden" name="key" value="searchwage">
                <input type="submit" value="进入工资管理系统">
            </form>
        </center>
    </div>

    <!--考勤管理操作界面-->
    <div id="searchkdao" class="searchkdao">
        <center>
            <h1 style="margin-top: 10%">您好，<%=user.getName()%>管理员</h1><br>
            <font size="+3" color="#2E04BB">
                <div class="showtime" align="center"></div>
            </font><br><br>
            <fieldset>
                <legend><b>考勤系统简介</b></legend>
                <p>欢迎进入考勤管理模块</p>
                <p>该模块中您可以查看所有员工的考勤信息以及修改某位员工某天的签到状态</p>
                <p>请点击按钮进入模块</p>
            </fieldset>
            <form action="servlet" method="post">
                <input type="hidden" name="key" value="searchsign">
                <input type="submit" value="点击查看考勤信息">
            </form>
        </center>
    </div>

    <!--留言信息操作界面-->
    <div class="mymsg" id="mymsg">
        <center>
            <h1>欢迎使用NGU留言功能</h1><br>
            <font class="font" color="#2E04BB" size="+3">
                <div class="showtime"></div>
            </font><br><br>
            <fieldset>
                <legend><b>留言系统简介</b></legend>
                <p>
                    留言板 在网络中用户的交流起着重要的作用，每个人都可以将自己所需要的信息和要求保存在页面上，供他人查看。
                    留言板上为其他网友给自己留言，或暂存自己的感受 。留言操作比较简单，进入任何留言板或社区都可以看到有输入框，输入后提交。
                    留言板提供了完整的信息发布功能，对网络用户的通信也有很大的影响。 而我这个留言板只是一个简单的留言板和管理员进行设置和回复、删除、管理的工具。
                    本留言板简单实用，具有留言板最基本的功能。非常适合中小型网站使用。
                </p>
            </fieldset>
            <form action="servlet" method="post">
                <input type="hidden" name="key" value="Dialog">
                <input type="submit" value="进入留言管理系统">
            </form>
        </center>
    </div>


    <script>/*留言发布操作界面 js判断*/
    function upNewMessage() {
        function $(id) {
            return document.getElementById(id);
        }

        var message = $("upNew");
        if (message.value === "") {
            alert("发布信息不能为空");
            message.focus()
            return false;
        } else {
            if (message.value.length > 50) {
                alert("字数过多,请控制在50个字符内!");
                return false;
            } else
                alert("公告发布成功！\n即将跳转留言查询页面！")
            return true;
        }
    }
    </script>
    <!--留言发布操作界面-->
    <div class="writemsg" id="writemsg">
        <center>
            <form action="servlet" method="post" class="form_dialog" onsubmit="return upNewMessage()">
                <input type="hidden" name="key" value="upNew">
                <input type="hidden" name="userDialog" value="<%=user.getNo() %>">
                <p><font size="+3">公告内容</font></p><br>
                <textarea id="upNew" name="Message" rows="15" cols="60" placeholder="请输入你需要留下的内容"
                          maxlength="50"></textarea><br><br>
                <input style="width:200px;height:50px;" type="submit" value="发布">
            </form>
        </center>
    </div>

    <!--查询意见-->
    <div id="suggest">
        <center>
            <h1 style="margin-top: 5%">欢迎使用NGU用户意见反馈系统</h1><br>
            <font class="font" color="#2E04BB" size="+3">
                <div class="showtime"></div>
            </font><br><br>
            <fieldset>
                <legend>留言系统</legend>
                <p>该系统是用户发现系统问题并对系统管理反馈系统意见的一个途径</p>
                <p>留言系统可以查看用户通过文件传输和文本传输形式传送的文本</p>
                <p>系统管理可以通过该系统获取并得知用户所遇到的问题并解决</p>
            </fieldset>
            <form action="servlet" method="post">
                <input type="hidden" name="key" value="readAdvice">
                <input type="hidden" name="userAdvice" value="<%=user.getNo() %>">
                <input style="width:200px;height:50px;" type="submit" value="进入反馈系统">
            </form>
        </center>
    </div>

    <!--修改密码操作界面-->
    <script>/*输入框判断空值*/
    function submitCheck() {
        function $(id) {
            return document.getElementById(id);
        }

        var password = $('password_modify');
        var psw = $('psw_modify');
        var psw_sure = $('psw_sure_modify');

        if (password.value === "" || psw.value === ""
            || psw_sure.value === "") {
            alert("请完整输入需要填写的内容！");
            if (password.value === "") {
                password.focus();
            } else if (psw.value === "") {
                psw.focus();
            } else {
                psw_sure.focus();
            }
            return false;
        } else {
            if ((parseInt(password.value)) !==
                <%=user.getPassword()%>
            ) {
                alert("原始密码输入错误！\n请重新输入！！！");
                password.value = "";
                psw.value = "";
                psw_sure.value = "";
                return false;
            } else if (psw.value !== psw_sure.value) {
                alert("两次密码输入不一致！\n请重新输入！！！")
                psw.value = "";
                psw_sure.value = "";
                return false;
            } else {
                return true;
            }
        }
    }

    function formReset() {
        var password = $('password_modify');
        password.focus();
        return true;
    }
    </script>
    <div class="psw_Aupdate" id="psw_Aupdate">
        <form id="form_pswUpdate" action="servlet" method="post" onsubmit="return submitCheck()"
              onreset="return formReset()">
            <center>
                <input type="hidden" name="key" value="UserPasswordUpdate">
                <h2>修改登录密码</h2><br><br>
                账号 :&emsp;&emsp;&emsp;<input type="text" name="name" id="name_modify" value="<%=user.getNo()%>"
                                             readonly><br><br>
                原密码 :&emsp;&emsp;<input type="password" name="password" id="password_modify"
                                        placeholder="请输入原始密码"><br><br>
                新密码 :&emsp;&emsp;<input type="password" name="psw" id="psw_modify" placeholder="请输入新密码"><br><br>
                确认密码 :&emsp;<input type="password" name="psw_sure" id="psw_sure_modify"
                                   placeholder="请再次输入修改后的密码"><br><br>
                <input type="submit" class="btn" value="确认" style="margin-right: 20px">
                <input type="reset" value="重置" class="btn" style="margin-left: 20px;">
            </center>
        </form>
    </div>

</div>
<hr>
<div class="page_bottom">
    <center>
        <p>该网站最终解释权归作者所有，本网站仅用于学习开发，不得用于商业用途。</p>
        <p>Copyright&copy; 2020-2021 NGU(the team of Never Give Up)</p>
        <p>All rights reserved</p>
    </center>
</div>
<script type="text/javascript" src="NGU/js/admin_click.js"></script>
</body>
</html>
