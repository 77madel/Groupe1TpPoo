package ville.info.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ville {
    private int idVille;
    private String nom;

    public Ville(int idVille, String nom) {
        this.idVille = idVille;
        this.nom = nom;
    }

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static void ajouterUneVille() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom de la ville: ");
        String nom = scanner.nextLine();

        String sql = "INSERT INTO villedb(nom) VALUES(?)";
        Connexion connexion = new Connexion();

        try {
            Connection con = connexion.obtenirConnexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            ps.executeUpdate();
            System.out.println("Ville ajoutée avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void modifierVilleParId() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'ID de la ville à modifier: ");
        int idVille = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Entrez le nouveau nom de la ville: ");
        String nouveauNom = scanner.nextLine();

        String sql = "UPDATE villedb SET nom = ? WHERE idVille = ?";
        Connexion connexion = new Connexion();

        try {
            Connection con = connexion.obtenirConnexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nouveauNom);
            ps.setInt(2, idVille);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Ville modifiée avec succès !");
            } else {
                System.out.println("Aucune ville trouvée avec cet identifiant.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void afficherToutesLesVilles() {
        String sql = "SELECT * FROM villedb";
        Connexion connexion = new Connexion();

        try {
            Connection con = connexion.obtenirConnexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("Liste des villes:");
            while (rs.next()) {
                int idVille = rs.getInt("idVille");
                String nom = rs.getString("nom");
                System.out.println("ID: " + idVille + ", Nom: " + nom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu des villes:");
            System.out.println("1. Ajouter une ville");
            System.out.println("2. Modifier une ville");
            System.out.println("3. Afficher toutes les villes");
            System.out.println("4. Quitter");

            System.out.print("Votre choix: ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choix) {
                case 1:
                    ajouterUneVille();
                    break;
                case 2:
                    modifierVilleParId();
                    break;
                case 3:
                    afficherToutesLesVilles();
                    break;
                case 4:
                    System.out.println("Au revoir!");
                    System.exit(0);
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
}