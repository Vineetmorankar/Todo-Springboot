<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<div class="container">
	<h1>Login Please!</h1>
	<pre>${errormsg}</pre>
	<br>
	<form method="post">
	Name : <input type="text" name="name">
	<br>
	<br>
	Password : <input type="password" name="password">
	<br>
	<br>
	<input type="submit">
</form>
</div>

</body>
</html>