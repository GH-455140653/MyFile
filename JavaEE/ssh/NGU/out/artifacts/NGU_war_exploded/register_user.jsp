<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/11/16
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>用户注册</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css?h=e9076665ab14bb6cd0d36a4d924723b8">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=ABeeZee">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aguafina+Script">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Comfortaa">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400|Roboto:300,400,700">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400|Roboto:300,400,700">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css?h=98a49735ed420ff1094cb21c75dd8271">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css?h=98a49735ed420ff1094cb21c75dd8271">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css?h=98a49735ed420ff1094cb21c75dd8271">
    <link rel="stylesheet" href="assets/fonts/typicons.min.css?h=98a49735ed420ff1094cb21c75dd8271">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css?h=98a49735ed420ff1094cb21c75dd8271">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
    <link rel="stylesheet" href="assets/css/styles.min.css?h=990709496d501640419db69e248acd30">
</head>

<body class="bg-gradient-primary" style="margin-top: 10%;">
<div class="container">
    <div class="card shadow-lg o-hidden border-0 my-5">
        <div class="card-body p-0">
            <div class="row">
                <div class="col-lg-5 d-none d-lg-flex">
                    <div class="flex-grow-1 bg-register-image" style="background-image: url(&quot;assets/img/register.jpg?h=98e22dcf8f0eec5569e202f58dcedab5&quot;);"></div>
                </div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h4 class="text-dark mb-4" style="font-family: Nunito, sans-serif;">用户注册</h4>
                        </div>

                        <!--后台数据获取-->
                        <form class="user" name="f" method="post" action="<%=basePath%>User/member_register" enctype = "multipart/form-data">
                            <div class="form-group">
                                <input class="form-control form-control-user" type="text"
                                       placeholder="请输入你的账号" name="member.member_account">
                            </div>

                            <div class="form-group">
                                <input class="form-control form-control-user" type="text"
                                       aria-describedby="emailHelp" placeholder="请输入你的昵称" name="member.member_name">
                            </div>

                            <div class="form-group border rounded">
                                <span style="padding-left: 20px;">头像：</span>
                                <input type="file" name="file" accept="image/*" style="padding: 24px 16px;">
                            </div>

                            <div class="form-group">
                                <input class="form-control form-control-user" type="password"
                                       placeholder="请输入密码" name="member.member_password">
                            </div>

                            <div class="form-group">
                                <input class="form-control form-control-user" type="password"
                                       placeholder="请再次输入密码" name="member.member_pwd_sure">
                            </div>

                            <button class="btn btn-primary btn-block text-white btn-user" type="submit">注册</button>
                            <hr>
                        </form>
                        <!--后台数据获取-->

                        <div class="text-center"><a class="small" href="./login_user.jsp">已有帐号？立即登录！</a></div>
                        <div class="text-center"><a class="small" href="javascript:window.history.back()">返回</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="assets/js/jquery.min.js?h=83e266cb1712b47c265f77a8f9e18451"></script>
<script src="assets/bootstrap/js/bootstrap.min.js?h=63715b63ee49d5fe4844c2ecae071373"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
<script src="assets/js/script.min.js?h=68260d362a72ee2d89c5f268b9d73b31"></script>
</body>
</html>