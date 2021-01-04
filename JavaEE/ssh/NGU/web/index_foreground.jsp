<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/11/16
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>NGU视频网站</title>
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
    <script src="./js/jq/jquery-3.4.1.min.js"></script>
    <script src="js/foreground/ValidateChecked.js"></script>
</head>
<script>
    $(document).ready(function () {
        $.ajax({
            type: "POST",
            url: "<%=basePath%>Classify/classify_foregroundDate",
            async: false,
            success: function () {
                if (window.name === "") {
                    console.log("首次被加载");
                    window.name = "isReload";  // 在首次进入页面时我们可以给window.name设置一个固定值
                    location.reload();
                } else if (window.name === "isReload") {
                    console.log("页面被刷新");
                }
            }
        })
    });
</script>
<body>

<!--导航栏-->
<nav class="navbar navbar-light navbar-expand-md daohanglan" id="navigate" style="background-color: rgba(0,0,0,0.8);">
    <div class="container">
        <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0"
           href="./index_foreground.jsp">
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
                        image_link.href = "<%=basePath%>User/member_videoBrowse?member.member_account=${memberAccount}";
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

            <%--用户退出按钮--%>
            <a class="list-group-item list-group-item-action border-white">
                <img class="rounded-circle" src="assets/img/out.png?h=a4454064bcec10f114e6a2f31a842588">
            </a>
            <%--用户退出按钮--%>

        </div>
    </div>
</nav>

<!--图片轮播-->
<div class="simple-slider" style="padding-top: 87px;padding-bottom: 20px;">
    <div class="swiper-container">
        <div class="swiper-wrapper">

            <!--需要几张图就在这加几个div-->
            <c:if test="${classList.size()!=0}">
                <c:forEach var="c" items="${classList}">

                    <%--后台数据查出并循环写入--%>
                    <c:set value="${c.videos}" var="videos"/>
                    <c:if test="${videos.size()!=0}">
                        <c:forEach items="${videos}" var="v">
                            <div class="swiper-slide" style="text-align: center">
                                <a onclick="return loginChecked(${memberAccount})"
                                   href="<%=basePath%>Video/video_videoPlay?video.video_id=${v.video_id}&member.member_account=${memberAccount}">
                                    <img src="<%=basePath%>upload/${v.video_cover}"
                                         alt="${v.video_title}" style="width: 100%;height: 100%">
                                </a>
                            </div>
                        </c:forEach>
                    </c:if>
                    <%--后台数据查出并循环写入--%>
                </c:forEach>
            </c:if>
            <!--需要几张图就在这加几个div-->
        </div>
        <div class="swiper-pagination"></div>
        <div class="swiper-button-prev"></div>
        <div class="swiper-button-next"></div>
    </div>
</div>

<div>
    <div class="container">
        <div class="row">

            <!--悬浮菜单栏-->
            <div class="col-md-6 col-xl-3 offset-xl-0" style="padding-top: 12px;">
                <div id="sidebar-main" class="sidebar sidebar-default sidebar-separate">
                    <div class="sidebar-category sidebar-default">
                        <div class="category-title">
                            <span>影视分类</span>
                        </div>
                        <div class="category-content">
                            <ul id="fruits-nav" class="nav flex-column">

                                <%--标签循环处--%>
                                <c:if test="${classList.size()!=0}">
                                    <c:forEach items="${classList}" var="c">
                                        <li class="nav-item">
                                            <a href="index_foreground.jsp#class_${c.c_id}" class="nav-link">
                                                <i class="far fa-star"
                                                   aria-hidden="true"></i> ${c.c_name} <%--根据后台查出数据修改--%>
                                            </a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <%--标签循环处--%>

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!--悬浮菜单栏-->

            <!--视频展示-->
            <div class="col-md-6 col-xl-9">

                <c:if test="${classList.size()!=0}">
                    <c:forEach var="c" items="${classList}">
                        <div class="float-left">

                                <%--标题读出与写入--%>
                            <h1 style="margin-top: 10px;" id="class_${c.c_id}">${c.c_name}</h1>
                                <%--标题读出与写入--%>

                                <%--后台数据查出并循环写入--%>
                            <c:set value="${c.videos}" var="videos"/>
                            <c:if test="${videos.size()!=0}">
                                <c:forEach items="${videos}" var="v">

                                    <div class="float-left" style="margin: 10px;text-align: center;">
                                        <a onclick="return loginChecked(${memberAccount})"
                                           href="<%=basePath%>Video/video_videoPlay?video.video_id=${v.video_id}&member.member_account=${memberAccount}">
                                            <img src="<%=basePath%>upload/${v.video_cover}">
                                            <span class="d-block" style="font-size: 20px;">${v.video_title}</span>
                                        </a>
                                    </div>
                                </c:forEach>
                            </c:if>
                                <%--后台数据查出并循环写入--%>
                        </div>
                    </c:forEach>
                </c:if>

            </div>
        </div>
    </div>
</div>

<!--页脚-->
<div class="footer-basic">
    <hr style="width: 90%;">
    <footer>
        <div class="social"><a href="#"><i class="fa fa-wechat"></i></a><a href="#"><i class="fa fa-qq"></i></a><a
                href="#"><i class="icon ion-social-twitter"></i></a><a href="#"><i class="fa fa-google"></i></a></div>
        <p class="copyright" style="margin-top: 0;"><br>Copyright © NGU 2020<br><br></p>
    </footer>
</div>

<!--脚本引入-->
<script src="js/foreground/sidebar_indexShow.js"></script>
<script src="assets/js/jquery.min.js?h=83e266cb1712b47c265f77a8f9e18451"></script>
<script src="assets/bootstrap/js/bootstrap.min.js?h=63715b63ee49d5fe4844c2ecae071373"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
<script src="assets/js/script.min.js?h=68260d362a72ee2d89c5f268b9d73b31"></script>
<%--<s:debug/>--%>
</body>
</html>
