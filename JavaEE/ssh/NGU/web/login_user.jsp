<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/11/16
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>用户登录</title>
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
    <div class="row justify-content-center">
        <div class="col-md-9 col-lg-12 col-xl-10">
            <div class="card shadow-lg o-hidden border-0 my-5">
                <div class="card-body p-0">
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-flex">
                            <div class="flex-grow-1 bg-login-image"
                                 style="background-image: url(./assets/img/timg.jpg);">

                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h4 class="text-dark mb-4">欢迎回来！请先登录！</h4>
                                </div>
                                <form class="user" name="f" method="post" action="<%=basePath%>User/member_login">

                                    <!--后台账号获取-->
                                    <div class="form-group">
                                        <input class="form-control form-control-user" type="text"
                                               id="account_loginCustomer"
                                               placeholder="请输入你的账号"
                                               name="member.member_account">
                                    </div>

                                    <!--后台密码获取-->
                                    <div class="form-group">
                                        <input class="form-control form-control-user" type="password"
                                               id="password_loginCustomer"
                                               placeholder="请输入你的密码"
                                               name="member.member_password">
                                    </div>

                                    <!--session结合cookies实现记住密码-->
                                    <div class="form-group">
                                        <div class="custom-control custom-checkbox small">
                                            <div class="form-check">
                                                <input class="form-check-input custom-control-input" type="checkbox"
                                                       id="remember_cb">
                                                <label class="form-check-label custom-control-label"
                                                       id="remember_loginCostomer" for="remember_cb">记住密码</label>
                                            </div>
                                        </div>
                                    </div>

                                    <!--验证码-->
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input class="form-control form-control-user" type="text"
                                                   id="validateNum" placeholder="验证码" name="">
                                        </div>
                                        <div class="col-sm-6" id="verifyNum" style="font-size: 25px">点我验证</div>
                                    </div>

                                    <button class="btn btn-primary btn-block text-white btn-user"
                                            id="login_btn_loginCostomer" type="submit">登录
                                    </button>
                                    <hr>
                                </form>
                                <div class="text-center">
                                    <a class="small" href="./pwdForget.jsp">忘记密码？</a>
                                </div>
                                <div class="text-center">
                                    <a class="small" href="register_user.jsp">创建一个新的账号！</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="./js/foreground/ValidateNumber.js"></script>
<script src="assets/js/jquery.min.js?h=83e266cb1712b47c265f77a8f9e18451"></script>
<script src="assets/bootstrap/js/bootstrap.min.js?h=63715b63ee49d5fe4844c2ecae071373"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
<script src="assets/js/script.min.js?h=68260d362a72ee2d89c5f268b9d73b31"></script>
</body>
</html>
