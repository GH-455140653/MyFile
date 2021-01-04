<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/11/29
  Time: 15:03
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
    <title>视频管理</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css?h=6b782e1cd0ca20a7e512b6f7c75d6bfe">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=ABeeZee">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aguafina+Script">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Comfortaa">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400|Roboto:300,400,700">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400|Roboto:300,400,700">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css?h=98a49735ed420ff1094cb21c75dd8271">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
    <link rel="stylesheet" href="assets/css/styles.min.css?h=a1c61629ef4cb4808c800b2efc363e31">
</head>

<style>
    #dataTable tr td {
        vertical-align: middle;
    }
</style>

<body id="page-top">
<div id="wrapper">
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content" style="margin-right: 10%;margin-left: 10%;margin-top: 5%;">

            <div id="VideoManager" style="margin-right: 10%;margin-left: 10%;margin-top: 5%;">
                <div class="container-fluid">
                    <h3 class="text-dark mb-4">视频管理</h3>
                    <div class="card shadow">
                        <div class="card-header py-3">
                            <p class="text-primary m-0 font-weight-bold">Videos Info</p>
                        </div>
                        <div class="card-body">
                            <div class="row text-center">
                                <div class="col-md-6 col-xl-5">
                                    <form action="<%=basePath%>Video/video_searchVideoBack" method="post">
                                        <div class="input-group">
                                            <input type="text" class="bg-light form-control-lg border-0 small"
                                                   placeholder="请输入视频名"
                                                   style="min-width: 200px;height: 40px;margin-top: 1%;margin-right: 10px;margin-bottom: 1%;"
                                                   name="video.video_title"/>
                                            <div class="input-group-append">
                                                <button class="btn btn-primary py-0" type="submit">
                                                    <i class="fas fa-search"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>

                                <div class="col-xl-2">
                                    <button class="btn btn-primary" type="button"
                                            onclick="window.location.href='<%=basePath%>Video/video_read'">显示全部
                                    </button>
                                </div>

                                <div class="col-xl-2">


                                    <button class="btn btn-primary" type="button" id="VideoAdd"
                                            onclick="VideoAddView_Show()">上传视频
                                    </button>
                                </div>
                            </div>

                            <div class="table-responsive table mt-2" role="grid" aria-describedby="dataTable_info">
                                <table class="table dataTable my-0" id="dataTable" border="1"
                                       style="text-align: center;vertical-align: center">

                                    <!--表头-->
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th>VID</th>
                                        <%--                                        <th>分类名</th>--%>
                                        <th>视频名</th>
                                        <th>封面</th>
                                        <th>简介</th>
                                        <th colspan="2">操作</th>
                                    </tr>
                                    </thead>
                                    <!--表头-->

                                    <!--表格-->
                                    <tbody>

                                    <c:if test="${videosList.size()!=0}">
                                        <c:forEach items="${videosList}" var="v">
                                            <form method="post" name="V_f_${v.video_id}">
                                                <tr>
                                                    <td><input type="checkbox"></td>
                                                    <td>
                                                        ${v.video_id}
                                                        <input type="hidden" name="video.video_id" value="${v.video_id}">
                                                    </td>
                                                    <td>
                                                        <input type="text" name="video.video_title" placeholder="${v.video_title}">
                                                    </td>
                                                    <td>
                                                        <img src="<%=basePath%>upload/${v.video_cover}">
                                                    </td>
                                                    <td>
                                                        <textarea name="video.video_desc" placeholder="${v.video_desc}"></textarea>
                                                    </td>
                                                    <td>
                                                        <button class="btn btn-primary" type="submit"
                                                                onclick="document.V_f_${v.video_id}.action='<%=basePath%>Video/video_videoUpdate'">
                                                            修改
                                                        </button>
                                                    </td>
                                                    <td>
                                                        <button class="btn btn-primary" type="submit"
                                                                onclick="document.V_f_${v.video_id}.action='<%=basePath%>Video/video_videoDelete'">
                                                            删除
                                                        </button>
                                                    </td>
                                                </tr>
                                            </form>
                                        </c:forEach>
                                    </c:if>

                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td colspan="7">
                                            <button class="btn btn-primary" type="button">批量删除</button>
                                        </td>
                                    </tr>
                                    </tbody>
                                    <!--表格-->

                                </table>
                            </div>

                            <div class="row">
                                <div class="col-md-6 col-xl-12">
                                    <div style="float: left">
                                        <button class="btn btn-primary" type="submit"
                                                onclick="window.location.href='<%=basePath%>index_background.jsp'">
                                            返回
                                        </button>
                                    </div>
                                    <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                                        <ul class="pagination">
                                            <li class="page-item disabled">
                                                <a class="page-link" href="#" aria-label="Previous">
                                                    <span aria-hidden="true">«</span>
                                                </a>
                                            </li>
                                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                                            <li class="page-item">
                                                <a class="page-link" href="#" aria-label="Next">
                                                    <span aria-hidden="true">»</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="VideoUpdate" style="margin-right: 10%;margin-left: 10%;">
                <div class="container-fluid">
                    <h3 class="text-dark mb-4">视频上传</h3>
                    <div class="card shadow">
                        <div class="card-header py-3">
                            <p class="text-primary m-0 font-weight-bold">Video Submit Info</p>
                        </div>
                        <div class="card-body">
                            <form method="post" action="<%=basePath%>Video/video_videoAdd"
                                  enctype="multipart/form-data">
                                <!--视频分类-->
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="text-align: center;">
                                            <h3>视频分类</h3>
                                            <select style="width: 185px" id="C_select" onchange="changeClass()">
                                                <option value="" selected disabled="disabled">请选择分类</option>
                                                <c:if test="${classList.size()!=0}">
                                                    <c:forEach items="${classList}" var="c">
                                                        <option value="${c.c_id}">${c.c_name}</option>
                                                    </c:forEach>
                                                </c:if>
                                                <input type="hidden" id="Class_id" name="classify.c_id">
                                                <script>
                                                    function changeClass() {
                                                        document.getElementById("Class_id").value = $('#C_select option:selected').val();
                                                        // alert(document.getElementById("Class_id").value);
                                                    }
                                                </script>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <!--视频名称-->
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="text-align: center;margin-top: 1%;margin-bottom: 1%;">
                                            <h3>视频名</h3>
                                            <input type="text" placeholder="请输入视频名称" name="video.video_title"/>
                                        </div>
                                    </div>
                                </div>

                                <!--视频简介-->
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="text-align: center;">
                                            <div style="text-align: center;vertical-align: middle;">
                                                <h3>视频简介</h3>
                                                <textarea name="video.video_desc" placeholder="输入该视频的简介"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!--封面-->
                                <div class="row">
                                    <div class="col-md-12 col-xl-12" style="text-align: center;">
                                        <div style="text-align: center;margin-top: 1%;margin-bottom: 1%;">
                                            <h3>视频封面</h3>
                                        </div>
                                        <input id="View_Img" type="file" onchange="read_Img(this)" accept="image/*"
                                               name="file"/>
                                    </div>
                                </div>

                                <!--视频-->
                                <div class="row">
                                    <div class="col-md-12 offset-xl-0" style="text-align: center;">
                                        <div style="text-align: center;margin-top: 1%;margin-bottom: 1%;">
                                            <h3>视频资源</h3>
                                        </div>
                                        <input id="View_Video" type="file" onchange="read_Video(this)" accept="video/*"
                                               name="file"/></div>
                                </div>

                                <!--按钮-->
                                <div class="row">
                                    <div class="col-md-12 col-xl-12 offset-xl-1" style="text-align: center;margin: 1%;">
                                        <button class="btn btn-primary" type="reset" onclick="ViewReset()">重置</button>
                                        <button class="btn btn-primary" type="submit" style="margin: 1%;">添加</button>
                                        <button class="btn btn-primary" type="button" id="backToVideos"
                                                onclick="VideoManagerView_show()">关闭
                                        </button>
                                    </div>
                                </div>

                                <!--实时展示-->
                                <div class="row">
                                    <div class="col-md-6" style="text-align: center;vertical-align: middle;">
                                        <h3>图片</h3>
                                        <img src="#" alt="" id="Viewimg">
                                    </div>
                                    <div class="col-md-6" style="text-align: center;">
                                        <h3>视频</h3>
                                        <video src="" id="Viewvideo" controls="controls"
                                               style="width: 400px;height: 200px"></video>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <footer class="bg-white sticky-footer">
            <div class="container my-auto">
                <div class="text-center my-auto copyright"><span>Copyright © NGU 2020</span></div>
            </div>
        </footer>
    </div>
    <a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a></div>

<script src="js/background/Video.js"></script>
<script src="assets/js/jquery.min.js?h=83e266cb1712b47c265f77a8f9e18451"></script>
<script src="assets/bootstrap/js/bootstrap.min.js?h=63715b63ee49d5fe4844c2ecae071373"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
<script src="assets/js/script.min.js?h=4283d98ce0b1a16c6767cde1db796ef8"></script>
</body>
<%--<s:debug/>--%>

</html>
