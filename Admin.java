import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public void ajouterCompagnie(CompagnieAerienne compagnie) throws SQLException {
        String ajoutComp = "INSERT INTO compagnie (ID_comp, nom_comp, nbre_d_avion, site_web, mot_de_passe, id_admin) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(ajoutComp)) {
            statement.setInt(1, compagnie.getId_comp());
            statement.setString(2, compagnie.getNom_comp());
            statement.setInt(3, compagnie.getNbred_avion());
            statement.setString(4, compagnie.getSiteWeb());
            statement.setString(5, compagnie.getMdp());
            statement.setInt(6, this.getAdminID()); // Utilise l'ID de l'admin courant
            statement.executeUpdate();
        }
    }

    public void supprimerCompagnie(int idCompagnie) throws SQLException {
        String supprComp = "DELETE FROM compagnie WHERE ID_comp = ?";
        try (Connection connection = ConnectDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(supprComp)) {
            statement.setInt(1, idCompagnie);
            statement.executeUpdate();
        }
    }

    public void modifierCompagnie(CompagnieAerienne compagnie) throws SQLException {
        String modifComp = "UPDATE compagnie SET nom_comp = ?, nbre_d_avion = ?, site_web = ?, mot_de_passe = ? WHERE ID_comp = ?";
        try (Connection connection = ConnectDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(modifComp)) {
            statement.setString(1, compagnie.getNom_comp());
            statement.setInt(3, compagnie.getNbred_avion());
            statement.setString(4, compagnie.getSiteWeb());
            statement.setString(5, compagnie.getMdp());
            statement.setInt(5, compagnie.getId_comp());
            statement.executeUpdate();
        }
    }
}
