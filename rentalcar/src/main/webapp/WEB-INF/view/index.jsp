<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" 
		integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

    <title>Indice</title>
  </head>
 
  <body>
    
    <div class="jumbotron">
    <h1>Benvenuti su RentalCar</h1>
			<div class="tab-pane fade show active" id="dati" role="tabpanel"
		aria-labelledby="dati-tab">
		<form:form action = "/Test1/login" method="POST" modelAttribute="loginDTO">
			

			<div class="form-body">

				

				<div class="form-row">
				
					<div class="form-group col-md-6">
						<label for="nome">Email</label>
						<form:input id="nome" path="email" type="text" class="form-control" />
					</div>

					<div class="form-group col-md-6">
						<label for="cognome">Password</label>
						<form:input id="cognome" path="password" type="password"
							class="form-control" />
					</div>
				</div>

	
			
				</div>
				

			
				<hr class="line-form">

				<div class="form-actions">
					<input type="submit" id="btnAdd" class="btn btn-green form-buttons"	value = "invia" /> <a
						 id="btnAbort"
						class="btn btn-default form-buttons"> 
					</a>
				</div>
				</form:form>
				</div>
					
					</div>
			</div>

	


      
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
  </body>
</html>