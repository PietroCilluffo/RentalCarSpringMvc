<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi prenotazione</title>
</head>
<body>
<h1>Aggiungi prenotazione</h1>
<div class="tab-pane fade show active" id="dati" role="tabpanel"
		aria-labelledby="dati-tab">
		<form:form action = "/Test1/reservation/add" method="POST" modelAttribute="Reservation">
			

			<div class="form-body">

				<form:input  type = "hidden" id="user.id" path="user.id" value = "${user.id}"
							class="form-control" />

				<div class="form-row">
				
					<div class="form-group col-md-3">
					<label for="dataInizio">Targa Auto</label>
						<form:select path="vehicle.id" class="form-control">
						    <c:forEach items="${vehicles}" var="vehicle">
					        <c:if test="${vehicle.id != selected}">
					            <option  value="${vehicle.id}">${vehicle.targa}</option>
					        </c:if>
					    </c:forEach>
						</form:select>
					</div>
                
					<div class="form-group col-md-3">
						<label for="dataInizio">Data Inizio (dd-mm-yyyy)</label>
						<form:input id="dataInizio" path="dataInizio" type="date"
							class="form-control" />
					</div>
				</div>

	
					<div class="form-group col-md-3">
						<label for="dataFine">Data fine (dd-mm-yyyy)</label>
						<form:input id="dataFine" path="dataFine" type="date" class="form-control" />
					</div>
				</div>
					
				
				

			
				<hr class="line-form">

				<div class="form-actions">
					<input type="submit" id="btnAdd" class="btn btn-green form-buttons"	value = "Inserisci" /> 
				</div>
		

		</form:form>
	</div>

<h1> Lista auto</h1>
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
					<td>${vehicle.targa}</td>
					<td>${vehicle.modello}</td>
					<td>${vehicle.casa}</td>
					<td>${vehicle.anno}</td>
				
				
					
				</tr>
			</c:forEach>
		</table>
</body>
</html>