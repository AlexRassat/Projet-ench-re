<%@page import="fr.eni.Encheres.bo.Utilisateur"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mon-Profile</title>
</head>
<body>

		<h2>Mon Profil :</h2>

					<th >Pseudo :</th>
					<td> ${profil.pseudo}</td>

					<th >Nom :</th>
					<td> ${profil.nom}</td>

					<th >Prenom :</th>
					<td> ${profil.prenom}</td>

					<th >Email :</th>
					<td> ${profil.email}</td>

					<th >Mobile :</th>
					<td> ${profil.telephone}</td>

					<th >Rue :</th>
					<td> ${profil.rue}</td>

					<th >Code postal :</th>
					<td> ${profil.codePostal}</td>

					<th >Ville :</th>
					<td> ${profil.ville}</td>


			<button onclick="window.location.href = './ModificationProfileServlet';"
			type="button" data-bs-toggle="button"
			autocomplete="off" aria-pressed="true">Modifier</button>
	</div>
</body>
</html>