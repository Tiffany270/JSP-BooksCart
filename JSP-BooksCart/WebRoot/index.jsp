<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript">
function validation() {
    var pwd = document.getElementById('pwd').value;  
 
if(pwd == '') {
        alert('���벻��Ϊ��!');
        return false;
    }
    
}
</script>
<style type="text/css">
	body{
	 font-family:"΢���ź�";
	 background-image: url(img/background5.jpg);
	 }
	 </style>
<body>
  <h1 align="center">Welcome to BookStores</h1>
    <hr>
  <br>  
    <table align="center">
		<tr>
			<td><a href="signup.jsp">�û�ע��</a></td>
		</tr>
	</table>
    
 <h1 align="center">
 �û���¼ ���ȵ�¼
 </h1> 
    
    <center>
    <form action="servlet/loginServlet?action=login" method="post" onsubmit='return validation();'>
    <table width="300" height="50"  style="text-align: center">
    	<tr><td>�û�����</td><td><input type="text" name="username" ></td></tr>
	   <tr><td> ���룺</td><td><input type="password" name="password"  id='pwd'></td></tr>
    </table>
    <br>
	      <input type="submit"  value=��¼ >
    </form>
    </center>
    <br>
    <hr>
    <h2 align="center">����Ա��½</h2>
    <center>
    <form action="servlet/manergerServlet?action=adminLogin" method="post">
    <table width="300" height="50"  style="text-align: center">
    	<tr><td>�û�����</td><td><input type="text" name="manergername" ></td><td>admin</td></tr>
	   <tr><td> ���룺</td><td><input type="password" name="manergerpassword" ><td>admin</td></td></tr>
    </table>
    <br>
	     <input type="submit" value="��½">
    </form>
    </center>
    
    
    
    <br><br><br><br><br><br><br><br><br>
    
    
</body>
</html>
