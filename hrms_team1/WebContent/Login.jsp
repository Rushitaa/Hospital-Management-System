<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="/HMSLoginModule/LoginValidation.js"></script>
<title>LOGIN PAGE</title>
</head>
<body>

<h2 align="center"><font color="#062445">Login</font></h2>

<form name="loginform" action="LoginController" method="post" onsubmit="return loginValidate();">
	<table align="center" border="0px" bgcolor="#2b27a1" cellpadding=0px>
		<tr><td><font color="white">User Name</font></td><td><input type="text" name="UserName"></td></tr>
		<tr><td><font color="white">Password</font></td><td><input type="password" name="Password"></td></tr>
		<tr><td align="center"><input type="submit" value="Login"></td><td align="center"><input type="reset" value="Clear"></td></tr>

	</table>
</form>
</body>
</html>