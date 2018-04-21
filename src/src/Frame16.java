import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
public class Frame16 extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField tf1,tf2;
	JPasswordField pf1,pf2,pf3;
	JButton b;
	Frame16(){
		
		Container c = getContentPane();
		c.setLayout(null);
		l1 = new JLabel("State Bank Of India");
		l1.setBounds(350,20,400,50);
		Font f1 = new Font("Plain",Font.BOLD,18);
		l1.setFont(f1);
		l1.setForeground(Color.blue);
		 
		l2 = new JLabel("Name");
		l2.setBounds(40, 95, 90, 25);
		
		l3 = new JLabel("Email_id");
		l3.setBounds(40, 135,110 , 25);
		
		l4 = new JLabel("ATM.no");
		l4.setBounds(40, 175, 90, 25);
		
		l5 = new JLabel("PIN Code");
		l5.setBounds(40, 215,100 , 25);
		
		l6 = new JLabel("3D Secure Password");
		l6.setBounds(40,255,250,25);
		
		
		tf1 = new JTextField("Enter Name");
		tf1.setBounds(180,95,250,25);
		
		tf2 = new JTextField("Enter Email_id");
		tf2.setBounds(180, 135, 250, 25);
		pf1 = new JPasswordField();
		pf1.setBounds(180,175,  250, 25);
		pf2 = new JPasswordField();
		pf2.setBounds(180, 215, 250, 25);
		
		pf3 = new JPasswordField();
		pf3.setBounds(180,255,250,25);
		
		b = new JButton("Next");
		b.setBounds(600, 350,90 ,25);
		Font f2 = new Font("Plain",Font.PLAIN,12);
		b.setFont(f2);
		b.setForeground(Color.blue);
		
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		c.add(l5);
		c.add(l6);
		c.add(tf1);
		c.add(tf2);
		c.add(pf1);
		c.add(pf2);
		c.add(pf3);
		c.add(b);
        b.addActionListener(this);
        
        setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setTitle("Frame16");
    	setSize(1300,1300);
        
		
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()== b){
			this.dispose();
			new Frame17().setVisible(true);
		}
	}

}
