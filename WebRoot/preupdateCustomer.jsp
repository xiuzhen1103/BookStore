<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>Update Customer</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
  

  <a href="addAccount.jsp">Add Account</a> 
   <a href="account!list.action">List Account</a> 

     <form method="post" action="updateCustomer">
    	Customer Id:<input type="text" name="customer.customerId" value="<s:property value='customer.customerId'/>" readonly><br>
    	User Name:<input type="text" name="customer.username" value="<s:property value='customer.username'/>"><br>
    	Name:<input type="text" name="customer.name" value="<s:property value='customer.name'/>"><br>
    	Address:<input type="text" name="customer.address" value="<s:property value='customer.address'/>"><br>
    	Phone:<input type="text" name="customer.phone" value="<s:property value='customer.phone'/>"><br>
    	<input name="back" type="button" onclick="history.back()" value="Back" >
    	<input type="submit" value="submit"/>
    </form>
  </body>
</html>
