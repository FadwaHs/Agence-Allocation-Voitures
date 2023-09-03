package location;

public class CritereAnnee implements Critere
{

	private int annee;
	
	public CritereAnnee( int annee )
	{
		this.annee = annee;
	}
 
	
	public boolean estSatisfaitPar(voiture v)
	{
	   
		if(v.getAnnee() == this.annee)
		{
			return true;
		}
		
		return false;
	}
	
}
