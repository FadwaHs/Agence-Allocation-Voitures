package location;

public class CritereMarque implements Critere
{
   
	private String Marque;
	
	public CritereMarque( String Marque )
	{ 
		this.Marque = Marque; 
		
	}

	
	public boolean estSatisfaitPar(voiture v)
	{
	   
		if(v.getMarque() == this.Marque)
		{
			return true;
		}
		
		return false;
		
	}
	
	

}
