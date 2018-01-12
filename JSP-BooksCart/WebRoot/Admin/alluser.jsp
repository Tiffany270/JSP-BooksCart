<%@page import="com.yiki.dbutil.*"%>
<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="gb2312" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style type="text/css">
	body{
	 font-family:"微软雅黑";
	 background-image: url(../img/background4.jpg);
	 }
	 </style>
<body>
<h1 align="center">所有用户信息</h1>
<hr style="border-color:#ecebf0">
	<table align="center" border="1">
		<tr>
			<td>姓名</td>
			<td>密码</td>
			<td>真实姓名</td>
			<td>性别</td>
			<td>地址</td>
			<td>操作</td>
		</tr>

		<c:forEach var="user" items="${requestScope.userall}">
			<tr>
			 <td>${user.username}</td>
             <td>${user.password}</td>
             <td>${user.realname}</td>
             <td>${user.sex}</td>
             <td>${user.address}</td>
				<td><a href="manergerServlet?action=deleteuser&deletename=${user.username}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<center>
	<br>
		<a href="manergerServlet?action=back">返回</a>
	</center>



</body>
</html>
