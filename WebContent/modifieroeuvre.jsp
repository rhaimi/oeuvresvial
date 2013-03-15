<%-- 
    Document   : oeuvre
    Created on : 2 déc. 2010, 16:35:33
    Author     : arsane
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Oeuvre</title>
<Link rel=stylesheet type="text/css" href="css/bootstrap.css">
<script src="js/jquery-1.9.0.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
            <div class="page-header">
	<H1 align="center">Modifier Oeuvre</H1>
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
        <form action="Controleur?action=confirmerModification" method="post" name="frmModif">
            <p>
            Titre : <input type="text" name="txtTitre" value="${ov.titre}">
            <br><br>
            Prix : <input type="text" name="txtPrix" value="${ov.prix}">
            <br><br>
            </p>
            Propriétaire : <SELECT name="lstProprietaires">
              <c:forEach var="liste" items="${liste}">
				<OPTION value=${liste.id_proprietaire}>${liste.nom_proprietaire}</OPTION>
			</c:forEach>
			<OPTION selected value=${prop.id_proprietaire}>${prop.nom_proprietaire}</OPTION>
            </SELECT>
            <br><br>
            <input type="submit" value="Modifier">

        </form>
    </body>
</html>
