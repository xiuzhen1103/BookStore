<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title> Add Book</title>
  </head>
  
  <body>
  <b>Add Book</b>
    <form method="post" action="book.action">
    	title:<input type="text" name="book.title"><br>
		Author:<input type="text" name="book.author"><br>
    	Price:<input type="text" name="book.price"><br>
    	Image Path:<input type="text" name="book.imagePath"><br>
    	
    	<table style="width:100%" width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">
 	 	 <tr>
		      <td colspan="2" width="5%" height="37" align="center"><b>Category</b></td>
		</tr>
		
    	 <s:iterator value="listCategory" id="cs">
	      <tr bgcolor="#EFF3F7" class="TableBody1" ">
	      <td><input type="radio" name="book.radioList" value="<s:property value="#cs.categoryId" />" /></td>
		  <td align="center" ><s:property value="#cs.categoryName" /></td>
		  
        </tr>
         </s:iterator>
       </table>
    	
    	<input type="submit" value="submit"/>
    </form>
  </body>
</html>
