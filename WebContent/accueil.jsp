<%-- 
    Document   : accueil
    Created on : 3 nov. 2010, 15:03:01
    Author     : alain
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<Link rel=stylesheet type="text/css" href="css/bootstrap.css">
<script src="js/jquery-1.9.0.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<title>Accueil</title>
</head>
<body>
<div class="page-header">
	<H1 align="center">Gestion des oeuvres</H1>
<div class="navbar">
			<div class="navbar-inner">
				<ul class="nav">
		<li class="active"><a href="accueil.jsp">Accueil</a></li>
		<li><a href="Controleur?action=saisieOeuvreVente">Ajouter une oeuvre à vendre</a></li> 
		<li><a href="Controleur?action=afficherReservation">Consulter les réservations</a></li>
		<li><a href="Controleur?action=afficheOeuvre">Consulter le catalogue</a></li> 
		<li><a href="Controleur?action=reserverOeuvre">Reserver	une oeuvre</a></li> 
		<li><a href="Controleur?action=deconnexion">Se déconnecter</a></li>
		</ul>
	</div>
	</div>
	</div>
</body>
</html>
