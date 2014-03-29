<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
   <link href="<%=basePath%>style/style.css"  type="text/css" rel="StyleSheet" />
   <meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
        <style>
            .bred{border: 1px solid red;}
            .bgreen{border: 1px solid green;}
        </style>
		<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
	    <script type="text/javascript" src="<%=basePath%>js/validation.js"></script>
  </head>
  
  <body>
 
<br/><br/>
  <div id="reg">
 <div id="displayTip" class="displayNone"></div>  
    <form name="register" method="post" action="book.action"  onsubmit="return book_validateForm();">
    <table width="600" height="263" border="0" align="right" cellpadding="0" cellspacing="0">
       <tr>
          <th colspan="2">Add Book</th>
        </tr>
        <tr>
          <td><span class="style1">Title：</span></td>
          <td><input name="book.title" type="text" id="title" class="formstyle" need="true">
          <font color="#F9481C">*</font>
          <font color="#F9481C" id="title_hint"></font>
          </td>
        </tr>
        <tr>
         <td>Author：</td>
          <td><input name="book.author" type="text" id="author" class="formstyle" need="true">
          <font color="#F9481C">*</font>
          <font color="#F9481C" id="author_hint"></font>
          </td>
        </tr>
        <tr>
        <td>Price:</td>
          <td><input name="book.price" type="text" id="price" class="formstyle" need="true">
          <font color="#F9481C">*</font>
          <font color="#F9481C" id="price_hint"></font>
          </td>
		   
        </tr>
		
        <tr>
          <td><span class="style1">Quantity：</span></td>
          <td><input name="book.quantity" type="text" id="quantity" class="formstyle" need="true">
          <font color="#F9481C">*</font>
          <font color="#F9481C" id="quantity_hint"></font>
          </td>
        </tr>
        
        <tr>
          <td><span class="style1">Image Path：</span></td>
          <td><input name="book.imagePath" type="text" class="formstyle" need="true">
          </td>
        </tr>
    	 
        <tr>
        <td> <span class="style1" >Topic:</span></td>
		<td>
			 <s:iterator value="listTopics" id="topics">
         <input type="checkbox" name="book.checkBoxes" id="topicId" value="<s:property value="#topics.topicId" />"/> 
    	 <s:property value="#topics.name" />
         </s:iterator>
		</td>
		
		</tr>
		
		
		<tr>
		 <td> <span class="style1">Book Category:</span></td>
		<td>
	
			<table style="width:100%" width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">
 	 	 <tr>
		      <td colspan="2" width="5%" height="37" align="center"><b>Category</b></td>
		</tr>
		
    	 <s:iterator value="listCategory" id="cs">
	      <tr bgcolor="#EFF3F7" class="TableBody1" ">
	      <td><input type="radio" name="book.radioList" id="bookCategoryId" value="<s:property value="#cs.categoryId" />" /></td>
		  <td align="center" ><s:property value="#cs.categoryName" /></td>
        </tr>
        
         </s:iterator>
      
	</table>
		</td>
		</tr>
  
    <tfoot>
        <tr>
          <td colspan="2">
              <input name="submit" type="submit" id="submit" value="Submit">
              <input name="reset" type="reset" value="Reset" >
          </td>
        </tr>
        <tr>
        </tfoot>
      </table>
    	
    </form>
</div>
  </body>
</html>
