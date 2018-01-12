<%@page import="com.yiki.entity.Books"%>
<%@page import="com.yiki.entity.Cart"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script language="javascript">
	    function delcfm() {
	        if (!confirm("确认要删除？")) {
	            window.event.returnValue = false;
	        }
	    }
   </script>
   
   <style type="text/css">
   
   body{
     font-family:"微软雅黑";
      background-image: url(img/background2.jpg);
    }
	   hr{
	     border-color:#ecebf0; 
	   }
	   
img 
{ 
	border:0;
	width:90px;
	height:90px;
}
table { border-collapse:collapse; }
input { font-size:12px; }
#shopping {text-align:center; margin:0 auto;width: 80%}
#shopping table { width:80%; line-height:24px; border-top:2px solid #c9aecd; border-bottom:2px solid #a94442;; }
#shopping table th { background:#ecebf0; color:#a94442; }
#shopping table td { padding:10px 0; border-top:1px solid #a94442; }
#shopping table td.thumb img { border:1px solid #a94442;; margin:0 10px; vertical-align:middle; }
#shopping table td.price,
#shopping table td.number { text-align:center; width:100px; border-left:1px solid #e1e1e1; }
#shopping table td.price { color:#cc3300; font-weight:bold; }
#shopping table td.delete { width:60px; text-align:center; border-left:1px solid #e1e1e1; }
#shopping table td.number span {padding:0 2px;border:1px #c0c0c0 solid;cursor:pointer;}
#shopping table td.number input { width:20px; border:1px solid #c9c9c9; padding:2px; text-align:center; }
#shopping .total{height:60px;}
#shopping .total span{line-height:60px;}
#shopping .button { text-align:right; padding:10px 0; }
#shopping .button input { border:0; background:url(../images/bg.png) left -213px; width:144px; height:35px; cursor:pointer; }
#shopping .shadow { width:500px; margin:50px auto; }

   </style>
   
  </head>
  
  <body>
   <center>
  <table>
		<tr>
			<td>欢迎您，${sessionScope.username}</td>
			<td><a href="servlet/loginServlet?action=out">退出</a></td>
			<td><a href="servlet/loginServlet?action=userinfo">个人信息</a></td>
			<td><a href="	servlet/orderServlet?action=order">查看订单</a></td>
		
		</tr>
	</table>
  </center>
	<h1 align="center">购物车</h1>
  <h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="servlet/loginServlet?action=back&success=yes">返回</a></h4>
    <hr>
   <div id="shopping">
   <form action="servlet/orderServlet?action=cartorder" method="POST">		
			<table>
				<tr>
					<th>书本名称</th>
					<th>书本单价</th>
					<th>书本价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<% 
				   //首先判断session中是否有购物车对象
				   if(request.getSession().getAttribute("cart")!=null)
				   {
				%>
				<!-- 循环的开始 -->
				     <% 
				         Cart cart = (Cart)request.getSession().getAttribute("cart");
				         HashMap<Books,Integer> goods = cart.getGoods();
				         Set<Books> items = goods.keySet();
				         Iterator<Books> it = items.iterator();
				         
				         while(it.hasNext())
				         {
				            Books i = it.next();
				     %> 
				<tr >
					<td class="thumb"><img src="img/<%=i.getPicture()%>" /><a href="JSP/detail.jsp?id=<%=i.getId()%>">
					<%=i.getBookname()%></a></td>
					<td class="number"><%=i.getPrice() %></td>
					<td class="price" >
						<span><%=i.getPrice()*goods.get(i) %></span>
						<input type="hidden"  name ="bookname" value="	<%=i.getBookname()%>" />
					</td>
					<td class="number">
                     	<%=goods.get(i)%>					
					</td>                        
                    <td class="delete">
					  <a href="servlet/bookServlet?action=delete&id=<%=i.getId()%>" onclick="delcfm();">删除</a>					                  
					</td>
						
				</tr>
				     <% 
				         }
				     %>
				<!--循环的结束-->
			</table>
			 <div class="total"><span id="total">总计：￥<%=cart.getTotalPrice() %></span></div>
			 		<input type="hidden"  name ="totalprice" value="	<%=cart.getTotalPrice() %>" />
			  <% 
			    }
			 %>
			<div class="number"><input type="submit" value="结算" /></div>
		</form>
	</div>
  </body>
</html>
