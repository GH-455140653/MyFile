<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/11/16
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>视频播放</title>
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/dplayer@1.25.0/dist/DPlayer.min.css">
    <script src="./js/background/page_time.js"></script>
    <script src="./js/foreground/dateTimeHandle.js"></script>
</head>
<%--<script>
    if (window.name === "") {
        console.log("首次被加载");
        window.name = "isReload";  // 在首次进入页面时我们可以给window.name设置一个固定值
        window.location.href = "<%=basePath%>Function/function_pageRefresh"
    } else if (window.name === "isReload") {
        console.log("页面被刷新");
    }
</script>--%>
<body>
<!--导航栏-->

<c:if test="${classList.size()!=0}">
    <c:forEach var="c" items="${classList}">
        <c:set value="${c.videos}" var="videos"/>
        <c:if test="${videos.size()!=0}">
            <c:forEach items="${videos}" var="v">
                <c:if test="${v.video_id==VideoID}">
                    <nav class="navbar navbar-light navbar-expand-md daohanglan" id="navigate"
                         style="background-color: rgba(0,0,0,0.8);">
                        <div class="container">
                            <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0"
                               href="./index_foreground.jsp">
                                <div class="sidebar-brand-icon rotate-n-15">
                                    <img class="rounded-circle"
                                         src="assets/img/16046299004874.png?h=ea0f538377d233d414cbb83954e75121">
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
                                <a class="list-group-item list-group-item-action border-white" id="user_image_link"
                                   href="./login_user.jsp">
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

                                    <%--后台进入图片--%>
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
                                    <%--后台进入图片--%>

                                <a class="list-group-item list-group-item-action border-white">
                                    <img class="rounded-circle"
                                         src="assets/img/out.png?h=a4454064bcec10f114e6a2f31a842588">
                                </a>
                            </div>
                        </div>
                    </nav>
                    <!--导航栏-->

                    <!--视频播放器-->
                    <div class="text-center" style="padding-top: 87px">

                            <%--后台查出视频标题--%>
                        <div class="container-fluid" style="margin: 3%">
                            <h3 class="text-dark mb-1">${v.video_title}</h3>
                        </div>
                            <%--后台查出视频标题--%>

                        <!--DPlayer框架实现视频播放-->
                        <div id="dplayer" style="width: 80%;margin: auto"></div>
                        <!--DPlayer框架实现视频播放-->

                        <script src="https://cdn.jsdelivr.net/npm/dplayer@1.25.0/dist/DPlayer.min.js"></script>
                        <script src="https://cdn.jsdelivr.net/npm/flv.js@1.5.0/dist/flv.min.js"></script>
                        <script src="https://cdn.jsdelivr.net/npm/hls.js@0.14.16/dist/hls.min.js"></script>
                        <script src="https://cdn.jsdelivr.net/npm/dash@3.16.1/dist/dash.min.js"></script>
                        <script src="https://cdn.jsdelivr.net/npm/shaka-player@3.0.5/dist/shaka-player.compiled.js"></script>
                        <script src="https://cdn.jsdelivr.net/npm/webtorrent@0.110.1/webtorrent.min.js"></script>

                        <script>
                            const dp = new DPlayer({
                                container: document.getElementById('dplayer'),
                                autoplay: false,//自动播放
                                theme: '#FADFA3',//主题颜色
                                loop: true,//循环播放
                                lang: 'zh-cn',//语言
                                screenshot: true,//是否支持截图
                                hotkey: true,//是否支持快捷键
                                preload: 'auto',//视频预加载
                                volume: 0.7,//默认音量
                                mutex: true,
                                video: {//视频属性
                                    url: '<%=basePath%>upload/${v.video_name}',//视频封面路径
                                    pic: './assets/img/loading.gif',//视频路径
                                    type: 'auto',//视频类型
                                },
                                danmaku: {//弹幕相关
                                    id: '9E2E3368B56CDBB4',
                                    api: 'https://dplayer.moerats.com/',
                                    token: 'tokendemo',
                                    maximum: 100,
                                    addition: ['https://dplayer.alone88.cn/v3/bilibili?aid=4157142'],
                                    user: 'DIYgod',
                                    bottom: '15%',
                                    unlimited: true,
                                },
                            });

                        </script>
                    </div>

                    <div style="margin-right: 10%;margin-left: 10%;">
                        <hr>
                        <div>
                            <span>视频简介：</span>

                                <%--后台查询视频简介写入--%>
                            <span>${v.video_desc}</span>
                                <%--后台查询视频简介写入--%>

                        </div>
                        <hr>

                        <div class="text-right">
                            <form action="<%=basePath%>Comment/comment_addComment" method="post">
                                <!-- 评论内容 -->
                                <input class="bg-light form-control-lg border-0 small" type="text" placeholder="请输入你的评论"
                                       name="comment.comment_text" id="comment_input_video">

                                <!-- 用户id -->
                                <input type="hidden" id="memberAccount" name="member.member_account" value=${memberAccount} />

                                <!-- 视频id -->
                                <input type="hidden" id="videoId" name="video.video_id" value=${VideoID} />
                                <button class="btn btn-primary" type="submit">发表</button>
                            </form>
                        </div>
                    </div>

                    <div style="margin-right: 10%;margin-left: 10%;">
                        <div style="padding: 20px;">
                            <span>精彩评论</span>
                            <i class="typcn typcn-arrow-down"></i>
                            <i class="typcn typcn-arrow-down"></i>
                            <i class="typcn typcn-arrow-down"></i>
                        </div>
                    </div>

                    <!--后台查询评论写入-->
                    <div class="row" style="margin-right: 10%;margin-left: 10%;">
                            <%--后台通过table表格展示，其中包括用户头像，昵称，时间以及评论内容--%>

                        <table border="1px" class="Ctable" align="center"
                               style="text-align: center;vertical-align: center">
                            <tr>
                                <th>用户账号</th>
                                <th>评论时间</th>
                                <th>评论内容</th>
                            </tr>

                            <%--c标签与fmt标签实现时间格式化--%>
                            <c:if test="${commentList.size()!=0}">
                                <c:forEach items="${commentList}" var="com">
                                    <tr>
                                        <td>${com.member_account}</td> <!-- 用户账号 -->
                                        <td>
                                            <fmt:formatDate value="${com.comment_post}" pattern="yyyy-MM-dd HH:mm:ss" />
                                        </td> <!-- 评论时间 -->
                                        <td>${com.comment_text}</td> <!-- 评论内容 -->
                                    </tr>
                                </c:forEach>
                            </c:if>

                            <%-- s标签实现时间格式化
                            <s:if test="%{#session.commentList.size()!=0}">
                                <s:iterator value="%{#session.commentList}">
                                    <tr>
                                        <td><s:property value="member_account"/></td> <!-- 用户账号 -->
                                        <td><s:date name="comment_post" format="yyyy-MM-dd HH:mm:ss"/></td> <!-- 评论时间 -->
                                        <td><s:property value="comment_text"/></td> <!-- 评论内容 -->
                                    </tr>
                                </s:iterator>
                            </s:if>
                            --%>
                        </table>

                    </div>
                    <!--后台查询评论写入-->

                    <hr style="width: 90%;">

                    <div class="footer-basic">
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
                </c:if>
            </c:forEach>
        </c:if>
    </c:forEach>
</c:if>

<script src="assets/js/jquery.min.js?h=83e266cb1712b47c265f77a8f9e18451"></script>
<script src="assets/bootstrap/js/bootstrap.min.js?h=63715b63ee49d5fe4844c2ecae071373"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
<script src="assets/js/script.min.js?h=68260d362a72ee2d89c5f268b9d73b31"></script>

</body>
</html>

