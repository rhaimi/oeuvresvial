package erreurs;

public class ExceptionPerso extends Exception implements java.io.Serializable {

    private String message;
    private String type;

    public ExceptionPerso() {
    }

    public ExceptionPerso(String libelle, String type) {
        this.message = libelle;
        this.type = type;
    }

    public ExceptionPerso(String libelle) {
        this.message = libelle;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(java.lang.String libelle) {
        this.message = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
