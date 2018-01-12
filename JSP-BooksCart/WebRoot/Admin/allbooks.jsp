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
<h1 align="center">所有图书信息</h1>
<hr style="border-color:#ecebf0"><br>
	<table align="center" border="1">
		<tr>
			<td>书号</td>
			<td>书名</td>
			<td>作者</td>
			<td>价格</td>
			<td>类型</td>
			<td>总量</td>
			<td>操作</td>
			
		</tr>

		<c:forEach var="book" items="${requestScope.bookall}">
			<tr>
			 <td>${book.id}</td>
             <td>${book.bookname}</td>
             <td>${book.writer}</td>
             <td>${book.price}</td>
             <td>${book.type}</td>
             <td>${book.count}</td>
				<td>
				<a href="../Admin/bookupdate.jsp?id=${book.id}">更新</a></td>
				
			</tr>
		</c:forEach>
	</table>
	<center>
	<br>
		<a href="manergerServlet?action=back">返回</a>
	</center>



</body>
</html>
