<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi Veicolo</title>
</head>
<body>
	<div class="tab-pane fade show active" id="dati" role="tabpanel"
		aria-labelledby="dati-tab">
		<form:form method="POST" modelAttribute="Vehicle">
			

			<div class="form-body">

				

				<div class="form-row">
				
					<div class="form-group col-md-6">
						<label for="targa">Targa</label>
						<form:input id="targa" path="targa" type="text" class="form-control" />
					</div>

					<div class="form-group col-md-6">
						<label for="modello">Modello</label>
						<form:input id="modello" path="modello" type="text"
							class="form-control" />
					</div>
				</div>

	
					<div class="form-group col-md-6">
						<label for="casa">Casa</label>
						<form:input id="casa" path="casa" type="text" class="form-control" />
					</div>
				</div>
						<div class="form-group col-md-6">
						<label for="anno">Anno</label>
						<form:input id="anno" path="anno" type="text" class="form-control" />
					</div>
				
				

			
				<hr class="line-form">

				<div class="form-actions">
					<input type="submit" id="btnAdd" class="btn btn-green form-buttons"	 value = "Conferma"/> 
				</div>
		

		</form:form>
	</div>
</body>
</html>