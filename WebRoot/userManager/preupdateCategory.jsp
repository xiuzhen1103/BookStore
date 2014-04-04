<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
  <p align="right">
Hello <s:property value="#session.customer.username"/><br/>
<a href="customer!get?customer.customerId=<s:property value="#session.customer.customerId"/> ">Profile</a>
<a href="book!listShoppingCart.action">Shopping Cart</a>
<a href="loginCustomer.jsp">Logout</a> 
</p> 
<div align="center" id="header">
  <h1><i>Book Store</i></h1>
  <div class="menu_20124162">
	<ul>
    	<li><a href="book!logged.action">Home</a></li>
        <li><a href="">About Us</a></li>
        <li><a href="">Contact Us</a></li>
    </ul>
</div>
</div>
  <body>
  <b>Update Category</b>
    <form method="post" action="updateCategory.action">
    	 Customer Id:<input type="text" name="category.categoryId" value="${category.categoryId}" readonly><br>
    	User Name:<input type="text" name="category.categoryName" value="${category.categoryName}"><br>
    	<input name="back" type="button" onclick="history.back()" value="Back" >
    	<input type="submit" value="submit"/>
    </form>
  </body>
</html>
