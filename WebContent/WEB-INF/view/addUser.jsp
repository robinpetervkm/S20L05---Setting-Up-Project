<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/files/css/style.css">
<title>Add User</title>
</head>
<body>
	<table>
		<form:form modelAttribute="User" action="addUser">
			<tr>
				<td>Name : <form:input path="name" /> <form:errors path="name"
						cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td>Email : <form:input path="email" /> <form:errors
						path="email" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td>Password : <form:input path="password" type="password" /> <form:errors
						path="email" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</form:form>
		<tr>
			<td>
				<c:url var="logoutUrl" value="/logout"/>
				<form action="${logoutUrl}" method="post" >
					<input  type="submit" value="Logout" />
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token } "/>
				</form>
			</td>

		</tr>
	</table>
</body>
</html>