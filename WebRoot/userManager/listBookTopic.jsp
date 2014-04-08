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
    <title>Display all Book Topic</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
 
  <body>
 
    <b>Display All Book Topic:</b>  
    <a href="userManager/addTopic.jsp">NOOOO </a> 
 <br> <br />

 	 <table style="width:100%" width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">
 	 	 <tr>
		      <td width="5%" height="37" align="center"><b>Book Topic Id</b></td>
		      <td width="10%" height="37" align="center"><b>Book Id</b></td>
		      <td width="10%" height="37" align="center"><b>Topic Id</b></td>

          </tr>
 	
          <s:iterator value="bookTopics" id="t">
	      <tr bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor='#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
		  <td align="center" ><s:property value="#t.bookTopicId" /></td>
		  <td align="center" ><s:property value="#t.book.bookId" /></td>
		  <td align="center" ><s:property value="#t.topic.topicId" /></td>
    	  <td><a href="bookTopic!delete?bookTopic.bookTopicId=<s:property value="#t.bookTopicId" />">Delete</a></td>
        </tr>
     </s:iterator>
    </table>
    

  </body>
</html>
