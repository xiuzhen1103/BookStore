<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title> add Topic</title>
     <link href="<%=basePath%>style/style.css"  type="text/css" rel="StyleSheet" />
  </head>
   <p align="right">
Hello <s:property value="#session.admin.username"/><br/>
<a href="admin!logout.action">Logout</a>
</p> 
<div align="center" id="header">
  <h1><i>Book Store</i></h1>
  <div class="menu_20124162">
	<ul>
    	<li><a href="admin.jsp">Home</a></li>
        <li><a href="">About Us</a></li>
        <li><a href="">Contact Us</a></li>
    </ul>
</div>
</div>
  <body>
  <b>add Topic</b>
    <form method="post" action="topic.action">
    	 Name:<input type="text" name="topic.name"><br>
    	<input type="submit" value="submit"/>
    </form>
  </body>
</html>
