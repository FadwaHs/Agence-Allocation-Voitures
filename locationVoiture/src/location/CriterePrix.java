package location;

public class CriterePrix  implements Critere
{
	
	private int prix;

	public CriterePrix(int prix)
	{
		this.prix = prix;
	}

	 
	
	public boolean estSatisfaitPar(voiture v)
	{
	    if ( v.getPrix() < this.prix)
	    {
	    	return true;
	    }
	    	
	    return false;
		
	}
	
	
	
	

}
