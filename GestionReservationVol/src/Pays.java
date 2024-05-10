import java.util.ArrayList;
import java.util.List;

public class Pays {
    int idPays;
    String nom;
    List<String> villes;  // Liste des villes associées au pays

    // Constructeur pour initialiser le pays avec un nom et un identifiant
    public Pays(int idPays, String nom) {
        this.idPays = idPays;
        this.nom = nom;
        this.villes = new ArrayList<>();  // Initialisation de la liste des villes
    }

    // Ajouter une ville à la liste des villes du pays
    void ajouterVille(String ville) {
        if (!villes.contains(ville)) {
            villes.add(ville);
            System.out.println("Ville ajoutée: " + ville);
        } else {
            System.out.println("La ville " + ville + " existe déjà.");
        }
    }

    // Modifier le nom d'une ville dans la liste des villes du pays
    void modifierVille(String villeAncienne, String villeNouvelle) {
        int index = villes.indexOf(villeAncienne);
        if (index != -1) {  // Si la ville à modifier existe
            villes.set(index, villeNouvelle);  // Modifier la ville
            System.out.println("Ville modifiée de " + villeAncienne + " à " + villeNouvelle);
        } else {
            System.out.println("La ville " + villeAncienne + " n'a pas été trouvée.");
        }
    }

    // Supprimer une ville de la liste des villes du pays
    void supprimerVille(String ville) {
        if (villes.remove(ville)) {  // Supprime la ville si elle existe
            System.out.println("Ville supprimée: " + ville);
        } else {
            System.out.println("La ville " + ville + " n'a pas été trouvée.");
        }
    }

    // Afficher les villes du pays
    void afficherVilles() {
        System.out.println("Liste des villes du pays " + nom + ":");
        for (String ville : villes) {
            System.out.println("- " + ville);
        }
    }
}
