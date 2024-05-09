public abstract class Personne {
    private int ID;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;

    // Constructeur avec paramètre
    public Personne(int ID, String nom, String prenom, String email, String motDePasse) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    // Méthode abstraite à implémenter dans les classes filles
    public abstract String getTypePersonne();
    public abstract String seConnecter();

    // Getters et setters
    public int getID() {
        return ID;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    
}
