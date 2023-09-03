package location;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ZJVoiture extends JFrame implements ActionListener
{  

	  private JLabel label = new JLabel("Nom:   ");
	  private JTextField t1 = new JTextField();
	  
	  private JLabel label2 = new JLabel("Marque:  ");
	  private JTextField t2 = new JTextField();
	  
	  private JLabel label3 = new JLabel("Annee:  ");
	  private JTextField t3 = new JTextField();
	  
	  private JLabel label4 = new JLabel("Prix:  ");
	  private JTextField t4 = new JTextField();
	  
	  private JButton addcars= new JButton("Ajouter Voiture");
	  private JButton seecars= new JButton("Consulter Les Voiture");
 
	  
	  JLabel labelT = new JLabel("Recherche Des Voirures Par Critere : ");
	  JLabel labelT2 = new JLabel("     ");
	  
	  JLabel labelP = new JLabel("CriterePrix :   ");
	  JTextField tP = new JTextField();
	  
	  JLabel labelM = new JLabel("CritereMarque:  ");
	  JTextField tMR = new JTextField();
	  
	  JLabel labelA = new JLabel("CritereAnnee:  ");
	  JTextField tA = new JTextField();
	  
	  private JButton recherche= new JButton("Chercher Voiture");
		 
             
	  Agence ag ;
      public ZJVoiture(Agence ag)
      {
    	  
        this.ag = ag;

  		this.setTitle("Gestion Des Voitures");
   	    this.setSize(700,500);
   	    this.setLocationRelativeTo(null); 
   	   
   	    
        JLabel tit = new JLabel("Registration Voitures");
        
   	    Container content = getContentPane();

   	    JPanel pan= new JPanel(new GridLayout(11,2,20,20) );
   	    
   	    label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
   	    label2.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
   	    label3.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
   	    label4.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
   	    
   	    labelA.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
	    labelM.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
	    labelP.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
	    
	    labelT.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
	    labelT.setBounds(60,10,300,30);
	    labelT.setFont(new Font("Arial",Font.BOLD,15));
	    labelT.setForeground(Color.gray);
	    
	    labelT2.setBounds(60,10,300,30);
	    labelT2.setFont(new Font("Arial",Font.BOLD,15));
	    labelT2.setForeground(Color.gray);
	   
   	    
   	    pan.add(label);  
   	    pan.add(t1);
   	    
   	    pan.add(label2);
	    pan.add(t2);
	    
	    pan.add(label3);
   	    pan.add(t3);
   	    
   	    pan.add(label4);
	    pan.add(t4);  
	    
	    pan.add(addcars);
   	    pan.add(seecars);
   	   
   	    
   	    pan.add(labelT);
	    pan.add(labelT2); 
	    
   	    pan.add(labelP);
	    pan.add(tP); 
	    
	    pan.add(labelM);
	    pan.add(tMR);
	    
	    pan.add(labelA);
	    pan.add(tA); 
	    
   	    pan.add(recherche);
   	   
   	   addcars.setForeground(Color.BLACK);
       addcars.setBackground( new Color( 121, 137, 255 ) );
       addcars.setFont(new Font("Tahoma", Font.BOLD, 12));
	   Border line11 = new LineBorder(Color.BLACK);
	   Border margin11 = new EmptyBorder(5, 15, 5, 15);
	   Border compound11 = new CompoundBorder(line11, margin11);
	   addcars.setBorder(compound11);
	   
	   seecars.setForeground(Color.BLACK);
       seecars.setBackground( new Color( 121, 137, 255 ) );
       seecars.setFont(new Font("Tahoma", Font.BOLD, 12));
	   Border line111 = new LineBorder(Color.BLACK);
	   Border margin111 = new EmptyBorder(5, 15, 5, 15);
	   Border compound111 = new CompoundBorder(line111, margin111);
	   seecars.setBorder(compound111);
	   
	   recherche.setForeground(Color.BLACK);
	   recherche.setBackground( new Color( 121, 137, 255 ) );
       recherche.setFont(new Font("Tahoma", Font.BOLD, 12));
	   Border line1111 = new LineBorder(Color.BLACK);
	   Border margin1111 = new EmptyBorder(5, 15, 5, 15);
	   Border compound1111 = new CompoundBorder(line1111, margin1111);
	   recherche.setBorder(compound1111);
     	
   	   addcars.addActionListener(this);  
   	   seecars.addActionListener(this);
   	   recherche.addActionListener(this);
   	  
   	   this.setContentPane(pan);
	 
       this.setVisible(true); 
    	  
      }

	@Override
	public void actionPerformed(ActionEvent e)
	{
		   
		     if(e.getSource() == addcars)
		     {
		    	   
		    	   String nom = t1.getText();
				   String marque = t2.getText();
				   int anne = Integer.parseInt(t3.getText());
				   int prix = Integer.parseInt(t4.getText());
				   
				   voiture vgui =new voiture(nom, marque, anne, prix);
				   
				   ag.add_voiture(vgui);
				   
				   //ag.affichageVoiture();
 
		     }	
		     if(e.getSource() == seecars)
		     {
		    	   
		    	    JFrame jr = new JFrame();
				    
				    jr.setTitle("La liste Des Voitures d'Agence"); 
				    jr.setSize(600,300);
				    jr.setLocationRelativeTo(null);  
				    
				      
				    JPanel panel = new JPanel();
				    
				    JLabel titre = new JLabel("La LIste Des Voitures D'Agence : ");
				    
				    DefaultTableModel mTableVModel = new DefaultTableModel();
				    mTableVModel.addColumn("Nom");
				    mTableVModel.addColumn("Marque");
				    mTableVModel.addColumn("Annee");
				    mTableVModel.addColumn("Price");
				    
	                Iterator<voiture> iterv = ag.affichageVoiture();
	                mTableVModel.setRowCount(0); 
	 
					while(iterv.hasNext())
					{
						 voiture v = iterv.next();
						 
						 String nom = v.getNom();
						 String marque = v.getMarque();
						 int annee = v.getAnnee();
						 int prix = v.getPrix();
						 
						 mTableVModel.addRow
						 (new Object[]{nom, marque,annee,prix});

					}
				   
			      
					 JTable tab = new JTable();
				     tab.setModel(mTableVModel);
				     JTableHeader header = tab.getTableHeader();
				        header.setBackground(Color.ORANGE);
		                header.setPreferredSize(new Dimension(40, 40));
		      			tab.setRowHeight(25);
		      			tab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				     
		      			int index = 0;
		                while (index < 4) {
		                   
		                	tab.getColumnModel().getColumn(index).setPreferredWidth(100);
		                	
		                    index++;
		                }	
				     
				     jr.getContentPane().setLayout(
				    		    new BoxLayout(jr.getContentPane(), BoxLayout.Y_AXIS)
				    		); 
		         
				     panel.add(titre);
	                 panel.add(header);
				     panel.add(tab);
				     
				     
				  
				    Container content2 = jr.getContentPane();
				    content2.add(panel, BorderLayout.CENTER);
				   
				    jr.setVisible(true); 

		     }	
		     
		     
		    if(e.getSource() == recherche)
		     {
		    	 

	    	    JFrame jr2 = new JFrame();
			    
			    jr2.setTitle("La liste Des Voitures"); 
			    jr2.setSize(600,300);
			    jr2.setLocationRelativeTo(null);  
			    
			    JPanel panelC = new JPanel();
			    
			    JLabel titre = new JLabel("La LIste Des Voitures Selon les Criters: ");
			    
			    DefaultTableModel mVModel = new DefaultTableModel();
			    mVModel.addColumn("Nom");
			    mVModel.addColumn("Marque"); 
			    mVModel.addColumn("Annee");
			    mVModel.addColumn("Price");
			    mVModel.setRowCount(0); 

				InterCriter incr = new InterCriter();
				 
				if(!tP.getText().equals("")) 
				{
					 
					 CriterePrix cp=new CriterePrix( Integer.parseInt(tP.getText()) );
					 incr.addCritere(cp);
				}
	            
				if(!tMR.getText().equals(""))
				{
					CritereMarque cm=new CritereMarque("Renaut");
					 incr.addCritere(cm);
				}
	        	
	        	
				if(!tA.getText().equals(""))
				{
					CritereAnnee can = new CritereAnnee(Integer.parseInt(tA.getText()) );
					incr.addCritere(can);
				}	
	        	
				
				
				Iterator<voiture> iterC =  ag.selectionne(incr);
				 
				while(iterC.hasNext())
				{
					 voiture v = iterC.next();
					 
					 String nomv = v.getNom();
					 String marquev = v.getMarque();
					 int anneev = v.getAnnee();
					 int priv = v.getPrix();
					 
					 mVModel.addRow
					 (new Object[]{nomv, marquev,anneev,priv});

				}
			   
		      
				 JTable tab = new JTable();
			     tab.setModel(mVModel);
			     JTableHeader header = tab.getTableHeader();
			        header.setBackground(Color.ORANGE);
	                header.setPreferredSize(new Dimension(40, 40));
	      			tab.setRowHeight(25);
	      			tab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			     
	      			int index = 0;
	                while (index < 4) {
	                   
	                	tab.getColumnModel().getColumn(index).setPreferredWidth(100);
	                	
	                    index++;
	                }	
		
			     jr2.getContentPane().setLayout(
			    		    new BoxLayout(jr2.getContentPane(), BoxLayout.Y_AXIS)
			    		); 
	         
			     panelC.add(titre);
			     panelC.add(header);
			     panelC.add(tab);
			     
			     
			  
			    Container content2 = jr2.getContentPane();
			    content2.add(panelC, BorderLayout.CENTER);
				
	
			    jr2.setVisible(true);

		     }
		
	}
	        
	 
	
	        
	
	
	
	
	
	
	
	
}
