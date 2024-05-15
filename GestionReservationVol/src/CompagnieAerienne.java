import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompagnieAerienne {
    private String nomCompagnie;
    private String motDePasse;
    private String siteWeb;
    private int idAdmin;

    public String getNomCompagnie() {
        return nomCompagnie;
    }

    public void setNomCompagnie(String nomCompagnie) {
        this.nomCompagnie = nomCompagnie;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public static void main(String[] args) {
        CompagnieAerienne c = new CompagnieAerienne();
        c.AjouterCompagnie();
    }

    Scanner c = new Scanner(System.in);

    public void AjouterCompagnie() {
        System.out.println("Entrer le nom de la compagnie : ");
        setNomCompagnie(c.next());

        System.out.println("Saisissez le mot de passe : ");
        setMotDePasse(c.next());

        // Validation du site web
        String site;
        do {
            System.out.println("Donnez votre site web : ");
            site = c.next();
            if (isValidURL(site)) {
                setSiteWeb(site);
            } else {
                System.out.println("Erreur: Le site web n'est pas valide. Veuillez réessayer.");
            }
        } while (!isValidURL(site));

        System.out.println("Entrez l'identifiant de l'Admin :");
        setIdAdmin(c.nextInt());

        String sql = "INSERT INTO compagnie(nomCompagnie, motDePasse, siteWeb, idAdmin) VALUES (?, ?, ?, ?)";
        Connexion.seConecter();
        try {
            PreparedStatement ps = Connexion.con.prepareStatement(sql);
            ps.setString(1, getNomCompagnie());
            ps.setString(2, getMotDePasse());
            ps.setString(3, getSiteWeb());
            ps.setInt(4, getIdAdmin());
            ps.execute();
            System.out.println("Enregistrement effectué !!!!!");
            System.out.println("Les données sont : " + getNomCompagnie() + " " + getMotDePasse() + " " + getSiteWeb() + " " + getIdAdmin());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour vérifier si l'URL est valide
    public static boolean isValidURL(String url) {
        String urlRegex = "^(http://www\\.|https://www\\.|http://|https://)?[a-zA-Z0-9][-a-zA-Z0-9]+(\\.[a-zA-Z]{2,7})+(:\\d{1,5})?(/.*)?$";
        Pattern pattern = Pattern.compile(urlRegex);
        if (url == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}
