<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title> Update Topic</title>
    <link href="<%=basePath%>style/style.css"  type="text/css" rel="StyleSheet" />
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
  <b>Update Topic</b>
    <form method="post" action="updateTopic">
<<<<<<< HEAD
  		Topic Id:<input type="text" name="topic.topicId" value="${topic.topicId}" ><br>
    	Topic Name:<input type="text" name="topic.name" value="${topic.name}"><br>
=======
  		Topic Id:<input type="text" name="topic.topicId" value="<s:property value='topic.topicId'/>" ><br>
    	Topic Name:<input type="text" name="topic.name" value="<s:property value='topic.name'/>"><br>
>>>>>>> 82bb03b2ad8310ecfe595292aa7459bad4a4b15f
    	<input name="back" type="button" onclick="history.back()" value="Back" >
    	<input type="submit" value="submit"/>
    </form>
  </body>
</html>
