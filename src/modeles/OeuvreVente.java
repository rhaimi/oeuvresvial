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
public class OeuvreVente {

    private int id_oeuvre;
    private int id_proprietaire;
    private String titre;
    private double prix;
    private Proprietaire proprietaire;
    private String etat;
    
    public OeuvreVente() {
    }

    /**
     * Initialise le Propriétaire d'une oeuvre
     * @param id_proprietaire Id du propriétaire de l'oeuvre
     * @throws Exception
     */
    public OeuvreVente(int id_proprietaire) throws Exception {
        Proprietaire prop = new Proprietaire();
        prop.Lire_Id(id_proprietaire);
        setId_proprietaire(id_proprietaire);
        setProprietaire(prop);
    }
    
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }


    public int getId_oeuvre() {
        return id_oeuvre;
    }

    public void setId_oeuvre(int id_oeuvre) {
        this.id_oeuvre = id_oeuvre;
    }

    public int getId_proprietaire() {
        return id_proprietaire;
    }

    public void setId_proprietaire(int id_proprietaire) {
        this.id_proprietaire = id_proprietaire;
    }

    /**
     * @return the proprietaire
     */
    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Lecture d'une Oeuvre dans la base de données
     * @param id Id de l'oeuvre à lire
     * @throws Exception
     */
    public void Lire_Id(int id) throws Exception {
    	Db_outils db = Db_outils.getInstance();

        String mysql = "";
        mysql = "select * from oeuvrevente where id_oeuvrevente = "+id;

        
        OeuvreVente tempOeuvre = db.getOeuvreVente(mysql);
        this.setId_oeuvre(tempOeuvre.getId_oeuvre());
        this.setId_proprietaire(tempOeuvre.getId_proprietaire());
        this.setTitre(tempOeuvre.getTitre());
        this.setPrix(tempOeuvre.getPrix());
        this.setEtat(tempOeuvre.getEtat());;
        this.setProprietaire(tempOeuvre.getProprietaire());
    }

    /**
     * Liste des oeuvre
     * @return List<Oeuvre> Collection d'oeuvres
     * @throws Exception
     */
    public List<OeuvreVente> Liste() throws Exception {
    	
		Db_outils dbo = Db_outils.getInstance();

		String mysql = "";
		mysql = "select * from oeuvrevente;";

		List<OeuvreVente> liste = dbo.getListeOeuvre(mysql);
		return liste;

	}
    public List<OeuvreVente> listeLibre() throws Exception {
    	
		Db_outils dbo = Db_outils.getInstance();

		String mysql = "";
		mysql = "select * from oeuvrevente where etat_oeuvrevente = 'L'";

		List<OeuvreVente> liste = dbo.getListeOeuvreLibre(mysql);
		return liste;

	}

    /**
     * Met à jour une oeuvre dans la base de données
     * @throws Exception
     */
    public void Modifier() throws Exception {
    	Db_outils db = Db_outils.getInstance();
        String mysql = "UPDATE oeuvrevente SET titre_oeuvrevente ='"+this.getTitre()+"', etat_oeuvrevente ='"+this.getEtat()+"', prix_oeuvrevente = "+this.getPrix()+", id_proprietaire = "+this.getId_proprietaire()+" where id_oeuvrevente ="+ this.getId_oeuvre();
        db.executeRequest(mysql);
    }

    /**
     * Insert une oeuvre dans la base de données
     * @throws Exception
     */
    public void Ajouter() throws Exception {
    	Db_outils db = Db_outils.getInstance();
        String mysql = "INSERT INTO oeuvrevente(titre_oeuvrevente,etat_oeuvrevente,prix_oeuvrevente,id_proprietaire) VALUES ('"+this.getTitre()+"','"+this.getEtat()+"',"+this.getPrix()+","+this.getId_proprietaire()+")";
        db.executeRequest(mysql);
    }
    
    public void Supprimer() throws Exception {
    	Db_outils db = Db_outils.getInstance();
        String mysql = "delete from oeuvrevente where id_oeuvrevente ="+ id_oeuvre;
        db.executeRequest(mysql);
    }
    
    public int supprimerOeuvreReservee() throws Exception {
    	
    	int id_adherent;
    	Db_outils db = Db_outils.getInstance();

        String mysql = "";
        mysql = "delete from reservation where id_oeuvrevente ="+ id_oeuvre;

        
        id_adherent = db.getIdAdherent(mysql);
        return id_adherent;
    	
    	
    }
    
}
