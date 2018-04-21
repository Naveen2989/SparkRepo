import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public  class NokiaShop extends JFrame implements ActionListener,ItemListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JButton b1,b2 ,b6;
	JCheckBoxMenuItem c1,c2,c3,c4,c5,c6;
	ImageIcon ii1,ii2,ii3,ii4,ii5,ii6;
	String item_name,item_price;
	
	NokiaShop(){
		Container c = getContentPane();
		c.setLayout(null);
		  
	 		
		l1 = new JLabel("Nokia Shop");
		l1.setBounds(500, 20,150,30);
		Font f1 = new Font("Plain",Font.BOLD,20);
		l1.setFont(f1);
		
		l1.setForeground(Color.BLUE);
		
		l8=new JLabel("  ManiaShopping.com");
	      l8.setBounds(210, 125, 725, 40);
	      l8.setFont(new Font("Vivaldi",Font.BOLD+Font.ITALIC,20));
	      l8.setForeground(new Color(0,255,0));
	      c.add(l8).setLocation(1050, 3);
		
	l2 = new JLabel(ii1);
	l2.setBounds(100,80, 260, 200);
	ImageIcon ii1 = new ImageIcon("images (1).jpg");
	l2.setIcon(ii1);
	
	 l3 = new JLabel(ii2);
	 l3.setBounds(450, 80, 240, 212);
	 ImageIcon ii2 = new ImageIcon("images (4).jpg");
	 l3.setIcon(ii2);
	 
	 l4 = new JLabel(ii3);
	 l4.setBounds(800, 80, 245, 206);
	 ImageIcon ii3 = new ImageIcon("images (2).jpg");
	 l4.setIcon(ii3);
	 
	 l5 = new JLabel(ii4);
	 l5.setBounds(130, 370, 200, 252);
	 ImageIcon ii4 = new ImageIcon("images (5).jpg");
	 l5.setIcon(ii4);
	 
	 l6 = new JLabel(ii5);
	 l6.setBounds(450, 390, 240, 210);
	 ImageIcon ii5 = new ImageIcon("images (7).jpg");
	 l6.setIcon(ii5);
	 
	 l7 = new JLabel(ii6);
	 l7.setBounds(800, 370, 225, 225);
	 ImageIcon ii6 = new ImageIcon("images (3).jpg");
	 l7.setIcon(ii6);
	  
	 
	 c1 = new JCheckBoxMenuItem();
	 c1.setText("INR.8000");
	 c1.setName("NOkia1");
	 c1.setBounds(190,300, 90, 25);
	 c1.addItemListener(this);
     c1.setState(false);
	 
	 c2 = new JCheckBoxMenuItem();
	 c2.setText("INR.9000");
	 c2.setName("Nokia2");
	 c2.setBounds(550,300,90,25);
	 c2.addItemListener(this);
     c2.setState(false);
	 
	 
	 c3 = new JCheckBoxMenuItem();
	 c3.setText("INR.21000");
	 c3.setName("Nokia3");
	 c3.setBounds(900,300,90,25);
	 c3.addItemListener(this);
     c3.setState(false);
     
	 c4 = new JCheckBoxMenuItem();
	 c4.setText("INR.3000");
	 c4.setName("Nokia4");
	 c4.setBounds(190,650, 90, 25);
	 c4.addItemListener(this);
     c4.setState(false);
	 
	 c5  = new JCheckBoxMenuItem();
	 c5.setText("INR. 3555");
	 c5.setName("Nokia5");
	 c5.setBounds(530, 650, 90, 25);
	 c5.addItemListener(this);
     c5.setState(false);
	 
	 c6 = new JCheckBoxMenuItem();
	 c6.setText("INR.25000");
	 c6.setName("Nokia6");
	 c6.setBounds(900, 650, 90, 25);
	 c6.addItemListener(this);
     c6.setState(false);
	 
	 
	  b1=new JButton(" Proceds");
      b1.setBounds(30,200,150,25);
      b1.setForeground(new Color(0, 102, 204));
      b1.setBackground(Color.white);
      b1.addActionListener(this);
      b1.setFont(new Font("Algerian",Font.BOLD,16));
      c.add(b1).setLocation(1000,670);
      
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
	 
	 
	
	 
	 
	 c.add(l1);
	 c.add(l2);
	 c.add(l3);
	 c.add(l4);
	 c.add(l5);
	 c.add(l6);
	 c.add(l7);
	 c.add(l8);
	 c.add(c1);
	 c.add(c2);
	 c.add(c3);
	 c.add(c4);
	 c.add(c5);
	 c.add(c6);
	
	 setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(1300, 1300);
}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==b6){
			this.dispose();
			new MainFrame().setVisible(true);
		}
		if(ae.getSource()==b1){
			this.dispose();
			new SamsungShop().setVisible(true);
		}
		
	  if(ae.getSource()==b2){
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
			}if(c6.getState()==true){
				ResultSet rs = st.executeQuery("insert into shoppingdetails1 values ('"+c6.getName()+"','"+c6.getLabel()+"')");
			
			}
			
			}catch(Exception f){
				
			}
		}
	}
	
		public void itemStateChanged(ItemEvent e) {
		
			
		}
		}
		
	