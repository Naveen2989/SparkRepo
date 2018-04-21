import java.awt.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.event.*;

public class CheckBoxDemo implements ActionListener {
	private JLabel l1,l2;
	  private static String des;
	  private static String el;
	  private JButton b1;
	  JFrame f=new JFrame("Your Cart");
	  JCheckBox c1;
	  JCheckBox c2;
	  Vector columnNames;
      Vector data;
      
     
	  
	  CheckBoxDemo(){
		  
		  
		  des = "purchase";
		  el="Select to View Items";
		  c1 = new JCheckBox(des);
		  c1.addActionListener(this);
		  f.add(c1);
		  
		  c2=new JCheckBox(el);
		  c2.addActionListener(this);
		  f.add(c2);
		  
		  columnNames = new Vector();
		  data = new Vector();
		  
		  
		  
		  f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		  f.setVisible(true);
		  f.setSize(500,500);
		  
	  }
	
	public void actionPerformed(ActionEvent e) {
		AbstractButton abstractButton = (AbstractButton)e.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        String newLabel = (selected ? el : des);
        abstractButton.setText(newLabel);
    
        
      if(newLabel.equals("Select to View Items")){
      try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system","system");
      Statement st = con.createStatement();
      ResultSet rs= st.executeQuery("Select * from shoppingdetails1");
      ResultSetMetaData md = rs.getMetaData();
      int columns = md.getColumnCount();
      for (int i = 1; i <= columns; i++) {
      columnNames.addElement( md.getColumnName(i) );
      }
      while (rs.next()) {
      Vector row = new Vector(columns);
      for (int i = 1; i <= columns; i++) {
      row.addElement( rs.getObject(i) );
      }
      data.addElement( row );
        }
      }
      catch(Exception ea){
    	  }
      }if(e.getSource()==b1){
	    	new Frame15();  
      }
      JTable table = new JTable(data, columnNames);
      JScrollPane pane = new JScrollPane(table);
      JFrame f=new JFrame("Confirm your cart");
      
     
      b1=new JButton("Make Payment");
      b1.setBounds(30,100,180,30);
      b1.setForeground(Color.black);
      b1.setBackground(Color.white);
      b1.setFont(new Font("San Serif",Font.PLAIN,16));
      b1.addActionListener(this);
      f.add(b1).setLocation(750,670);
      
      f.add(pane);
      f.setVisible(true);
      f.pack();
      f.setSize(600,600);
      f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
      
     
      
      
	}
	
	 
}
