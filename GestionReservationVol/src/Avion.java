    import java.sql.Connection;
    import java.sql.SQLException;
    import java.util.Date;
    import java.util.Scanner;
    import java.sql.PreparedStatement;

public class Avion {

    private String capacite; 
    private String nom;
    private String modele;

        System.out.println("Veuillez donnee les informations de l'Avion : ");

        System.out.println("Nombre de place  : ");
        String capacite = scanner.nextLine();

        System.out.println("Nom : ");
        int nom = scanner.nextInt();

        System.out.println("Modele : ");
        int modele = scanner.nextInt();


    String sql = "INSERT INTO Avion (capacite, nom, modele) VALUES (?, ?, ?)";
    // String modifier = "UPDATE Avion SET capacite = ?, nom = ?, modele = ? WHERE immatriculation = ?";
    // Méthode pour ajouter un avion dans la base de données

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, capacite);
            statement.setString(2, nom);
            statement.setString(3, modele);

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