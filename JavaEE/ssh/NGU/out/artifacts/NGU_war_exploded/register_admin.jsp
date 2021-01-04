<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/11/26
  Time: 9:40
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
    <title>管理员注册</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css?h=f9c53c884c01a7944ada09fdf7321010">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=ABeeZee">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aguafina+Script">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Comfortaa">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400|Roboto:300,400,700">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400|Roboto:300,400,700">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
    <link rel="stylesheet" href="assets/css/styles.min.css?h=990709496d501640419db69e248acd30">
    <script src="./js/jq/jquery-3.4.1.js"></script>
</head>
<body class="bg-gradient-primary">
<div class="container">
    <div class="card shadow-lg o-hidden border-0 my-5">
        <div class="card-body p-0">
            <div class="col-lg-7 col-xl-8 offset-xl-2">
                <div class="p-5">
                    <div class="text-center">
                        <h4 class="text-dark mb-4"><br>Registration<br><br></h4>
                    </div>
                    <form class="user" method="post" action="<%=basePath%>Admin/admin_register">
                        <div class="form-group row">
                            <input class="form-control form-control-user" type="text" placeholder="请输入账号"
                                   id="admin_account" name="admin.admin_account">
                        </div>
                        <div class="form-group row">
                            <input class="form-control form-control-user" type="text" placeholder="请输入昵称"
                                   id="admin_name" name="admin.admin_name">
                        </div>
                        <div class="form-group row">
                            <input class="form-control form-control-user" type="password" placeholder="请输入密码"
                                   id="admin_pwd" name="admin.admin_password">
                        </div>
                        <div class="form-group row">
                            <input class="form-control form-control-user" type="password" placeholder="请输入确认密码"
                                   id="admin_pwd_sure">
                        </div>
                        <div class="form-group border rounded">
                            <span style="padding-left: 20px;">头像：</span>
                            <div class="dropdown d-inline-block">
                                <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                                        aria-expanded="false" type="button">
                                    选择头像&nbsp;
                                </button>
                                <div class="dropdown-menu" role="menu">
                                    <a class="dropdown-item" role="presentation">图片1</a>
                                    <a class="dropdown-item" role="presentation">图片2</a>
                                    <a class="dropdown-item" role="presentation">图片3</a>
                                    <a class="dropdown-item" role="presentation">图片4</a>
                                    <a class="dropdown-item" role="presentation">图片5</a>
                                </div>
                            </div>

                            <div class="text-center d-block">
                                <img id="admin_image_show">
                                <input type="hidden" id="admin_image" name="admin.admin_icon">
                            </div>
                            <script>
                                var image = document.getElementById("admin_image_show");
                                var admin_name = document.getElementById("admin_image");
                                var image_link = document.getElementsByClassName("dropdown-item");
                                $('.dropdown-item').on('click', function (e) {
                                    var filename="admin"+($(this).index() + 1) + ".png";
                                    image.src = "<%=basePath%>/images/" + filename;
                                    admin_name.value = filename;
                                });

                            </script>
                        </div>
                        <button class="btn btn-primary btn-block text-white btn-user" type="submit">注册</button>
                        <hr>
                    </form>
                    <div class="text-center"></div>
                    <div class="text-center">
                        <a class="small" href="./login_admin.jsp">已有账号？立即登录！</a>
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
