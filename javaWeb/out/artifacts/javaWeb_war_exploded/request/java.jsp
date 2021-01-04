<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'input.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
       <p>这是java.jsp</p>
    <%
    String name = request.getParameter("name");
    //String name = (String)request.getAttribute("name1");
    //String name = (String)session.getAttribute("name");
    if(name!=null){
    name = new String(name.getBytes("iso-8859-1"),"gb2312");
    }
    out.println("<p>欢迎来到java课程："+name+"同学！</p>");
     %>

  </body>
</html>
