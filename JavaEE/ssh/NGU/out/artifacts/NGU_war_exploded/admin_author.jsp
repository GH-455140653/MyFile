<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/11/21
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title></title>
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
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.0/js/bootstrap.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>


</head>

<body id="page-top">
<div id="wrapper">
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <div class="container-fluid" style="margin-top: 100px;padding: 0 10% 0 10%">
                <h3 class="text-dark mb-4">权限管理</h3>
                <div class="card shadow">
                    <div class="card-header py-3">
                        <!--                             <p class="text-primary m-0 font-weight-bold">author Info</p> -->
                        <a href="<%=basePath%>index_background.jsp">返回</a>
                    </div>
                    <div class="card-body">
                        <div class="admin-top">

                            <form action="<%=basePath%>Admin/admin_add" method="post">
                                <table>
                                    <tr style="width:100%;">
                                        <td style="width:150px;">
                                            <select id="one-Rsleect" class="one-Rsleect"
                                                    onchange="changeClass()">
                                                <c:choose>
                                                    <c:when test="${adminList.size()!=0}">
                                                        <option value="" selected disabled="disabled">请选择</option>
                                                        <c:forEach items="${adminList}" var="admin">
                                                            <option value="${admin.admin_account}">${admin.admin_account}</option>
                                                        </c:forEach>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="" selected disabled="disabled">请选择</option>
                                                    </c:otherwise>
                                                </c:choose>
                                                <script>
                                                    function changeClass() {
                                                        document.getElementById("Admin_id").value = $('#one-Rsleect option:selected').val();
                                                        // alert(document.getElementById("Class_id").value);
                                                    }
                                                </script>
                                                <input type="hidden" id="Admin_id" name="Admin.admin_account"
                                                       value="${Admin.admin_account}"/>
                                            </select>
                                        </td>
                                        <td><input type="text" name="Admin.admin_desc" placeholder="职责简介" value=""/>
                                        </td>
                                        <td style="width:100px;padding:0 50px;"><input type="submit" value="添加" class="btn btn-primary"/></td>
                                    </tr>
                                </table>
                            </form>
                        </div>

                        <div class="table-responsive table mt-2" id="dataTable" role="grid"
                             aria-describedby="dataTable_info">
                            <table class="table dataTable my-0">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" name="boxname" id="all"
                                               onclick="cli('boxname')" value="checkbox"/></th>
                                    <th>昵称</th>
                                    <th>描述</th>
                                    <th>修改描述</th>
                                    <th>操作</th>
                                    <th>权限展示</th>
                                    <th>权限分配</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${AdminList!=null}">
                                    <c:forEach items="${AdminList}" var="Admin" begin="${(pageNos-1)*2}"
                                               end="${pageNos*2-1}">

                                        <form method="post" name="adminmethod${Admin.admin_account}"
                                              id="adminmethod${Admin.admin_account}">
                                            <tr>
                                                <td><input type="checkbox" name="boxname"
                                                           value="${Admin.admin_account}"/>
                                                </td>
                                                <td>${Admin.admin_name}</td>
                                                <td>${Admin.admin_desc}</td>
                                                <td><input type="text" name="Admin.admin_desc" value=""/></td>
                                                <input type="hidden" name="Admin.admin_account"
                                                       value="${Admin.admin_account}"/>
                                                <td><input type="submit" value="修改" class="btn btn-primary"
                                                           onclick="document.adminmethod${Admin.admin_account}.action='<%=basePath%>Admin/admin_update'"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <input type="submit" value="删除"
                                                           onclick="document.adminmethod${Admin.admin_account}.action='<%=basePath%>Admin/admin_delete'" class="btn btn-primary"/>
                                                </td>
                                                <td>
                                                    <c:if test="${PowerList!=null}">
                                                        <c:forEach items="${PowerList}" var="Power">
                                                            <span>${Power.power_name}</span>
                                                        </c:forEach>
                                                    </c:if>
                                                </td>
                                                <td>
                                                    <input type="hidden" id="Admin_power" name="powers" value=""/>
                                                    <input type="button" value="权限分配" onclick="xx('${Admin.admin_account}')" class="btn btn-primary"/>
                                                </td>
                                                <td>
                                                    <select class="selectpicker" multiple onchange="changeClass()"
                                                            id="${Admin.admin_account}selectpower">
                                                        <option value="2">评论管理</option>
                                                        <option value="3">用户管理</option>
                                                        <option value="4">报表管理</option>
                                                        <option value="5">视频管理</option>
                                                        <option value="6">分类管理</option>
                                                    </select>
                                                    <script>
                                                        function xx(x) {
                                                            var formName = "adminmethod" + x;
                                                            var powerName = "#" + x + "selectpower";
                                                            var powers = $(powerName).val();
                                                            // alert(powers);
                                                            // alert(formName);
                                                            var s = document.getElementById(formName);
                                                            var path = '<%=basePath%>Admin/admin_apport?powers=' + powers;
                                                            // alert(path);
                                                            // alert(s);
                                                            s.action = path;
                                                            s.submit();
                                                        }
                                                    </script>
                                            </tr>
                                        </form>
                                    </c:forEach>
                                </c:if>
                                </tbody>
                                <tfoot>
                                <%--                                 <td colspan="3" align="center"><c:if test="${pageNos>1}"> --%>

                                <%--                                     <a href="<%=basePath%>Admin/admin_authorPagination?pageNos=1">首页</a> --%>
                                <%--                                     <a href="<%=basePath%>Admin/admin_authorPagination?pageNos=${pageNos-1 }">上一页</a> --%>
                                <%--                                 </c:if> <c:if test="${pageNos<countPage}"> --%>
                                <%--                                     <a href="<%=basePath%>Admin/admin_authorPagination?pageNos=${pageNos+1 }">下一页</a> --%>
                                <%--                                     <a href="<%=basePath%>Admin/admin_authorPagination?pageNos=${countPage }">末页</a> --%>
                                <%--                                 </c:if> --%>
                                <td colspan="3" align="center">

                                    <%--                                     <form action="<%=basePath%>Admin/admin_authorPagination" method="post"> --%>
                                    <%--                                         共${countPage}页跳转到第几<input type="text" name="pageNos">页 --%>
                                    <!--                                         <input type="submit" value="go"> -->
                                    <!--                                     </form> -->
                                </td>
                                <td><input type="button" value="批量删除" onclick="deleAll('boxname')" class="btn btn-primary"/>
                                </td>
                                <td colspan="5">
                                    <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                                        <ul class="pagination">
                                            <li class="page-item active"><a class="page-link" href="<%=basePath%>Admin/admin_authorPagination?pageNos=1">首页</a></li>
                                            <li class="page-item"><a class="page-link" href="<%=basePath%>Admin/admin_authorPagination?pageNos=${pageNos-1 }">上一页</a></li>
                                            <li class="page-item"><a class="page-link" href="<%=basePath%>Admin/admin_authorPagination?pageNos=${pageNos+1 }">下一页</a></li>
                                            <li class="page-item active">
                                                <a class="page-link" href="<%=basePath%>Admin/admin_authorPagination?pageNos=${countPage }">尾页</a>
                                            </li>
                                        </ul>
                                    </nav>
                                </td>
                                </tfoot>
                            </table>
                            <script type="text/javascript">
                                /* 全选 */
                                function cli(Obj) {
                                    var collid = document.getElementById("all")
                                    var coll = document.getElementsByName(Obj)
                                    if (collid.checked) {
                                        for (var i = 1; i < coll.length; i++)
                                            coll[i].checked = true;
                                    } else {
                                        for (var i = 1; i < coll.length; i++)
                                            coll[i].checked = false;
                                    }
                                }

                                /*批量删除  */
                                function deleAll(Obj) {
                                    var check = document.getElementsByName(Obj);
                                    var len = check.length;
                                    var idAll = ""
                                    for (var i = 1; i < len; i++) {
                                        if (check[i].checked) {
                                            //idAll[i] = check[i].value;
                                            idAll = idAll + check[i].value + ",";
                                        }
                                    }
                                    window.location.href = "<%=basePath%>Admin/admin_deleteAll?idAll=" + idAll;
                                }
                            </script>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="bg-white sticky-footer">
            <div class="container my-auto">
                <div class="text-center my-auto copyright"><span>Copyright © Brand 2019</span></div>
            </div>
        </footer>
    </div>
    <a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a></div>
<script src="assets/bootstrap/js/bootstrap.min.js?h=63715b63ee49d5fe4844c2ecae071373"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
<script src="assets/js/script.min.js?h=68260d362a72ee2d89c5f268b9d73b31"></script>
</body>

</html>
