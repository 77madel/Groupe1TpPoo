

public class Main {
    public static void main(String[] args) {
        // Création d'une instance de la classe Admin avec des valeurs factices
        Admin admin = new Admin(1, "GOITA", "Assimi", "assimigoita@gmail.com", null, null, null, 0);

        // Utilisation de la méthode getNom() pour récupérer le nom de l'admin
        String nom = admin.getNom();

        // Affichage du nom de l'admin
        System.out.println("Nom de l'admin : " + nom);
    }
}

