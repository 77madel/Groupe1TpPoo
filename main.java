import Personne;
import Passager;
import Admin;
public class main {
    public static void main(String[] args) {
        // Création d'un passager
        Passager passager = new Passager(1, "John", "Doe", "john@example.com",
                                        "pass123", 1001, "1990-05-15", 123456789);

        // Création d'un administrateur
        Admin admin = new Admin(2, "Alice", "Smith", "alice@example.com", "admin456", 5001);

        // Affichage des informations
        afficherInformationsPersonne(passager);
        afficherInformationsPersonne(admin);
    }

    public static void afficherInformationsPersonne(Personne personne) {
        System.out.println("ID: " + personne.getID());
        System.out.println("Nom: " + personne.getNom());
        System.out.println("Prénom: " + personne.getPrenom());
        System.out.println("Email: " + personne.getEmail());
        System.out.println("Type de personne: " + personne.getTypePersonne());
        System.out.println(); // Saut de ligne
    }
}
