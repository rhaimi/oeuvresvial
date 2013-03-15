/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

import erreurs.ExceptionPerso;

/**
 *
 * @author Jaillet Hainaud
 */
public class Connexion {
	private Connection conn = null;
    private static Connexion instance = null;
    /**
     * Constructeur par défaut
     */
    public Connexion() {
    }

    /**
     * Etablit une connexion à la base de données en prenant les paramètres
     * de connexion dans un fichier properties
     * @return Connexion à la base de données
     * @throws Exception
     */
    public Connection Connecter() throws Exception {


        try {


        } catch (Exception e) {
            throw e;
        }
		return conn;
    }
    
    public static Connexion getInstance() {
        if (instance == null) {
            instance = new Connexion();
        }
        return instance;
    }
    
    public void  setConnexion( )throws ExceptionPerso ,SQLException
	  {    
		try 
	       {
			   Context ctxt=JBossContext.getInitialContext();	
			   if(ctxt!=null){
	           DataSource ds = (DataSource) ctxt.lookup("java:/Oeuvre");
	           this.conn= ds.getConnection();
			   }
	       
	       }
		catch( SQLException e )  {
	          throw new ExceptionPerso(e.getMessage());
	       }
		catch (NamingException e) {
		 throw new ExceptionPerso(e.getMessage());
        }
	     catch ( Exception e )      {
	          throw new ExceptionPerso(e.getMessage());
	       }
	} 

  public Connection getConnexion() {
      return this.conn;
  }
}
