<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<!-- Quando avro una sessione visualizzare solo per admin -->
		<c:if test="${sessionScope.isSuper == 1}">
		<h1>Benvenuto  ${sessionScope.nome}</h1>
		
	<a href="<spring:url value="/user/add" /> " style="margin-left: 20px;"
		class="btn btn-success float-right">Aggiungi Utente</a>
		
	<a href="<spring:url value="/vehicle/find" /> " style="margin-left: 20px;"
		class="btn btn-success float-right">Parco Auto</a>
	<form:form id="search" role="search" method="GET"
		action="/Test1/user/search" modelAttribute="searchDTO">
		<form:select path="selected" class="form-control col-md-6">
			<option value="nome">Nome</option>
			<option value="cognome">Cognome</option>
			<option value="email">Email</option>
		</form:select>
		<div class="form-group col-md-6">
			<form:input path="" name="filter" id="value" type="text"
				class="form-control" />
		</div>
		
		<input type="submit" id="btnAdd" class="btn btn-green form-buttons" value = "Cerca" />  <span
						class="oi oi-pencil"></span>
				
	</form:form>
	<table class="table table-striped table-bordered">
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>email</th>

		</tr>

		<c:forEach items="${users}" var="user">
			<tr>

				<td>${user.id}</td>
				<td>${user.nome}</td>
				<td>${user.cognome}</td>
				<td>${user.email}</td>
			
				<td><a href="<spring:url value="/user/handle/${user.id}" /> "
					class="btn btn-primary table-buttons"> <span
						class="oi oi-pencil"></span> Gestisci
				</a>
				<td><a href="<spring:url value="/user/delete/${user.id}" /> "
					class="btn btn-primary table-buttons" onclick="return confirm('Sei sicuro di voler eliminare l'utente?')"> <span
						class="oi oi-pencil"></span> Elimina
				</a></td>

			</tr>
		</c:forEach>
	</table>
	</c:if>
	<!-- Quando avro una sessione visualizzare solo per user -->
	
	<c:if test="${sessionScope.isSuper == 0}">
	<h1>Benvenuto  ${sessionScope.nome}</h1>
		<a href="<spring:url value="/reservation/add/${sessionScope.id}" /> " style="margin-left: 20px;"
		class="btn btn-success float-right">Aggiungi Prenotazione</a>
			<a href="<spring:url value="/vehicle/find" /> " style="margin-left: 20px;"
		class="btn btn-success float-right">Parco Auto</a>
	<table class="table table-striped table-bordered">
		<tr>
			<th>Id</th>
			<th>DataInizio</th>
			<th>DataFine</th>
			<th>Nome</th>
			<th>targa</th>

		</tr>

		<c:forEach items="${reservations}" var="reservation">
			<tr>

				<td>${reservation.id}</td>
				<td>${reservation.dataInizio}</td>
				<td>${reservation.dataFine}</td>
				<td>${reservation.user.nome}</td>
				<td>${reservation.vehicle.targa}</td>
			
				<td><a
					href="<spring:url value="/reservation/handle/${reservation.id}" /> "
					class="btn btn-primary table-buttons"> <span
						class="oi oi-pencil"></span> Gestisci
				</a>
				<td><a
					href="<spring:url value="/reservation/delete/${reservation.user.id}/${reservation.id}" /> "
					class="btn btn-primary table-buttons"> <span
						class="oi oi-pencil"></span> Elimina
				</a></td>

			</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>