<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<title>Login Page</title>
</head>
<body>
<div class="container">
	<h1>Add Todo Details</h1>
	<br>
	<form:form method="post" modelAttribute="todo">
		Description : <form:input type="text" name="description" required="required" path="description"/>
		<form:errors path="description" cssClass="text-warning"/>
		<form:input type="hidden" path="id"/>
		<form:input type="hidden" path="done"/>
		<br>
		<br>
		<input type="submit" class="btn btn-success">
	</form:form>
</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>