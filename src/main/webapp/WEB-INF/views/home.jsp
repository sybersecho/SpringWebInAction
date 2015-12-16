<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Spittles</title>
</head>
<body>
	<h1>
		<spring:message code="spittr.welcome"/>
	</h1>

	<a href='<c:url value="/spittles" />'>Spittles</a> |
	<a href='<c:url value="/spitter/register"/>'>Register</a>
</body>
</html>