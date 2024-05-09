import Personne;
public class Admin extends Personne {
    private int adminID;

    // Constructeur
    public Admin(int ID, String nom, String prenom, String email, String motDePasse, int adminID) {
        super(ID, nom, prenom, email, motDePasse);
        this.adminID = adminID;
    }

    public String getTypePersonne() {
        return "admin";
    }

    // Getter spécifique à l'admin
    public int getAdminID() {
        return adminID;
    }

    public void seConnecter() {
        System.out.println("Vous êtes connecter");
    }
}
