<%@page import="com.yiki.dbutil.*"%>
<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="gb2312" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style type="text/css">
	body{
	 font-family:"΢���ź�";
	 background-image: url(../img/background4.jpg);
	 }
	 </style>
<body>
<h1 align="center">�����û���Ϣ</h1>
<hr style="border-color:#ecebf0">
	<table align="center" border="1">
		<tr>
			<td>����</td>
			<td>����</td>
			<td>��ʵ����</td>
			<td>�Ա�</td>
			<td>��ַ</td>
			<td>����</td>
		</tr>

		<c:forEach var="user" items="${requestScope.userall}">
			<tr>
			 <td>${user.username}</td>
             <td>${user.password}</td>
             <td>${user.realname}</td>
             <td>${user.sex}</td>
             <td>${user.address}</td>
				<td><a href="manergerServlet?action=deleteuser&deletename=${user.username}">ɾ��</a></td>
			</tr>
		</c:forEach>
	</table>
	<center>
	<br>
		<a href="manergerServlet?action=back">����</a>
	</center>



</body>
</html>
