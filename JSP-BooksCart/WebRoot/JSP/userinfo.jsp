<%@page import="com.yiki.dbutil.*"%>
<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style type="text/css">
	   hr{
	    border-color:ff2832; 
	   }
	   body{
	   font-size: 20px;
     font-family:"΢���ź�";
      background-image: url(../img/background2.jpg);
	   }
	   </style>
<body>

<h1 align="center">������Ϣ</h1>
<hr>
<center>
	������${requestScope.user["username"]}<br><br>
	��ʵ������${requestScope.user["realname"]} <br><br>
	�Ա�${requestScope.user["sex"]}<br><br>
	��ַ��${requestScope.user["address"]}<br><br>
</center>




	<center>
		<a href="javascript:history.back(-1)">����</a>
	</center>



</body>
</html>
