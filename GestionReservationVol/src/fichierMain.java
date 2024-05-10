package Groupe1TpPoo.GestionReservationVol.src;
public class FichierMain {
    public static void main(String[] args) {
        // Création d'une autre compagnie aérienne
        CompagnieAerienne compagnie2 = new CompagnieAerienne(2, "AirSenegal", 8, "mdp456", "www.airsenegal.com", 2);

        // CréGroupe1TpPoo/GestionReservationVol/src/fichierMain.javad'un avion
        Avion avion2 = new Avion("Airbus A330", 250);

        // Ajout de l'avion à la compagnie
        compagnie2.ajouterAvion(avion2);

        // Affichage des avions de la compagnie
        System.out.println("Avions de la compagnie :");
        for (Avion avion : compagnie2.getAvions()) {
            System.out.println(avion);
        }

        // Suppression de l'avion
        compagnie2.supprimerAvion(avion2);

        // Affichage des avions après suppression
        System.out.println("\nAvions après suppression :");
        for (Avion avion : compagnie2.getAvions()) {
            System.out.println(avion);
        }

        // Création d'un vol
        Vol vol2 = new Vol("Dakar", "Bamako", "2024-05-20", 2, 200);

        // Ajout du vol à la compagnie
        compagnie2.ajouterVol(vol2);

        // Modification du vol
        compagnie2.modifierVol(vol2, "Dakar", "Paris", "2024-05-25");

        // Affichage des vols de la compagnie après modification
        System.out.println("\nVols de la compagnie après modification :");
        for (Vol vol : compagnie2.getVols()) {
            System.out.println(vol);
        }
    }
}
