import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class SamsungShop extends JFrame implements ActionListener,ItemListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JButton b2,b6;
    JCheckBoxMenuItem c1,c2,c3,c4,c5,c6;
	ImageIcon ii1,ii2,ii3,ii4,ii5,ii6;
	String item_name,item_price;
	
	
	SamsungShop(){	Container c = getContentPane();
	c.setLayout(null);

	
	  l8=new JLabel("  ManiaShopping.com");
      l8.setBounds(210, 125, 725, 40);
      l8.setFont(new Font("Vivaldi",Font.BOLD+Font.ITALIC,20));
      l8.setForeground(new Color(0,255,0));
      c.add(l8).setLocation(1050, 3);
      
	l1 = new JLabel("Samsung Shop");
	l1.setBounds(500, 20,200,30);
	Font f1 = new Font("Plain",Font.BOLD,20);
	l1.setFont(f1);
	l1.setForeground(Color.BLUE);
	
l2 = new JLabel(ii1);
l2.setBounds(100, 80, 240, 210);
ImageIcon ii1 = new ImageIcon("images (9).jpg");
l2.setIcon(ii1);

 l3 = new JLabel(ii2);
 l3.setBounds(490, 80, 170, 310);
 ImageIcon ii2 = new ImageIcon("images (15).jpg");
 l3.setIcon(ii2);
 
 l4 = new JLabel(ii3);
 l4.setBounds(800, 80,225 , 225);
 ImageIcon ii3 = new ImageIcon("images (16).jpg");
 l4.setIcon(ii3);
 
 l5 = new JLabel(ii4);
 l5.setBounds(130,420 , 223, 226);
 ImageIcon ii4 = new ImageIcon("images (8).jpg");
 l5.setIcon(ii4);
 
 l6 = new JLabel(ii5);
 l6.setBounds(450, 440, 260, 200);
 ImageIcon ii5 = new ImageIcon("images (12).jpg");
 l6.setIcon(ii5);
 
 l7 = new JLabel(ii6);
 l7.setBounds(800, 420, 225, 225);
 ImageIcon ii6 = new ImageIcon("images (11).jpg");
 l7.setIcon(ii6);
  
 
 c1 = new JCheckBoxMenuItem();
 c1.setText("INR 21000/");
 c1.setName("Samsung Phone1");
 c1.setBounds(190,330, 100, 25);
 c1.addItemListener(this);
 c1.setState(false);
 
 c2 = new JCheckBoxMenuItem();
 c2.setText("INR .15000/");
 c2.setBounds(550,400,90,25);
 c2.addItemListener(this);
 c2.setState(false);
 c2.setName("Samsung Phone2");
 
 
 c3 = new JCheckBoxMenuItem();
 c3.setText("INR.18000/");
 c3.setBounds(900,330,90,25);
 c3.addItemListener(this);
 c3.setState(false);
 c3.setName("Samsung Phone3");
 
 c4 = new JCheckBoxMenuItem();
 c4.setText("INR.19000");
 c4.setBounds(190,650, 90, 25);
 c4.addItemListener(this);
 c4.setState(false);
 c4.setName("Samsung Phone4");
 
 
 c5  = new JCheckBoxMenuItem();
 c5.setText("INR.4500");
 c5.setBounds(530, 650, 90, 25);
 c5.addItemListener(this);
 c5.setName("Samsung Phone5");
 c5.setState(false);
 
 c6 = new JCheckBoxMenuItem();
 c6.setText("INR.3500");
 c6.setBounds(900, 650, 90, 25);
 c6.addItemListener(this);
 c6.setState(false);
 c6.setName("Samsung Phone6");
 
 
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

@Override
public void itemStateChanged(ItemEvent e) {
	// TODO Auto-generated method stub
	
}
		
}
