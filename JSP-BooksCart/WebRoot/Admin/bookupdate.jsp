<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style type="text/css">
	body{
	 font-family:"微软雅黑";
	 background-image: url(../img/background5.jpg);
	 }
	 </style>
<body>
  <h1 align="center">管理员操作</h1>
    <hr>
  <br>  
  
    
 <h1 align="center">
 更改库存
 </h1> 
 
    
    <center>
    <form action="../servlet/manergerServlet?action=updatecount&orderid=<%=request.getParameter("id")%>" method="post">
    <table width="300" height="50"  style="text-align: center">
	   <tr><td> 修改数量：</td><td><input type="text" name="count" ></td></tr>
    </table>
    <br>
	      <input type="submit"  value="更新">
    </form>
    <a href="javascript:history.back(-1)">返回</a>
    </center>
    <br>
    
    
    
    
    <br><br><br><br><br><br><br><br><br>
    
    
</body>
</html>
