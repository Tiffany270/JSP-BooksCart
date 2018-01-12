<%@page import="com.yiki.entity.Books"%>
<%@page import="com.yiki.impl.BooksImpl"%>
<%@page import="com.yiki.dao.BooksDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"
	contentType="text/html; charset=gb2312"%>
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
	   .form{
	      float:left;
	      margin: 12px;
	   }
	   div dd{
	      margin:0px;
	      font-size:12pt;
	   }
	   .dd_name
	   {
	      color:blue;
	   }
	  .dd_type
	   {
	      color:#000;
	   }

     .bookclass{
margin-left: 160px;
position: absolute;
}
.bookclass tr{
width: 50px;
height: 40px;
}


	</style>
  </head>
<body>

	<table align="center">
		<tr>
			<td>欢迎您，${sessionScope.username}</td>
			<td><a href="loginServlet?action=out">退出</a></td>
			<td><a href="loginServlet?action=userinfo">个人信息</a></td>
			<td><a href="	orderServlet?action=order">查看订单</a></td>
			<td><a href="	../servlet/bookServlet?action=show">我的购物车</a></td>
		</tr>
	</table>
	<h1 align="center">Welcome to BookStores</h1>
	 <h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <a href="loginServlet?action=back&success=yes">查看全部</a></h4>
    <hr>
<table class="bookclass">
<tr><td><a href="bookServlet?action=bookclass&type=novel">小说</a></td></tr>
<tr><td><a href="bookServlet?action=bookclass&type=poetry">诗歌</a></td></tr>
<tr><td><a href="bookServlet?action=bookclass&type=life">传记</a></td></tr>
</table>
	<center>
    <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
      <tr>
        <td>
          
          <!-- 商品循环开始 -->
           <% 
            
               List<Books> list = (List<Books>)session.getAttribute("classlist");
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	                  Books item = list.get(i);
           %>   
          <div class="form">
             <dl>
               <dt>
                 <a href="../JSP/detail.jsp?id=<%=item.getId()%>"><img src="../img/<%=item.getPicture()%>" width="120" height="90" /></a>
               </dt>
               <dd class="dd_name"><%=item.getBookname()%></dd>
               <dd class="dd_type">类别:<%=item.getType()%>&nbsp;&nbsp;价格:￥<%=item.getPrice()%></dd> 
             </dl>
          </div>
          <!-- 商品循环结束 -->
        
          <%
                   }
              } 
          %>
        </td>
      </tr>
    </table>
    </center>
    <br>  <br>  <br>  <br>  <br>  <br>  <br>  <br>  <br>  <br>
</body>
</html>
