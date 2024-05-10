
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

public void inscrire() throws SQLException {
    String inscriptionQuery = "INSERT INTO passagers (ID, nom, prenom, email, mot_de_passe, id_passager, date_naissance, numero_telephone) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection connection = ConnectDB.getConnection();
        PreparedStatement statement = connection.prepareStatement(inscriptionQuery)) {
        // Paramètres pour l'insertion du passager
        statement.setInt(1, this.getID());
        statement.setString(2, this.getNom());
        statement.setString(3, this.getPrenom());
        statement.setString(4, this.getEmail());
        statement.setString(5, this.getMotDePasse());
        statement.setInt(6, this.getIdPassager());
        statement.setString(7, this.getDateNaissance());
        statement.setInt(8, this.getNumeroTelephone());
        
        // Exécution de la requête d'insertion
        statement.executeUpdate();
        System.out.println("Passager inscrit avec succès !");
    } catch (SQLException e) {
        System.err.println("Erreur lors de l'inscription du passager : " + e.getMessage());
        throw e; // Propagation de l'exception pour une gestion supérieure
    }
}


    public void modifierReservation(int idReservation, String nouveauStatut) throws SQLException {
    String modificationQuery = "UPDATE reservations SET statut = ? WHERE id_reservation = ?";
    try (Connection connection = ConnectDB.getConnection();
        PreparedStatement statement = connection.prepareStatement(modificationQuery)) {
        // Paramètres pour la modification de la réservation
        statement.setString(1, nouveauStatut);
        statement.setInt(2, idReservation);
        
        // Exécution de la requête de mise à jour
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Réservation modifiée avec succès !");
        } else {
            System.out.println("Aucune réservation trouvée avec l'ID : " + idReservation);
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la modification de la réservation : " + e.getMessage());
        throw e; // Propagation de l'exception pour une gestion supérieure
    }
}


    public void verifierStatutReservation() {

    }

}
