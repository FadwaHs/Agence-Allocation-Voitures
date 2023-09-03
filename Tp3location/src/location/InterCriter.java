package location;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InterCriter implements Critere
{
    // list des criteres :
	private List<Critere> lesCriteres;

	public InterCriter()
	{
		
		this.lesCriteres = new ArrayList<Critere>();
	}
	
	// add criter 
	public void addCritere(Critere c)
	{ 
		lesCriteres.add(c);
	}

	
	
	// Satisfait all Criter:
	public boolean estSatisfaitPar(voiture v)
	{
		Iterator<Critere> criter = lesCriteres.iterator(); ///parcourire lesCriteres
		
		while (criter.hasNext())
		{
			Critere c = criter.next();
			
			if( ! c.estSatisfaitPar(v) )
			{
				 return false;
			}
	    }
		
		return true;
	}
	
	
	
	
	
	
	
}
