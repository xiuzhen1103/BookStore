<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title> Add Category</title>
    <link href="<%=basePath%>style/style.css"  type="text/css" rel="StyleSheet" />
  </head>



  <body>
  
  <p align="right">
Hello <s:property value="#session.admin.username"/><br/>
<a href="admin!logout.action">Logout</a>
 <body>
</p> 
<div align="center" id="header">
  <h1><i>Book Store</i></h1>
  <div class="menu_20124162">
	<ul>

    	<li><a href="userManager/admin.jsp">Home</a></li>

        <li><a href="">About Us</a></li>
        <li><a href="">Contact Us</a></li>
    </ul>
</div>
</div>

 
  <b>Update Category</b>
    <form method="post" action="updateCategory.action">
    	 Customer Id:<input type="text" name="category.categoryId" value="${category.categoryId}" readonly><br>
    	User Name:<input type="text" name="category.categoryName" value="${category.categoryName}"><br>
    	<input name="back" type="button" onclick="history.back()" value="Back" >
    	<input type="submit" value="submit"/>
    </form>
  </body>
</html>
