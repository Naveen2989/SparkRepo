import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.border.*;

import javax.swing.*;
public class MainFrame extends JFrame implements 	ActionListener{
	
	JLabel l1,l2,l4,l5,l6,l9,l10,l11,l12,l13,l14;
	JComboBox c1;
	int x,y;
    JButton b1,b2,b3,b4,b5,b6,b7;
	ImageIcon ii1,ii2,ii3,ii4,ii5,ii6;
	String str[]= {"select","kids comics", "Samsung shop", "Tennis collection", "Bmw shop"," footware"};
	
	MainFrame(){
		Container c = getContentPane();
 		y=140;
 		c.setLayout(null);
        
 		
		l1 = new JLabel("ShoppingMania.com");
		l1.setBounds(20, 20, 250, 40);
		Font f2 = new Font("Tahoma",Font.BOLD,24);
		l1.setFont(f2);
		l1.setForeground(Color.blue);
		
		l2 = new JLabel("Online ShoppingStore");
		l2.setBounds(20,45 ,250,40);
		l2.setForeground(new Color(0,255,0));
		Font f3 = new Font("Tahoma",Font.BOLD,18);
		l2.setFont(f3);
		
	
		
		l4 = new JLabel("Search");
		l4.setBounds(330, 85, 100, 25);
		Font f4 = new Font("Tahoma",Font.BOLD,14);
		l4.setFont(f4);
		l4.setForeground(Color.blue);
		
		
		l5 = new JLabel("Top Searches");
		l5.setBounds(300, 115,100, 25);
		Font f5 = new Font("Tahoma",Font.BOLD,14);
		l5.setForeground(new Color(0,255,0));
		l5.setFont(f5);
		
		l6 = new  JLabel("Welcome Anil");
		l6.setBounds(800, 20, 150, 35);
		Font f6 = new Font("Tahoma",Font.BOLD,14);
		l6.setForeground(new Color(0,255,0));
		l6.setFont(f6);
		
		
		b5 = new  JButton("Logout");
		b5.setBounds(980, 20, 100, 30);
		Font f15 = new Font("Tahoma",Font.BOLD,14);
		b5.setForeground(new Color(0,255,0));
		b5.setFont(f15);	
		b5.addActionListener(this);
		
		
	    l9 = new  JLabel(ii1);
		l9.setBounds(280,150, 175, 220);
		ii1 = new ImageIcon("mike.jpg");
		l9.setIcon(ii1);
		l9.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new LadiesFootware();
			}
		});
		
		l10 = new  JLabel(ii2);
		l10.setBounds(470, 150, 175, 220);
		ii2 = new ImageIcon("main2.jpg");
		l10.setIcon(ii2);
		l10.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			new NokiaShop();	
			}
		});
		
		l11 = new  JLabel(ii3);
		l11.setBounds(670, 150, 200, 256);
		ii3 = new ImageIcon("main3.jpg");
		l11.setIcon(ii3);
		l11.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			     new Audi();	
			}
		});


		
		l12 = new  JLabel(ii4);
		l12.setBounds(280,380,175,220);
		ii4 = new ImageIcon("main4.jpg");
		l12.setIcon(ii4);
		l12.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			   new CricketCollection();	
			}
		});
		l13 = new  JLabel(ii5);
		l13.setBounds(470, 380, 175, 220);
		ii5 = new ImageIcon("main5.jpg");
		l13.setIcon(ii5);
		l13.addMouseListener( new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			new SamsungShop();	
			}
		});
		l14 = new  JLabel(ii6);
		l14.setBounds(670, 380, 175, 220);
		ii6 = new ImageIcon("main6.jpg");
		l14.setIcon(ii6);
		l14.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			 new Novels();	
			}
		});
		c1 = new JComboBox(str);
	    c1.setBounds(400, 90, 300, 20);
	    c1.addActionListener(this);
		
	    
		b1 = new JButton("Books");
		b1.setBounds(400,120,100,20);
		Font f8 = new Font("Plain",Font.PLAIN,12);
		b1.setFont(f8);
		b1.addActionListener(this);
		
		b2 = new JButton("Mobiles");
		b2.setBounds(510, 120, 110, 20);
		Font f9 = new Font("Plain",Font.PLAIN,12);
		b2.setFont(f9);
		b2.addActionListener(this);
		
		b3 = new JButton("Sports");
		b3.setBounds(630, 120, 110, 20);
		Font f10 = new Font("Plain",Font.PLAIN,12);
		b3.setFont(f10);
		b3.addActionListener(this);
		
		b4 = new JButton("Cars");
		b4.setBounds(750, 120, 100, 20);
		Font f11 = new Font("Plain",Font.PLAIN,12);
		b4.setFont(f11);
		b4.addActionListener(this);
		
		
		
		b6 = new JButton("Footware");
		b6.setBounds(750, 120, 100, 20);
		Font f14 = new Font("Plain",Font.PLAIN,12);
		b6.setFont(f14);
		b6.addActionListener(this);
          c.add(b6).setLocation(870, 118);
          
        b7 = new JButton("Search");
  		b7.setBounds(740, 85, 100, 25);
  		Font f16 = new Font("Tahoma",Font.BOLD,14);
  		b7.setFont(f16);
  		b7.setForeground(Color.blue);
  		b7.addActionListener(this);
  		
		
		
		c.add(l1);
		c.add(l2);
		c.add(l4);
		c.add(l5);
		c.add(l6);
		c.add(b5);
		c.add(l9);
		c.add(l10);
		c.add(l11);
		c.add(l12);
		c.add(l13);
		c.add(l14);
		c.add(c1);
		
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(b4);
		c.add(b7);
		
		setSize(1600,1100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
}
		
public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==b1){
			this.dispose();
			new Novels();
			
		}
		if(ae.getSource()==b2){
			this.dispose();
			new NokiaShop();
			
		}
		if(ae.getSource()==b3){
			this.dispose();
			new CricketCollection();
		}
		if(ae.getSource()==b4){
			this.dispose();
			new Audi();
		}
		
		if(ae.getSource()==b5){
			this.dispose();
			new Onlineframe1();
		}
		
		if(ae.getSource()==b6){
			this.dispose();
			new LadiesFootware();
		}
		if(ae.getSource()==b7){
			this.dispose();
			new LadiesFootware().setVisible(true);
		}
String str1=c1.getSelectedItem().toString();
	if(str1=="kids comics"){
		this.dispose();
		new KidsComics();
	}
String str2=c1.getSelectedItem().toString();
	if(str2=="Samsung shop"){
		this.dispose();
		new SamsungShop();
	}
String str3=c1.getSelectedItem().toString();
	if(str3=="Bmw shop"){
		this.dispose();
		new Bmw();
	}
String str4=c1.getSelectedItem().toString();
	if(str4=="Tennis collection"){
		this.dispose();
		new TennisCollection();
	}


	JComboBox combo=new JComboBox(str);
	Object source=combo.getSelectedItem();
}
}


