
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.border.Border;


public class Onlineframe1 extends JFrame implements ActionListener  {
    private JButton jButton1,jButton2;
    private JLabel jLabel1,jLabel2,jL3, jL4,jL6,jL7,jL8,jL9;
    int x,y;   
    
    
 	
 Onlineframe1(){
    	Container c = getContentPane();
 		y=140;
 		c.setLayout(null);
        
 		
 		
        jLabel1=new JLabel (" Welcome to Online  Shopping Mania");
        jLabel1.setBounds(210,125, 725, 30);
        jLabel1.setFont(new Font("Vivaldi",Font.BOLD+Font.ITALIC,42));
        jLabel1.setForeground(new Color(0, 255, 0));
        c.add(jLabel1).setLocation(120, 34);
        
        jL8=new JLabel("  ManiaShopping.com");
        jL8.setBounds(210, 125, 725, 40);
        jL8.setFont(new Font("Vivaldi",Font.BOLD+Font.ITALIC,20));
        jL8.setForeground(new Color(0,255,0));
        c.add(jL8).setLocation(1050, 3);
        
        
        
   
        jButton1=new JButton("Login");
        jButton1.setBounds(100,15,140,37);
        jButton1.setBackground(Color.white);
        jButton1.setForeground(new Color(0, 102, 204));
        jButton1.setFont(new Font("Tw Cen MT Condensed Extra Bold",Font.BOLD+Font.ITALIC,22)); 
        jButton1.addActionListener(this);
        c.add(jButton1).setLocation(700, 111);
        
        
        jButton2=new JButton("Registration");
        jButton2.setBounds(100, 15, 150, 37);
        jButton2.setBackground(Color.white);
        jButton2.setForeground(new Color(0, 102, 204));
        jButton2.setFont(new Font("Tw Cen MT Condensed Extra Bold",Font.BOLD+Font.ITALIC , 22));
        jButton2.addActionListener(this);
        c.add(jButton2).setLocation(850, 111);
        
       
        
        Icon i=new ImageIcon("aman.jpg");
        jLabel2=new JLabel(i);
        jLabel2.setBounds(430,348,370,1050);
        c.add(jLabel2).setLocation(0,50);
        
      
        Icon i1=new ImageIcon("hindi.jpg");
        jL3=new JLabel(i1);
        jL3.setBounds(234,143,215,195);
        c.add(jL3).setLocation(70, 180);
        
        Icon i2=new ImageIcon("math.jpg");
        jL4=new JLabel(i2);
        jL4.setBounds(1000,533,1133,595);
        c.add(jL4).setLocation(420, 270);
        
       
        Icon i3=new ImageIcon("raghav.jpg");
        jL6=new JLabel(i3);
        jL6.setBounds(100,300,250,250);
        c.add(jL6).setLocation(870, 200);
        
        
        Icon i4=new ImageIcon("vivek.jpg");
        jL7=new JLabel(i4);
        jL7.setBounds(350,250,350,350);
        c.add(jL7).setLocation(400, 380);
      
        Icon i5=new ImageIcon("deepak.jpg");
        jL9=new JLabel(i5);
        jL9.setBounds(350,250,350,350);
        c.add(jL9).setLocation(400, 120);
      
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         setVisible(true);   
         setSize(1300,1300);
         
        
     }
public static void main(String args[]){
       new Onlineframe1();    
    }
public void actionPerformed(ActionEvent e) {
	

	if(e.getSource()==jButton1){
		this.dispose();
		new LoginPage();	
	}
	if(e.getSource()==jButton2){
		this.dispose();
		new Registration().setVisible(true);
	}
}

   }
       
   
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 