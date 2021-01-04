<%@ page language="java" import="java.util.*,java.net.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'output.jsp' starting page</title>
    
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
    <%
    String name = request.getParameter("name");
    
    //byte[] b = name.getBytes("iso-8859-1");
    //name = new String(b,"gb2312");
     name = new String(name.getBytes("iso-8859-1"),"gb2312");
     String message="";
	String age = request.getParameter("age");
	
	int ageN=0;
	try{
	  ageN = Integer.parseInt(age);
	}catch(Exception e){
	  //跳转回input页面
	 %> 
	 <jsp:forward page="input.jsp">
	   <jsp:param name="message" value="please input right age!!!!!!!!"/>
	 </jsp:forward>
	<%
	}
	ageN++;
 	out.println(name+"<br/>"+age);
 	String sex = request.getParameter("sex");
 	try{
 	sex = new String(sex.getBytes("iso-8859-1"),"gb2312");
 	}catch(Exception e){
 	  message="请选择你的性别！";
 	  message=URLEncoder.encode(message);
 	  %> 
	 <jsp:forward page="input.jsp">
	   <jsp:param name="message" value="<%=message %>"/>
	 </jsp:forward>
	<% 
 	}
 	out.println("<br/>"+sex);

        %>  </body>
</html>
