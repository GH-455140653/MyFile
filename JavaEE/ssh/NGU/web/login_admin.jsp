<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/11/16
  Time: 14:42
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
    <title>后台登录</title>
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
<body>
<div class="login-dark">
    <form method="post" action="<%=basePath%>Admin/admin_login">
        <h2 class="sr-only">Login Form</h2>
        <h1>后台管理系统</h1>
        <div class="illustration">
            <i class="icon ion-ios-locked-outline"></i>
        </div>
        <div class="form-group">
            <input class="form-control" type="text" id="account_loginAdmin" name="admin.admin_account" placeholder="请输入管理员账号">
        </div>
        <div class="form-group">
            <input class="form-control" type="password" id="password_loginAdmin" name="admin.admin_password" placeholder="请输入密码">
        </div>
        <div class="form-group row">
            <div class="col-sm-6 mb-3 mb-sm-0">
                <input class="form-control form-control-user" type="text" id="validateNum" placeholder="验证码" name="">
            </div>
            <div class="col-sm-6" id="verifyNum" style="text-align: center;font-size: 25px">点我验证</div>
        </div>
        <div class="form-group">
            <button class="btn btn-primary btn-block" id="login_btn_loginAdmin" type="submit">登录</button>
        </div>
        <a class="forgot" href="./register_admin.jsp">注册</a>
    </form>
</div>

<script src="./js/foreground/ValidateNumber.js"></script>
<script src="assets/js/jquery.min.js?h=83e266cb1712b47c265f77a8f9e18451"></script>
<script src="assets/bootstrap/js/bootstrap.min.js?h=63715b63ee49d5fe4844c2ecae071373"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
<script src="assets/js/script.min.js?h=68260d362a72ee2d89c5f268b9d73b31"></script>
</body>
</html>
