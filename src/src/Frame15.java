import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
public class Frame15 extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6;
	JComboBox c1;
	JButton b;
	Checkbox c2,c3,c4;
	ImageIcon ii1,ii2,ii3;


Frame15(){
	Container c = getContentPane();
	c.setLayout(null);
	l1 = new JLabel("Select Payment Options");
	l1.setBounds(500, 20, 250, 35);
	Font f1 = new Font("Plain",Font.BOLD,24);
	l1.setFont(f1);
	l1.setForeground(Color.BLUE);
	
	l2 = new JLabel("Transfer funds From");
	l2.setBounds(50, 80, 250,25);
	Font f2 = new Font("Plain",Font.BOLD,18);
	l1.setFont(f2);
	
	c1 = new JComboBox();
	c1.addItem("Select Your Bank");
	c1.addItem("State Bank Of India");
	c1.setBounds(400, 80, 300,35);
	
	l3 = new JLabel("Options");
	l3.setBounds(40,130,50,25);
	
	l4 = new JLabel(ii1);
	ImageIcon ii1 = new ImageIcon("C:/Users/praveen.malik/Workspaces/MyEclipse 9/OnlineShopping/src/atm1.jpg");
	l4.setIcon(ii1);
	l4.setBounds(450,180 ,120,80);
	
	l5 = new JLabel(ii2);
	ImageIcon ii2 = new ImageIcon("C:/Users/praveen.malik/Workspaces/MyEclipse 9/OnlineShopping/src/atm2.jpg");
	l5.setIcon(ii2);
	l5.setBounds(470,180 ,276,182);
	
	l6 = new JLabel(ii3);
	ImageIcon ii3 = new ImageIcon("C:/Users/praveen.malik/Workspaces/MyEclipse 9/OnlineShopping/src/atm3.jpg");
	l6.setIcon(ii3);
	l6.setBounds(470,180 ,276,182);
	
	
	
	
	c2 = new Checkbox("Cash On Delivery");
	c3 = new Checkbox("Debit Card");
	c4 = new Checkbox("Credit Card");
    c2.setBounds(40, 180,250,25);
	c3.setBounds(40, 220, 250, 25);
	c4.setBounds(40,260,250,25);
	b = new JButton("Proceed");
	b.setBounds(600, 600,200,40);
	Font f3 = new Font("Plain",Font.PLAIN,12);
	b.setFont(f3);
	b.setForeground(Color.blue);
	c.add(l1);
	c.add(l2);
	c.add(l3);
	/*c.add(l4);
	c.add(l5);
	c.add(l6);*/
	c.add(c1);
	c.add(c2);
	c.add(c2);
	c.add(c3);
	c.add(c4);
	c.add(b);
	b.addActionListener(this);	
	
	setTitle("Frame15");
	setVisible(true);
	setSize(1300,1300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent ae){
	if(ae.getSource()==b){
		this.dispose();
		new Frame16().setVisible(true);
	}
}

}