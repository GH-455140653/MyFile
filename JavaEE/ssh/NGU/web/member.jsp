<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/11/29
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>用户管理</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css?h=265ed69146e2e9fb7c056b1179deb510">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=ABeeZee">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aguafina+Script">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Comfortaa">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400|Roboto:300,400,700">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400|Roboto:300,400,700">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css?h=98a49735ed420ff1094cb21c75dd8271">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
    <link rel="stylesheet" href="assets/css/styles.min.css?h=990709496d501640419db69e248acd30">
</head>
<body id="page-top">
<div id="wrapper">
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <div class="container-fluid" style="margin-top: 100px;padding: 0 10% 0 10%">
                <h3 class="text-dark mb-4">用户管理</h3>
                <div class="card shadow">
                    <div class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold">Member Info</p>
                    </div>
                    <div class="card-body">

                        <div class="row text-center">
                            <div class="col-md-6 col-xl-5">
                                <form action="<%=basePath%>User/member_searchMember" method="post" onsubmit="return searchMember()">
                                    <div class="input-group">
                                        <input class="search-text bg-light form-control-lg border-0 small" type="text"
                                               name="member.member_name" placeholder="根据用户昵称搜索" id="searchInput"
                                               style="min-width: 200px;height: 40px;margin-top: 1%;margin-right: 10px;margin-bottom: 1%;">
                                        <div class="input-group-append">
                                            <button class="search btn btn-primary py-0" type="submit">
                                                <i class="fas fa-search">搜索</i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>

                            <div class="col-xl-2">
                                <form id="myForm" action="<%=basePath%>User/member_getAllMember">
                                    <button class="btn btn-primary" type="submit">查询全部用户信息</button>
                                </form>
                            </div>
                        </div>

                        <div class="table-responsive table mt-2" role="grid" aria-describedby="dataTable_info">
                            <table class="table dataTable my-0" id="dataTable"
                                   style="text-align: center;vertical-align: center">

                                <thead>
                                <tr>
                                    <td></td>
                                    <td>ID</td>
                                    <td>账号</td>
                                    <td>昵称</td>
                                    <td>注册时间</td>
                                </tr>
                                </thead>

                                <tbody>
                                <form>
                                    <c:if test="${membersList.size()!=0}">
                                        <%int count = 0;%>
                                        <c:forEach items="${membersList}" var="m">
                                            <%count++;%>
                                            <tr>
                                                <td><input type="checkbox" name="userChecked"
                                                           value="${m.member_account}"></td>
                                                <td><%=count%>
                                                </td>
                                                <td>${m.member_account}</td>
                                                <td>${m.member_name}</td>
                                                <td>${m.member_borndate}</td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                </form>
                                <tr>
                                    <form id="deleteForm">
                                        <td>
                                            <input type="checkbox" id="selectAll" onclick="usersCheckedAll()"/>
                                        </td>
                                        <td style="text-align: center">
                                            <button class="btn btn-primary" onclick="DeleteSelectMember()">
                                                删除
                                            </button>
                                            <input type="hidden" id="tempString" name="tempString"/>
                                        </td>
                                        <td colspan="3"></td>
                                    </form>
                                </tr>
                                </tbody>
                            </table>
                        </div>

                        <div class="row">
                            <div class="col-md-6 col-xl-12">
                                <div style="float: left">
                                    <button class="btn btn-primary" onclick="window.location.href='<%=basePath%>index_background.jsp'">
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
        <footer class="bg-white sticky-footer">
            <div class="container my-auto">
                <div class="text-center my-auto copyright"><span>Copyright © NGU 2020</span></div>
            </div>
        </footer>
    </div>

    <a class="border rounded d-inline scroll-to-top" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
</div>
<script src="assets/js/jquery.min.js?h=83e266cb1712b47c265f77a8f9e18451"></script>
<script src="assets/bootstrap/js/bootstrap.min.js?h=63715b63ee49d5fe4844c2ecae071373"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
<script src="assets/js/script.min.js?h=68260d362a72ee2d89c5f268b9d73b31"></script>
<script src="js/background/Member.js"></script>
</body>
</html>
