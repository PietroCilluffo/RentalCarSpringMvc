<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi Utente</title>
</head>
<body>
	<div class="tab-pane fade show active" id="dati" role="tabpanel"
		aria-labelledby="dati-tab">
		<form:form method="POST" modelAttribute="User">
			

			<div class="form-body">

				

				<div class="form-row">
				
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
						<label for="tipo">Tipo (u/s)</label>
						<form:input id="tipo" path="tipo" type="text" class="form-control" />
					</div>
				</div>
				

			
				<hr class="line-form">

				<div class="form-actions">
					<input type="submit" id="btnAdd" class="btn btn-green form-buttons"	 /> <a
						href="<spring:url value="/user/add" /> " id="btnAbort"
						class="btn btn-default form-buttons"> Conferma
					</a>
				</div>
			</div>

		</form:form>
	</div>
</body>
</html>