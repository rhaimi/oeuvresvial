package controleurs;

import java.io.IOException;
import modeles.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@WebServlet("/Controleur")
public class Controleur extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String ACTION_TYPE = "action";
	private static final String SAISIE_OEUVRE_VENTE = "saisieOeuvreVente";
	private static final String CONFIRMER_MODIFICATION = "confirmerModification";
	private static final String AFFICHER_OEUVRE = "afficheOeuvre";
	private static final String RESERVER_OEUVRE = "reserverOeuvre";
	private static final String AFFICHER_RESERVATION = "afficherReservation";
	private static final String MODIFIER_OEUVRE = "modifierOeuvre";
	private static final String AJOUT_OEUVRE = "ajouterOeuvre";
	private static final String ANNULER_RESERVATION = "annulerReservation";
	private static final String CHOIX_RESERVATION = "choixReservation";
	private static final String AJOUTER_RESERVATION = "ajouterReservation";
	private static final String LOGIN = "login";
	private static final String DECONNEXION = "deconnexion";
	private static final String SUPPRIMER_OEUVRE = "supprimerOeuvre";
	private static final String ERROR_PAGE = null;
	protected OeuvreVente ov;
	protected Reservation re;
	protected Adherent ad;

	protected void processusTraiteRequete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			Exception {

		jbUser unUser;
		String login, pwd, erreur, titre, prix, prop;
		// Par défaut si on ne rentre dans aucun des cas
		// prévu la page de redirection sera login.jsp
		String pageReponse = "/login.jsp";
		erreur = "";
		String actionName = request.getParameter(ACTION_TYPE);
		String destinationPage = ERROR_PAGE;
		Proprietaire p = new Proprietaire();
		// execute l'action
		if (SAISIE_OEUVRE_VENTE.equals(actionName)) {
			destinationPage = "/oeuvreVente.jsp";
			request.setAttribute("liste", p.Liste());
		} else if (CONFIRMER_MODIFICATION.equals(actionName)) {
			;
			titre = request.getParameter("txtTitre");
			prix = request.getParameter("txtPrix");
			prop = request.getParameter("lstProprietaires");
			ov.setId_proprietaire(Integer.parseInt(prop));
			p.Lire_Id(ov.getId_proprietaire());
			ov.setProprietaire(p);
			ov.setPrix(Double.parseDouble(prix));
			ov.setTitre(titre);
			ov.Modifier();
			destinationPage = "/catalogue.jsp";
			request.setAttribute("listeOeuvreVente", ov.Liste());
		} else if (AFFICHER_OEUVRE.equals(actionName)) {
			destinationPage = "/catalogue.jsp";
			ov = new OeuvreVente();
			request.setAttribute("listeOeuvreVente", ov.Liste());
		} else if (RESERVER_OEUVRE.equals(actionName)) {
			destinationPage = "/reservation.jsp";
			ov = new OeuvreVente();
			request.setAttribute("listeOeuvreVente", ov.listeLibre());
		} else if (AFFICHER_RESERVATION.equals(actionName)) {
			re = new Reservation();
			request.setAttribute("listeReservation", re.Liste());
			destinationPage = "/listereservations.jsp";
		} else if (MODIFIER_OEUVRE.equals(actionName)) {
			ov = new OeuvreVente();
			ov.Lire_Id(Integer.parseInt(request.getParameter("id")));
			p.Lire_Id(ov.getId_proprietaire());
			destinationPage = "/modifieroeuvre.jsp";
			request.setAttribute("liste",
			p.listeProprietaireDifferent(ov.getId_proprietaire()));
			request.setAttribute("ov", ov);
			request.setAttribute("prop", p);

		} else if (ANNULER_RESERVATION.equals(actionName)) {
			re = new Reservation(Integer.parseInt(request.getParameter("ida")),
					Integer.parseInt(request.getParameter("ido")));
			re.Annuler();
			ov = new OeuvreVente();
			ov.Lire_Id(re.getId_oeuvre());
			ov.setEtat("L");
			ov.Modifier();
			request.setAttribute("listeReservation", re.Liste());
			destinationPage = "/listereservations.jsp";
		} else if (AJOUT_OEUVRE.equals(actionName)) {

			titre = request.getParameter("txtTitre");
			prix = request.getParameter("txtPrix");
			prop = request.getParameter("lstProprietaires");
			ov = new OeuvreVente(Integer.parseInt(prop));
			ov.setEtat("L");
			ov.setPrix(Double.parseDouble(prix));
			ov.setTitre(titre);
			ov.Ajouter();
			destinationPage = "/catalogue.jsp";
			request.setAttribute("listeOeuvreVente", ov.Liste());
		} else if (LOGIN.equals(actionName)) {
			try {
				login = request.getParameter("txtLogin");
				pwd = request.getParameter("txtPwd");
				unUser = new jbUser();
				if (unUser.connecter(login, pwd)) {
					request.setAttribute("nom", unUser.getNom());
					request.setAttribute("prn", unUser.getPrenom());
					request.setAttribute("adresse", unUser.getAdresse());
					destinationPage = "/accueil.jsp";
				} else {
					erreur = "Login ou mot de passe inconnus !";
					destinationPage = "/index.jsp";
				}
				request.setAttribute("erreur", erreur);
			} catch (Exception e) {
				request.setAttribute("erreur", erreur);
			}
		} else if (CHOIX_RESERVATION.equals(actionName)) {
			ov = new OeuvreVente();
			ad = new Adherent();
			ov.Lire_Id(Integer.parseInt(request.getParameter("id")));
			p.Lire_Id(ov.getId_proprietaire());
			destinationPage = "/confirmereservation.jsp";
			request.setAttribute("liste", ad.Liste());
			request.setAttribute("ov", ov);
		} else if (AJOUTER_RESERVATION.equals(actionName)) {
			ov.setEtat("R");
			ov.Modifier();
			re = new Reservation(Integer.parseInt(request
					.getParameter("lstAdherent")), ov.getId_oeuvre());
			re.Ajouter();
			destinationPage = "/reservation.jsp";
			request.setAttribute("listeOeuvreVente", ov.listeLibre());
			
		} else if (SUPPRIMER_OEUVRE.equals(actionName)) {
			ov = new OeuvreVente();
			ov.Lire_Id(Integer.parseInt(request.getParameter("id")));
			if (ov.getEtat().equalsIgnoreCase("R")) {
				
				ov.supprimerOeuvreReservee();

			}
			ov.Supprimer();
			destinationPage = "/catalogue.jsp";
			request.setAttribute("listeOeuvreVente", ov.Liste());
		} else if (DECONNEXION.equals(actionName)) {

			destinationPage = "/index.jsp";
		}
		RequestDispatcher dsp = request.getRequestDispatcher(destinationPage);
		dsp.forward(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processusTraiteRequete(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processusTraiteRequete(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
