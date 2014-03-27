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
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
 
  <body>
 
    <b>Display All Books:</b>  
    <a href="userManager/addTopic.jsp">Add Topic </a> 
 <br> <br />

 	 <table style="width:100%" width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">
 	 	 <tr>
		      <td width="5%" height="37" align="center"><b>Topic Id</b></td>
		      <td width="10%" height="37" align="center"><b>Name</b></td>

          </tr>
 	
          <s:iterator value="topics" id="t">
	      <tr bgcolor="#EFF3F7" class="TableBody1" onmouseover="this.bgColor='#DEE7FF';" onmouseout="this.bgColor='#EFF3F7';">
		  <td align="center" ><s:property value="#t.topicId" /></td>
		  <td align="center" ><s:property value="#t.name" /></td>
    	  <td><a href="topic!delete?topic.topicId=<s:property value="#t.topicId" />">Delete</a></td>
        </tr>
     </s:iterator>
    </table>
    
    <s:debug></s:debug>
  </body>
</html>
