<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestisci Prenotazione</title>
</head>
<body>

<div class="tab-pane fade show active" id="dati" role="tabpanel"
		aria-labelledby="dati-tab">
		<form:form action = "/Test1/reservation/update" method="POST" modelAttribute="Reservation">
			

			<div class="form-body">

				

				<div class="form-row">
						<div class="form-group col-md-6">
					
						<form:input id="id" path="id" type="hidden" class="form-control" />
					</div>
					<div class="form-group col-md-6">
						<label for="dataInizio">Data Inizio (dd/mm/yyyy)</label>
						<form:input id="dataInizio" path="dataInizio" type="date" class="form-control" />
					</div>

					<div class="form-group col-md-6">
						<label for="dataFine">Data fine (dd/mm/yyyy)</label>
						<form:input id="dataFine" path="dataFine" type="date"
							class="form-control" />
					</div>
				</div>

	
					<div class="form-group col-md-6">
						<label for="approvazione">Approvazione</label>
						<form:input id="approvazione" path="approvazione" type="text" class="form-control" />
					</div>
					
					<div class="form-group col-md-6">
						
						<form:input type = "hidden"  id="user.id" path="user.id"  class="form-control" />
					</div>
						
					<div class="form-group col-md-6">
						
						<form:input type = "hidden"  id="vehicle.id" path="vehicle.id"  class="form-control" />
					</div>
				</div>
					
				
				

			
				<hr class="line-form">

				<div class="form-actions">
					 <input type="submit" id="btnAdd" class="btn btn-green form-buttons"	value = "Modifica" />  
				</div>
				</form:form>
			</div>

		
	
</body>
</html>