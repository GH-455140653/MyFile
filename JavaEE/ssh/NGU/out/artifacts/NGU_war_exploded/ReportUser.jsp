<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/11/20
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    /*  System.out.println("/*--------------------------------------------------------------------------------------------"+basePath); */
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>后台视频管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/background/ReportContral.css">
    <link rel="stylesheet" href="css/background/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="css/background/bootstrap/styles.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css?h=98a49735ed420ff1094cb21c75dd8271">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css?h=98a49735ed420ff1094cb21c75dd8271">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
    <script src="js/background/echarts/echarts.min.js"></script>
</head>
<body id="page-top">

<!-- 第一行 -->
<div class="Report-top">
    <a href="./index_background.jsp">返回后台首页</a> <span id="uy"
        style="display: none"></span> <span id="um" style="display: none"></span><span id="vd" style="display: none"></span><br /> <input type="button" value="导出"
        onclick="saveAsImage()" />
    <form method="post" action="<%=basePath%>Table/table_getUserList"
        style="display: inline;">
        <button>刷新</button>
    </form>
    <br />
    <button id="reportback" style="display: none; float: left;">年度报表</button>
</div>

<!-- 第二行 -->
<div class="Rtop-second">
    <div class="Rtop-left">
        <label class="Rtop-label" id="Report-text">用户报表</label>
    </div>

    <!-- 图注区 -->
    <div class="Rtop-middle">
        <div class="imgcolor"></div>
        <div class="middle-label">
            <label>每月点击量</label>
        </div>

    </div>
</div>

<!-- 图表 -->

<!-- 用户报表 -->
<div id="Reportuser" style="width: 900px; height: 400px;"></div>


<span id="sessionList" style="display: none">${userListR}</span>
<!-- style="display:none" -->


<footer class="bg-white sticky-footer">
    <div class="container my-auto">
        <div class="text-center my-auto copyright"><span>Copyright © NGU 2020</span></div>
    </div>
</footer>

<script type="text/javascript" src="js/background/Report/ReportUser.js"></script>
<script type="text/javascript" src="js/background/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="js/background/bootstrap/jquery.min.js"></script>
<script type="text/javascript" src="js/background/bootstrap/script.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
<script type="text/javascript" src="js/jq/jquery-3.4.1.js"></script>
<script type="text/javascript" src="js/jq/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/jq/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="js/jq/jquery.form.js"></script>

</body>
</html>
