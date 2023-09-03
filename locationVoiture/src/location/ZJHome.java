package location;
 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ZJHome extends JFrame  implements ActionListener
{
	
	 private JPanel panneau = new JPanel();
	 
	 private JLabel titre = new JLabel("Bienvenue dans l'Agence des Voitures");
	 
	 private JButton btnClient = new JButton("Gestion Des Clients");
	 private JButton btnVoiture = new JButton("Gestion Des Voiture");
	 private JButton btnlocation= new JButton("Gestion Des Locations");
	
	 Agence ag;
     public ZJHome(Agence ag)
     {
    	
    	 
    	 this.ag = ag;
    	 
        JOptionPane jop2 = new JOptionPane();
	    jop2.showMessageDialog(null, "Bonjour veuillez cliquer sur ok pour Commencez", "Message", JOptionPane.INFORMATION_MESSAGE);
	     
    	this.setTitle("Location Des Voitures");
 	    this.setSize(700,400);
 	    this.setLocationRelativeTo(null);  
 	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 	    
 	    Container content = getContentPane();
 	     
 	    
 	    titre.setFont(new Font("Arial",Font.BOLD,20));
 	    titre.setForeground(Color.gray);
        titre.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));
 	    
        JPanel panel2 = new JPanel();
        panel2.add(titre);
        panel2.setBackground(Color.white);
 	    
        JPanel panel = new JPanel(new GridLayout(3,1));
 	    panel.add( btnClient );
 	    panel.add(btnVoiture);
 	    panel.add( btnlocation );
 	    panel.setBackground(Color.white);
 	    
 	    
 	   
        JLabel label = new JLabel(); //JLabel Creation 
        label.setIcon(new ImageIcon("/home/fadwa/eclipse-workspace/index.jpeg")); //Sets the image to be displayed as an icon
        Dimension size = label.getPreferredSize(); //Gets the size of the image
        
        JPanel panel4 = new JPanel(new GridLayout(1,0,0,0));  
        panel4.add(label);
        panel4.setBackground(Color.white);
        
       JPanel panel3 = new JPanel(new GridLayout(0,2,0,0));

 	   
        panel3.add(panel4);
        panel3.add(panel);
        panel3.setBackground(Color.white);
        
        
        panneau.setLayout(new GridLayout(3,0,0,0));
        panneau.add(panel2);
        panneau.add(panel3);
 	    panneau.setBackground(Color.white);
 	    
 	    content.add(panneau, BorderLayout.CENTER);

 	    
 	   btnClient.setForeground(Color.BLACK);
 	   btnClient.setBackground( new Color( 121, 137, 255 ) );
 	   btnClient.setFont(new Font("Tahoma", Font.BOLD, 12));
 	   Border line = new LineBorder(Color.BLACK);
 	   Border margin = new EmptyBorder(5, 15, 5, 15);
 	   Border compound = new CompoundBorder(line, margin);
 	   btnClient.setBorder(compound);
 	   
 	   btnVoiture.setForeground(Color.BLACK);
 	   btnVoiture.setBackground( new Color( 121, 137, 255 ) );
 	   btnVoiture.setFont(new Font("Tahoma", Font.BOLD, 12));
 	   Border line1 = new LineBorder(Color.BLACK);
	   Border margin1 = new EmptyBorder(5, 15, 5, 15);
	   Border compound1 = new CompoundBorder(line1, margin1);
	   btnVoiture.setBorder(compound1);
	   
	   
	   btnlocation.setForeground(Color.BLACK);
	   btnlocation.setBackground( new Color( 121, 137, 255 ) );
	   btnlocation.setFont(new Font("Tahoma", Font.BOLD, 12));
 	   Border line11 = new LineBorder(Color.BLACK);
 	   Border margin11 = new EmptyBorder(5, 15, 5, 15);
 	   Border compound11 = new CompoundBorder(line11, margin11);
 	   btnlocation.setBorder(compound11);
 	  
 	    btnClient.addActionListener(this);
 	    btnVoiture.addActionListener(this);
 	    btnlocation.addActionListener(this);

 	    this.setVisible(true);
 	    
     }


	@Override
	public void actionPerformed(ActionEvent e)
	{
	      
		  if(e.getSource() == btnClient)
		  {
			  
			  ZJClient ClientGui = new ZJClient(ag);
			  
		  }
		
		  if(e.getSource() == btnVoiture)
		  {
			  
			  ZJVoiture Voiture = new ZJVoiture(ag);
			  
		  }
		  
		  if(e.getSource() == btnlocation)
		  {
			  
			  ZJLoaction location = new ZJLoaction(ag);
			  
		  }
	}

	
	
	
	
	
	
	
	
}
