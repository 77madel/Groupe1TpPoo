import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AeroportDAO {
    private Connection connection;
    
    // Constructeur
    public AeroportDAO() {
        // Initialise la connexion à la base de données
        connect();
    }
    
    // Méthode pour établir la connexion à la base de données
    private void connect() {
        try {
            // Remplacez "url", "user" et "password" par les informations de connexion à votre base de données
            String url = "jdbc:mysql://localhost:3306/gestiondevolgroupe1";
            String user = "root";
            String password = "";
            
            // Établit la connexion
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Méthode pour ajouter les informations d'un aéroport dans la base de données
    public void ajouterAeroport(Aeroport aeroport) {
        try {
            // Requête SQL d'insertion
            String query = "INSERT INTO Aeroport (idAeroport, idVille, nomAeroport) VALUES (?, ?, ?)";
            
            // Crée un objet PreparedStatement avec la requête SQL
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            // Définit les valeurs des paramètres dans la requête SQL
            preparedStatement.setInt(1, aeroport.getIdAeroport());
            preparedStatement.setInt(2, aeroport.getIdVille());
            preparedStatement.setString(3, aeroport.getNomAeroport());
            
            // Exécute la requête SQL
            preparedStatement.executeUpdate();
            
            // Ferme le PreparedStatement
            preparedStatement.close();
            
            System.out.println("Aéroport ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Méthode pour fermer la connexion à la base de données
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
