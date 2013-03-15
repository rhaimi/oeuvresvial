<%-- 
    Document   : modifUser
    Created on : 24 nov. 2010, 10:04:11
    Author     : arsane
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<Link rel=stylesheet type="text/css" href="css/bootstrap.css">
<script src="js/jquery-1.9.0.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
        <title>Profil</title>
    </head>
    <body>
        <div class="page-header">
	<H1 align="center">Catalogue</H1>
<div class="navbar">
			<div class="navbar-inner">
				<ul class="nav">
		<li><a href="accueil.jsp">Accueil</a></li>
		<li><a href="Controleur?action=saisieOeuvreVente">Ajouter une oeuvre à vendre</a></li> 
		<li><a href="Controleur?action=afficherReservation">Consulter les réservations</a></li>
		<li class="active"><a href="Controleur?action=afficheOeuvre">Consulter le catalogue</a></li> 
		<li><a href="Controleur?action=reserverOeuvre">Reserver	une oeuvre</a></li> 
		<li><a href="Controleur?action=deconnexion">Se déconnecter</a></li>
		</ul>
	</div>
	</div>
	</div>
            <p>
            <table border="1">
                <tr>
                    <td>Titre</td>
                    <td>Etat</td>
                    <td>Prix</td>
                    <td>Prénom propriétaire</td>
                    <td>Nom propriétaire</td>
                    <td>Modifier</td>
                    <td>Supprimer</td>
                </tr>                
			<c:forEach var="listeOeuvreVente" items="${listeOeuvreVente}">

				<tr>
				
					<td>${listeOeuvreVente.titre}</td>
					
					<td>${listeOeuvreVente.etat}</td>
					
					<td>${listeOeuvreVente.prix}</td>
					
					<td>${listeOeuvreVente.proprietaire.prenom_proprietaire}</td>
					
					<td>${listeOeuvreVente.proprietaire.nom_proprietaire}</td>
					
					<td><a href="Controleur?action=modifierOeuvre&id=${listeOeuvreVente.id_oeuvre}">Modifier</a></td>
					
					<td><a href="Controleur?action=supprimerOeuvre&id=${listeOeuvreVente.id_oeuvre}">Supprimer</a></td>
				
				</tr>
				
				</c:forEach>

            </table>
            <p>

            </p>
    </body>
</html>
