<%@page import="com.yiki.dbutil.*"%>
<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="gb2312"%>
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
<h1 align="center">���ж�����Ϣ</h1>
<hr style="border-color:#ecebf0"><br>
	<table align="center" border="1">
		<tr>
			<td>������</td>
			<td>����</td>
			<td>���</td>
			<td>��ҵ�ַ</td>
			<td>�Ƿ����</td>
			<td>�ܼ�</td>
			<td>����</td>
			<td>����</td>
		</tr>

		<c:forEach var="order" items="${requestScope.orderall}">
			<tr>
			 <td>${order.orderid}</td>
             <td>${order.bookname}</td>
             <td>${order.buyer}</td>
             <td>${order.address}</td>
             <td>${order.stockout}</td>
             <td>${order.totalprice}</td>
				<td>
				<a href="manergerServlet?action=update&orderid=${order.orderid}&buyer=${order.buyer}">����</a></td>
				<td><a href="manergerServlet?action=deleteorder&orderid=${order.orderid}&buyer=${order.buyer}">ɾ��</a></td>
			</tr>
		</c:forEach>
	</table>
	<center>
	<br>
		<a href="manergerServlet?action=back">����</a>
	</center>



</body>
</html>
