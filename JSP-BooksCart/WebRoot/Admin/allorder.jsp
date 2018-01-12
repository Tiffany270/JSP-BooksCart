<%@page import="com.yiki.dbutil.*"%>
<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="gb2312"%>
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
<h1 align="center">所有订单信息</h1>
<hr style="border-color:#ecebf0"><br>
	<table align="center" border="1">
		<tr>
			<td>订单号</td>
			<td>书名</td>
			<td>买家</td>
			<td>买家地址</td>
			<td>是否出库</td>
			<td>总价</td>
			<td>操作</td>
			<td>操作</td>
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
				<a href="manergerServlet?action=update&orderid=${order.orderid}&buyer=${order.buyer}">发货</a></td>
				<td><a href="manergerServlet?action=deleteorder&orderid=${order.orderid}&buyer=${order.buyer}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<center>
	<br>
		<a href="manergerServlet?action=back">返回</a>
	</center>



</body>
</html>
