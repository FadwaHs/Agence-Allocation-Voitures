package location;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ZJClient extends JFrame implements ActionListener
{
	 
	  private JLabel label = new JLabel("Nom:   "); 
	  private JTextField t1 = new JTextField();
	  
	  private JLabel label2 = new JLabel("Prenom:  ");
	  private JTextField t2 = new JTextField();
	  
	  private JLabel label3 = new JLabel("Civilite:  ");
	  private JTextField t3 = new JTextField();
	  
	  private JLabel label4 = new JLabel("Cin:  ");
	  private JTextField t4 = new JTextField();
	  
	  private JButton addclient= new JButton("Ajouter Client");
	  private JButton seeclient= new JButton("Consulter Client");
	  
	  
	  
    Agence ag ;
	
	public ZJClient(Agence ag)
	{
		
		this.ag = ag;
		
		this.setTitle("Gestion Des Client");
 	    this.setSize(600,300);
 	    this.setLocationRelativeTo(null); 
 	   
 	    
 	    
 	    Container content = getContentPane();
 	    
	    t1.setPreferredSize(new Dimension(130, 30));
	    t2.setPreferredSize(new Dimension(130, 30));
	    t3.setPreferredSize(new Dimension(130, 30));
	    t4.setPreferredSize(new Dimension(130, 30));
	    
 	    label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
   	    label2.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
   	    label3.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
   	    label4.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
   	    

	  
 	    JPanel pan1 = new JPanel (new GridLayout(5,2,20,20) );

	    
	    pan1.add(label);
	    pan1.add(t1);
	    pan1.add(label2);
	    pan1.add(t2);
	    pan1.add(label3);
	    pan1.add(t3);
	    pan1.add(label4);
	    pan1.add(t4);
 	    pan1.add(addclient);
 	    pan1.add(seeclient);
 	    
 	    
	    content.add(pan1);
	   
	    
	    
	    addclient.setForeground(Color.BLACK);
	    addclient.setBackground( new Color( 121, 137, 255 ) );
	    addclient.setFont(new Font("Tahoma", Font.BOLD, 12));
	 	Border line1 = new LineBorder(Color.BLACK);
		Border margin1 = new EmptyBorder(5, 15, 5, 15);
	    Border compound1 = new CompoundBorder(line1, margin1);
		addclient.setBorder(compound1);
		
		 addclient.setForeground(Color.BLACK);
		 seeclient.setBackground( new Color( 121, 137, 255 ) );
		 seeclient.setFont(new Font("Tahoma", Font.BOLD, 12));
		 Border line11 = new LineBorder(Color.BLACK);
	     Border margin11 = new EmptyBorder(5, 15, 5, 15);
		 Border compound11 = new CompoundBorder(line11, margin11);
		 seeclient.setBorder(compound11);
	    
	    addclient.addActionListener(this);
	    seeclient.addActionListener(this);
	    
 	    this.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
	       
		
		   if(e.getSource() == addclient)
		   {
			   
			   String nom = t1.getText();
			   String prenom = t2.getText();
			   String civ = t3.getText();
			   String cin = t4.getText();
			   
			   
			   Client clgui = new Client(nom,prenom,civ,cin);
			   
			   ag.add_client(clgui);
			   
			   //ag.affichageClient();  
		   }
		   
		   if(e.getSource() == seeclient)
		   {   
			    JFrame jr = new JFrame();
			    
			    jr.setTitle("La liste Des Client d'Agence"); 
			    jr.setSize(500,300);
			    jr.setLocationRelativeTo(null);  
			    
			      
			    JPanel panel = new JPanel();
			    
			    JLabel titre = new JLabel("La LIste Des Client De Notre Agence : ");
			    
			    DefaultTableModel mTableClientModel = new DefaultTableModel();
			    mTableClientModel.addColumn("CIN");
				mTableClientModel.addColumn("Nom");
				mTableClientModel.addColumn("Prenom");
				mTableClientModel.addColumn("Civilité"); 
			    
                Iterator<Client> iter  = ag.affichageClient();
                mTableClientModel.setRowCount(0);
 
				while(iter.hasNext())
				{
					 Client c = iter.next();
					 
					 String nom = c.getNom();
					 String prenom = c.getPrenom();
					 String civ = c.getCivilite();
					 String cin = c.getCin();
					 
					 mTableClientModel.addRow
					 (new Object[]{nom, prenom,civ,cin});

				}
			   
		      
				 JTable tab = new JTable();
			     tab.setModel(mTableClientModel);
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
		
	}
	
	
	
}




