<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/11/29
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>评论管理</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css?h=265ed69146e2e9fb7c056b1179deb510">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=ABeeZee">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aguafina+Script">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Comfortaa">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400|Roboto:300,400,700">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400|Roboto:300,400,700">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css?h=98a49735ed420ff1094cb21c75dd8271">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
    <link rel="stylesheet" href="assets/css/styles.min.css?h=990709496d501640419db69e248acd30">
    <script src="./js/foreground/dateTimeHandle.js"></script>
</head>
<script type="text/javascript">

</script>
<body id="page-top">
<div id="wrapper">
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <div class="container-fluid" style="margin-top: 100px;padding: 0 10% 0 10%">
                <h3 class="text-dark mb-4">评论管理</h3>
                <div class="card shadow">
                    <div class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold">Comment Info</p>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive table mt-2" role="grid" aria-describedby="dataTable_info">
                            <table class="table dataTable my-0" id="dataTable"
                                   style="text-align: center;vertical-align: middle">
                                <tr>
                                    <th></th>
                                    <th>ID</th>
                                    <th>用户</th>
                                    <th>视频ID</th>
                                    <th>内容</th>
                                    <th>时间</th>

                                </tr>
                                <c:if test="${commentList!=null}">
                                    <c:forEach items="${commentList}" var="c" begin="${(pageNos-1)*2}"
                                               end="${pageNos*2-1}">
                                        <tr>
                                            <td><input type="checkbox" name="Ccheck" value=${c.comment_id}>
                                            </td>
                                            <td>${c.comment_id}</td>              <!-- 评论id -->
                                            <td>${c.member_account}</td>          <!-- 发表该评论的用户 -->
                                            <td>${c.video_id}</td>                <!-- 视频id -->
                                            <td>${c.comment_text}</td>            <!-- 评论内容 -->
                                            <td>
                                                <fmt:formatDate value="${c.comment_post}" pattern="yyyy-MM-dd HH:mm:ss" />
                                            </td>                                 <!-- 评论时间 -->
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                <tr>
                                    <td><input type="checkbox" id="Cselectall" onclick="commentCheckAll(this)"/></td>
                                    <td colspan="5" style="text-align: left">
                                        <form id="deleteForm">
                                            <button class="btn btn-primary" type="submit"
                                                    onclick="DeleteSelectMember()">
                                                删除
                                            </button>
                                            <input type="hidden" id="tempString" name="tempString"/>
                                        </form>
                                    </td>
                                </tr>
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
                                        <li class="page-item active">
                                            <a class="page-link"
                                               href="<%=basePath%>Comment/comment_commentPagination?pageNos=1">首页</a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link"
                                               href="<%=basePath%>Comment/comment_commentPagination?pageNos=${pageNos-1}">上一页</a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link"
                                               href="<%=basePath%>Comment/comment_commentPagination?pageNos=${pageNos+1}">下一页</a>
                                        </li>
                                        <li class="page-item active">
                                            <a class="page-link"
                                               href="<%=basePath%>Comment/comment_commentPagination?pageNos=${countPage}">尾页</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
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

<script type="text/javascript" src="js/background/Comment.js"></script>
<script src="assets/js/jquery.min.js?h=83e266cb1712b47c265f77a8f9e18451"></script>
<script src="assets/bootstrap/js/bootstrap.min.js?h=63715b63ee49d5fe4844c2ecae071373"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
<script src="assets/js/script.min.js?h=68260d362a72ee2d89c5f268b9d73b31"></script>
</body>
</html>
