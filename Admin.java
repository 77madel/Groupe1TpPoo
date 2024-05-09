public class Admin extends Personne {
    private int adminID;

    // Constructeur
    public Admin(int ID, String nom, String prenom, String email, String motDePasse, int adminID) {
        super(ID, nom, prenom, email, motDePasse);
        this.adminID = adminID;
    }

    @Override
    public String getTypePersonne() {
        return "admin";
    }

    // Getter spécifique à l'admin
    public int getAdminID() {
        return adminID;
    }

    // Autres méthodes si nécessaire
}
