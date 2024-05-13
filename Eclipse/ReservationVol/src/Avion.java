import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Avion {
	private String immatriculation ;
	private int capacite;
	private String modele;
	private int idCompagnie;
	
	private String getImmatriculation() {
		return immatriculation;
	}
	private void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	private int getCapacite() {
		return capacite;
	}
	private void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	private String getModele() {
		return modele;
	}
	private void setModele(String modele) {
		this.modele = modele;
	}
	private int getIdCompagnie() {
		return idCompagnie;
	}
	private void setIdCompagnie(int idCompagnie) {
		this.idCompagnie = idCompagnie;
	}
	
	public static void main(String[] args) {
		Avion a=new Avion();
		a.AjouterAvions();
	}
	
	public void AjouterAvions() {
		Avion a=new Avion();
		try (Scanner c = new Scanner(System.in)) {
			System.out.println("Entrez l'immatriculation de l'avion : ");
			a.setImmatriculation(c.next());
			System.out.println("Entrez le model de l'avion : ");
			a.setModele(c.next());
			System.out.println("Quel est le nombre de places dans l'avion ? ");
			a.setCapacite(c.nextInt());
			System.out.println("Entrez l'identifiant de la compagnie : ");
			a.setIdCompagnie(c.nextInt());
		}
		
		String sql="INSERT INTO avion VALUES(?,?,?,?)";
		Connexion.seConecter();
		try {
			PreparedStatement ps=Connexion.con.prepareStatement(sql);
			ps.setString(1, a.getImmatriculation());
			ps.setInt(2, a.getCapacite());
			ps.setString(3, a.getModele());
			ps.setInt(4, a.getIdCompagnie());
			ps.execute();
			System.out.println("Enregistrement effectuée !!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
