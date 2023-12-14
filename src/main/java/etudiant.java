
public class etudiant {
	private String nom;
	private String prenom;
	private int age;
	
	public etudiant(String nom,String prenom,int age) {
		this.nom=nom;
		this.prenom=prenom;
		this.age=age;
	}
	
	
	public String getnom() {
		return nom;
	}
	
	public String getprenom() {
		return prenom;
	}
	
	public int getage() {
		return age;
	}
}