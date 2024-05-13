public class Aeroport {
    private int idAeroport;
    private int idVille;
    private String nomAeroport;
    
    // Constructeur
    public Aeroport(int idAeroport, int idVille, String nomAeroport) {
        this.idAeroport = idAeroport;
        this.idVille = idVille;
        this.nomAeroport = nomAeroport;
    }
    
    // Getters et Setters
    public int getIdAeroport() {
        return idAeroport;
    }
    
    public void setIdAeroport(int idAeroport) {
        this.idAeroport = idAeroport;
    }
    
    public int getIdVille() {
        return idVille;
    }
    
    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }
    
    public String getNomAeroport() {
        return nomAeroport;
    }
    
    public void setNomAeroport(String nomAeroport) {
        this.nomAeroport = nomAeroport;
    }
    
    // Méthode pour afficher les informations de l'aéroport
    @Override
    public String toString() {
        return "Aeroport [idAeroport=" + idAeroport + ", idVille=" + idVille + ", nomAeroport=" + nomAeroport + "]";
    }

    
}
