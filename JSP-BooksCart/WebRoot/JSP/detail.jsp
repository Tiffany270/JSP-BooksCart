<%@page import="com.yiki.entity.Books"%>
<%@page import="com.yiki.impl.BooksImpl"%>
<%@page import="com.yiki.dao.BooksDao"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript">
    
      function add()//增加数量+
      {
         var num = parseInt(document.getElementById("number").value);
         if(num<100)
         {
            document.getElementById("number").value = ++num;
         }
      }
      function sub()//减少数量图标-
      {
         var num = parseInt(document.getElementById("number").value);
         if(num>1)
         {
            document.getElementById("number").value = --num;
         }
      }
      

    </script>
    <style type="text/css">
    body{
     font-family:"微软雅黑";
     background-image: url(../img/background.jpg);
    }
	   hr{
	     border-color:ff2832; 
	   }
	   
	   .cart {
	      float:left;
	      margin-left: 30px;
	      margin-right:30px;
	      margin-top: 5px;
	      margin-bottom: 5px;
	     
	   }
	  
	 
	   tr span{
	     padding:0 2px;border:1px #c0c0c0 solid;cursor:pointer;
	   }
	 a{
	      text-decoration: none; 
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
			<td><a href="	../servlet/bookServlet?action=show">我的购物车</a></td>
		</tr>
	</table>
  </center>
	<h1 align="center">商品详情</h1>
  <h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="javascript:history.back(-1)">返回首页</a></h4>
    <hr>
    <br>
    <center>
      <table width="500" height="60" cellpadding="0" cellspacing="0" border="0">
        <tr>
          <% 
             BooksDao itemDao = new BooksImpl();
             Books item = itemDao.getSbyID(Integer.parseInt(request.getParameter("id")));
             if(item!=null)
             {
          %>
          <td width="70%" valign="top">
             <table>
               <tr>
                 <td rowspan="5"><img src="../img/<%=item.getPicture()%>" width="200" height="160"/></td>
               </tr>
               <tr>
                 <td><B><%=item.getBookname()%></B></td> 
               </tr>
               <tr>
                 <td>类别：<%=item.getType()%></td>
               </tr>
               <tr>
                 <td>价格：￥<%=item.getPrice() %></td>
               </tr>
             </table>
             <br>
             <center>
               <form action="../servlet/bookServlet?action=add&id=<%=item.getId()%>" method="POST">
             购买数量：<span id="sub" onclick="sub();">-</span><input type="text" id="number" name="number" value="1" size="2"/><span id="add" onclick="add();">+</span>
          <br><br>
          <input type="submit" value="" style="border:none;background:url('../img/addToCart.jpg') left top no-repeat;width:150px; height:50px;" />
             
           <input type="submit"  value="" style="border:none;background:url('../img/buyItNow.jpg') left top no-repeat;width:150px; height:50px;" onClick="javascript:form1.action='../servlet/bookServlet?action=add&id=<%=item.getId()%>';">
             
             </form>
             
                 <a href="../servlet/bookServlet?action=show"><img src="../img/view_cart.jpg"/></a>
             </center>
             <br>
              <dl>
            <dd>&nbsp;&nbsp;简介：<%=item.getDetail() %></dd>
          </dl>
          
          </td>
          <% 
            }
          %>
         
      </table>
      </center>
      
      <br><br><br><br><br><br><br><br><br><br>
      
  </body>
</html>
