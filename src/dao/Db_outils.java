/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.*;


import modeles.*;
import erreurs.ExceptionPerso;

/**
 *
 * @author Jaillet Hainaud
 */
public class Db_outils {

    private static Connexion connexion = null;
    private static Db_outils instance = null;

    public static Db_outils getInstance() {
        if (instance == null) {
            instance = new Db_outils();
            connexion = Connexion.getInstance();
        }

        return instance;

    }

	public OeuvreVente getOeuvreVente(String mysql) throws ExceptionPerso, SQLException {
		Connection cnx = null;
		try{
		connexion.setConnexion();
        cnx = connexion.getConnexion();
        Statement unstatement = cnx.createStatement();
        boolean rs = unstatement.execute(mysql);
        if (rs) {
            ResultSet result = null;
            result = unstatement.getResultSet();
            result.next();
            OeuvreVente ov = new OeuvreVente();
            ov.setId_oeuvre(result.getInt("id_oeuvrevente"));
            ov.setId_proprietaire(result.getInt("id_proprietaire"));
            ov.setPrix(result.getDouble("prix_oeuvrevente"));
            ov.setTitre(result.getString("titre_oeuvrevente"));
            ov.setEtat(result.getString("etat_oeuvrevente"));
            Proprietaire prop = new Proprietaire();
            try {
				prop.Lire_Id(result.getInt("id_proprietaire"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            ov.setProprietaire(prop);
           // result.close();
            cnx.close();
            return ov;
         }
        cnx.close();
        return null;
		}
		  catch (SQLException e) {
	          System.out.println("Erreur :" + e.getMessage());
	          System.out.println(mysql);
	          new ExceptionPerso(e.getMessage());
	      }
        cnx.close();
        return null;
	}

	public Proprietaire getProrietaire(String mysql) throws ExceptionPerso, SQLException {
		Connection cnx = null;
		try{
			connexion.setConnexion();
        cnx = connexion.getConnexion();
        Statement unstatement = cnx.createStatement();
        boolean rs = unstatement.execute(mysql);
        if (rs) {
            ResultSet result = null;
            result = unstatement.getResultSet();
            result.first();
            Proprietaire prop = new Proprietaire();
            prop.setId_proprietaire(result.getInt("id_proprietaire"));
            prop.setNom_proprietaire(result.getString("nom_proprietaire"));
            prop.setPrenom_proprietaire(result.getString("prenom_proprietaire"));
            cnx.close();
            return prop;
        }
        
		}
	   catch (SQLException e) {
          System.out.println("Erreur :" + e.getMessage());
          System.out.println(mysql);
          new ExceptionPerso(e.getMessage());
      }
		cnx.close();
		return null;
	}

	public List<Proprietaire> getListeProprietaire(String mysql) throws ExceptionPerso, SQLException {
		Connection cnx = null;
        try {
        	connexion.setConnexion();
            cnx = connexion.getConnexion();

            Statement unstatement = cnx.createStatement();
            boolean rs = unstatement.execute(mysql);
            if (rs) {
                ResultSet result = null;
                result = unstatement.getResultSet();
                result.first();
                List<Proprietaire> list = new ArrayList<Proprietaire>();
                do {
                	Proprietaire s = new Proprietaire();
                    s.setId_proprietaire(result.getInt("id_proprietaire"));
                    s.setNom_proprietaire(result.getString("nom_proprietaire"));
                    s.setPrenom_proprietaire(result.getString("prenom_proprietaire"));
                    list.add(s);
                } while (result.next());
                cnx.close();
                return list;
            }
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
            System.out.println(mysql);
            new ExceptionPerso(e.getMessage());
        }
        return null;
    }
		
	public List<OeuvreVente> getListeOeuvre(String mysql) throws Exception {
		Connection cnx = null;
        try {
        	connexion.setConnexion();
            cnx = connexion.getConnexion();

            Statement unstatement = cnx.createStatement();
            boolean rs = unstatement.execute(mysql);
            if (rs) {
                ResultSet result = null;
                result = unstatement.getResultSet();
                result.first();
                List<OeuvreVente> list = new ArrayList<OeuvreVente>();
                do {
                	OeuvreVente ov = new OeuvreVente(result.getInt("id_proprietaire"));
                    ov.setEtat(result.getString("etat_oeuvrevente"));
                    ov.setId_oeuvre(result.getInt("id_oeuvrevente"));
                    ov.setId_proprietaire(result.getInt("id_proprietaire"));
                    ov.setPrix(result.getDouble("prix_oeuvrevente"));
                    ov.setTitre(result.getString("titre_oeuvrevente"));
                    list.add(ov);
                } while (result.next());
                cnx.close();
                return list;
            }
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
            System.out.println(mysql);
            new ExceptionPerso(e.getMessage());
        }
        return null;
    }
	
	public List<OeuvreVente> getListeOeuvreLibre(String mysql) throws Exception {
		Connection cnx = null;
        try {
        	connexion.setConnexion();
            cnx = connexion.getConnexion();

            Statement unstatement = cnx.createStatement();
            boolean rs = unstatement.execute(mysql);
            if (rs) {
                ResultSet result = null;
                result = unstatement.getResultSet();
                result.first();
                List<OeuvreVente> list = new ArrayList<OeuvreVente>();
                do {
                	OeuvreVente ov = new OeuvreVente(result.getInt("id_proprietaire"));
                    ov.setEtat(result.getString("etat_oeuvrevente"));
                    ov.setId_oeuvre(result.getInt("id_oeuvrevente"));
                    ov.setId_proprietaire(result.getInt("id_proprietaire"));
                    ov.setPrix(result.getDouble("prix_oeuvrevente"));
                    ov.setTitre(result.getString("titre_oeuvrevente"));
                    list.add(ov);
                } while (result.next());
                cnx.close();
                return list;
            }
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
            System.out.println(mysql);
            new ExceptionPerso(e.getMessage());
        }
        return null;
    }
	public Adherent getAdherent(String mysql) throws ExceptionPerso, SQLException {
		Connection cnx = null;
		try{
			connexion.setConnexion();
        cnx = connexion.getConnexion();
        Statement unstatement = cnx.createStatement();
        boolean rs = unstatement.execute(mysql);
        if (rs) {
            ResultSet result = null;
            result = unstatement.getResultSet();
            result.first();
            Adherent adherent= new Adherent();
            adherent.setId_adherent(result.getInt("id_adherent"));
            adherent.setNom_adherent(result.getString("nom_adherent"));
            adherent.setPrenom_adherent(result.getString("prenom_adherent"));
            cnx.close();
            return adherent;
        }
        
		}
	   catch (SQLException e) {
          System.out.println("Erreur :" + e.getMessage());
          System.out.println(mysql);
          new ExceptionPerso(e.getMessage());
      }
		cnx.close();
		return null;
	}
	public List<Adherent> getListeAdherent(String mysql) throws ExceptionPerso, SQLException {
		Connection cnx = null;
        try {
        	connexion.setConnexion();
            cnx = connexion.getConnexion();

            Statement unstatement = cnx.createStatement();
            boolean rs = unstatement.execute(mysql);
            if (rs) {
                ResultSet result = null;
                result = unstatement.getResultSet();
                result.first();
                List<Adherent> list = new ArrayList<Adherent>();
                do {
                	Adherent adherent = new Adherent();
                	adherent.setId_adherent(result.getInt("id_adherent"));
                	adherent.setNom_adherent(result.getString("nom_adherent"));
                	adherent.setPrenom_adherent(result.getString("prenom_adherent"));
                    list.add(adherent);
                } while (result.next());
                cnx.close();
                return list;
            }
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
            System.out.println(mysql);
            new ExceptionPerso(e.getMessage());
        }
        return null;
    }
	
	public List<Reservation> getListeReservation(String mysql) throws Exception {
		Connection cnx = null;
        try {
        	connexion.setConnexion();
            cnx = connexion.getConnexion();

            Statement unstatement = cnx.createStatement();
            boolean rs = unstatement.execute(mysql);
            if (rs) {
                ResultSet result = null;
                result = unstatement.getResultSet();
                result.first();
                List<Reservation> list = new ArrayList<Reservation>();
                do {
                	Reservation re = new Reservation(result.getInt("id_adherent"),result.getInt("id_oeuvrevente"));
                    list.add(re);
                } while (result.next());
                cnx.close();
                return list;
            }
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
            System.out.println(mysql);
            new ExceptionPerso(e.getMessage());
        }
        return null;
    }	

	public void executeRequest(String mysql) throws ExceptionPerso, SQLException{
		Connection cnx = null;
        try {
        	connexion.setConnexion();
            cnx = connexion.getConnexion();
            Statement unstatement = cnx.createStatement();
            unstatement.execute(mysql);
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
            System.out.println(mysql);
            new ExceptionPerso(e.getMessage());
        }

        cnx.close();
	}
	public int getIdAdherent(String mysql) throws ExceptionPerso, SQLException {
		Connection cnx = null;
		int id_adherent;
		try{
			connexion.setConnexion();
        cnx = connexion.getConnexion();
        Statement unstatement = cnx.createStatement();
        boolean rs = unstatement.execute(mysql);
        if (rs) {
            ResultSet result = null;
            result = unstatement.getResultSet();
            result.first();
            id_adherent = result.getInt("id_adherent");
            cnx.close();
            return id_adherent;
        }
        
		}
	   catch (SQLException e) {
          System.out.println("Erreur :" + e.getMessage());
          System.out.println(mysql);
          new ExceptionPerso(e.getMessage());
      }
		cnx.close();
		return 0;
	}
}

