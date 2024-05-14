import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Vol {

    public static void ajouterVol(Connection connection, Scanner scanner){
        System.out.println("Veuillez saisir les informations de vol :");

        System.out.print("Ville de départ : ");
        String villeDepart = scanner.nextLine();

        System.out.print("Ville d'arrivée : ");
        String villeArrivee = scanner.nextLine();

        System.out.print("Date de départ (au format YYYY-MM-DD) : ");
        String dateDepart = scanner.nextLine();

        System.out.print("Date d'arrivée (au format YYYY-MM-DD) : ");
        String dateArrivee = scanner.nextLine();

        int nbr_de_escale = 0;
        boolean isInt = false;
        do {
            System.out.print("Nombre d'escale : ");
            if (scanner.hasNextInt()) {
                nbr_de_escale = scanner.nextInt();
                isInt = true;
            } else {
                System.out.println("Veuillez saisir un entier.");
                scanner.next(); // Pour vider le scanner et éviter une boucle infinie
            }
        } while (!isInt);

        System.out.print("Tarif : ");
        int tarif = scanner.nextInt();

        String sql = "INSERT INTO vol (villeDeDepart, villeDArrive, dateDeDepart, dateDArrive, nombreDEscale, tarif ) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, villeDepart);
            statement.setString(2, villeArrivee);
            statement.setString(3, dateDepart);
            statement.setString(4, dateArrivee);
            statement.setInt(5, nbr_de_escale);
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

    public static void modifierVol(Connection connection, Scanner scanner) {
        System.out.println("Modification vol : ");
        
        
        System.out.print("Ville de départ : ");
        String villeDepart = scanner.nextLine();

        System.out.print("Ville d'arrivée : ");
        String villeArrivee = scanner.nextLine();

        System.out.print("Date de départ (au format YYYY-MM-DD) : ");
        String dateDepart = scanner.nextLine();

        System.out.print("Date d'arrivée (au format YYYY-MM-DD) : ");
        String dateArrivee = scanner.nextLine();

        int nbr_de_escale = 0;
        boolean isInt = false;
        do {
            System.out.print("Nombre d'escale : ");
            if (scanner.hasNextInt()) {
                nbr_de_escale = scanner.nextInt();
                isInt = true;
            } else {
                System.out.println("Veuillez saisir un entier.");
                scanner.next(); // Pour vider le scanner et éviter une boucle infinie
            }
        } while (!isInt);

        System.out.print("Tarif : ");
        int tarif = scanner.nextInt();


        int idVol = 0;
        do {
            System.out.println("ID Categorie : ");
            if (scanner.hasNextInt()) {
                idVol = scanner.nextInt();
                isInt = true;
            } else {
                System.out.println("Veuillez saisir un entier.");
                scanner.next(); // Pour vider le scanner et éviter une boucle infinie
            }
        } while (!isInt);
           
        String sql = "UPDATE vol SET villeDeDepart = ?, villeDArrive = ?, dateDeDepart = ?, dateDArrive = ?, nombreDEscale = ?, tarif = ? WHERE idVol = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, villeDepart);
            statement.setString(2, villeArrivee);
            statement.setString(3, dateDepart);
            statement.setString(4, dateArrivee);
            statement.setInt(5, nbr_de_escale);
            statement.setInt(6, tarif);
            statement.setInt(7, idVol);

            int lignesModifiees = statement.executeUpdate();
            if (lignesModifiees > 0) {
                System.out.println("Vol a été modifié avec succès !");
            } else {
                System.out.println("Erreur lors de la modification du vol.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void supprimerVol(Connection connection, Scanner scanner) {
        System.out.println("Suppression vol : ");
        int idVol = 0;
        boolean isInt = false;
        do {
            System.out.println("ID vol à supprimer : ");
            if (scanner.hasNextInt()) {
                idVol = scanner.nextInt();
                isInt = true;
            } else {
                System.out.println("Veuillez saisir un entier.");
                scanner.next(); // Pour vider le scanner et éviter une boucle infinie
            }
        } while (!isInt);

        String sql = "DELETE FROM vol WHERE idVol = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idVol);

            int lignesModifiees = statement.executeUpdate();
            if (lignesModifiees > 0) {
                System.out.println("Vol a été supprimé avec succès !");
            } else {
                System.out.println("Erreur lors de la suppression du vol.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
