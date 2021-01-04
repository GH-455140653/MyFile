<%--
  Created by IntelliJ IDEA.
  User: lrl
  Date: 2020/5/22
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>输出页面</title>
</head>
<body>
<%!
    int time = 0;
%>
<%
    String name = request.getParameter("name");
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    if (title != null && content != null) {
        title = new String(title.getBytes("iso-8859-1"), "utf-8");
        content = new String(content.getBytes("iso-8859-1"), "utf-8");
        name = new String(name.getBytes("iso-8859-1"), "utf-8");
        if (!title.equals("") && !content.equals("")) {
            time++;

            String message = "No." + time + "<br>" + "姓名：" + name + "<br>" + "标题:" + title + "<br>" + "内容:" + content;
            ArrayList messList = (ArrayList) application.getAttribute("message");
            if (messList == null) {
                messList = new ArrayList();
            }
            messList.add(message);
            application.setAttribute("message", messList);
            ArrayList list = (ArrayList) (application.getAttribute("message"));
            for (Object value : list) {
                String str = (String) value;
                out.print("<br>" + str);
                out.print("<hr>");
            }
        } else {
            out.println("标题和内容都要输入才能留言！");
        }
    } else {
        ArrayList list = (ArrayList) (application.getAttribute("message"));
        if (list == null) {
            out.println("还没有人来留言，快来说说吧！");
        } else {
            for (Object value : list) {
                String str = (String) value;
                out.print("<br>" + str);
                out.print("<hr>");
            }
        }
    }
%>
<a href="handle.jsp">继续留言</a>
</body>
</html>
