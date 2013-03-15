<%-- 
    Document   : listereservations
    Created on : 5 déc. 2010, 17:12:15
    Author     : alain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste réservations</title>
<Link rel=stylesheet type="text/css" href="css/bootstrap.css">
<script src="js/jquery-1.9.0.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
                <div class="page-header">
	<H1 align="center">Liste des Reservations</H1>
<div class="navbar">
			<div class="navbar-inner">
				<ul class="nav">
		<li><a href="accueil.jsp">Accueil</a></li>
		<li><a href="Controleur?action=saisieOeuvreVente">Ajouter une oeuvre à vendre</a></li> 
		<li class="active"><a href="Controleur?action=afficherReservation">Consulter les réservations</a></li>
		<li><a href="Controleur?action=afficheOeuvre">Consulter le catalogue</a></li> 
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
                    <td>Prénom adhérent</td>
                    <td>Nom adhérent</td>
                    <td>Annuler</td>
                </tr>
			<c:forEach var="listeReservation" items="${listeReservation}">

				<tr>
				
					<td>${listeReservation.oeuvre.titre}</td>
					
					<td>${listeReservation.adherent.prenom_adherent}</td>
					
					<td>${listeReservation.adherent.nom_adherent}</td>
					
					<td><a href="Controleur?action=annulerReservation&ido=${listeReservation.id_oeuvre}&ida=${listeReservation.id_adherent}">Annuler</a></td>
				
				</tr>
				
				</c:forEach>

            </table>
            <p>

            </p>
    </body>
</html>
