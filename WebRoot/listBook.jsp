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
 
    <b>Display All Books:</b>  
 <br> <br />
  <form method="post" action="book!list.action">
  Book Title:<input type="text" name="book.title"/>
  Category :<input type="text" name="book.category.categoryName"/>
  
    &nbsp;Book Topic:
  <select multiple id="topicId" name="book.checkBoxes" style="width:180px">
    <option></option>
  </select>
  	
  		<input type="submit" value="submit"/>
  	</form>

 	 <table style="width:100%" width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">
 	 	 <tr>
		      <td width="5%" height="37" align="center"><b>Book Id</b></td>
		      <td width="10%" height="37" align="center"><b>Title</b></td>
		      <td width="10%" height="37" align="center"><b>Author</b></td>
		      <td width="5%" height="37" align="center"><b>Price</b></td>
		      <td width="5%" height="37" align="center"><b>Quantity</b></td>
		      <td width="10%" height="37" align="center"><b>Category Name</b></td>
		      <td width="10%" height="37" align="center"><b>Image Path</b></td> 
			 <td width="30%" height="37" align="center"><b>Topics</b></td>
			 <td width="6%" height="37" align="center"><b>Add To Cart</b></td>
          </tr>
 	
          <s:iterator value="books" id="b">
	      <tr bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor='#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
		  <td align="center" ><s:property value="#b.bookId" /></td>
		  <td align="center" ><s:property value="#b.title" /></td>
		  <td align="center" ><s:property value="#b.author" /></td>
		  <td align="center" ><s:property value="#b.price" /></td>
		   <td align="center" ><s:property value="#b.quantity" /></td>
		  <td align="center" ><s:property value="#b.category.categoryName" /></td>
    	  <td align="center" ><s:property value="#b.imagePath" /></td>
		  <td align="center" >
             <s:iterator value="#b.bookTopics" var="bt" status="st">
                ${bt.topic.name} <s:if test="!#st.last">,</s:if>
             </s:iterator>
           </td>
           <td><a href="book!addToCart?book.bookId=<s:property value="#b.bookId" />">Add To Cart</a></td>

        </tr>
     </s:iterator>
    </table>

  </body>
</html>
