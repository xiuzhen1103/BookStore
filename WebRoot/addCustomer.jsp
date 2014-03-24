<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title> Customer Register</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  <b>Register</b>
    <form method="post" action="customer.action">
    	Use Name:<input type="text" name="customer.username"><br>
		Password:<input type="text" name="customer.password"><br>
    	Name:<input type="text" name="customer.name"><br>
    	Address:<input type="text" name="customer.address"><br>
    	Phone:<input type="text" name="customer.phone"><br>
    	<input type="submit" value="submit"/>
    </form>
  </body>
</html>
