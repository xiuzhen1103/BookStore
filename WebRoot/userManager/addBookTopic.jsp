<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title> Book Topic</title>
  </head>
  
  <body>
  <b>Add Book Topic</b>
  
    <form method="post" action="bookTopic.action">
		bookId:<input type="text" name="bookTopic.book.bookId"><br>
    	topicId:<input type="text" name="bookTopic.topic.topicId"><br>	
    	<input type="submit" value="submit"/>
    </form>
  </body>
</html>
