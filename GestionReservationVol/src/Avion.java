<<<<<<< HEAD
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
<<<<<<< HEAD

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, capacite);
=======
    public void ajouterAvion() {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Avion (nbreplace, nom, modele) VALUES (?, ?, ?)")) {
            statement.setString(1, nbreplace);
            statement.setString(2, nom);
            statement.setString(3, modele);
            statement.executeUpdate();
            System.out.println("Avion ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}