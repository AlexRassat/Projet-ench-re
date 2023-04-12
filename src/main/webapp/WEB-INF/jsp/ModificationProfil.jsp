<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link href="ProfilStyle.css" rel="stylesheet">


<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mon Profil</title>
</head>
<body>
	<div>
		<h2>Mon Profil</h2>
	</div>
	<form method="post" action="ModificationProfileServlet">
		<!-- Input : Pseudo -->
		<div>
			<div>
				<div>
					<div>
						<label>Pseudo</label> <input
							type="text" id="eech-pseudo" name="pseudo" value="${profil.pseudo}" >
					</div>
					<!-- ./Input : Pseudo -->

					<!-- Input : Nom -->
					<div>
						<label>Nom</label> <input
							type="text" id="eech-nom" name="nom" value="${profil.nom}">
					</div>
					<!-- ./Input : Nom -->

					<!-- Input : Prenom -->
					<div>
						<label>Prenom</label> <input type="text"
							name="prenom" value="${profil.prenom}">
					</div>
					<!-- ./Input : Prenom -->

					<!-- Input : Email -->
					<div>
						<label>Email</label> <input type="text"
							name="email" value="${profil.email}">
					</div>
					<!-- ./Input : Email -->

					<!-- Input : Telephone -->
					<div>
						<label>Telephone</label> <input
							type="text" name="telephone" value="${profil.telephone}">
					</div>
					<!-- ./Input : Telephone -->

					<!-- Input : Rue -->
					<div>
						<label>Rue</label> <input type="text"
							name="rue" value="${profil.rue}">
					</div>
					<!-- ./Input : Rue -->

					<!-- Input : Code postale -->
					<div>
						<label>Code postale</label> <input
							type="text" name="codePostal" value="${profil.codePostal}">
					</div>
					<!-- ./Input : Code postale -->

					<!-- Input : City -->
					<div>
						<label>Ville</label> <input
							type="text" id="eech-citycode" name="ville" value="${profil.ville}">
					</div>
					<!-- ./Input : City Code -->

					<!-- Input : Mot de passe -->
					<div>
						<label>Mot de passe</label>
						<input type="password" id="eech-password" name="motDePasse"
							value="${profil.motDePasse}">
					</div>
					<!-- ./Input : Mot de passe -->

					<!-- Input : Mot de passe confirmation -->
					<div>
						<label>Mot de passe confirmation</label> 
						<input type="password" id="eech-password-confirm" name="motDePasse"
								value="${profil.motDePasse}">
					</div>
								<tr>
									<th>Credit :</th>
									<td>${profil.credit}</td>
								</tr>
							</div>
						</div>
					</div>
		<!-- ./Input : Mot de passe confirmation -->


		<div>
			<button type="submit">Enregister</button> 									
		</div>
	</form>
</body>
</html>