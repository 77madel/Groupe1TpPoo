public class Passager extends Personne {
    private int idPassager;
    private String dateNaissance;
    private int numeroTelephone;

    // Constructeur
    public Passager(int ID, String nom, String prenom, String email, String motDePasse,
                    int idPassager, String dateNaissance, int numeroTelephone) {
        super(ID, nom, prenom, email, motDePasse);
        this.idPassager = idPassager;
        this.dateNaissance = dateNaissance;
        this.numeroTelephone = numeroTelephone;
    }

    @Override
    public String getTypePersonne() {
        return "passager";
    }

    // Getters spécifiques aux passagers
    public int getIdPassager() {
        return idPassager;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public int getNumeroTelephone() {
        return numeroTelephone;
    }

    // Autres méthodes si nécessaire
}
