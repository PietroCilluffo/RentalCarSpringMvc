<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>

<body>
<table>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>email</th>

			</tr>

			<c:forEach items="${users}" var="user">
				<tr>

					<td>${user.id}</td>
					<td >${user.nome}</td>
					<td>${user.cognome}</td>
					<td>${user.email}</td>
					<td>
					
					<td>
					
					</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>