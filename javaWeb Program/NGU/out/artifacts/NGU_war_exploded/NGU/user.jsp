<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/6/26
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.NGU.Moduel.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>用户管理界面</title>
    <link rel="stylesheet" href="<%=basePath%>NGU/css/userCenter.css">
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
        // alert(document.getElementsByClassName("showtime").innerHTML);
        var timeBox = document.getElementsByClassName("showtime");
        for (var i = 0; i < timeBox.length; i++) {
            timeBox[i].innerHTML = str;
        }
        setTimeout('showTime()', 1000);
    }
</script>
<body onLoad="showTime()">
<%
    ArrayList list = (ArrayList) session.getAttribute("list_login");
    User user = (User) list.get(0);
    int Statues = Integer.parseInt(String.valueOf(session.getAttribute("statues")));
    if (Statues == -1) {%>
<script>
    alert("员工编号为：<%=user.getNo()%>目前无法登录！\n请稍后再试！");
    window.location.href = "<%=basePath%>NGU/index.jsp";
</script>
<%}%>
<div class="subject" id="subject">
    <!--主界面菜单栏-->
    <div id="left">
        <br>
        <h2 align="center"><a href="javascript:void(0)" id="r0">NGU人事工资管理系统</a></h2><br>
        <p class="p0">员工姓名：<span><%=user.getName()%></span></p>
        <p class="p0">权限：<span>用户</span></p>
        <p class="p0"><a href="<%=basePath%>NGU/index.jsp" style="color: #ff4400"><u>退出登录</u></a></p><br>

        <h3>&nbsp;&nbsp;&nbsp;个人信息管理</h3>
        <p class="p1"><a href="javascript:void(0)" id="r1">修改个人信息</a></p>
        <p class="p1"><a href="javascript:void(0)" id="r2">查询个人信息</a></p><br>

        <h3>&nbsp;&nbsp;&nbsp;考勤</h3>
        <p class="p1"><a href="javascript:void(0)" id="g1">签到</a></p><br>

        <h3>&nbsp;&nbsp;&nbsp;留言系统</h3>
        <p class="p1"><a href="javascript:void(0)" id="l1">查看留言信息</a></p>
        <p class="p1"><a href="javascript:void(0)" id="l2">发布留言</a></p><br>

        <h3>&nbsp;&nbsp;&nbsp;个人中心</h3>
        <p class="p1"><a href="javascript:void(0)" id="ge1">修改密码</a></p><br>

        <h3>&nbsp;&nbsp;&nbsp;意见反馈</h3>
        <p class="p1"><a href="javascript:void(0)" id="k1">反馈</a></p>
        <br>
    </div>
    <!--子模块界面-->
    <div id="right">
        <!--主界面系统介绍-->
        <div class="introduce" id="introduce">
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

        <!--更改我的资料-->

        <%
            //用户个人信息信息获取
            ArrayList l2 = (ArrayList) session.getAttribute("userinfo");
            Person p2 = (Person) l2.get(0);
            String myname = p2.getName();
            String mysex = p2.getSex();
            int myage = p2.getAge();
            String mydept = p2.getDept();
            String mytel = p2.getTele();
            String mysalary = p2.getSalary();
            String path1 = request.getRealPath("/NGU");
        %>
        <script>
            function $(id) {
                return document.getElementById(id);
            }

            /*用户修改自己信息*/
            function changeInfo() {
                var userno = $("userno").value;
                var username = $("username").value;
                var usersex = $("usersex").value;
                var userage = $("userage").value;
                var userdept = $("userdept").value;
                var usertel = $("usertel").value;
                if (username === "<%=myname%>" && userage === "<%=myage%>" && userdept === "<%=mydept%>" && usertel === "<%=mytel%>" && usersex === "<%=mysex%>") {
                    alert("个人信息没有变化，请确认修改数据后再点击！");
                } else if (username === "" || userage === "" || userdept === "" || usertel === "" || usersex === "") {
                    alert("信息输入不完整,请补全信息");
                } else if (usersex !== "男" && usersex !== "女") {
                    alert("性别必须为男或女!");
                } else if (!isNo(userage) || (userage > 60 || userage < 18)) {
                    alert("年龄为18到60之间的数字!");
                } else if (userdept !== "销售部" && userdept !== "财务部" && userdept !== "技术部" && userdept !== "人力资源部" && userdept !== "后勤部") {
                    alert("部门必须为:销售部、财务部、技术部、人力资源部、后勤部中的一个!");
                } else if (!isNo(usertel) || usertel.length !== 11) {
                    alert("电话为11位数字!");
                } else {
                    window.location.href = "<%=basePath %>servlet?key=changePerson&userno=" + userno + "&username=" + username + "&userage=" + userage + "&usertel=" + usertel + "&userdept=" + userdept + "&usersex=" + usersex;
                    alert("修改成功!");
                }
            }

            function reset_person() {
                var userName = $("username").value;
                var userSex = $("usersex").value;
                var userAge = $("userage").value;
                var userDept = $("userdept").value;
                var userTel = $("usertel").value;
                var flag = confirm("请问你真要重置已有表中数据吗？");
                if (flag) {
                    if (userName === "<%=myname%>" && userAge === "<%=myage%>" && userDept === "<%=mydept%>" && userTel === "<%=mytel%>" && userSex === "<%=mysex%>") {
                        alert("个人信息没有变化，请确认修改数据后再点击！");
                    } else {
                        userName = "<%=myname%>";
                        userSex = "<%=mysex%>";
                        userAge =<%=myage%>;
                        userDept = "<%=mydept%>";
                        userTel =<%=mytel%>;
                        alert("数据重置成功！");
                    }
                }
            }

            /*校验是否全由数字组成 */
            function isNo(str) {
                var reg = /^[0-9]*$/;   /*定义验证表达式*/
                return reg.test(str);     /*进行验证*/
            }
        </script>
        <div id="changeinfo">
            <center>
                <h1 style="margin-top: 5%">修改个人资料</h1>
                <fieldset style="width: 30%;margin-top: 5%">
                    <input type="hidden" name="userno" id="userno" value="<%=user.getNo() %>"><br><br>
                    姓名:&nbsp;&nbsp;<input type="text" name="username" id="username" value="<%=myname%>"><br><br>
                    性别:&nbsp;&nbsp;<input type="text" name="usersex" id="usersex" value="<%=mysex%>"><br><br>
                    年龄:&nbsp;&nbsp;<input type="text" name="userage" id="userage" value="<%=myage%>"><br><br>
                    所在部门:&nbsp;&nbsp;<input type="text" name="userdept" id="userdept" value="<%=mydept%>" readonly
                                            style="margin-right: 30px"><br><br>
                    电话:&nbsp;&nbsp;<input type="text" name="usertel" id="usertel" value="<%=mytel%>"><br><br>
                </fieldset>
                <input type="button" name="ok" value="确认修改" onclick="changeInfo()"
                       style="margin-top: 3%;margin-right: 25px" class="btn_person">
                <input type="reset" class="btn_person" style="margin-left: 25px" onclick="reset_person()">
            </center>
        </div>


        <!--查看我的资料-->
        <script>
            /*打印*/
            function printinfo() {
                if (confirm("是否要打印个人信息?")) {
                    var path = document.getElementById("path").innerHTML;
                    var myname = document.getElementById("myname").innerHTML;
                    var mysex = document.getElementById("mysex").innerHTML;
                    var myage = document.getElementById("myage").innerHTML;
                    var mydept = document.getElementById("mydept").innerHTML;
                    var mytel = document.getElementById("mytel").innerHTML;
                    window.location.href = "<%=basePath %>servlet?key=downloadInfo&path=" + path + "&myname=" + myname + "&myage=" + myage + "&mytel=" + mytel + "&mydept=" + mydept + "&mysex=" + mysex;
                }
            }
        </script>
        <div id="searchinfo">
            <input type="hidden" name="path" id="path" value="<%=path1 %>">
            <center>
                <h1 style="margin-top: 5%"><%=myname%>员工的个人信息</h1>
                <table border="1" cellpadding="0" cellspacing="1" align="center" id="table_person"
                       style="margin-top: 3%">
                    <tr>
                        <td>姓名</td>
                        <td id="myname"><%=myname%>
                        </td>
                    </tr>
                    <tr>
                        <td>性别</td>
                        <td id="mysex"><%=mysex%>
                        </td>
                    </tr>
                    <tr>
                        <td>年龄</td>
                        <td id="myage"><%=myage%>
                        </td>
                    </tr>
                    <tr>
                        <td>所在部门</td>
                        <td id="mydept"><%=mydept%>
                        </td>
                    </tr>
                    <tr>
                        <td>联系电话</td>
                        <td id="mytel"><%=mytel%>
                        </td>
                    </tr>
                    <tr>
                        <td>底薪</td>
                        <td id="mysalary"><%=mysalary%>
                        </td>
                    </tr>
                </table>
                <input type="button" id="print" name="print" value="打印" onclick="printinfo()">
            </center>
        </div>

        <!--签到-->
        <div id="kdao">
            <center>
                <h1>当前时间:</h1><br><br>
                <font color="#2E04BB" size="30px">
                    <div class="showtime"></div>
                </font><br>
                <form action="servlet?no=<%=user.getNo() %>" method="post">
                    <input type="hidden" name="key" value="sign">
                    <%
                        if (Statues == 0) {
                    %>
                    <input type="submit" id="qiandao" name="qiandao" value="签到" onclick="clickQianDao">
                    <%
                    } else {
                    %>
                    <input type="submit" id="qiandao" name="qiandao" value="当天已签到" disabled="disabled">
                    <%} %>
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

        <!--留言发布操作界面-->
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
                    alert("留言发布成功！\n将带你进入留言发布系统！")
                return true;
            }
        }
        </script>
        <div class="writemsg" id="writemsg">
            <center>
                <form action="servlet" method="post" class="form_dialog" onsubmit="return upNewMessage()">
                    <input type="hidden" name="key" value="upNew">
                    <input type="hidden" name="userDialog" value="<%=user.getNo() %>">
                    <p><font size="+3">留言内容</font></p><br>
                    <textarea id="upNew" name="Message" rows="15" cols="60" placeholder="请输入你需要留下的内容"
                              maxlength="50"></textarea><br><br>
                    <input style="width:200px;height:50px;" type="submit" value="发布">
                </form>
            </center>
        </div>

        <!--修改密码-->
        <script>
            function submitCheck() {
                function $(id) {
                    return document.getElementById(id);
                }

                var password = $('password_modify');
                var psw = $('psw_modify');
                var psw_sure = $('psw_sure_modify');

                if (password.value === "" || psw.value === "" || psw_sure.value === "") {
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
                    if ((parseInt(password.value)) !== <%=user.getPassword()%>) {
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
        <div class="changepassword" id="changepassword">
            <center>
                <form class="formPswUpdate" action="servlet" method="post" onsubmit="return submitCheck()"
                      onreset="return formReset()">
                    <input type="hidden" name="key" value="UserPasswordUpdate">
                    <h2>修改登录密码</h2><br><br>
                    账号 :&emsp;&emsp;&emsp;<input type="text" name="name" id="name_modify" value="<%=user.getNo()%>"
                                                 readonly><br><br>
                    原密码 :&emsp;&emsp;<input type="password" name="password" id="password_modify"
                                            placeholder="请输入原始密码"><br><br>
                    新密码 :&emsp;&emsp;<input type="password" name="psw" id="psw_modify" placeholder="请输入新密码"><br><br>
                    确认密码 :&emsp;<input type="password" name="psw_sure" id="psw_sure_modify"
                                       placeholder="请再次输入修改后的密码"><br><br>
                    <input type="submit" class="button7" value="确认">
                    <input type="reset" value="重置" class="button8">
                </form>
            </center>
        </div>

        <!--意见反馈-->
        <script> <!--意见反馈判空-->
        function upNewAdvice() {
            function $(id) {
                return document.getElementById(id);
            }

            return clickSec();
        }


        function clickSec() {
            var message = $("opinion_tarea");
            if (message.value === "") {
                alert("发布信息不能为空");
                message.focus();
                return false;
            } else {
                if (message.value.length > 100) {
                    alert("字数过多,请控制在100个字符内!");
                    return false;
                } else
                    alert("意见反馈已到达管理员系统，请耐心等待。");
                return true;
            }
        }

        function fileSec() {
            var values = document.querySelector("input[type=file]").value;
            if (values === "") {
                alert("未选中需要上传的文件！")
                return false
            } else {
                alert("文件已经上传到服务器指定目录。")
                return true;
            }

        }
        </script>
        <div id="opinion_txt">
            <p style="margin: 100px 0 0 "><font size="+2">文本反馈:</font></p><br>
            <form action="servlet" method="post" onsubmit="return upNewAdvice()">
                <input type="hidden" name="key" value="submitAdvance">
                <input type="hidden" name="userAdvice" value="<%=user.getNo() %>">
                <textarea id="opinion_tarea" rows="20" cols="150" placeholder="请输入您的意见" name="advice"></textarea><br>
                <input type="submit" class="btn" name="submit" value="提交" style="margin-bottom: 50px">
            </form>
            <hr style="width: 40%">
            <p style="margin: 100px 0 0 "><font size="+2">文件反馈:</font></p><br>
            <form action="upload" enctype="multipart/form-data" method="post" onsubmit="return fileSec()">
                <input type="file" id="fileUpload" name="upload" value=""
                       style="font-size: 16px;padding: 5px;margin-left: 120px"><br>
                <input type="submit" value="提交" class="btn">
            </form>
        </div>
    </div>
</div>
<hr>
<div class="page_bottom">
    <center>
        <h1>&nbsp;</h1>
        <p>该网站最终解释权归作者所有，本网站仅用于学习开发，不得用于商业用途。</p>
        <p>Copyright&copy; 2020-2021 NGU(the team of Never Give Up)</p>
        <p>All rights reserved</p>
        <h1>&nbsp;</h1>
        <br>
    </center>
</div>
</body>
<script type="text/javascript" src="<%=basePath%>NGU/js/user_click.js"></script>
</html>
