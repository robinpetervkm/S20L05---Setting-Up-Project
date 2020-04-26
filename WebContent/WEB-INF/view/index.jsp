<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/files/css/style.css">
</head>
<body>
	<h4>Home Page : List of all user in the Project</h4>
	<hr />

	<table border="1" align="left">
		<tr>
			<th>UserId</th>
			<th>Name</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.userID }</td>
				<td>${user.name }</td>
				<td>${user.email }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>