/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import java.util.ArrayList;
import java.util.List;

import dao.*;



/**
 *
 * @author Jaillet Hainaud
 */
public class Reservation {

    private int id_oeuvre;
    private int id_adherent;
    private Adherent adherent;
    private OeuvreVente oeuvre;

    public Reservation() {
    }

    /**
     * Initialise l'Adhérent et l'Oeuvre de la Reservation
     * @param id_oeuvre Id de l'oeuvre réservée
     * @param id_adherent Id de l'adhérent réservant
     * @throws Exception
     */
    public Reservation( int id_adherent, int id_oeuvre) throws Exception {
    	oeuvre = new OeuvreVente();
    	adherent = new Adherent();
    	this.id_adherent = id_adherent;
    	adherent.Lire_Id(id_adherent);
    	this.id_oeuvre = id_oeuvre;
    	oeuvre.Lire_Id(id_oeuvre);

    }
    
    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }


    public OeuvreVente getOeuvre() {
        return oeuvre;
    }

    public void setOeuvre(OeuvreVente oeuvre) {
        this.oeuvre = oeuvre;
    }

    public int getId_oeuvre() {
        return id_oeuvre;
    }

    public void setId_oeuvre(int id_oeuvre) {
        this.id_oeuvre = id_oeuvre;
    }

    public int getId_adherent() {
        return id_adherent;
    }

    public void setId_adherent(int id_adherent) {
        this.id_adherent = id_adherent;
    }

    

    /**
     * Convertit une chaîne en date avant de l'affecter
     * @param date_reservation
     * @throws Exception
     */
   

    /**
     * Liste des Réservations en Attente
     * @return List<Reservation> Collection de Réservations
     * @throws Exception
     */
    public List<Reservation> Liste() throws Exception {
		Db_outils dbo = Db_outils.getInstance();

		String mysql = "";
		mysql = "select * from reservation;";

		List<Reservation> liste = dbo.getListeReservation(mysql);
		return liste;
    }

    /**
     * Met à jour une Réservation dans la base de données
     * @throws Exception
     */
    public void Annuler() throws Exception {
		Db_outils dbo = Db_outils.getInstance();

		String mysql = "";
		mysql = "delete from reservation where id_oeuvrevente ="+ id_oeuvre +" and id_adherent =" + id_adherent;
    	dbo.executeRequest(mysql);
    }

    /**
     * Insert une Réservation dans la base de données
     * @throws Exception
     */
    public void Ajouter() throws Exception {
    	
		Db_outils dbo = Db_outils.getInstance();

		String mysql = "";
		mysql = "INSERT INTO reservation VALUES ("+id_oeuvre+","+id_adherent +")";
    	dbo.executeRequest(mysql);	
    	
 }
}
