<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title> Customer Register</title>
  </head>
  
  <body>
  <b>add Topic</b>
    <form method="post" action="topic.action">
    	 Name:<input type="text" name="topic.name"><br>
    	<input type="submit" value="submit"/>
    </form>
  </body>
</html>
