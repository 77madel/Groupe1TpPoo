package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	public static Connection con;
	public static void seConecter() {
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/reservation";
			String user="root";
			String pass="";
			con=DriverManager.getConnection(url,user,pass);
			System.out.println("Connection reusi ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connexion c=new Connexion();
		c.seConecter();
	}
	
}
