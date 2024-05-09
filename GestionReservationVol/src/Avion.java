public class Avion {
    
    import java.sql.*;

    private String nbreplace; 
    private String nom;
    private String modele;

    // Constructeur

    public void Avion(String nbreplace, String nom, String modele){
        this.nbreplace = nbreplace;
        this.nom = nom;
        this.modele = modele;
    }

        // Getter et Setter de Modele

    public String getModele(){
        return modele;
    }
    public void getModele(String modele){
        this.modele = modele;
    }

        // Getter et Setter de Vol

    public String getNbreplace(){
        return nbreplace;
    }
    public void setNbreplace(String nbreplace){
        this.nbreplace = nbreplace;
    }

            // Getter et Setter de compagnie_aerienne

    public String getCompagnie_aerienne(){
        return nom;
    }
    public void setCompagnie_aerienne(String nom){
        this.nom = nom;
    }

    // Méthode pour établir une connexion à la base de données
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Avion";
        String user = "votre_utilisateur";
        String password = "votre_mot_de_passe";
        return DriverManager.getConnection(url, user, password);
    }
    
    // Méthode pour ajouter un avion dans la base de données
    public void ajouterAvion() {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Avion (nbreplace, nom, modele) VALUES (?, ?, ?)")) {
            statement.setString(1, nbrePlace);
            statement.setString(2, nom);
            statement.setString(3, modele);
            statement.executeUpdate();
            System.out.println("Avion ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour modifier un avion dans la base de données
    public void modifierAvion(int immatriculation) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE Avion SET nbreplace = ?, nom = ?, modele = ? WHERE immatriculation = ?")) {
            statement.setString(1, nbrePlace);
            statement.setString(2, nom);
            statement.setString(3, modele);
            statement.setInt(4, immatriculation);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Avion modifié avec succès !");
            } else {
                System.out.println("Aucun avion trouvé avec l'immatriculation spécifiée.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer un avion de la base de données
    public void supprimerAvion(int immatriculation) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Avion WHERE immatriculation = ?")) {
            statement.setInt(1, immatriculation);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Avion supprimé avec succès !");
            } else {
                System.out.println("Aucun avion trouvé avec l'immatriculation spécifiée.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}