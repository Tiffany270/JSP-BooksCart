<%@page import="com.yiki.entity.User"%>
<%@page import="com.yiki.impl.OrderImpl"%>
<%@page import="com.yiki.dao.OrderDao"%>
<%@page import="com.yiki.entity.Order"%>
<%@page import="com.yiki.entity.Books"%>
<%@page import="com.yiki.impl.BooksImpl"%>
<%@page import="com.yiki.dao.BooksDao"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <style type="text/css">
    body{
     font-family:"微软雅黑";
     background-image: url(../img/background2.jpg);
    }
	   hr{
	     border-color:ff2832; 
	   }
	   
	 
	</style>
  </head>
  
  <body>
  <center>
  <table>
		<tr>
			<td>欢迎您，${sessionScope.username}</td>
			<td><a href="../servlet/loginServlet?action=out">退出</a></td>
			<td><a href="../servlet/loginServlet?action=userinfo">个人信息</a></td>
		</tr>
	</table>
  </center>
	<h1 align="center">订单详情</h1>
  <h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="loginServlet?action=back&success=yes">返回</a></h4>
    <hr>
    <center>
    
    <% List<Order> list = new ArrayList<Order>();
    OrderDao dao  = new OrderImpl();
    String name  = request.getSession().getAttribute("username").toString();
     list = dao.getSbyName(name);
     User user = (User)request.getSession().getAttribute("orderuser");
    %>
    <table >
    <tr><td>  您的名字：<%=name%></td></tr>
     <tr><td> 收货地址：<%=user.getAddress()%></td></tr>
     </table>
     
     <table  border="1" width="500" height="50"  style="text-align: center">
     <tr>
     <td>订单号：</td>
     <td>您购买的书：</td>
     <td>发货状态：</td>
     <td>总价</td>
     </tr>
    
     
    <% 
     for(int i=0;i<list.size();i++)
	               {
	                  Order item = list.get(i);
     %>
   
     <tr><td><%=item.getOrderid() %></td>
     <td> <%=item.getBookname() %></td>
     <td> <%=item.getStockout() %></td>
     <td>￥<%=item.getTotalprice() %>RMB</td></tr>
 
   
<% 

        }
 %>
    
   
      </table>
    </center>
  </body>
</html>
