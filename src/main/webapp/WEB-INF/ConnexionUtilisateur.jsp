<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ENI Enchères</title>
	</head>
	<body class="container">
	<h2 class="text-center">Connexion</h2>
  	<div class="col-12">
		<form method="post" action="${pageContext.request.contextPath}/ConnexionServlet" class="row justify-content-center mb-2">
		
			<label for="email" class="col-2 col-form-label">Identifiant :</label>
  			<div class="col-10">
				<input class="form-control" type="text" id="pseudo_utilisateur" name="pseudo_utilisateur" value="">
			</div>
			<label for="mot_de_passe" class="col-2 col-form-label">Mot de passe :</label>
  			<div class="col-10">
				<input class="form-control" type="password" id="mot_de_passe_utilisateur" name="mot_de_passe_utilisateur" value="">
			</div>
			<a href="#">Mot de passe oublié.</a>
			<div>
				<input type="submit" class="btn btn-primary"></input>
				<a href="#connexion" class="badge text-success" title="Connexion"></a>
			</div>
		</form>

		<div class="row py-5"></div>
	</div>
	
    <!-- Footer -->
	<footer class="row bg-dark footer-demodule fixed-bottom py-1">
		
	</footer>
  </body>
</html>