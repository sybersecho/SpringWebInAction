<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<style type="text/css">
span.error {
	color: red;
}

span.errors {
	background-color: #ffcccc;
	border: 2px solid red;
}
</style>
<title>Register Spitter</title>
</head>
<body>
	<h1>Register</h1>
	<form:form method="POST" commandName="spitter">
		<form:errors path="*" cssClass="errors" />
		<br />
		<form:label path="firstName">First Name</form:label>
		<form:input path="firstName" />
		<form:errors path="firstName" cssClass="error" />
		<br />
		<form:label path="lastName">Last Name</form:label>
		<form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br />
		<form:label path="email">Email</form:label>
		<form:input path="email" />
		<form:errors path="email" cssClass="error" />
		<br />
		<form:label path="username">Username</form:label>
		<form:input path="username" />
		<form:errors path="username" cssClass="error" />
		<br />
		<form:label path="password">Password</form:label>
		<form:password path="password" />
		<form:errors path="password" cssClass="error" />
		<br />
		<form:button>Submit</form:button>
	</form:form>
</body>
</html>