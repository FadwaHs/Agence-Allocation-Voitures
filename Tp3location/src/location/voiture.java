package location;

import java.util.Objects;
 
public class voiture {
	
	
	private String nom;
	private String marque;
	private int annee;
	private int  prix;
	


	public voiture(String nom, String marque, int annee, int prix) {
		
 
		this.nom = nom;
		this.marque = marque;
		this.annee = annee;
		this.prix = prix;
	}



	public String toString() {
		
		return "voiture : [nom=" + nom + ", marque=" + marque + ", annee=" + annee + ", prix=" + prix + "]";
	}



	
	public boolean equals(voiture other)
	{
		if (this == other)
			return true;
		
		if (other == null)
			return false;
		
		
		return annee == other.annee && Objects.equals(marque, other.marque) && Objects.equals(nom, other.nom)
				        && prix == other.prix;
	}



	public String getNom() {
		return nom;
	}



	public String getMarque() {
		return marque;
	}



	public int getAnnee() {
		return annee;
	}



	public int getPrix() {
		return prix;
	}

	
	
	 
	

}
















