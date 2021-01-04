<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/11/18
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>上传与下载测试</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<script src="./js/foreground/RegexValidate.js"></script>
<body>
<script>
    if (window.name === "") {
        console.log("首次被加载");
        window.name = "isReload";  // 在首次进入页面时我们可以给window.name设置一个固定值
        window.location.href = "<%=basePath%>Function/function_pageRefresh"
    } else if (window.name === "isReload") {
        console.log("页面被刷新");
    }
</script>
<div align="center">
    <!-- 上传文件需要设置表单属性为 method="post" enctype="multipart/form-data" -->
    <form action="<%=basePath%>Function/function_upload" method="post" enctype="multipart/form-data">
        <table style="border-collapse:separate; border-spacing:0px 10px;">
            <tr>
                <td>图片文件：</td>
                <td><input type="file" name="file"></td>
            </tr>
            <tr>
                <td>视频文件：</td>
                <td><input type="file" name="file"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="上传"/></td>
            </tr>
        </table>
    </form>
    <br>

    <div>
        <%--通过代码片for循环修改图片scr以及filename的名字实现下载不同的文件。--%>
        <c:if test="${videoName.size()!=0}">
            <c:forEach items="${videoName}" var="video">
                <s:div>${videoName}</s:div>
                <span>${video.video_name}</span>
                <div>
                    <button onclick="window.location=
                            encodeURI(encodeURI('<%=basePath%>Function/function_download?fileName=${video.video_name}'))">
                        下载
                    </button>
                </div>
                <div id="main"></div>
                <script>
                    var box = document.getElementById("main");
                    if (isPhoto("${video.video_name}")) {
                        console.log(isPhoto("${video.video_name}"));
                        var node = document.createElement("img");
                        node.setAttribute("src", "<%=basePath%>/upload/${video.video_name}");
                        box.appendChild(node);
                    } else {
                        var video = document.createElement("video");
                        video.setAttribute("controls", "controls");
                        video.style.display = "block";
                        var source = document.createElement("source");
                        source.setAttribute("src", "<%=basePath%>/upload/${video.video_name}");
                        video.appendChild(source);
                        box.appendChild(video);
                    }
                </script>
            </c:forEach>
        </c:if>
    </div>
    <s:debug/>
</div>

</body>
</html>
