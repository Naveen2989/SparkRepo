

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.io.*;

public class Novels extends JFrame implements ActionListener,ItemListener {
	private JLabel l1,l2,l3,l4,l5,l8,l9;
	private JButton b1,b2,b6;
   private JCheckBoxMenuItem c1,c2,c3,c4,c5;
	
	Novels(){
		
		Container c=getContentPane();
		c.setLayout(null);
	
		
		l1=new JLabel(" Novals ");
	    l1.setBounds(210,125,725,30);
		l1.setFont(new Font("Vivaldi",Font.BOLD+Font.ITALIC,40));
		l1.setForeground(new Color(0,255,0));
		      c.add(l1).setLocation(500,34);
		      
	    Icon i=new ImageIcon("ankit.jpg");
        l2=new JLabel(i);
        l2.setBounds(100,100,400,390);
        c.add(l2).setLocation(870,120);
        
       
	    Icon i1=new ImageIcon("bar.jpg");
        l3=new JLabel(i1);
        l3.setBounds(50,50,250,250);
        c.add(l3).setLocation(70,180);
        
        Icon i2=new ImageIcon("bara.jpg");
        l4=new JLabel(i2);
        l4.setBounds(100,100,250,250);
            c.add(l4).setLocation(370,180);
            
        Icon i3=new ImageIcon("bari.jpg");
        l5=new JLabel(i3);
        l5.setBounds(100,100,250,250);
            c.add(l5).setLocation(670,180);
            
        c1=new JCheckBoxMenuItem();
        c1.setText("INR 350/-");
        c1.setBounds(200,20,100,20);
        c1.setBackground(Color.white);
        c1.setForeground(Color.black);
        c1.setFont(new Font("Algerian",Font.PLAIN,12));
        c.add(c1).setLocation(150,420);
        c1.setName("Noval1");
        c1.addItemListener(this);
        c1.setState(false);
        
        c2=new JCheckBoxMenuItem();
        c2.setText("INR 700/-");
        c2.setBounds(200,20,100,20);
        c2.setBackground(Color.white);
        c2.setForeground(Color.black);
        c2.setFont(new Font("Algerian",Font.PLAIN,12));
        c.add(c2).setLocation(420,420);
        c2.setName("Novel2");
        c2.addItemListener(this);
        c2.setState(false);
        
        
        c3=new JCheckBoxMenuItem();
        c3.setText("INR 600/-");
        c3.setBounds(200,20,100,20);
        c3.setBackground(Color.white);
        c3.setForeground(Color.black);
        c3.setFont(new Font("Algerian",Font.PLAIN,12));
        c.add(c3).setLocation(760,450);
        c3.setName("Novel3");
        c3.addItemListener(this);
        c3.setState(false);
        
        c4=new JCheckBoxMenuItem();
        c4.setText("INR 710/-");
        c4.setBounds(200,20,100,20);
        c4.setBackground(Color.white);
        c4.setForeground(Color.black);
        c4.setFont(new Font("Algerian",Font.PLAIN,12));
        c.add(c4).setLocation(1030,480);
        c4.setName("Novel4");
        c4.addItemListener(this);
        c4.setState(false);
        
        c5=new JCheckBoxMenuItem();
        c5.setText("INR 710/-");
        c5.setBounds(200,20,100,20);
        c5.setBackground(Color.white);
        c5.setForeground(Color.black);
        c5.setFont(new Font("Algerian",Font.PLAIN,12));
        c.add(c5).setLocation(150,670);
        c5.setName("Novel4");
        c5.addItemListener(this);
        c5.setState(false);
        
        Icon i5=new ImageIcon("aman.jpg");
        l9=new JLabel(i5);
        l9.setBounds(430,348,370,1050);
        c.add(l9).setLocation(0,50);
        
         l8=new JLabel("  ManiaShopping.com");
        l8.setBounds(210, 125, 725, 40);
        l8.setFont(new Font("Vivaldi",Font.BOLD+Font.ITALIC,20));
        l8.setForeground(new Color(0,255,0));
        c.add(l8).setLocation(1050, 3);
        
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
    
        
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1300,1300);
        setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		

		if(e.getSource()==b1){
			this.dispose();
			new KidsComics();	
		}
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


