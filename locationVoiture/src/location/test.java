package location;

import java.util.Iterator;

public class test {

	public static void main(String[] args) throws louee ,notexiste
	{
	     
		 
		Agence ag=new Agence(); 
		
		voiture v1=new voiture("jazz", "hyndai", 2001, 40);
		
		voiture v3=new voiture("mega", "Renaut", 2003, 100000);
		voiture v4=new voiture("clio", "Renaut", 2009, 12);
		
		voiture vt1=new voiture("Renaut1", "Renaut", 2020, 120);
		voiture vt2=new voiture("Renaut3", "Renaut", 2020, 189);
		voiture vt3=new voiture("Renaut2", "Renaut", 2020, 128);
		
		//voiture v5=new voiture("Renaut4", "Renaut", 2009, 12); // une voiture n'existe pas dans l'agance ag
		
		Client cl = new Client("fadwa","hsissou","mrocco","JB12345");
		Client cl1 = new Client("imad","hsissou","mrocco","JB18945");
		Client cl2 = new Client("amina","hsissou","mrocco","JB17845");
		Client cl3 = new Client("mohamed","hsissou","mrocco","JB12675");
		
		
		ag.add_voiture(v1);
		ag.add_voiture(v3);
		ag.add_voiture(v4);
		
		// pas encore louées
		ag.add_voiture(vt1);
		ag.add_voiture(vt2);
		ag.add_voiture(vt3);

		//add client
		ag.add_client(cl);
		ag.add_client(cl1);
		ag.add_client(cl2);
		ag.add_client(cl3);
		
		
		
		/*System.out.println("les Client Agence : ");

        Iterator<Client> iter  = ag.affichageClient();
		
		while(iter.hasNext())
		{
			System.out.println( iter.next().toString() );	
		}*/
		
		
		
		 /*try{
			 
			
			ag.loueVoiture(cl, v1);
			ag.loueVoiture(cl3, v3);
			
			
			System.out.println("les Location : ");
			ag.afficher_Location();
			

			 System.out.println("les voitures louees: ");
			 ag.afficher_voit_louees();
			 
				
			 System.out.println("les client loueer: ");
			 ag.afficherClient_Loueur();
				
			 ag.rendVoiture(cl);
			 System.out.println("le cl rend la voiture v1 : ");
			 ag.afficher_Location(); 
			 		
			// ag.loueVoiture(cl1, v1);
			
			//ag.loueVoiture(cl1, v5);
			
			
		}
		catch( notexiste p )
		{
			System.out.println(" la voiture n'existe pas dans cette agence");
		}
		catch( louee l )
		{
			System.out.println("La voiture deja louée ");
		}*/
		
        

	
		/* CriterePrix cp=new CriterePrix(100);
		// ag.afficheSelection(cp);
		
		CritereMarque cm=new CritereMarque("Renaut");
		// ag.afficheSelection(cm);
		
		CritereAnnee can = new CritereAnnee(2009);
	    
		InterCriter incr = new InterCriter();
		//add:
		incr.addCritere(cp);
		incr.addCritere(cm);
		incr.addCritere(can);
		
		ag.afficheSelection(incr); */
		

		ZJHome hm = new ZJHome(ag);

			
	}

}











