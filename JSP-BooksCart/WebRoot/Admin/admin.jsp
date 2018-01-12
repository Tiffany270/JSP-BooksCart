<%@page import="com.yiki.dbutil.*"%>
<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="gb2312"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style type="text/css">
	body{
	 font-family:"微软雅黑";
	 background-image: url(../img/background4.jpg);
	 }
	 </style>
<body>
<center>
<br>
	<h1>管理员操作</h1>
	<hr style="border-color:#ecebf0"><br>
	<a href="manergerServlet?action=alluser">查看用户</a>
	<a href="manergerServlet?action=allorder">查看订单</a>
	<a href="manergerServlet?action=allbook">书籍数据</a>
    <a href="manergerServlet?action=adminOut">退出</a>
</center>


	

</body>
</html>
