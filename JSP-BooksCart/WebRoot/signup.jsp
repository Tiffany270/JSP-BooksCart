<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="gb2312"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<script type="text/javascript">
function validation() {
    var name = document.getElementById('name').value;          
    var pwd = document.getElementById('pwd').value;  
    var address=document.getElementById('address').value;  
    var realname=document.getElementById('realname').value;  
  
    if(name == '') {
        alert('请输入用户名!');
        return false;
    }
 
if(pwd == '') {
        alert('密码不能为空!');
        return false;
    }
    if(isDigit(pwd)){
     alert('密码只能是数字!');
        return false;
    }
    if(address==''){
     alert('地址不能为空!');
        return false;
    }
    if(realname==''){
     alert('请输入真实姓名!');
        return false;
    }
    
}

function isDigit(s)   
{   
var patrn=/^[0-9]{1,20}$/;   
if (patrn.exec(s)) return false   
return true   
}  
</script>

<style type="text/css">
	body{
	 font-family:"微软雅黑";
	 background-image: url(img/background5.jpg);
	 }
	 </style>
	 <br>
<h1 align="center">填写注册信息</h1>

<body>
<br>
<div  align="center">
	<form action="servlet/loginServlet?action=insert" method="POST" onsubmit='return validation();'>
用户名&nbsp;：<input type="text" name="username"  id='name'><br><br>
密码:&nbsp;&nbsp;&nbsp;<input type="password" name="password" id='pwd' > <br><br>
确认密码：<input type="password"  > <br><br>
真实姓名：<input type="text" name="realname"  id='realname'><br><br>
性别：<input type="radio"value="男" name="sex">男<input type="radio"value="女" name="sex" checked="checked">女<br><br>
地址：<input type="text" name="address" id='address' ><br><br>
	     <input type="submit" value="注册">
	</form>
	
	
		<a href="javascript:history.back(-1)">返回</a>
</div>


</body>
</html>
