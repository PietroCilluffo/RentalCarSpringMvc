<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Parco Auto</title>
</head>
<body>
	<!-- Quando avro una sessione visualizzare solo per admin -->
	<c:if test="${sessionScope.isSuper == 1}">
<a href="<spring:url value="/vehicle/add" /> "  style="margin-left: 20px;" class="btn btn-success float-right">Aggiungi Auto</a>
	</c:if>
	<form:form id="search" role="search" method="GET"
		action="/Test1/vehicle/search" modelAttribute="searchDTO">
		<form:select path="selected" class="form-control col-md-6">
			<option value="modello">Modello</option>
			<option value="casa">Casa</option>
			<option value="anno">Anno</option>
		</form:select>
		<div class="form-group col-md-6">
			<form:input path="" name="filter" id="value" type="text"
				class="form-control" />
		</div>
		<input type="submit" id="btnAdd" class="btn btn-green form-buttons" value = "Cerca" />
	</form:form>
<table class="table table-striped table-bordered">
			<tr>
				<th>Id</th>
				<th>Targa</th>
				<th>Modello</th>
				<th>Casa</th>
				<th>Anno</th>

			</tr>

			<c:forEach items="${vehicles}" var="vehicle">
				<tr>

					<td>${vehicle.id}</td>
					<td >${vehicle.targa}</td>
					<td>${vehicle.modello}</td>
					<td>${vehicle.casa}</td>
					<td>${vehicle.anno}</td>
					<c:if test="${sessionScope.isSuper == 1}">
			
					
					<!-- Quando avro una sessione visualizzare solo per admin -->
					
					 <td>
						<a href="<spring:url value="/vehicle/handle/${vehicle.id}" /> " class="btn btn-primary table-buttons">
								<span class="oi oi-pencil"></span> Gestisci 
      							</a> 
						
					<td>
						<a href="<spring:url value="/vehicle/delete/${vehicle.id}" /> " class="btn btn-primary table-buttons" onclick="return confirm('Sei sicuro di voler eliminare il veicolo?')">
								<span class="oi oi-pencil"></span> Elimina 
      							</a> 
					</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
</body>
</html>