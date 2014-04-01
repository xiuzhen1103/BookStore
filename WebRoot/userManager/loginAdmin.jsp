<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="GB18030"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<title> Admin Login Page </title>
</head>
<body>


		<form action="adminLogin.action" method="post">
		  <h2>Administrator Login</h2>

		<label for="username">Username:</label>
		<input type="text" name="admin.username" tabindex="1" id="email">
		<br />
		<label for="password">Password:</label>
		<input type="password" id="password" name="admin.password" tabindex="2" />


<br />
<input type="submit" value="submit"/>
<p class="no-account">Haven't Register,Yet? <a href="addAdmin.jsp" class="reg-now">Register</a></p>
</form>


</body>
</html>