<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<body>
	<center>
		<img src="../img/add_cart_success.jpg" />
		<hr>
		<%
			String id = request.getParameter("id");
			String num = request.getParameter("number");
		%>
		您成功购买了<%=num%>件商品编号为<%=id%>的商品&nbsp;&nbsp;&nbsp;&nbsp; <br> <br>
		<br>
		
		<a href="javascript:history.back(-1)">返回</a>

	</center>
</body>
</html>
