import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        // Création d'une instance de la classe Admin
        Admin admin = new Admin(1, "GOITA", "Assimi", "assimigoita@gmail.com", "Mali", 1);
        
        // Utilisation des méthodes de l'objet Admin
        String nom = admin.getNom(); // Utilisation de la méthode getNom() héritée de la classe Personne
        System.out.println("Nom de l'admin : " + nom); // Affichage du nom de l'admin
        
        
        CompagnieAerienne compagnie = new CompagnieAerienne(1, "Air Mali", 0, "123", null, 0);
        try {
            admin.ajouterCompagnie(compagnie);
            System.out.println("Compagnie aérienne ajoutée avec succès.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de la compagnie aérienne : " + e.getMessage());
        }
    }
}
