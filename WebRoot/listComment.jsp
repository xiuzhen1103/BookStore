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
    <title>Display all Books</title>
   
   <link type="text/css" href="<%=basePath%>style/style.css" rel="StyleSheet" />
	<link type="text/css" href="<%=basePath%>js/select2/select2.css" rel="StyleSheet" />
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/select2/select2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/select2/select2_locale_en.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/bookTopic.js"></script>

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
    <b>Display All Comments:</b>  
 <br> <br />
 			<a href="comment!add.action?bookId=<s:property value="%{bookId}" />">Comment</a>
<%-- 			<a href="addComment.jsp?bookId=<s:property value="%{bookId}"/>">Add Comment</a>  --%>
			<br /> <br />

 	 <table style="width:100%" width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">
 	 	 <tr>
		      <td width="5%" height="37" align="center"><b>Book Id</b></td>
		       <td width="5%" height="37" align="center"><b>Customer Name</b></td>
		      <td width="5%" height="37" align="center"><b>Rate</b></td>
		      <td width="40%" height="37" align="center"><b>Comment</b></td>
          </tr>
 	
          <s:iterator value="comments" id="c">
	      <tr bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor='#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
		  <td align="center" ><s:property value="#c.book.bookId" /></td>
		  <td align="center" ><s:property value="#c.customer.name" /></td>
		  <td align="center" ><s:property value="#c.rate" /></td>
		  <td align="center" ><s:property value="#c.comment" /></td>
        </tr>
     </s:iterator>
    </table>

  </body>
</html>
