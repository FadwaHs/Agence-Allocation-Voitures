package location;

public class Client implements Comparable<Client> 
{
	  
	/*
	 * Note :
	 * Cette interface impose un ordonnancement global sur les objets de chaque classe qui l'implémente. 
	 * Cet ordre est appelé ordre naturel de la classe 
	 * et la méthode compareTo de la classe est appelée sa méthode de comparaison naturelle.
	 */
	
    private String nom;
    private String prenom;
    private String civilite;
    private  String cin; 
    
    
	public Client(String nom, String prenom, String civilite, String cin) {
	
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
		this.cin = cin;
	}



	public String toString() {
		return "Client : [nom=" + nom + ", prenom=" + prenom + ", civilite=" + civilite + ", cin=" + cin + "]";
	}
	
	

	public String getNom() {
		return nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public String getCivilite() {
		return civilite;
	}



	public String getCin() {
		return cin;
	}



	/// par ordre Alphabetique Des Clients
	public int compareTo(Client cl)
	{
	     
		if (nom.compareTo(cl.getNom()) <0 )
			return -1;
		
		else if(nom.compareTo(cl.getNom())==0 )
			
			return 0;
		else
			 return 1;
	}
	
	
	
  
}









