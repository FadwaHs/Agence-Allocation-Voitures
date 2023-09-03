package location;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ZJLoaction extends JFrame implements ActionListener
{
      
	  private JLabel titre = new JLabel(" Faire une location de voiture "); 
	  private JLabel label = new JLabel("Client:   "); 
	  private JLabel label2 = new JLabel("Voiture:  ");
	
	  private JButton louee= new JButton("Loue Voiture");
	  private JButton seelouee= new JButton("Afficher les Locations");
	  private JButton seeV= new JButton("les voitures louees");
	  private JButton seeC= new JButton("les Client louees");

	 /* JLabel labelP = new JLabel("CriterePrix :   ");
	  JTextField tP = new JTextField(40);
	  
	  JLabel labelM = new JLabel("CritereMarque:  ");
	  JTextField tMR = new JTextField(40);
	  
	  JLabel labelA = new JLabel("CritereAnnee:  ");
	  JTextField tA = new JTextField(40);
	  
	  private JButton recherche= new JButton("Choice"); */
	  
	  JComboBox<Client>  cb = new JComboBox();
	  JComboBox<voiture>  cbV = new JComboBox();
	
	
	Agence ag ;
	
	public ZJLoaction(Agence ag )
	{	
		    this.ag = ag;

	  		this.setTitle("Gestion Des Location");
	   	    this.setSize(700,500);
	   	    this.setLocationRelativeTo(null); 
	   	   
	   	   
	   	    Container content = getContentPane();
	   	    
	   	    JPanel pan = new JPanel (new GridLayout(5,0,20,20) );
	   	    
	   	    
	   	    JPanel pan0 = new JPanel (new FlowLayout(3,4,0) );
	   	    JPanel pan1 = new JPanel (new FlowLayout(3,4,0) );
	     	JPanel pan2 = new JPanel (new FlowLayout(3,4,0) );
	     	JPanel pan3 = new JPanel (new FlowLayout(3,4,0) );
	     	
	     	/*JPanel pan31 = new JPanel (new FlowLayout(3,4,0) );
	     	JPanel pan32 = new JPanel (new FlowLayout(3,4,0) );
	     	JPanel pan33 = new JPanel (new FlowLayout(3,4,0) );*/
	     	
	     	cb.setBounds(50, 50,90,20);
	     	cbV.setBounds(50, 50,90,20);
	   	 
	     	 titre.setFont(new Font("Arial",Font.BOLD,20));
	  	     titre.setForeground(Color.gray);
	         titre.setBorder(BorderFactory.createEmptyBorder(10, 150, 0, 0));
	         
	        
	         pan0.add(titre);
	    	 
	    	/* pan31.add(labelP);
	    	 pan31.add(tP);
	    	 
	    	 pan32.add(labelM);
	    	 pan32.add(tMR);
	    	 
	    	 pan33.add(labelA);
	    	 pan33.add(tA);*/
	    	 
	    	 pan1.add(label);
	    	 pan1.add(cb);
	    	 
	    	 pan2.add(label2);
	    	 pan2.add(cbV);
	    	 
	    	 pan3.add(louee);
	    	 pan3.add(seelouee);
	    	 pan3.add(seeC);
	    	 pan3.add(seeV);
	    	 //pan3.add(recherche);
	    	 
	    	 pan.add(pan0);
	    	 /*pan.add(pan31);
	    	 pan.add(pan32);
	    	 pan.add(pan33);*/
	    	 
	    	 pan.add(pan1);
	    	 pan.add(pan2);
	    	 pan.add(pan3);
	    	 
	    	 

	   	    Iterator<Client> iter  = ag.affichageClient();
	   	    Iterator<voiture> iterv = ag.affichageVoiture();
	 
	   	
	    	 while(iter.hasNext())
			{
				 Client c = iter.next(); 
				 cb.addItem(c);
			} 
	      
	    	 while(iterv.hasNext())
			{
	    		 voiture c = iterv.next(); 
				 cbV.addItem(c);
			}

	    
	        pan.setBorder(BorderFactory.createTitledBorder(""));
	        
	        louee.setForeground(Color.BLACK);
	        louee.setBackground( new Color( 121, 137, 255 ) );
	        louee.setFont(new Font("Tahoma", Font.BOLD, 12));
	 	    Border line11 = new LineBorder(Color.BLACK);
	 	    Border margin11 = new EmptyBorder(5, 15, 5, 15);
	 	    Border compound11 = new CompoundBorder(line11, margin11);
	 	   louee.setBorder(compound11);
	 	    
	 	   seelouee.setForeground(Color.BLACK);
	 	   seelouee.setBackground( new Color( 121, 137, 255 ) );
	       seelouee.setFont(new Font("Tahoma", Font.BOLD, 12));
		   Border line111 = new LineBorder(Color.BLACK);
		   Border margin111 = new EmptyBorder(5, 15, 5, 15);
		   Border compound111 = new CompoundBorder(line111, margin111);
		   seelouee.setBorder(compound111);
	    	 
	   	    louee.addActionListener(this);
	   	    seelouee.addActionListener(this);
	   	    
	   	    cb.addActionListener(this);
	   	    cbV.addActionListener(this);

	   	    content.add(pan);
	   	    this.setVisible(true); 
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
			if(e.getSource() == louee)
			{
				try
				{
					ag.loueVoiture((Client) cb.getSelectedItem(), (voiture) cbV.getSelectedItem());
	
				}
				catch( notexiste p )
				{
					System.out.println(" la voiture n'existe pas dans cette agence");
				}
				catch( louee l )
				{
					System.out.println("La voiture deja louée ");
					
					JOptionPane jop2 = new JOptionPane();
				    jop2.showMessageDialog(null, "La voiture est deja louée ", "Message", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			if(e.getSource() == seelouee)
			{
				Map<Client,voiture> location = ag.afficher_Location();
				
	    	    JFrame jr2 = new JFrame();
			    
			    jr2.setTitle("La liste Des Voitures"); 
			    jr2.setSize(780,400);
			    jr2.setLocationRelativeTo(null);  

			    
			    DefaultTableModel table = new DefaultTableModel();
			    table.addColumn("Client louer Name");
			    table.addColumn("Client louer Cin ");
			    table.addColumn("Voitur Name");
			    table.addColumn("Voiture Price");
			    table.addColumn("Voiture Marque");
			    table.setRowCount(0); 
                
                for ( Map.Entry<Client,voiture> m : location.entrySet())
				{
					
				    // System.out.println("Location key and val --> "+ m.getKey() + " "+ m.getValue());
					 table.addRow
					 (new Object[]{m.getKey().getNom(),m.getKey().getCin(), m.getValue().getNom(),m.getValue().getPrix(),m.getValue().getMarque()});
				     
				}
                
      			JTable tab = new JTable();
      			tab.setModel(table);
      			JTableHeader header = tab.getTableHeader();
      			
      			header.setBackground(Color.ORANGE);
                header.setPreferredSize(new Dimension(40, 40));
      			tab.setRowHeight(25);
      			tab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      			
      			int index = 0;
                while (index < 5) {
                   
                	tab.getColumnModel().getColumn(index).setPreferredWidth(140);
                	
                    index++;
                }
     
                jr2.getContentPane().setLayout(
      			    		    new BoxLayout(jr2.getContentPane(), BoxLayout.Y_AXIS)
      			    		); 
      	         
      		
                 JPanel panel = new JPanel();

                 panel.add(header);
      			 panel.add(tab);
	  
      			 Container content2 = jr2.getContentPane();
      			 content2.add(panel, BorderLayout.CENTER);
      			   
      			 jr2.setResizable(true);
      			 jr2.setVisible(true);
			}
			

	}

}
