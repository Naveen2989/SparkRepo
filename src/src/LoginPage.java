

import java.sql.*;
import javax.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener {
	private JLabel l1,l2,l3,l4,l5,l8;
	private JButton b1,b6;
	private JTextField tf1;
	private JPasswordField pf1;
	  String p;
      int check;
	int x,y;
	
	Container c=getContentPane();
	
	LoginPage(){
		y=140;
		c.setLayout(null);
		
		p=" ";
        check=0;
		
		
            l1=new JLabel("Login Page");		
		    l1.setBounds(210,125, 725, 30);
		    l1.setFont(new Font("Viner Hand ITC",Font.BOLD+Font.ITALIC , 32));
	        l1.setForeground(new Color(0, 255, 0));
	        c.add(l1).setLocation(380, 98);
	        
	        l8=new JLabel("  ManiaShopping.com");
	        l8.setBounds(210, 125, 725, 40);
	        l8.setFont(new Font("Vivaldi",Font.BOLD+Font.ITALIC,20));
	        l8.setForeground(new Color(0,0,0));
	        c.add(l8).setLocation(1050, 3);
		
            l2=new JLabel("UserName");
            l2.setBounds(300,50,100,150);
            l2.setFont(new Font("Tw Cen MT Condensed Extra Bold",Font.BOLD+Font.ITALIC,18));
            l2.setForeground(new Color(0,102,204));
            c.add(l2).setLocation(420,100);
        
            tf1=new JTextField(100);
            tf1.setBounds(350,90,180,25);
            tf1.setBackground(new Color(255,255,255));
            tf1.setForeground(new Color(0,0,0));
            c.add(tf1).setLocation(520,170);
        
            l3=new JLabel("Password");
            l3.setBounds(400,90,90,190);
            l3.setForeground(new Color(0,102,204));
            l3.setFont(new Font("Tw Cen MT Condensed Extra Bold",Font.BOLD+Font.ITALIC,18));
            c.add(l3).setLocation(420,120);
        
            pf1=new JPasswordField(100);
            pf1.setBounds(350,140,180,25);
            pf1.setBackground(new Color(255,255,255));
            pf1.setForeground(new Color(0,0,0));
            c.add(pf1).setLocation(520,210);
        
            b1=new JButton("Submit");
            b1.setBounds(400,120,100,30);
            b1.setBackground(Color.white);
            b1.setForeground(Color.black);
            b1.setFont(new Font("Monotype Corsiva",Font.BOLD,20));
            b1.addActionListener(this);
            c.add(b1).setLocation(600,310);
        
            l4=new JLabel("Forgot Password");
            l4.setBounds(420,150,150,55);
            l4.setForeground(new Color(0,153,0));
            l4.setFont(new Font("Viner Hand ITC",Font.BOLD,14));
            c.add(l4).setLocation(610,340);
         
            b6=new JButton("Back ");
            b6.setBounds(400,100, 100, 30);
            b1.setBackground(Color.white);
            b6.setForeground( Color.black);
            b6.setFont(new Font("Viner Hand ITC",Font.BOLD,14));
            b6.addActionListener(this);
              c.add(b6).setLocation(20, 34);             
                            
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       setSize(1400,1600);
        setVisible(true);
       
   	
	}
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource()==b6){
			this.dispose();
              new Onlineframe1();	
			}		
       if(e.getSource()==b1){
    	   
    	String str = this.tf1.getText();
   		char[] pass = pf1.getPassword();
   		String str1 = new String(pass);
   		
   		try {
   			Class.forName("oracle.jdbc.driver.OracleDriver");
   			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
   			Statement st = con.createStatement();
   			ResultSet rs = st
   					.executeQuery("select name,set_password from  resgistration1");
   			String uname = "", pwd = "";
   			while (rs.next()) {
   				uname = rs.getString("name");
   			    pwd = rs.getString("set_password");

   				if (str.equals(uname) && str1.equals(pwd)) {
   					JOptionPane.showMessageDialog(null, "Welcome '" + uname+ "',Press Ok to Enter..!");
   					this.dispose();
   					new MainFrame().setVisible(true);
   					
   				}
   				else {
   					
   				}
   			} 
   		} catch (Exception ae) {
   		
   		}
   		
   	}
   		
   	}
}


