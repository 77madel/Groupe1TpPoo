package ville.info.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Vol {
    private String ville_depart;
    private String ville_arriver;
    private Date date_depart = new Date();
    private Date date_arrive;
    private int nbr_de_place;
    private int tarif;

    public static void ajouterVol(Connection connection, Scanner scanner){
        System.out.println("Veuillez saisir les informations de vol :");

        System.out.print("Ville de départ : ");
        String villeDepart = scanner.nextLine();

        System.out.print("Ville d'arrivée : ");
        String villeArrivee = scanner.nextLine();

        System.out.print("date depart (au format YYYY-MM-DD) : ");
        String date_depart = scanner.nextLine();

        System.out.print("date arriver (au format YYYY-MM-DD) : ");
        String date_arriver = scanner.nextLine();

        System.out.print("nombre de place  : ");
        int nbr_de_place = scanner.nextInt();

        System.out.print("tarif  : ");
        int tarif = scanner.nextInt();

        String sql = "INSERT INTO vol (ville_depart, ville_arriver, date_depart, date_arriver, nbr_de_place, tarif ) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, villeDepart);
            statement.setString(2, villeArrivee);
            statement.setString(3, date_depart);
            statement.setString(4, date_arriver);
            statement.setInt(5, nbr_de_place);
            statement.setInt(6, tarif);

            // Exécutez la requête
            int lignesModifiees = statement.executeUpdate();
            if (lignesModifiees > 0) {
                System.out.println("Les données ont été ajoutées avec succès !");
            } else {
                System.out.println("Erreur lors de l'ajout des données.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}