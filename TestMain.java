public class TestMain {
    public static void main(String[] args) {
        Aeroport nouvelAeroport = new Aeroport(1, 1, "Aéroport International");
        
        // Crée un ojet AeroportDAO
        AeroportDAO aeroportDAO = new AeroportDAO();
        
        // Ajoute l'aéroport à la base de données en utilisant la méthode ajouterAeroport()
        aeroportDAO.ajouterAeroport(nouvelAeroport);
        
        // Ferme la connexion à la base de données
        aeroportDAO.disconnect();
    }
}
