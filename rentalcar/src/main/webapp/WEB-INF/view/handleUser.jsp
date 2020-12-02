<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestisci utente</title>
</head>
<body>

<div class="tab-pane fade show active" id="dati" role="tabpanel"
		aria-labelledby="dati-tab">
		<form:form action = "/Test1/user/update" method="POST" modelAttribute="User">
			

			<div class="form-body">

				

				<div class="form-row">
						<div class="form-group col-md-6">
						<label for="id">id</label>
						<form:input id="id" path="id" type="text" class="form-control" />
					</div>
					<div class="form-group col-md-6">
						<label for="nome">Nome</label>
						<form:input id="nome" path="nome" type="text" class="form-control" />
					</div>

					<div class="form-group col-md-6">
						<label for="cognome">Cognome</label>
						<form:input id="cognome" path="cognome" type="text"
							class="form-control" />
					</div>
				</div>

	
					<div class="form-group col-md-6">
						<label for="email">Email</label>
						<form:input id="email" path="email" type="text" class="form-control" />
					</div>
				</div>
						<div class="form-group col-md-6">
						<label for="password">Password</label>
						<form:input id="password" path="password" type="text" class="form-control" />
					</div>
				<div class="form-group col-md-6">
						
						<form:input  id="tipo" path="tipo" type="hidden" class="form-control" value = "u"/>
					</div>
				

			
				<hr class="line-form">

				<div class="form-actions">
					<input type="submit" id="btnAdd" class="btn btn-green form-buttons"	 /> 
				</div>
				</form:form>
			</div>
  <table class="table table-striped table-bordered">
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>DataInizio</th>
				<th>DataFine</th>
				
				<th>Targa</th>
				<th>Modello</th>
				<th>Casa</th>
				<th>Approvato</th>
				

			</tr>

			<c:forEach items="${reservations}" var="reservation">
				<tr>

					<td>${reservation.id}</td>
					<td>${reservation.user.nome}</td>
					<td>${reservation.user.cognome}</td>
					<td >${reservation.dataInizio}</td>
					<td>${reservation.dataFine}</td>
					
					<td>${reservation.vehicle.targa}</td>
					<td>${reservation.vehicle.modello}</td>
					<td>${reservation.vehicle.casa}</td>
					<td>${reservation.approvazione}</td>
					<td>
					
					
					 <td>
						<a href="<spring:url value="/reservation/approve/${reservation.user.id}/${reservation.id}" /> " class="btn btn-primary table-buttons">
								<span class="oi oi-pencil"></span> Approva 
      							</a> 
						
					
					</td>
					
				</tr>
			</c:forEach>
		</table>
		
	
</body>
</html>