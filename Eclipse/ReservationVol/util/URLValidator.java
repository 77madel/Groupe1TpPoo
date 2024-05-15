import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLValidator {

    // Méthode pour vérifier si l'URL est valide
    public static boolean isValidURL(String url) {
        // Regex pour valider l'URL
        String urlRegex = "^(http://www\\.|https://www\\.|http://|https://)?[a-zA-Z0-9][-a-zA-Z0-9]+(\\.[a-zA-Z]{2,7})+(:\\d{1,5})?(/.*)?$";
        
        // Compiler l'expression régulière
        Pattern pattern = Pattern.compile(urlRegex);
        
        // Si l'URL est vide, elle n'est pas valide
        if (url == null) {
            return false;
        }
        
        // Matcher l'URL contre le pattern
        Matcher matcher = pattern.matcher(url);
        
        // Retourner si l'URL correspond au pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url;
        boolean isValid;

        // Boucle jusqu'à ce que l'utilisateur entre une URL valide
        do {
            System.out.print("Entrez le nom du site web (URL): ");
            url = scanner.nextLine();
            
            // Vérifier la validité de l'URL
            isValid = isValidURL(url);
            
            // Afficher un message en fonction de la validité de l'URL
            if (!isValid) {
                System.out.println("Erreur: Le nom du site web n'est pas valide. Veuillez réessayer.");
            } else {
                System.out.println("Succès: Le nom du site web est valide.");
            }
        } while (!isValid);
        
        // Fermer le scanner
        scanner.close();
    }
}
