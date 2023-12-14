import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*public class test {
public static void main(String[ ]args)  {
	try {
	    
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		}

	   
	    String url = "jdbc:mysql://localhost:3306/tp_jdbc";
	    String user = "root";
	    String password = "";
	    Connection conn = DriverManager.getConnection(url, user, password);
	    
	    System.out.print("connects");

	

	} catch ( SQLException e) {
	    ((Throwable) e).printStackTrace();
	}

	
}
}*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class test {
	public static void main(String[] args) {
	    String url = "jdbc:mysql://localhost:3306/tp_jdbc";
	    String user = "root";
	    String password = "";

	    Etudiants gestionEtudiants = new Etudiants(url, user, password);
	    
	    etudiant nouveau=new etudiant("wiam","akil",19);
	    
	    gestionEtudiants.ajouterEtudiant(nouveau);
	    System.out.println("l'etudiant du nom: "+nouveau.getnom()+"et du prenom: "+nouveau.getprenom()+"a ete ajoute avec succes");
	
	    
	    System.out.println("Affichage des etudiants");
	    gestionEtudiants.afficherEtudiants();

	    System.out.println("Suppresion d'un etudiant:");
	    gestionEtudiants.supprimerEtudiants(2);
	    
	    
	    System.out.println("Nouveau affichage ");
	    gestionEtudiants.afficherEtudiants();
	}

}

