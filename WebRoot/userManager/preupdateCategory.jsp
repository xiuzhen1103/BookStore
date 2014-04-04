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
<<<<<<< HEAD
  <p align="right">
Hello <s:property value="#session.customer.username"/><br/>
<a href="customer!get?customer.customerId=<s:property value="#session.customer.customerId"/> ">Profile</a>
<a href="book!listShoppingCart.action">Shopping Cart</a>
<a href="loginCustomer.jsp">Logout</a> 
=======


  <body>
  
  <p align="right">
Hello <s:property value="#session.admin.username"/><br/>
<a href="admin!logout.action">Logout</a>
>>>>>>> 82bb03b2ad8310ecfe595292aa7459bad4a4b15f
</p> 
<div align="center" id="header">
  <h1><i>Book Store</i></h1>
  <div class="menu_20124162">
	<ul>
<<<<<<< HEAD
    	<li><a href="book!logged.action">Home</a></li>
=======
    	<li><a href="userManager/admin.jsp">Home</a></li>
>>>>>>> 82bb03b2ad8310ecfe595292aa7459bad4a4b15f
        <li><a href="">About Us</a></li>
        <li><a href="">Contact Us</a></li>
    </ul>
</div>
</div>
<<<<<<< HEAD
  <body>
  <b>Update Category</b>
    <form method="post" action="updateCategory.action">
    	 Customer Id:<input type="text" name="category.categoryId" value="${category.categoryId}" readonly><br>
    	User Name:<input type="text" name="category.categoryName" value="${category.categoryName}"><br>
=======
  <b>add Category</b>
    <form method="post" action="updateCategory.action">
    	 Customer Id:<input type="text" name="category.categoryId" value="<s:property value='category.categoryId'/>" readonly><br>
    	User Name:<input type="text" name="category.categoryName" value="<s:property value='category.categoryName'/>"><br>
>>>>>>> 82bb03b2ad8310ecfe595292aa7459bad4a4b15f
    	<input name="back" type="button" onclick="history.back()" value="Back" >
    	<input type="submit" value="submit"/>
    </form>
  </body>
</html>
