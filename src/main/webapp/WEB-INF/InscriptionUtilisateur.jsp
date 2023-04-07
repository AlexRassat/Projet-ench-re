<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body class="container">
	<h2 class="text-center">Inscription</h2>
  	<div class="col-12">
		<form method="post" action="${pageContext.request.contextPath}/InscriptionServlet" class="row justify-content-center mb-2">
			<div class="col-12">
				<div class="col-6">
      				<label for="pseudo" class="col-2 col-form-label">Pseudo :</label>
  					<div class="col-10">
						<input class="form-control" type="text" id="pseudo_utilisateur" name="pseudo_utilisateur" value="${param.pseudo_utilisateur}">
					</div>
					<label for="prenom" class="col-2 col-form-label">Prénom :</label>
  					<div class="col-10">
						<input class="form-control" type="text" id="prenom_utilisateur" name="prenom_utilisateur" value="">
					</div>
					<label for="telephone" class="col-2 col-form-label">Téléphone :</label>
  					<div class="col-10">
						<input class="form-control" type="tel" id="telephone_utilisateur" name="telephone_utilisateur" value="">
					</div>
					<label for="code_postal" class="col-2 col-form-label">Code postal :</label>
  					<div class="col-10">
						<input class="form-control" type="text" id="code_postal_utilisateur" name="code_postal_utilisateur" value="">
					</div>
					<label for="mot_de_passe" class="col-2 col-form-label">Mot de passe :</label>
  					<div class="col-10">
						<input class="form-control" type="password" id="mot_de_passe_utilisateur" name="mot_de_passe_utilisateur" value="">
					</div>
				</div>
				<div class="col-6">
      				<label for="nom" class="col-2 col-form-label">Nom :</label>
  					<div class="col-10">
						<input class="form-control" type="text" id="nom_utilisateur" name="nom_utilisateur" value="">
					</div>
					<label for="email" class="col-2 col-form-label">Email :</label>
  					<div class="col-10">
						<input class="form-control" type="email" id="email_utilisateur" name="email_utilisateur" value="">
					</div>
					<label for="rue" class="col-2 col-form-label">Rue :</label>
  					<div class="col-10">
						<input class="form-control" type="text" id="rue_utilisateur" name="rue_utilisateur" value="">
					</div>
					<label for="ville" class="col-2 col-form-label">Ville :</label>
  					<div class="col-10">
						<input class="form-control" type="text" id="ville_utilisateur" name="ville_utilisateur" value="">
					</div>
					<label for="confirmation" class="col-2 col-form-label">Confirmation :</label>
  					<div class="col-10">
						<input class="form-control" type="password" id="confirmation_utilisateur" name="confirmation_utilisateur" value="">
					</div>
				</div>
				<div>
					<input type="submit" class="btn btn-primary"></input>
					<a href="#inserer" class="badge text-success" title="Creer"></a>
				</div>
			</div>
		</form>

		<div class="row py-5"></div>
	</div>
	
    <!-- Footer -->
	<footer class="row bg-dark footer-demodule fixed-bottom py-1">
		
	</footer>
  </body>
</html>