import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try{
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/reservation_vol",
					"root",
					""
			);
			Scanner scanner = new Scanner(System.in);
			//Vol.ajouterVol(connection,scanner);
			Categorie.ajouteCategorie(connection,scanner);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
