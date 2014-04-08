<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>  
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=basePath%>style/style.css"  type="text/css" rel="StyleSheet" />
<title>Administrator page</title>
</head>
<body>
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
	<h2> Welcome to administrator page: </h2>
	<div align="center">
	<b>Book: </b><br/>

	<a href="book!booklist.action">Book List: </a> <br/> <br/>


	<b>Topic: </b><br/>

	<a href="topic!list.action">Topic list</a> <br/> <br/>
	
	<b>Category: </b><br/>
	<a href="category!list.action">Category list</a> <br/> <br/>
	
	<b>Order: </b><br/>
	<a href="order!list.action">Order list</a> <br/> <br/>
	

</body>
</html>