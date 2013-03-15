/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeles;

import java.sql.SQLException;
import java.util.List;

import dao.*;
import erreurs.ExceptionPerso;


/**
 *
 * @author Jaillet Hainaud
 */
public class Proprietaire {
    private int id_proprietaire;
    private String nom_proprietaire;
    private String prenom_proprietaire;

    public Proprietaire() {
    }

    public int getId_proprietaire() {
        return id_proprietaire;
    }

    public void setId_proprietaire(int id_proprietaire) {
        this.id_proprietaire = id_proprietaire;
    }

    public String getNom_proprietaire() {
        return nom_proprietaire;
    }

    public void setNom_proprietaire(String nom_proprietaire) {
        this.nom_proprietaire = nom_proprietaire;
    }

    public String getPrenom_proprietaire() {
        return prenom_proprietaire;
    }

    public void setPrenom_proprietaire(String prenom_proprietaire) {
        this.prenom_proprietaire = prenom_proprietaire;
    }

    /**
     * Lecture d'un Propriétaire dans la base de données
     * @param id Id du Propriétaire à lire
     * @throws Exception
     */
    public void Lire_Id(int id) throws Exception {
    	Db_outils db = Db_outils.getInstance();

        String mysql = "";
        mysql = "select * from proprietaire where id_proprietaire =" + "'" + id + "'";
        Proprietaire tempProp = db.getProrietaire(mysql);
        setId_proprietaire(tempProp.getId_proprietaire());
        setNom_proprietaire(tempProp.getNom_proprietaire());
        setPrenom_proprietaire(tempProp.getPrenom_proprietaire());
    }

    /**
     * Liste des Propriétaires
     * @return List<Proprietaire> Collection de Propriétaires
     * @throws SQLException 
     * @throws ExceptionPerso 
     * @throws Exception
     */
    public List<Proprietaire> Liste() throws ExceptionPerso, SQLException {
    	
            Db_outils dbo = Db_outils.getInstance();

            String mysql = "";
            mysql = "select * from Proprietaire";

            List<Proprietaire> liste = dbo.getListeProprietaire(mysql);
            return liste;
        
    }
    public List<Proprietaire> listeProprietaireDifferent(int id) throws ExceptionPerso, SQLException {
    	
        Db_outils dbo = Db_outils.getInstance();

        String mysql = "";
        mysql = "select * from Proprietaire where id_proprietaire <>"+id;

        List<Proprietaire> liste = dbo.getListeProprietaire(mysql);
        return liste;
    
}
}
