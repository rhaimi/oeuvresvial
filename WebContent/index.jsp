<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%String erreur = (String)request.getAttribute("erreur");
if (erreur == null) erreur = "";%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
<Link rel=stylesheet type="text/css" href="css/bootstrap.css">
<script src="js/jquery-1.9.0.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <h1 align='center'>Page d'identification</h1>
        <form action="Controleur?action=login" method="post" name="frmLogin">
            <p>
            Login : <input type="text" name="txtLogin" >
            <br><br>
            Mot de passe : <input type="password" name="txtPwd">
            </p>
            <input type="submit" value="Se connecter">
            <p>
             <%=erreur%>
            </p>
        </form>
    
    </body>
</html>

