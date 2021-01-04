<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/11/29
  Time: 16:52
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
    <meta charset="UTF-8">
    <title>分类管理</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css?h=6b782e1cd0ca20a7e512b6f7c75d6bfe">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
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

            <div id="ClassifyManager" style="margin-right: 10%;margin-left: 10%;margin-top: 5%;">
                <div class="container-fluid">
                    <h3 class="text-dark mb-4">分类管理</h3>
                    <div class="card shadow">
                        <div class="card-header py-3">
                            <p class="text-primary m-0 font-weight-bold">Classify Info</p>
                        </div>
                        <div class="card-body">
                            <div class="row text-center">
                                <div class="col-md-6 col-xl-5">
                                    <div class="input-group">
                                        <form action="<%=basePath%>Classify/classify_add" method="post">
                                            <input type="text" class="bg-light form-control-lg border-0 small"
                                                   placeholder="请输入分类名"
                                                   name="classify.c_name"
                                                   style="min-width: 200px;height: 40px;margin-top: 1%;margin-bottom: 1%;"/>
                                            <button class="btn btn-primary" type="submit">添加</button>
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <div class="table-responsive table mt-2" role="grid"
                                 aria-describedby="dataTable_info">
                                <table class="table dataTable my-0" id="dataTable" border="1"
                                       style="text-align: center;vertical-align: center">

                                    <!--表头-->
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th>分类名</th>
                                        <th colspan="2">操作</th>
                                    </tr>
                                    </thead>
                                    <!--表头-->

                                    <!--表格-->
                                    <tbody>
                                    <c:if test="${classList.size()!=0}">
                                        <c:forEach items="${classList}" var="c">
                                            <form method="post" name="C_f_${c.c_id}">
                                                <tr>
                                                    <td><input type="checkbox"></td>
                                                    <td>
                                                        <input type="text" name="classify.c_name"
                                                               placeholder="${c.c_name}">
                                                        <input type="hidden" name="classify.c_id" value="${c.c_id}">
                                                    </td>
                                                    <td>
                                                        <button class="btn btn-primary" type="submit"
                                                                onclick="document.C_f_${c.c_id}.action='<%=basePath%>Classify/classify_update'">
                                                            修改
                                                        </button>
                                                    </td>
                                                    <td>
                                                        <button class="btn btn-primary" type="submit"
                                                                onclick="document.C_f_${c.c_id}.action='<%=basePath%>Classify/classify_delete'">
                                                            删除
                                                        </button>
                                                    </td>
                                                </tr>
                                            </form>
                                        </c:forEach>
                                    </c:if>

                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td colspan="4">
                                            <button class="btn btn-primary" type="button">批量删除</button>
                                        </td>
                                    </tr>
                                    </tbody>
                                    <!--表格-->

                                    <!--表脚-->
                                    <tfoot>
                                    <tr>
                                        <th></th>
                                        <th>分类名</th>
                                        <th colspan="2">操作</th>
                                    </tr>
                                    </tfoot>
                                    <!--表脚-->

                                </table>
                            </div>

                            <div class="row">
                                <div class="col-md-6 col-xl-12">
                                    <div style="float: left">
                                        <button class="btn btn-primary" type="button"
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
