package travelinformation;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class ViewCustomer extends JFrame implements ActionListener{
	
	JButton back;
	
	ViewCustomer(String username){
		
		setBounds(450,180,870,625);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(30,50,150,25);
		add(lblusername);
		
		JLabel labelusername = new JLabel();
		labelusername.setBounds(220,50,150,25);
		labelusername.setForeground(Color.BLUE);
		add(labelusername);
		
		JLabel lblid = new JLabel("ID");
		lblid.setBounds(30,110,150,25);
		add(lblid);
		
		JLabel labelid = new JLabel();
		labelid.setBounds(220,110,150,25);
		labelid.setForeground(Color.BLUE);
		add(labelid);
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(30,170,150,25);
		add(lblnumber);
		
		JLabel labelnumber = new JLabel();
		labelnumber.setBounds(220,170,150,25);
		labelnumber.setForeground(Color.BLUE);
		add(labelnumber);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(30,230,150,25);
		add(lblname);
		
		JLabel labelname= new JLabel();
		labelname.setBounds(220,230,150,25);
		labelname.setForeground(Color.BLUE);
		add(labelname);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(30,290,150,25);
		add(lblgender);
		
		JLabel labelgender = new JLabel();
		labelgender.setBounds(220,290,150,25);
		labelgender.setForeground(Color.BLUE);
		add(labelgender);
		
		JLabel lblcountry = new JLabel("Country");
		lblcountry.setBounds(450,50,150,25);
		add(lblcountry);
		
		JLabel labelcountry = new JLabel();
		labelcountry.setBounds(640,50,150,25);
		labelcountry.setForeground(Color.BLUE);
		add(labelcountry);
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(450,110,150,25);
		add(lblphone);
		
		JLabel labelphone = new JLabel();
		labelphone.setBounds(640,110,150,25);
		labelphone.setForeground(Color.BLUE);
		add(labelphone);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(450,170,150,25);
		add(lbladdress);
		
		JLabel labeladdress = new JLabel();
		labeladdress.setBounds(640,170,150,25);
		labeladdress.setForeground(Color.BLUE);
		add(labeladdress);
		
		JLabel labelemail = new JLabel();
		labelemail.setBounds(640,230,150,25);
		labelemail.setForeground(Color.BLUE);
		add(labelemail);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(450,230,150,25);
		add(lblemail);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(350,350,100,25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(20,400,600,200);
		add(image);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image2 = new JLabel(i6);
		image2.setBounds(600,400,600,200);
		add(image2);
		
		try {
			Conn c = new Conn();
			String query = "select * from customer where username = '"+username+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelname.setText(rs.getString("name"));
				labelgender.setText(rs.getString("gender"));
				labelcountry.setText(rs.getString("country"));
				labeladdress.setText(rs.getString("address"));
				labelphone.setText(rs.getString("phone"));
				labelemail.setText(rs.getString("email"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
	}

	public static void main(String[] args) {
		new ViewCustomer("John_Wick");

	}

}
