<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/11/20
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>后台视频管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/background/HomePage.css">
    <link rel="stylesheet" href="css/background/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="css/background/bootstrap/styles.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css?h=98a49735ed420ff1094cb21c75dd8271">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css?h=98a49735ed420ff1094cb21c75dd8271">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
    <script src="js/background/echarts/echarts.min.js"></script>
</head>
<body id="page-top">
<div id="wrapper">

    <!-- 左边系统功能栏目 -->
    <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
        <div class="container-fluid d-flex flex-column p-0">
            <hr class="sidebar-divider my-0">
            <ul class="nav navbar-nav text-light"></ul>
            <div class="text-center d-none d-md-inline"></div>
            <nav class="navbar navbar-dark bg-primary align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
                <div class="container-fluid d-flex flex-column p-0">
                    <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0"
                       href="./index_background.jsp">
                        <div class="sidebar-brand-icon rotate-n-15">
                            <img class="rounded-circle" src="assets/img/16046299004874.png">
                        </div>
                        <div class="sidebar-brand-text mx-3"><span>视频管理系统</span></div>
                    </a>
                    <hr class="sidebar-divider my-0">
                    <ul class="nav navbar-nav text-light"></ul>
                    <div class="text-center d-none d-md-inline">
                        <button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button>
                    </div>
                    <div class="list-group" data-aos="fade" data-aos-delay="500" style="font-size: 25px;">
                        <a id="user-mean" href="javascript:void(0)"
                           class="list-group-item list-group-item-action text-center"
                           style="font-family: Nunito, sans-serif;">
                            <span class="text-center">用户管理</span>
                        </a>
                        <a id="Classified-mean" href="javascript:void(0)"
                           class="list-group-item list-group-item-action">
                            <span class="text-center">分类管理</span>
                        </a>
                        <a id="Video-mean" href="javascript:void(0)" class="list-group-item list-group-item-action">
                            <span class="text-center">视频管理</span>
                        </a>
                        <a id="Comment-mean" href="javascript:void(0)" class="list-group-item list-group-item-action">
                            <span class="text-center">评论管理</span>
                        </a>
                        <a id="Report-mean" href="javascript:void(0)" class="list-group-item list-group-item-action">
                            <span class="text-center">报表管理</span>
                        </a>
                        <a id="Role-mean" href="javascript:void(0)" class="list-group-item list-group-item-action">
                            <span class="text-center">权限管理</span>
                        </a>
                    </div>
                </div>
            </nav>
        </div>
    </nav>
    <!-- 左边系统功能栏目 -->

    <!-- 右边 -->
    <div class="d-flex flex-column" id="content-wrapper">
        <!-- 右上导航栏 -->
        <div id="content">
            <nav class="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top">
                <div class="container-fluid">
                    <button class="btn btn-link d-md-none rounded-circle mr-3" id="sidebarToggleTop" type="button">
                        <i class="fas fa-bars"></i>
                    </button>
                    <a href="./index_background.jsp">
                        <span class="text-info link_button" data-aos="fade" data-aos-delay="500"
                              style="background-size: auto;font-weight: bold;font-style: normal;">后台首页</span>
                    </a>
                    <a href="./index_foreground.jsp">
                        <span class="text-info link_button" data-aos="fade" data-aos-delay="500"
                              style="font-weight: bold;">前台首页</span>
                    </a>
                    <form class="form-inline d-none d-sm-inline-block mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <div class="input-group-append"></div>
                        </div>
                    </form>

                    <%--管理员图片--%>
                    <a class="list-group-item border-white">
                        <img data-aos="fade" data-aos-delay="500" style="width: 40px;height: 40px"
                             src="<%=basePath%>images/${adminImage}">
                    </a>
                    <%--管理员图片--%>

                    <%--管理员的昵称--%>
                    <span style="margin-right: 1%;margin-left: 1%" data-aos="fade"
                          data-aos-delay="500">${adminName}</span>
                    <%--管理员的昵称--%>

                    <a class="list-group-item border-white"
                       onclick="window.location.href ='<%=basePath%>Admin/admin_loginout'">
                        <img class="rounded-circle" data-aos="fade" data-aos-delay="500" src="assets/img/out.png">
                    </a>
                </div>
            </nav>
            <!-- 右上导航栏 -->

            <!-- 后台首页内容展示部分 -->
            <div class="HomePage" id="HomePage">
                <div class="Hpleft">
                    <div><img src="./images/smile.png"></div>
                    <div><p class="jianjie">&emsp;&emsp;欢迎使用NGU后台管理系统，本平台不收取任何费用，你的使用就是对我们的最大鼓励。</p></div>
                    <p class="HpL-bo" id="nowTime"></p>
                    <script src="js/background/page_time.js"></script>
                </div>
                <div class="Hpright">
                    <table border="1">

                        <!-- 管理员头像 -->
                        <tr>
                            <td style="text-align: center;"><img src="<%=basePath%>images/${adminImage}"></td>
                        </tr>
                        <!-- 管理员头像 -->

                        <tr>
                            <td>管理员账号：</td>
                        </tr>
                        <tr>

                            <!-- 管理员账号 -->
                            <td style="text-align: center;background-color: #fceec9">${adminAccount}</td>
                            <!-- 管理员账号 -->

                        </tr>
                        <tr>
                            <td>管理员权限：</td>
                        </tr>
                        <tr>

                            <!-- 管理员权限 -->
                            <td style="text-align: center;background-color: #fceec9">***********</td>
                            <!-- 管理员权限 -->

                        </tr>
                        <tr>
                            <td>注册时间：</td>
                        </tr>
                        <tr>

                            <!-- 管理员注册时间 -->
                            <td style="text-align: center;background-color: #fceec9">${adminRegisterDate}</td>
                            <!-- 管理员注册时间 -->

                        </tr>
                        <%--                        <tr>
                                                    <td>上次登录时间：</td>
                                                </tr>
                                                <tr>

                                                    <!-- 上次管理员上次登录时间 -->
                                                    <td style="text-align: center;background-color: #fceec9">
                                                    </td>
                                                    <!-- 上次管理员上次登录时间 -->

                                                </tr>--%>
                    </table>
                </div>
            </div>
            <!-- 后台首页内容展示部分 -->

            <!-- 权限管理 -->
            <div class="Role" id="Role">
                <shiro:hasRole name="超管">
                    <button onclick="window.location.href='<%=basePath%>admin_author.jsp'">权限管理</button>
                </shiro:hasRole>
            </div>

            <!-- 分类管理 -->
            <div class="Classified" id="Classified">
                <shiro:hasAnyRoles name="分类管理,超管">
                    <button onclick="window.location.href='<%=basePath%>Classify/classify_read'">分类管理</button>
                </shiro:hasAnyRoles>
            </div>

            <!-- 用户管理 -->
            <div class="usercontral" id="usercontral">
                <shiro:hasAnyRoles name="用户管理,超管">
                    <button onclick="window.location.href='<%=basePath%>User/member_getAllMember'">用户管理</button>
                </shiro:hasAnyRoles>
            </div>

            <!-- 资源管理/视频管理 -->
            <div class="resourcescontral" id="resourcescontral">
                <shiro:hasAnyRoles name="视频管理,超管">
                    <button onclick="window.location.href='<%=basePath%>Video/video_read'">视频管理</button>
                </shiro:hasAnyRoles>
            </div>

            <!-- 评论管理 -->
            <div class="CommentContral" id="CommentContral">
                <shiro:hasAnyRoles name="评论管理,超管">
                    <button onclick="window.location.href='<%=basePath%>Comment/comment_findData'">评论管理</button>
                </shiro:hasAnyRoles>
            </div>

            <!-- 报表管理 -->
            <div class="ReportContral" id="ReportContral">
                <shiro:hasAnyRoles name="报表管理,超管">
                    <div>
                        <button onclick="window.location.href='<%=basePath%>Table/table_getUserList'">用户报表</button>
                        <button onclick="window.location.href='<%=basePath%>Table/table_getVideoList'">视频报表</button>
                    </div>
                </shiro:hasAnyRoles>
            </div>
        </div>

        <!-- 页脚 -->
        <footer class="bg-white sticky-footer">
            <div class="container my-auto">
                <div class="text-center my-auto copyright"><span>Copyright © NGU 2020</span></div>
            </div>
        </footer>

    </div>
    <a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
</div>

<script type="text/javascript" src="js/background/main.js"></script>
<script type="text/javascript" src="js/background/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="js/background/bootstrap/jquery.min.js"></script>
<script type="text/javascript" src="js/background/bootstrap/script.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
<%--<s:debug/>--%>

</body>
</html>
