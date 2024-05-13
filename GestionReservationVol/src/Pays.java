import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Pays {
    private int idPays;
    private String nom;

    public static void ajouterPays(Connection connection, Scanner scanner) {
        System.out.println("Ajout d'un pays : ");

        System.out.println("Nom du pays : ");
        String nom = scanner.nextLine();

        String sql = "INSERT INTO pays (nom) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nom);

            int lignesModifiees = statement.executeUpdate();
            if (lignesModifiees > 0) {
                System.out.println("Les données du pays ont été ajoutées avec succès !");
            } else {
                System.out.println("Erreur lors de l'ajout des données.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void modifierNomPays(Connection connection, Scanner scanner) {
        System.out.println("Modification du nom d'un pays : ");

        System.out.println("ID du pays à modifier : ");
        int idPays = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne

        System.out.println("Nouveau nom du pays : ");
        String nouveauNom = scanner.nextLine();

        String sql = "UPDATE pays SET nom = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nouveauNom);
            statement.setInt(2, idPays);

            int lignesModifiees = statement.executeUpdate();
            if (lignesModifiees > 0) {
                System.out.println("Le nom du pays a été modifié avec succès !");
            } else {
                System.out.println("Erreur lors de la modification du nom du pays.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void supprimerPays(Connection connection, Scanner scanner) {
        System.out.println("Suppression d'un pays : ");

        System.out.println("ID du pays à supprimer : ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM pays WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int lignesModifiees = statement.executeUpdate();
            if (lignesModifiees > 0) {
                System.out.println("Le pays a été supprimé avec succès !");
            } else {
                System.out.println("Erreur lors de la suppression du pays.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
