import java.sql.*;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class ShoppingDetails extends JFrame implements ActionListener{
	
	private JLabel l1,l2;
	private JButton b1,b2;
	private JTable t;
	private JCheckBox cb;
	
	ShoppingDetails(){
		
		Container c=getContentPane();
		setLayout(null);
		
		
		Icon i=new ImageIcon("sanu.jpg");
        l1=new JLabel(i);
        l1.setBounds(10,10,1000,200);
        c.add(l1).setLocation(100,10);
        
        l2=new JLabel("Shopping Details");
        l2.setBounds(200,100,700,60);
		l2.setFont(new Font("Script MT Bold",Font.BOLD+Font.ITALIC,40));
		l2.setForeground(new Color(253,0,153));
        c.add(l2).setLocation(500,210);
		
    
        b1=new JButton("Click to view items Selected");
        b1.setBounds(30,100,380,80);
        b1.setForeground(Color.black);
        b1.setBackground(Color.green);
        b1.setFont(new Font("Algerian",Font.BOLD,16));
        b1.addActionListener(this);
        c.add(b1).setLocation(450,300);
        
        b2=new JButton("Back");
        b2.setBounds(30,200,150,30);
        b2.setForeground(Color.black);
        b2.setBackground(Color.white);
        b2.setFont(new Font("Algerian",Font.BOLD,16));
        b2.addActionListener(this);
        c.add(b2).setLocation(500,650);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1400,1400);
        setVisible(true);
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==b1){
			this.dispose();
			new CheckBoxDemo();
		}
		if(ae.getSource()==b2){
			this.dispose();
			new MainFrame().setVisible(true);
		}
	}

}

