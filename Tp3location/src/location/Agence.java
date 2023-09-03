
package location;

import java.util.*;

public class Agence  
{
   
	private List<voiture> voiture; /// list des voitures
	
	private List<Client> client;  /// list des client
	// map:
	private Map<Client,voiture> Locations; // key:Client Val:voiture 
	
	                                       /* important : Client must implement Comparable. 
	                                        * The implementation of Comparable is what defines the natural ordering.
	                                        */

	/// Constructeur par defaut
	public Agence() 
	{
	    	this.voiture = new ArrayList<voiture>();
	    	
	    	this.client = new ArrayList<Client>();
	    	
	    	this.Locations =  new TreeMap<Client,voiture>();
	    
	}
	
	public void add_voiture(voiture v)
	{
		this.voiture.add(v);
	}
	
	
	public void add_client(Client c) //// AJouter Client
	{
	     this.client.add(c);
	}
	
	
	public Iterator<voiture> selectionne(Critere c)
	{
		
		Iterator<voiture> itr = voiture.iterator(); // pour parcourir
		
		List<voiture> voitureC  = new ArrayList<voiture>(); // voitureC : pour stocker le resultat de recherche
		
		while (itr.hasNext())
		{
			voiture v = itr.next();
			if( c.estSatisfaitPar(v) )
			{
				 //stocker dans une autre liste des voitures  qui satisfont le critère c ( Marque ou Prix )
				voitureC.add(v);
			}
	    }
	
		 return voitureC.iterator();
	} 
	
	
	public void afficheSelection( Critere c )
	{     
		Iterator<voiture> itvoiture =selectionne(c);
		
	     while( itvoiture.hasNext() )	
	     {
	    	 
	    	 System.out.println( itvoiture.next().toString() );
	     }
	}


	public String toString() {
		
		return "Agence [voiture=" + voiture + "]";
	}
	
	
	//// Functions :
	
	public void loueVoiture(Client client, voiture v) throws notexiste , louee
	{
		
		if ( voiture.contains(v) )
		{
			if(! Locations.containsValue(v) )
			{
				//cas correcte --> Add loue Voiture:
				Locations.put(client, v);
				
			}
			else
			{
				//Le cas ou elle existe mais elle est déjà louée :
				throw new louee();
			}
			
		}
	}
	
	
	/// afficher les Location Voiture louée avec son Client 
	public Map<Client,voiture> afficher_Location()
	{
		// Iterating over Map using for each loop
		
		
		for ( Map.Entry<Client,voiture> m : Locations.entrySet())
		{
			
		  System.out.println("Location key and val --> "+ m.getKey() + " "+ m.getValue());
		}
		
		return  Locations ;
		
	}
	
	
	public boolean estLoueur(Client client)
	{
		if (Locations.containsKey(client))
		{
			return true;
		}
		
		return false;
	}
	
	
	public boolean estLoue(voiture v)
	{
		if (Locations.containsValue(v))
		{
			return true;
		}
		
		return false;	
	}
	
	
	
	public void rendVoiture(Client cl )
	{
		// 1 : verifier si le Client existe dans la liste des Client d'agence
		if(client.contains(cl))
		{
			if( estLoueur(cl) )
			{
				// rendre 
				Locations.remove((Client)cl);
			}
		}
	
	}
	
    // renvoie la collection des voitures de l'agence qui sont actuellement louées :
	public Iterator<voiture> lesVoituresLouees()
	{
		/// method 1 : chercher from liste global des voiture ce qui existe dans la location
		
		/* 
		Iterator<voiture> itr = voiture.iterator(); // pour parcourir la liste des voiture d'agence
        List<voiture> voiturelouees  = new ArrayList<voiture>();  //pour stocker le resultat de recherche
		
		while (itr.hasNext())
		{
			voiture v = itr.next();
			if( estLoue(v) )
			{
				 //stocker dans une autre liste des voitures louees
				voiturelouees.add(v);
			}
	    }
	
		return voiturelouees.iterator(); 
		 
		 */
		
		 
		 /// method2 : trouver les voiture louee directemet from Location Values = voiture:
		 
		 List<voiture> vtr = new ArrayList<voiture>(Locations.values());  // return les voiture dans la locations
		 
		 Iterator<voiture> iter=vtr.iterator();
		 
		 return iter; 
	
	}
	
	
	
	
	/// ******************** De plus Other Function ************************************** :
	
	/// afficher les voiture louees :
	public void afficher_voit_louees()
	{
		Iterator<voiture> iter  =lesVoituresLouees();
		
		while(iter.hasNext())
		{
			System.out.println( iter.next().toString() );	
		}
	}
	
	
	///aficher all voiture:
	
	public Iterator<voiture> affichageVoiture()
	{
		/*for(voiture v:voiture)
			System.out.println(v);*/
		
		Iterator<voiture> iterv = voiture.iterator();
		return iterv;
	}
	
	///aficher all Client :
	
	public Iterator<Client> affichageClient()
	{ 
		Iterator<Client> iterc = client.iterator();
				
		return iterc;
	}
		
	
	/// afficher les Client Loueur
    public void afficherClient_Loueur()
	{
		
    	for(Client v: Locations.keySet())
    		
			System.out.println(v);
	}
    
    
     /// afficher les voiture Louee
    public void affichageVoitureLouee()
    {
		for(voiture v:Locations.values())
			System.out.println(v);
	}
	

} 



class notexiste extends Exception
{}

class louee extends Exception
{}








