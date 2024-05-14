import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Categorie {
    private int id;
    private String nom;
    private int vil_id;

    public static void ajouteCategorie(Connection connection, Scanner scanner){
        System.out.println("Les informations sur les categories : ");

        System.out.println("Nom categorie : ");
        String nom = scanner.nextLine();

        System.out.println("Vol id : ");
        int vol_id = scanner.nextInt();

        String sql = "INSERT INTO categorie (nom, vol_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,"nom");
            statement.setInt(2,vol_id);

            int lignesModifiees = statement.executeUpdate();
            if (lignesModifiees > 0) {
                System.out.println("Les données du categorie ont été ajoutées avec succès !");
            } else {
                System.out.println("Erreur lors de l'ajout des données.");
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}