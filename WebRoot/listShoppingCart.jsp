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
    <link href="<%=basePath%>style/style.css"  type="text/css" rel="StyleSheet" />
    <title>Display All Books</title>

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
  
 <br />
    <b>Display Shopping Cart:</b>  
 <br> <br />
 <s:form action="book!pay.action" method="post">
 	 <table style="width:100%" width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">
 	 	 <tr>
		      <td width="5%" height="37" align="center"><b>Book Id</b></td>
		      <td width="10%" height="37" align="center"><b>Title</b></td>
		      <td width="10%" height="37" align="center"><b>Author</b></td>
		      <td width="15%" height="37" align="center"><b>Price</b></td>
		      <td width="15%" height="37" align="center"><b>Quantity</b></td>
		      <td width="20%" height="37" align="center"><b>Category Name</b></td>
		      <td width="20%" height="37" align="center"><b>Image Path</b></td>
          </tr>
			<s:iterator value="listBooks" id="b" status="stat">
				<tr bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor='#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
					<s:hidden name="requestBooks[%{#stat.index}].bookId" value="%{listBooks[#stat.index].bookId}"/>
					<s:hidden name="requestBooks[%{#stat.index}].price" value="%{listBooks[#stat.index].price}"/>
					<%-- 			       <s:textfield label="Name" name="listBooks[%{#stat.index}].name" value="%{listBooks[#stat.index].name}"/> --%>
					<td align="center" ><s:property value="#b.bookId" /></td>
					<td align="center" ><s:property value="#b.title" /></td>
					<td align="center" ><s:property value="#b.author" /></td>
					<td align="center" ><s:property value="#b.price" /></td>
					<td align="center" >
					<s:set var="quantity" value="listBooks[%{#stat.index}].quantity"></s:set>
						<s:textfield id="listBooks%{#stat.index}" 
						 name="requestBooks[%{#stat.index}].quantity" value="1" 
						 theme="simple" onchange="javascript:;checkNum(this, this.value, '%{quantity}');"/>
					</td>
					<td align="center" ><s:property value="#b.category.categoryName" /></td>
					<td align="center" ><s:property value="#b.imagePath" /></td>
					<br/>
				</tr>
			</s:iterator>
			<tr>
				<td colspan="7">
					<div align="center">
						<input type="submit" value="付款Pay" style="height: 50px; width: 90px; font-size: 20px;">
					</div>
				</td>
			</tr>
    </table>
</s:form> 
	<SCRIPT type="text/javascript" src="js/jquery-1.8.3.js"></SCRIPT>
    <script type="text/javascript">
	    function checkNum(obj, num, quantity){
	    	var numN = parseInt(num);
	    	var quantityN = parseInt(quantity);
	        if(numN > quantityN){
	            alert("本书只剩下" + quantity + "本，超出该书数量，请重新输入！");
	            var ids = obj.id;
	            $("#"+ids).val(1);
	        }else{
	            return true;
	        }
	    }
    </script>
  </body>
</html>
