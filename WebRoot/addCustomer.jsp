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
    <form name="register" method="post" action="customer.action" onsubmit="return validateForm();">
    <table width="600" height="263" border="0" align="right" cellpadding="0" cellspacing="0">
       <tr>
          <th colspan="2">Customer Register</th>
        </tr>
        <tr>
          <td><span class="style1">User Name：</span></td>
          <td><input name="customer.username" type="text" id="username" class="formstyle" need="true">
          <font color="#F9481C">*</font>
          <font color="#F9481C" id="username_hint"></font>
          </td>
        </tr>
        <tr>
         <td>Password：</td>
          <td><input name="cutsomr.password" type="password" id="pass1" class="formstyle" need="true">
          <font color="#F9481C">*</font>
          <font color="#F9481C" id="p1_hint"></font>
          </td>
        </tr>
        <tr>
        <td>Confirm Password:</td>
          <td><input name="customer.password2" type="password" id="pass2" class="formstyle" need="true">
          <font color="#F9481C">*</font>
          <font color="#F9481C" id="p2_hint"></font>
          </td>
		   
        </tr>
		
        <tr>
          <td><span class="style1">Name：</span></td>
          <td><input name="customer.name" type="text" id="name" class="formstyle" need="true">
          <font color="#F9481C">*</font>
          <font color="#F9481C" id="name_hint"></font>
          </td>
        </tr>
    	 <tr>
          <td><span class="style1">Address：</span></td>
          <td><input name="js.address" type="text" id="address" class="formstyle">
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
