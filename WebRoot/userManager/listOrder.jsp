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
    <title>Display All Topics</title>
    <link href="<%=basePath%>style/style.css"  type="text/css" rel="StyleSheet" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
    	<li><a href="userManager/admin.jsp">Home</a></li>
        <li><a href="">About Us</a></li>
        <li><a href="">Contact Us</a></li>
    </ul>
</div>
</div>
 <br />
    <b>Display All Orders:</b>  
 <br> <br />

 	 <table style="width:100%" width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">
 	 	 <tr>
		      <td width="5%" height="37" align="center"><b>Order Id</b></td>
		      <td width="10%" height="37" align="center"><b>Quantity</b></td>
		      <td width="10%" height="37" align="center"><b>Account Id</b></td>
		      <td width="10%" height="37" align="center"><b>Customer Name</b></td>
		       <td width="10%" height="37" align="center"><b>Order Detail</b></td>


          </tr>
 	
          <s:iterator value="orders" id="o">
	      <tr bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor='#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
		  <td align="center" ><s:property value="#o.orderId" /></td>
		  <td align="center" ><s:property value="#o.quantity" /></td>
		  <td align="center" ><s:property value="#o.account.accountId" /></td>
		  <td align="center" ><s:property value="#o.customer.name" /></td>
    	<td align="center" ><a href="orderItem!list?orderId=${o.orderId}">Order Detail</a></td>
        </tr>
     </s:iterator>
    </table>
    <br />
    <input name="back" type="button" onclick="history.back()" value="Back" >
  </body>
</html>
