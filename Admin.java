import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Admin extends Personne {
    private int idAdmin;

    // Constructeur
    public Admin(int idPersonne, String nom, String prenom, String email, String numeroDeTelephone, Date dateDeNaissance, String motDePasse, int idAdmin) {
        super(idPersonne, nom, prenom, email, numeroDeTelephone, dateDeNaissance, motDePasse);
        this.idAdmin = idAdmin;
    }

    // Getter et Setter spécifique à Admin
    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void ajouterCompagnie(CompagnieAerienne compagnie) throws SQLException {
        String ajoutComp = "INSERT INTO Compagnie (nomCompagnie, nombreDAvion, motDePasse, siteWeb, idAdmin) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(ajoutComp)) {
            statement.setString(1, compagnie.getNom_compagnie());
            statement.setString(2, compagnie.getNombreDAvion());
            statement.setString(3, compagnie.getMotDePasse());
            statement.setString(4, compagnie.getSiteWeb());
            statement.setInt(5, this.getIdAdmin()); // Utilise l'ID de l'admin courant
            statement.executeUpdate();
        }
    }

    public void supprimerCompagnie(int idCompagnie) throws SQLException {
        String supprComp = "DELETE FROM Compagnie WHERE idCompagnie = ?";
        try (Connection connection = ConnectDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(supprComp)) {
            statement.setInt(1, idCompagnie);
            statement.executeUpdate();
        }
    }

    public void modifierCompagnie(CompagnieAerienne compagnie) throws SQLException {
        String modifComp = "UPDATE Compagnie SET nomCompagnie = ?, nombreDAvion = ?, motDePasse = ?, siteWeb = ? WHERE idCompagnie = ?";
        try (Connection connection = ConnectDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(modifComp)) {
            statement.setString(1, compagnie.getNom_compagnie());
            statement.setString(2, compagnie.getNombreDAvion());
            statement.setString(3, compagnie.getMotDePasse());
            statement.setString(4, compagnie.getSiteWeb());
            statement.setInt(5, compagnie.getId_compagnie());
            statement.executeUpdate();
        }
    }
}
