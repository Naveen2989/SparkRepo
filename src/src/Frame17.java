import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import javax.swing.border.*;
public class Frame17 extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5;
    JButton b5;
    
    Frame17(){
    	Container c = getContentPane();
    	c.setLayout(null);
    	l1 = new JLabel("Success");
    	Font f1 = new Font("Plain",Font.BOLD,18);
    	l1.setFont(f1);
    	l1.setBounds(350, 20, 80, 60);
    	l1.setForeground(Color.BLUE);
    	
    	l2 = new JLabel("Your E-Payment through Debit Card has been successful.Try to choose more & more options because it is fully secure");
    	Font f2 = new Font("Plain",Font.PLAIN,12);
    	l2.setFont(f2);
    	l2.setBounds(20, 70, 800, 25);
    	l2.setForeground(Color.blue);
    	
    	l3 = new JLabel("no information related to your account that is your PIN-Code,Email_id etc have been stored while choosing online shopping through");
    	Font f3 = new Font("Plain",Font.PLAIN,12);
    	l3.setFont(f3);
    	l3.setBounds(20, 100, 950,25);
    	l3.setForeground(Color.blue);
    	
    	l4 = new JLabel("E-Payment");
    	Font f4 = new Font("Plain",Font.PLAIN,12);
    	l4.setFont(f4);
    	l4.setBounds(20, 130,100, 25);
    	l4.setForeground(Color.blue);
    	
    	l5 = new JLabel("Thanks For Choosing ShoppingMania.com...............");
    	Font f5 = new Font("Plain",Font.BOLD,18);
    	l5.setFont(f5);
    	l5.setBounds(150, 200, 500,35);
    	l5.setForeground(Color.blue);
    	
    	
    	
    	
    	
		
		b5 = new  JButton("Signout");
		b5.setBounds(800, 20, 100, 30);
		Font f15 = new Font("Tahoma",Font.BOLD,14);
		b5.setForeground(new Color(0,255,0));
		b5.setFont(f15);	
		b5.addActionListener(this);
			
    	
    	
    	c.add(b5);
    	c.add(l1);
    	c.add(l2);
    	c.add(l3);
    	c.add(l4);
    	c.add(l5);
    	
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(1300,1300);
    	
    	
    }
    
    
    public void actionPerformed(ActionEvent ae){
    	
       if(ae.getSource()==b5){
			this.dispose();
			new Onlineframe1().setVisible(true);
		}
		
    	
    	
    }
}