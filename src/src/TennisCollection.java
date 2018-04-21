import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.border.Border;

public class TennisCollection extends JFrame implements ActionListener,ItemListener {
	private JLabel l1,l2,l3,l4,l5,l8,l9;
	private JButton b1,b2,b6;
	private JCheckBoxMenuItem c1,c2,c3,c4,c5;
	
	
	TennisCollection(){
		
		Container c=getContentPane();
		c.setLayout(null);
		
		
		l1=new JLabel("Tennis Collection ");
	    l1.setBounds(210,125,725,30);
		l1.setFont(new Font("Vivaldi",Font.BOLD+Font.ITALIC,40));
		l1.setForeground(new Color(0,255,0));
		      c.add(l1).setLocation(470,34);
		      
		      Icon i=new ImageIcon("san.jpg");
		        l2=new JLabel(i);
		        l2.setBounds(430,348,370,1050);
		        c.add(l2).setLocation(0,30);
		        
		        
		       
			    Icon i1=new ImageIcon("sana.jpg");
		        l3=new JLabel(i1);
		        l3.setBounds(50,50,250,250);
		        c.add(l3).setLocation(70,120);
		        
		        
		        Icon i2=new ImageIcon("sanag.jpg");
		        l4=new JLabel(i2);
		        l4.setBounds(100,100,250,250);
		        c.add(l4).setLocation(430,120);
		      
		        
		            
		        Icon i3=new ImageIcon("sanage.jpg");
		        l5=new JLabel(i3);
		        l5.setBounds(100,300,250,250);
		        c.add(l5).setLocation(870, 120);
		        
		        
		        Icon i4=new ImageIcon("sanageta.jpg");
		        l9=new JLabel(i4);
		        l9.setBounds(350,250,350,350);
		        c.add(l9).setLocation(500, 380);
		      
		            
		        c1=new JCheckBoxMenuItem();
		        c1.setText("INR 950/-");
		        c1.setBounds(200,20,100,20);
		        c1.setBackground(Color.white);
		        c1.setForeground(Color.black);
		        c1.setFont(new Font("Algerian",Font.PLAIN,12));
		        c.add(c1).setLocation(150,380);
		        c1.setName("Tennis1");
		        c1.addItemListener(this);
		        c1.setState(false);
		        
		        c2=new JCheckBoxMenuItem();
		        c2.setText("INR 900/-");
		        c2.setBounds(200,20,100,20);
		        c2.setBackground(Color.white);
		        c2.setForeground(Color.black);
		        c2.setFont(new Font("Algerian",Font.PLAIN,12));
		        c.add(c2).setLocation(500,380);
		        c2.setName("tennis2");
		        c2.addItemListener(this);
		        c2.setState(false);
		        
		        c3=new JCheckBoxMenuItem();
		        c3.setText("INR 1100/-");
		        c3.setBounds(200,20,100,20);
		        c3.setBackground(Color.white);
		        c3.setForeground(Color.black);
		        c3.setFont(new Font("Algerian",Font.PLAIN,12));
		        c.add(c3).setLocation(960,380);
		        c3.setName("tennis3");
		        c3.addItemListener(this);
		        c3.setState(false);
		        
		        c4=new JCheckBoxMenuItem();
		        c4.setText("INR 710/-");
		        c4.setBounds(200,20,100,20);
		        c4.setBackground(Color.white);
		        c4.setForeground(Color.black);
		        c4.setFont(new Font("Algerian",Font.PLAIN,12));
		        c.add(c4).setLocation(150,700);
		        c4.setName("tennis4");
		        c4.addItemListener(this);
		        c4.setState(false);
		        
		        c5=new JCheckBoxMenuItem();
		        c5.setText("INR 1100/-");
		        c5.setBounds(200,20,100,20);
		        c5.setBackground(Color.white);
		        c5.setForeground(Color.black);
		        c5.setFont(new Font("Algerian",Font.PLAIN,12));
		        c.add(c5).setLocation(650,700);
		        c5.setName("tennis5");
		        c5.addItemListener(this);
		        c5.setState(false);
		        
		         l8=new JLabel("  ManiaShopping.com");
		        l8.setBounds(210, 125, 725, 40);
		        l8.setFont(new Font("Vivaldi",Font.BOLD+Font.ITALIC,20));
		        l8.setForeground(new Color(0,255,0));
		        c.add(l8).setLocation(1050, 3);
		        
		    
		        
		        
		        b2=new JButton(" Add to Cart");
		        b2.setBounds(30,200,150,25);
		        b2.setForeground(new Color(0, 102, 204));
		        b2.setBackground(Color.white);
		        b2.addActionListener(this);
		        b2.setFont(new Font("Algerian",Font.BOLD,16));
		        c.add(b2).setLocation(830,670);
		        
		        b6=new JButton("Back ");
		        b6.setBounds(400,100, 100, 30);
		        b6.setBackground(Color.white);
		        b6.setForeground(new Color(0, 102, 204));
		        b6.setFont(new Font("Viner Hand ITC",Font.BOLD,14));
		        b6.addActionListener(this);
		          c.add(b6).setLocation(20, 34);
		    
		        setDefaultCloseOperation(EXIT_ON_CLOSE);
		        setSize(1300,1300);
		        setVisible(true);
				
				
			}
	

public void actionPerformed(ActionEvent e) {
           if(e.getSource()==b6){
			this.dispose();
			new MainFrame().setVisible(true);
    }
		
	
		if(e.getSource()==b2){
			this.dispose();
			new ShoppingDetails().setVisible(true);
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
				Statement st=con.createStatement();
		
		if(c1.getState()==true){
				ResultSet rs = st.executeQuery("insert into shoppingdetails1 values ('"+c1.getName()+"','"+c1.getLabel()+"')");
			}if(c2.getState()==true){
				ResultSet rs = st.executeQuery("insert into shoppingdetails1 values ('"+c2.getName()+"','"+c2.getLabel()+"')");
			}if(c3.getState()==true){
				ResultSet rs = st.executeQuery("insert into shoppingdetails1 values ('"+c3.getName()+"','"+c3.getLabel()+"')");
			}if(c4.getState()==true){
				ResultSet rs = st.executeQuery("insert into shoppingdetails1 values ('"+c4.getName()+"','"+c4.getLabel()+"')");
			}if(c5.getState()==true){
				ResultSet rs = st.executeQuery("insert into shoppingdetails1 values ('"+c5.getName()+"','"+c5.getLabel()+"')");
			}
			
			}catch(Exception f){
				
			}
		}
	}
		
		


@Override
public void itemStateChanged(ItemEvent e) {
	// TODO Auto-generated method stub
	
}

}




