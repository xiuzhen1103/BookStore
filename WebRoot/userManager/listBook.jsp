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
  
  <body>
 <br> <br />
 <s:form method="post" action="book!list.action">
  		<s:textfield label="Please Enter Book Title" name="book.title"></s:textfield>
  			<s:textfield label="Please Enter Job Category Name" name="book.category.categoryName"></s:textfield>
  				
  		<s:submit label="submit"/>
  			</s:form>
  			
  			   <a href="book!addBook.action">Add Book </a> 
  			   <br /> <br />

 	 <table style="width:100%" width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">
 	 	 <tr>
		      <td width="5%" height="37" align="center"><b>Book Id</b></td>
		      <td width="10%" height="37" align="center"><b>Title</b></td>
		      <td width="10%" height="37" align="center"><b>Author</b></td>
		      <td width="15%" height="37" align="center"><b>Price</b></td>
		      <td width="15%" height="37" align="center"><b>Quantity</b></td>
		      <td width="20%" height="37" align="center"><b>Category Name</b></td>
		      <td width="20%" height="37" align="center"><b>Image Path</b></td>
		      <td width="5%" height="37" align="center"><b>delete</b></td>
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
    	  <s:iterator value="books" id="b">
    	  
    	  </s:iterator>

    	  <td><a href="book!delete?book.bookId=<s:property value="#b.bookId" />">Delete</a></td>
    	  <td><a href="book!list?book.bookId=<s:property value="#b.bookId" />">Update</a></td>
    	  
    	  
        </tr>
     </s:iterator>
    </table>
    
  </body>
</html>
