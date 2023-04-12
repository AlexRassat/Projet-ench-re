<%@page import="fr.eni.Encheres.bo.Utilisateur"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consultation</title>
</head>
<body>

<%--
	<h1>${ArrayListeUtilisateur.no_utilisateur}</h1>
		<h1>${utilisateur.pseudo}</h1>
		
		

	<div class="contenu">
			        <ul class="list-group col col-lg-4">
				            <li value="${ArrayListeUtilisateur.no_utilisateur}"></li>
							<li value="${utilisateur.pseudo}"/></li>
							<li value="test"/></li>
	
			        </ul>
	</div>
	
	
	<table>			        
	    	<%
				ArrayList<Utilisateur> listeUtilisateur = (ArrayList<Utilisateur>) request.getAttribute("listeUtilisateur");
			%>
		
			<%
				for(Utilisateur utilisateur : listeUtilisateur)
					
			{
			%>

				<td><%= utilisateur.getPseudo()%></td> 

			<%
			}
			%>

	</table>

	
	FOREACH!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				<%
				ArrayList<Utilisateur> listeUtilisateur = (ArrayList<Utilisateur>) request.getAttribute("listeUtilisateur");
					if(listeUtilisateur!=null && listeUtilisateur.size()>0)
					{
				%>
						<tbody>
							<%
							for(Utilisateur repas : listeUtilisateur)
							{
							%>
								<tr>
									<td><%=repas.getPseudo()%></td>

						</tr>
							<%
								if(String.valueOf(repas.getIdentifiant()).equals(request.getParameter("detail")))
								{
							%>
									<tr>
										<td colspan="3">
											<ul>
												<%
												for(Aliment aliment:repas.getListeAliments())
												{
												%>
													<li><%=aliment.getNom()%></li>
												<%
												}
												%>
											</ul>
										</td>
									</tr>
							<%
								}
							}
							%>
						</tbody>
				<%
					}
					else
					{
				%>
					<p>Il n'y a aucun repas à afficher<P>
				<%
					}
				%>
				
				---------------
	<div class="contenu">
		<table align="center">
				<%
						
				if(request.getAttribute("listeUtilisateur")!=null)
					{
					ArrayList<Utilisateur> listeUtilisateur = (ArrayList<Utilisateur>) request.getAttribute("listeUtilisateur");

				%>
						<tbody>
							<%
							for(Utilisateur utilisateur : listeUtilisateur)
							{
							%>
								<tr>
									<td>Pseudo: <%=utilisateur.getPseudo() %></td>
									<td>Nom: <%=utilisateur.getNom() %></td>
									<td>Prenom: <%=utilisateur.getPrenom() %></td>
									<td>Email: <%=utilisateur.getEmail() %></td>
									<td>Téléphone: <%=utilisateur.getTelephone() %></td>
									<td>Code Postal: <%=utilisateur.getCodePostal() %></td>
									<td>Ville: <%=utilisateur.getVille() %></td>
								</tr>
				<%
					}
				%>
	
				<%
					}
					else
					{
				%>
					<p>Il n'y a aucun utilisateur à afficher<P>
					
				<%
					}
				%>
			
		</table>
	</div>	
	
------------------------			
--%>	
<%--	
	<div class="contenu">
		<table align="center">
				<%

				if(request.getAttribute("utilisateur")!=null)
					{
					Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");

				%>
						<tbody>
								<tr>
									<td>Pseudo: <%=utilisateur.getPseudo() %></td>
									<td>Nom: <%=utilisateur.getNom() %></td>
									<td>Prenom: <%=utilisateur.getPrenom() %></td>
									<td>Email: <%=utilisateur.getEmail() %></td>
									<td>Téléphone: <%=utilisateur.getTelephone() %></td>
									<td>Code Postal: <%=utilisateur.getCodePostal() %></td>
									<td>Ville: <%=utilisateur.getVille() %></td>
								</tr>
				<%
					}
				%>

			
		</table>
	</div>
	
------------------------			
--%>	

	<div>
		<h2>Profil de l'utilisateur:</h2>
	</div>
					<th >Pseudo :</th>
					<td> ${utilisateur.pseudo}</td>

					<th >Nom :</th>
					<td> ${utilisateur.nom}</td>

					<th >prenom :</th>
					<td> ${utilisateur.prenom}</td>

					<th >Email :</th>
					<td> ${utilisateur.email}</td>

					<th >Mobile :</th>
					<td> ${utilisateur.telephone}</td>

					<th >Rue :</th>
					<td> ${utilisateur.rue}</td>

					<th >Code postal :</th>
					<td> ${utilisateur.codePostal}</td>

</body>
</html>