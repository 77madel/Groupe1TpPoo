package bins;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connexion.Connexion;

public class Ville {
	private String nom;
	public static void main(String[] args) {
		Ville v=new Ville();
		// TODO Auto-generated method stub
		
		v.EnregistrerVille();
	}
	
Ville (){
	
 }

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public void EnregistrerVille() {
	Ville v=new Ville();
	String sql="INSERT INTO ville(nom) values(?)";
	System.out.println("Renseigner le nom de la ville :");
	Scanner c= new Scanner(System.in);
	v.setNom(c.next());
	System.out.println("Voulez-vous enregistrer ? si oui cliquez sur 1 ");
	int a=c.nextInt();
	
	try {
		Connexion.seConecter();
		PreparedStatement ps=Connexion.con.prepareStatement(sql);
		ps.setString(1, v.getNom());
		ps.execute();
		System.out.println("enregistrement Effectuer");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}


}
