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
        alert('�������û���!');
        return false;
    }
 
if(pwd == '') {
        alert('���벻��Ϊ��!');
        return false;
    }
    if(isDigit(pwd)){
     alert('����ֻ��������!');
        return false;
    }
    if(address==''){
     alert('��ַ����Ϊ��!');
        return false;
    }
    if(realname==''){
     alert('��������ʵ����!');
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
	 font-family:"΢���ź�";
	 background-image: url(img/background5.jpg);
	 }
	 </style>
	 <br>
<h1 align="center">��дע����Ϣ</h1>

<body>
<br>
<div  align="center">
	<form action="servlet/loginServlet?action=insert" method="POST" onsubmit='return validation();'>
�û���&nbsp;��<input type="text" name="username"  id='name'><br><br>
����:&nbsp;&nbsp;&nbsp;<input type="password" name="password" id='pwd' > <br><br>
ȷ�����룺<input type="password"  > <br><br>
��ʵ������<input type="text" name="realname"  id='realname'><br><br>
�Ա�<input type="radio"value="��" name="sex">��<input type="radio"value="Ů" name="sex" checked="checked">Ů<br><br>
��ַ��<input type="text" name="address" id='address' ><br><br>
	     <input type="submit" value="ע��">
	</form>
	
	
		<a href="javascript:history.back(-1)">����</a>
</div>


</body>
</html>
