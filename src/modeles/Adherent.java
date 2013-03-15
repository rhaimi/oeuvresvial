/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeles;

import java.util.List;

import dao.*;


/**
 *
 * @author Jaillet Hainaud
 */
public class Adherent {
    private int id_adherent;
    private String nom_adherent;
    private String prenom_adherent;

    public Adherent() {
    }

    /**
     * @return the id_adherent
     */
    public int getId_adherent() {
        return id_adherent;
    }

    /**
     * @param id_adherent the id_adherent to set
     */
    public void setId_adherent(int id_adherent) {
        this.id_adherent = id_adherent;
    }

    /**
     * @return the nom_adherent
     */
    public String getNom_adherent() {
        return nom_adherent;
    }

    /**
     * @param nom_adherent the nom_adherent to set
     */
    public void setNom_adherent(String nom_adherent) {
        this.nom_adherent = nom_adherent;
    }

    /**
     * @return the prenom_adherent
     */
    public String getPrenom_adherent() {
        return prenom_adherent;
    }

    /**
     * @param prenom_adherent the prenom_adherent to set
     */
    public void setPrenom_adherent(String prenom_adherent) {
        this.prenom_adherent = prenom_adherent;
    }

    /**
     * Lecture d'un adhérent dans la base de données
     * @param id Id de l'adhérent à lire
     * @throws Exception
     */
    public void Lire_Id(int id) throws Exception {

    	Db_outils db = Db_outils.getInstance();

        String mysql = "";
        mysql = "select * from adherent where id_adherent =" + id;
        Adherent tempAdher = db.getAdherent(mysql);
        setId_adherent(tempAdher.getId_adherent());
        setNom_adherent(tempAdher.getNom_adherent());
        setPrenom_adherent(tempAdher.getPrenom_adherent());
    }

    /**
     * Liste des adhérents
     * @return List<Adherent> Collection d'adhérents
     * @throws Exception
     */
    public List<Adherent> Liste() throws Exception {
        Db_outils dbo = Db_outils.getInstance();

        String mysql = "";
        mysql = "select * from Adherent"; 

        List<Adherent> liste = dbo.getListeAdherent(mysql);
        return liste;

    }
}
