<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title> Add Category</title>
  </head>
  
  <body>
  <b>add Category</b>
    <form method="post" action="updateCategory">
    Category Id:<input type="text" name="category.categoryId"><br>
    	 Name:<input type="text" name="category.categoryName"><br>
    	<input type="submit" value="submit"/>
    </form>
  </body>
</html>
