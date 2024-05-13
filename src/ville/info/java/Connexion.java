package ville.info.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private String url = "jdbc:mysql://localhost:3306/reservationvol";
    private String utilisateur = "root";
    private String motDePasse = "";

    public Connection obtenirConnexion() {
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion : " + e.getMessage());
        }
        return connexion;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Connexion c = new Connexion();
      c.obtenirConnexion();
	}

}
