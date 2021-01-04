<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/11/16
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.NGU.ssh.Model.Video" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>用户中心</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css?h=e9076665ab14bb6cd0d36a4d924723b8">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
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
<!--导航栏-->
<nav class="navbar navbar-light navbar-expand-md" id="navigate" style="background-color: rgba(0,0,0,0.8);">
    <div class="container">
        <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0"
           href="index_foreground.jsp">
            <div class="sidebar-brand-icon rotate-n-15">
                <img class="rounded-circle" src="assets/img/16046299004874.png?h=ea0f538377d233d414cbb83954e75121">
            </div>
            <div class="float-right sidebar-brand-text mx-3">
                <span style="font-size: 25px;color: #66d7d7;">NGU</span>
            </div>
        </a>

        <%--搜索框--%>
        <form class="form-inline" method="post" onsubmit="return loginChecked(${memberAccount})"
              action="<%=basePath%>Video/video_videoSearch?member.member_account=${memberAccount}">
            <div class="text-center input-group" style="text-align: center;">
                <input class="bg-light form-control border-0 small" type="text" placeholder="请输入视频名"
                       style="min-width: 300px;" name="video.video_title" id="searchVideo">
                <button class="btn btn-primary py-0" type="submit">
                    <i class="fas fa-search"></i>
                </button>
            </div>
        </form>
        <%--搜索框--%>

        <%--实现页面跳转或者某种功能--%>
        <div class="list-group list-group-horizontal" style="height: auto;">

            <%--用户头像--%>
            <a class="list-group-item list-group-item-action border-white" id="user_image_link" href="./login_user.jsp">
                <img id="user_image" class="rounded-circle" style="width: 40px;height: 40px"
                     src="assets/img/admin.png?h=8d56c42188c743248eedb374ac98716c">
                <c:if test="${memberImage!=null}">
                    <script>
                        var image = document.getElementById("user_image");
                        image.src = "<%=basePath%>upload/${memberImage}";
                        var image_link = document.getElementById("user_image_link");
                        image_link.href = "<%=basePath%>User/member_videoBrowse?record.member_account=${memberAccount}";
                    </script>
                </c:if>
            </a>
            <%--用户头像--%>

            <%--后台图片--%>
            <a class="list-group-item list-group-item-action border-white" id="background_link"
               href="./login_admin.jsp">
                <img src="assets/img/background.png?h=a4454064bcec10f114e6a2f31a842588">
                <c:if test="${adminAccount!=null}">
                    <script>
                        var image_link = document.getElementById("background_link");
                        image_link.href = "./index_background.jsp";
                    </script>
                </c:if>
            </a>
            <%--后台图片--%>

            <%--用户账号退出--%>
            <a class="list-group-item list-group-item-action border-white" onclick="">
                <img class="rounded-circle" src="assets/img/out.png?h=a4454064bcec10f114e6a2f31a842588">
            </a>
            <%--用户账号退出--%>
        </div>
        <%--实现页面跳转或者某种功能--%>

    </div>
</nav>
<!--导航栏-->

<div style="padding-top: 87px;">
    <div class="container" style="width: 70%;">
        <div class="row">
            <div class="col-md-12" style="text-align: center;">

                <%--后台用户图片查询--%>
                <div class="userCenter_item">
                    <img src="./upload/${memberImage}" style="width: 100px;height: 100px;">
                </div>
                <%--后台用户图片查询--%>

                <%--后台用户昵称查询--%>
                <div class="userCenter_item">
                    <label id="user_name">${memberName}</label>
                </div>
                <%--后台用户昵称查询--%>

                <%--页面跳转--%>
                <div class="userCenter_item">
                    <button class="btn btn-primary" id="password_modify" type="button"
                            onclick="window.location.href='./pwdModify.jsp'">修改密码
                    </button>
                </div>
                <%--页面跳转--%>

            </div>
        </div>

        <%--后台观看记录添加区--%>
        <div class="row">
            <div class="col-md-12">
                <div id="wrapper">
                    <div class="d-flex flex-column" id="content-wrapper">
                        <div id="content" style="margin-right: 10%;margin-left: 10%;margin-top: 5%;">

                            <div id="memberBrowse" style="margin-right: 10%;margin-left: 10%;margin-top: 5%;">
                                <div class="container-fluid">
                                    <h3 class="text-dark mb-4">浏览记录</h3>
                                    <div class="card shadow">
                                        <div class="card-header py-3">
                                            <p class="text-primary m-0 font-weight-bold">browse Info</p>
                                        </div>
                                        <div class="card-body">
                                            <div class="row text-center">
                                                <div class="col-md-6 col-xl-5">
                                                </div>
                                            </div>

                                            <div class="table-responsive table mt-2" role="grid"
                                                 aria-describedby="dataTable_info">
                                                <table class="table dataTable my-0" id="dataTable" border="1"
                                                       style="text-align: center;vertical-align: center">

                                                    <!--表头-->
                                                    <thead>
                                                    <tr>
                                                        <th>视频名称</th>
                                                        <th>用户账号</th>
                                                        <th>最近播放时间</th>
                                                        <th>点击次数</th>
                                                    </tr>
                                                    </thead>
                                                    <!--表头-->

                                                    <!--表格-->
                                                    <tbody>
                                                    <tr>
                                                        <%
                                                            List<Video> allVideo = (List<Video>) session.getAttribute("vedioList");
                                                            Map click = (Map) session.getAttribute("clickMap");
                                                            Map record = (Map) session.getAttribute("recordMap");
                                                            if (click != null && record != null && allVideo.size() != 0) {
                                                                for (Video v : allVideo) {
                                                                    Date date = (Date) record.get(v.getVideo_id());
                                                                    String video_title = v.getVideo_title();
                                                                    Object count = click.get(v.getVideo_id());
                                                        %>
                                                        <td><%=video_title%>
                                                        </td>
                                                        <td>${memberAccount}</td>
                                                        <td><fmt:formatDate value="<%=date%>" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                                        <td><%=count%>
                                                        </td>
                                                    </tr>
                                                    <%
                                                            }
                                                        }
                                                    %>
                                                    </tr>
                                                    </tbody>
                                                    <!--表格-->

                                                </table>
                                            </div>

                                            <div class="row">
                                                <%--控件显示--%>
                                                <div class="col-md-6 col-xl-12">
                                                </div>
                                                <%--控件显示--%>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%--后台观看记录添加区--%>

        <!--页脚-->
        <div class="footer-basic">
            <hr style="width: 90%;">
            <footer>
                <div class="social">
                    <a href="#"><i class="fa fa-wechat"></i></a>
                    <a href="#"><i class="fa fa-qq"></i></a>
                    <a href="#"><i class="icon ion-social-twitter"></i></a>
                    <a href="#"><i class="fa fa-google"></i></a>
                </div>
                <p class="copyright" style="margin-top: 0;"><br>Copyright © NGU 2020<br><br></p>
            </footer>
        </div>

        <!--页脚-->
        <script src="assets/js/jquery.min.js?h=83e266cb1712b47c265f77a8f9e18451"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js?h=63715b63ee49d5fe4844c2ecae071373"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
        <script src="assets/js/script.min.js?h=68260d362a72ee2d89c5f268b9d73b31"></script>
</body>
</html>
