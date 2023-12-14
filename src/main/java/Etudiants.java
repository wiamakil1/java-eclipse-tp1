import java.sql.*;

public class Etudiants {
    private Connection conn;

    public Etudiants(String url, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch ( SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void ajouterEtudiant(etudiant ee) {
        try {
            String sqlInsert = "INSERT INTO etudiants (nom, prenom, age) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
            pstmt.setString(1, ee.getnom());
            pstmt.setString(2, ee.getprenom());
            pstmt.setInt(3, ee.getage());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Étudiant ajouté avec succès !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afficherEtudiants() {
        try {
            Statement stmt = conn.createStatement();
            String sqlSelect = "SELECT * FROM etudiants";
            ResultSet rs = stmt.executeQuery(sqlSelect);

            System.out.println("Liste des étudiants :");

            while (rs.next()) {
                int age = rs.getInt("age");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");

                System.out.println("Age: " + age + ", Nom: " + nom + ", Prénom: " + prenom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void supprimerEtudiants(int idd) {
        try {
            String sqlDelete = "DELETE FROM etudiants WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sqlDelete);
            pstmt.setInt(1, idd);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Étudiant supprimé avec succès !");
            } else {
                System.out.println("Aucun étudiant trouvé avec l'ID spécifié.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fermerConnexion() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connexion fermée.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}

