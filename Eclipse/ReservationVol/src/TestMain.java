import java.sql.SQLException;
import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		Connexion.seConecter();
		
		/* Ajout De pays */
		// Pays.ajouterPays(Connexion.con, scanner);
		
		/* Ajout de Ville */
		// Ville.ajouterUneVille();
		
		/*Nouveau Aeroport
		Aeroport airport = new Aeroport(3, "Senegal Plane Station");
		AeroportDAO.ajouterAeroport(airport); */
		
		// Creation des Nouvelles personnes
		
		/*Passager passager1 = new Passager(1, "Traore", "Fakoro", "fakoro88@gmail.com", "73375200", "2002-12-01","hello123", 1);
		passager1.inscription(); */
		
		// AJout d'un vol
		// Vol.ajouterVol(Connexion.con, scanner);
		
		/* Reservation
		Reservation r = new Reservation();
		 r.EffecuterReservation(); */
		
		/* Ajout D'une Compagnie
		CompagnieAerienne comp = new CompagnieAerienne();
		comp.AjouterCompagnie(); */
		
		/* Ajout d'un Avion
		Avion avion = new Avion();
		avion.AjouterAvions(); */
		
		// Paiement de la reservation
		Paiement.ajouterPaiement(Connexion.con, scanner);
	}
}
