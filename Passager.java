import Personne;

import java.sql.Connection;
import java.sql.SQLException;

import ConnectDB;
public class Passager extends Personne {
    private int idPassager;
    private String dateNaissance;
    private int numeroTelephone;

    // Constructeur
    public Passager(int ID, String nom, String prenom, String email, String motDePasse,
                    int idPassager, String dateNaissance, int numeroTelephone) {
        super(ID, nom, prenom, email, motDePasse);
        this.idPassager = idPassager;
        this.dateNaissance = dateNaissance;
        this.numeroTelephone = numeroTelephone;
    }

    public String getTypePersonne() {
        return "passager";
    }

    // Getters spécifiques aux passagers
    public int getIdPassager() {
        return idPassager;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public int getNumeroTelephone() {
        return numeroTelephone;
    }

    public void seConnecter() throws SQLException {
        Connection connection = ConnectDB.getConnection();
        System.out.println("Vous êtes connecter");
    }
}
