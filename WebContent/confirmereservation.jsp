<%-- 
    Document   : oeuvre
    Created on : 2 d�c. 2010, 16:35:33
    Author     : arsane
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Reservation</title>
<Link rel=stylesheet type="text/css" href="css/bootstrap.css">
<script src="js/jquery-1.9.0.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
    <div class="page-header">
	<H1 align="center">Reserver une Oeuvre</H1>
<div class="navbar">
			<div class="navbar-inner">
				<ul class="nav">
		<li><a href="accueil.jsp">Accueil</a></li>
		<li><a href="Controleur?action=saisieOeuvreVente">Ajouter une oeuvre � vendre</a></li> 
		<li><a href="Controleur?action=afficherReservation">Consulter les r�servations</a></li>
		<li><a href="Controleur?action=afficheOeuvre">Consulter le catalogue</a></li> 
		<li  class="active"><a href="Controleur?action=reserverOeuvre">Reserver	une oeuvre</a></li> 
		<li><a href="Controleur?action=deconnexion">Se d�connecter</a></li>
		</ul>
	</div>
	</div>
	</div>
        <form action="Controleur?action=ajouterReservation" method="post" name="frmModif">
            <p>
            Titre : <input disabled="disabled" type="text" name="txtTitre" value="${ov.titre}">
            <br><br>
            Prix : <input disabled="disabled" type="text" name="txtPrix" value="${ov.prix}">
            <br><br>
            Adherent : <SELECT name="lstAdherent">
              <c:forEach var="liste" items="${liste}">
				<OPTION value=${liste.id_adherent}>${liste.nom_adherent}</OPTION>
			</c:forEach>
			</SELECT>
            </p>
            

            <p>
             <br/><br/>
			<input type="submit" value="Reserver">
            </p>
            
        </form>
    </body>
</html>