import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    // Méthode pour vérifier si l'email est valide
    public static boolean isValidEmail(String email) {
        // Regex pour valider l'adresse email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        // Compiler l'expression régulière
        Pattern pattern = Pattern.compile(emailRegex);
        
        // Si l'email est vide, il n'est pas valide
        if (email == null) {
            return false;
        }
        
        // Matcher l'email contre le pattern
        Matcher matcher = pattern.matcher(email);
        
        // Retourner si l'email correspond au pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email;
        boolean isValid;

        // Boucle jusqu'à ce que l'utilisateur entre un email valide
        do {
            System.out.print("Entrez votre adresse email: ");
            email = scanner.nextLine();
            
            // Vérifier la validité de l'email
            isValid = isValidEmail(email);
            
            // Afficher un message en fonction de la validité de l'email
            if (!isValid) {
                System.out.println("Erreur: L'adresse email n'est pas valide. Veuillez réessayer.");
            } else {
                System.out.println("Succès: L'adresse email est valide.");
            }
        } while (!isValid);
        
        // Fermer le scanner
        scanner.close();
    }
}
