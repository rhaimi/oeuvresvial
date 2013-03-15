package modeles;

public class jbUser {

	private String _login, _pwd, _nom, _prenom, _adresse;
    public void setNom(String nom){
        _nom = nom;
    }
    public String getNom(){
        return _nom;
    }
    public void setPrenom(String prenom){
        _prenom = prenom;
    }
    public String getPrenom(){
        return _prenom;
    }
    public void setLogin(String login){
        _login = login;
    }
    public String getLogin(){
        return _login;
    }
    public void setPwd(String pwd){
        _pwd = pwd;
    }
    public String getPwd(){
        return _pwd;
    }
    public String getAdresse(){
        return _adresse;
    }
    public void setAdresse(String adresse){
        _adresse = adresse;
    }

public boolean connecter(String login, String pwd){
    boolean retour = false;
    if (login.equals("admin") && pwd.equals("mdp")){
        retour = true;
    }
    return retour;
 }

}
