import java.sql.SQLException;
import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		Connexion.seConecter();
		
		/* Ajout De pays */
		//Pays.ajouterPays(Connexion.con, scanner);
		
		/* Ajout de Ville */
		// Ville.ajouterUneVille();
		
		 /*Nouveau Aeroport
		Aeroport airport = new Aeroport(3, "Senegal Plane Station");
		AeroportDAO.ajouterAeroport(airport); */
		
		// Creation des Nouvelles personnes
		
		Passager passager = new Passager("Thera", "Mohmed", "mriam@gmail.com", "03450423", "2012-02-01","uiJbvzv");
		passager.inscription();
		
		// AJout d'un vol
		// Vol.ajouterVol(Connexion.con, scanner);
		
		// Reservation
		Reservation.EffecuterReservation(passager, scanner);
		
		/* Ajout D'une Compagnie
		CompagnieAerienne comp = new CompagnieAerienne();
		comp.AjouterCompagnie(); */
		
		/* Ajout d'un Avion
		Avion avion = new Avion();
		avion.AjouterAvions(); */
		
		// Paiement de la reservation
		// Paiement.ajouterPaiement(Connexion.con, scanner);
	}
}
