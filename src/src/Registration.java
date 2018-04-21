

	import java.sql.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.applet.*;
import javax.swing.*;


public class Registration extends JFrame  implements ActionListener{
		private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
		private JButton b1,b2,b6;
		private JTextField name,email,contact_no,Date_of_Birth,cntct_numbr,gender;
		private JPasswordField Set_password ,confirm_password;
		private JTextArea address;
		private JComboBox cb;
		private JRadioButton rb1,rb2;
		private JScrollBar sb;
		private ButtonGroup bg;
		String Name,Email_ID,Contact_no,Gender,Address,Set_Password,Confirm_Password,Date_Of_Birth;

		
    Registration(){
			Container c=getContentPane();
			c.setLayout(null);
		
	        
	        l2=new JLabel("Registration Details");
	        l2.setBounds(300,250,720,60);
			l2.setFont(new Font("vivaldi",Font.BOLD+Font.ITALIC,32));
			l2.setForeground(new Color(0,255,0));
	        c.add(l2).setLocation(420,120);
	    
	        Icon i=new ImageIcon("sanage.jpg");
	        l9=new JLabel(i);
	        l9.setBounds(10,10,1000,90);
	        c.add(l9).setLocation(49,30);
	        
	        Icon i1=new ImageIcon("hindi.jpg");
	        l14=new JLabel(i1);
	        l14.setBounds(10,10,200,240);
	        c.add(l14).setLocation(0,0);
	        
	        Icon i2=new ImageIcon("aman.jpg");
	        l15=new JLabel(i2);
	        l15.setBounds(430,348,170,1050);
	        c.add(l15).setLocation(0,50);
	        
	        l8=new JLabel("  ManiaShopping.com");
	        l8.setBounds(210, 125, 725, 40);
	        l8.setFont(new Font("Vivaldi",Font.BOLD+Font.ITALIC,20));
	        l8.setForeground(new Color(0,255,0));
	        c.add(l8).setLocation(1050, 3);
	        
	        l3=new JLabel("Name");
	        l3.setBounds(20,90,150,20);
	        l3.setForeground(new Color(0, 102, 204));
	        l3.setFont(new Font("vavlide",Font.BOLD+Font.ITALIC,20));
	        c.add(l3).setLocation(450,200);
	        
	        name=new JTextField(100);
	        name.setBounds(350,140,250,25);
	        name.setBackground(new Color(255,255,255));
	        name.setForeground(new Color(0,0,0));
	        c.add(name).setLocation(540,200);
	        
	        l4=new JLabel("Email_id");
	        l4.setBounds(30,100,150,20);
	        l4.setForeground(new Color(0, 102, 204));
	        l4.setFont(new Font("vavlide",Font.BOLD+Font.ITALIC,20));
	        c.add(l4).setLocation(450,240);
	        
	        email=new JTextField(100);
	        email.setBounds(350,140,250,25);
	        email.setBackground(new Color(255,255,255));
	        email.setForeground(new Color(0,0,0));
	        c.add(email).setLocation(540,240);
	        
	        l5=new JLabel("@example.com");
	        l5.setBounds(700,140,280,40);
	        l5.setForeground(Color.magenta);
	        l5.setFont(new Font("vavlide",Font.BOLD+Font.ITALIC,18));
	        c.add(l5).setLocation(790,240);
	        
	        l6=new JLabel("Contact_No");
	        l6.setBounds(30,100,150,20);
	        l6.setForeground(new Color(0, 102, 204));
	        l6.setFont(new Font("vavlide",Font.BOLD+Font.ITALIC,20));
	        c.add(l6).setLocation(450,280);
	        
	        contact_no=new JTextField(100);
	        contact_no.setBounds(350,140,230,25);
	        contact_no.setBackground(new Color(255,255,255));
	        contact_no.setForeground(new Color(0,0,0));
	        c.add(contact_no).setLocation(565,280);
	        
	        l7=new JLabel("Gender");
	        l7.setBounds(30,100,190,60);
	        l7.setForeground(new Color(0, 102, 204));
	        l7.setFont(new Font("vavlide",Font.BOLD+Font.ITALIC,20));
	        c.add(l7).setLocation(450,290);
	        
	        rb1=new JRadioButton("Male");
	        rb1.setBounds(70,90,110,30);
	        rb1.setForeground(new Color(0,0,0));
	        rb1.setFont(new Font("vavlide",Font.BOLD+Font.ITALIC,18));
	        c.add(rb1).setLocation(550, 310);
	     
	    
	        rb2=new JRadioButton("Female");
	        rb2.setBounds(70,90,110,30);
	        rb2.setForeground(new Color(0,0,0));
	        rb2.setFont(new Font("vavlide",Font.BOLD+Font.ITALIC,18));
	        c.add(rb2).setLocation(690, 310);
	        
	       bg=new ButtonGroup();
	       bg.add(rb1);
	       bg.add(rb2);
	        
	        l8=new JLabel("Address");
	        l8.setBounds(30,100,190,60);
	        l8.setForeground(new Color(0, 102, 204));
	        l8.setFont(new Font("vavlide",Font.BOLD+Font.ITALIC,20));
	        c.add(l8).setLocation(450,330);
	        
	        address=new JTextArea();
	        address.setBounds(350,140,180,25);
	        address.setBackground(Color.white);
	        address.setForeground(Color.black);
	        address.setSize(260,40);
	        c.add(address).setLocation(540,350);
	        
	      
	        l10=new JLabel("Set Password");
	        l10.setBounds(30,100,190,60);
	        l10.setForeground(new Color(0, 102, 204));
	        l10.setFont(new Font("vavlide",Font.BOLD+Font.ITALIC,20));
	        c.add(l10).setLocation(450,380);
	        
	        Set_password=new JPasswordField(100);
	        Set_password.setBounds(350,140,200,25);
	        Set_password.setBackground(new Color(255,255,255));
	        Set_password.setForeground(new Color(0,0,0));
	        c.add(Set_password).setLocation(600,400);
	        
	        l11=new JLabel("Confirm Password");
	        l11.setBounds(30,100,190,60);
	        l11.setForeground(new Color(0, 102, 204));
	        l11.setFont(new Font("vavlide",Font.BOLD+Font.ITALIC,20));
	        c.add(l11).setLocation(430,440);
	        
	        confirm_password=new JPasswordField(100);
	        confirm_password.setBounds(350,100,180,25);
	        confirm_password.setBackground(new Color(255,255,255));
	        confirm_password.setForeground(new Color(0,0,0));
	        c.add(confirm_password).setLocation(620,460);
	        
	        l12=new JLabel("Date of Birth");
	        l12.setBounds(30,100,190,60);
	        l12.setForeground(new Color(0, 102, 204));
	        l12.setFont(new Font("vavlide",Font.BOLD+Font.ITALIC,20));
	        c.add(l12).setLocation(450,480);
	        
	        Date_of_Birth=new JTextField(100);
	        Date_of_Birth.setBounds(350,140,180,25);
	        Date_of_Birth.setBackground(new Color(255,255,255));
	        Date_of_Birth.setForeground(new Color(0,0,0));
	        c.add(Date_of_Birth).setLocation(620,500);
	        
	        l13=new JLabel("dd/mm/yy");
	        l13.setBounds(30,100,190,60);
	        l13.setForeground(Color.magenta);
	        l13.setFont(new Font("vavlide",Font.BOLD+Font.ITALIC,20));
	        c.add(l13).setLocation(820,480);
	        
	        b1=new JButton("Submit");
	        b1.setBounds(300,200,100,30);
	        b1.setBackground(Color.white);
	        b1.setForeground(Color.black);
	        b1.addActionListener(this);
	        b1.setFont(new Font("Monotype Corsiva",Font.BOLD,20));
	        c.add(b1).setLocation(800,650);
	        
	        b2=new JButton("Go Back");
	        b2.setBounds(100,40,100,30);
	        b2.setBackground(Color.white);
	        b2.setForeground(Color.black);
	        b2.addActionListener(this);
	        b2.setFont(new Font("Monotype Corsiva",Font.BOLD+Font.ITALIC,18));
	        c.add(b2).setLocation(950,650);
	        
	        b6=new JButton("Refresh");
	        b6.setBounds(300,200,100,30);
	        b6.setBackground(Color.white);
	        b6.setForeground(Color.black);
	        b6.addActionListener(this);
	        b6.setFont(new Font("Monotype Corsiva",Font.BOLD,20));
	        c.add(b6).setLocation(650,650);
	        
	        
	        
	   
	        
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize(1300,1300);
	        setVisible(true);
	        
	       }
		
public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b1){
		
	            
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system","system");
						Statement st = con.createStatement();
						if(Set_password.getText().equals (confirm_password.getText())){
		                      
							
						 boolean flag;
	                        if (this.rb1.isSelected()) {
	            				flag = true;
	            				
	            			} else {
	            				flag = false;
	            			}if (flag == true) {
	            				
						ResultSet rs = st.executeQuery("insert into  resgistration1 values('"+name.getText() +"','"+ email.getText()+"','"+contact_no.getText()+"','"+ rb1.getText()+"','"+address.getText()+"','"+Set_password.getText()+"','"+ confirm_password.getText()+"','"+ Date_of_Birth.getText()+"')");
	            			}else{		ResultSet rs = st.executeQuery("insert into  resgistration1 values('"+name.getText() +"','"+ email.getText()+"','"+contact_no.getText()+"','"+ rb2.getText()+"','"+address.getText()+"','"+Set_password.getText()+"','"+ confirm_password.getText()+"','"+ Date_of_Birth.getText()+"')");
	            			}
	            			JOptionPane.showMessageDialog(null,"Data Has Been Save Successfully"); 
		                       
						}
	            			 else{
	    		            	 JOptionPane.showMessageDialog(null,"set password again"); 
	    		             }
                       
		                 con.commit();
		                 st.close();
		                 con.close();                             
	            			
				
			}catch (Exception ae) {
				JOptionPane.showMessageDialog(null, ae.getMessage());
				
			}
				
			}
			if(e.getSource()==b2){
				this.dispose();
				new Onlineframe1 ();	
			}
			if(e.getSource()==b6){
				this.dispose();
			    new Registration ().setVisible(true);	
			}
	}
}