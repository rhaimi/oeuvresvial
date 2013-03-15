package controleurs;

import java.io.IOException;
import modeles.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userServlet
 */
@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		jbUser unUser;
		String login, pwd, erreur;
		// Par défaut si on ne rentre dans aucun des cas
		// prévu la page de redirection sera login.jsp
		String pageReponse = "/login.jsp";
		erreur = "";
		try {
			login = request.getParameter("txtLogin");
			pwd = request.getParameter("txtPwd");
			unUser = new jbUser();
			if (unUser.connecter(login, pwd)) {
				request.setAttribute("nom", unUser.getNom());
				request.setAttribute("prn", unUser.getPrenom());
				request.setAttribute("adresse", unUser.getAdresse());
				pageReponse = "/accueil.jsp";
			} else {
				erreur = "Login ou mot de passe inconnus !";
			}
			request.setAttribute("erreur", erreur);
		} catch (Exception e) {
			request.setAttribute("erreur", erreur);
		} finally {
			//erreur = e.getMessage();
			RequestDispatcher dsp = request.getRequestDispatcher(pageReponse);
			dsp.forward(request, response);
		}
	}

}
