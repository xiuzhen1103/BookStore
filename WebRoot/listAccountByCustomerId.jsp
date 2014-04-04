<%@ page language="java" import="java.util.*" 
contentType="text/html; charset=UTF-8" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

  <head>
    <base href="<%=basePath%>">
    <title>Display all Accounts</title>
    <link href="<%=basePath%>style/style.css"  type="text/css" rel="StyleSheet" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
 
    <b>Display All Accounts:</b>  
 <br> <br />
  <form method="post" action="book!list.action">
  Book Title:<input type="text" name="book.title"/>
  Category :<input type="text" name="book.category.categoryName"/>
  Topic Name:<input type="text" name="book.topic.name"/>
  	
  		<input type="submit" value="submit"/>
  	</form>

 	 <table style="width:100%" width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">
 	 	 <tr>
		      <td width="5%" height="37" align="center"><b>Account Id</b></td>
		      <td width="10%" height="37" align="center"><b>Shipping Address</b></td>
		      <td width="10%" height="37" align="center"><b>Payment Method</b></td>
		      <td width="5%" height="37" align="center"><b>Balance</b></td>
			 <td width="6%" height="37" align="center"><b>Delete</b></td>
			 <td width="6%" height="37" align="center"><b>Update</b></td>
          </tr>
 	
          <s:iterator value="accounts" id="a">
	      <tr bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor='#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
		  <td align="center" ><s:property value="#a.accountId" /></td>
		  <td align="center" ><s:property value="#a.shippingAddress" /></td>
		  <td align="center" ><s:property value="#a.paymentMethod" /></td>
		  <td align="center" ><s:property value="#a.balance" /></td>

           <td><a href="account!delete?account.accountId=<s:property value="#a.accountId" />">Delete</a></td>
           <td><a href="account!get?account.accountId=<s:property value="#a.accountId" />">Update</a></td>

        </tr>
     </s:iterator>
    </table>
    
  </body>
</html>
