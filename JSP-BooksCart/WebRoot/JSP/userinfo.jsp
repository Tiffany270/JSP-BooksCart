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
     font-family:"微软雅黑";
      background-image: url(../img/background2.jpg);
	   }
	   </style>
<body>

<h1 align="center">个人信息</h1>
<hr>
<center>
	姓名：${requestScope.user["username"]}<br><br>
	真实姓名：${requestScope.user["realname"]} <br><br>
	性别：${requestScope.user["sex"]}<br><br>
	地址：${requestScope.user["address"]}<br><br>
</center>




	<center>
		<a href="javascript:history.back(-1)">返回</a>
	</center>



</body>
</html>
