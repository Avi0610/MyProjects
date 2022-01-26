package com.avinash.swing.users;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import com.avinash.jdbc.daos.UsersDao;
import com.avinash.jdbc.pojos.Users;

public class SearchUserByMobile extends JPanel implements ActionListener{
	
	JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11;
	JTextField tf1;
	JPanel p1, p2;
	
	public SearchUserByMobile() {
		
		setBackground(Color.white);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		
		
		p1 = new JPanel(new GridLayout(1, 2));
		p2 = new JPanel(new GridLayout(10, 1));
		
		lb1 = new JLabel();
		lb1.setText("Mobile");
		lb1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		p1.add(lb1);
		
		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBackground(Color.white);
		tf1.setCaretColor(Color.black);
		tf1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tf1.addActionListener(this);
		p1.add(tf1);
		
		add(p1);
		add(p2);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		UsersDao userdao3  = new UsersDao();
		Users user7 = userdao3.findAllByMobile(tf1.getText().trim());
		
		if(user7.getUserName() == null) {
			JOptionPane.showMessageDialog(this, "the user is not registered", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else {
			
			
			lb2 = new JLabel();
			lb2.setText("User Id   = "+user7.getUserId());
			lb2.setFont(new Font("Times New Roman", Font.BOLD, 15));
			p2.add(lb2);
			
			lb3 = new JLabel();
			lb3.setText("Name      = "+user7.getUserName());
			lb3.setFont(new Font("Times New Roman", Font.BOLD, 15));
			p2.add(lb3);
			
			lb4 = new JLabel();
			lb4.setText("Address   = "+user7.getAddress());
			lb4.setFont(new Font("Times New Roman", Font.BOLD, 15));
			p2.add(lb4);
			
			lb5 = new JLabel();
			lb5.setText("Email      = "+user7.getEmail());
			lb5.setFont(new Font("Times New Roman", Font.BOLD, 15));
			p2.add(lb5);
			
			lb6 = new JLabel();
			lb6.setText("User type  = "+user7.getUserType());
			lb6.setFont(new Font("Times New Roman", Font.BOLD, 15));
			p2.add(lb6);
			
			lb7 = new JLabel();
			lb7.setText("Password  = "+user7.getPassword());
			lb7.setFont(new Font("Times New Roman", Font.BOLD, 15));
			p2.add(lb7);
			
			lb8 = new JLabel();
			lb8.setText("Store Id   = "+user7.getStoreId());
			lb8.setFont(new Font("Times New Roman", Font.BOLD, 15));
			p2.add(lb8);
			
			lb9 = new JLabel();
			lb9.setText("Sale      = "+user7.getTotalSale());
			lb9.setFont(new Font("Times New Roman", Font.BOLD, 15));
			p2.add(lb9);
			
			lb10 = new JLabel();
			lb10.setText("Dob       = "+user7.getDob());
			lb10.setFont(new Font("Times New Roman", Font.BOLD, 15));
			p2.add(lb10);
			
			lb11 = new JLabel();
			lb11.setText("Doj       = "+user7.getDoj());
			lb11.setFont(new Font("Times New Roman", Font.BOLD, 15));
			p2.add(lb11);
			
			
			add(p2);
			
			
			
			p1.invalidate();
			p1.updateUI();
			
			p2.invalidate();
			p2.updateUI();
			
		}
		
	}
	
	public static void main(String args[]) {
		JFrame f =  new JFrame("Search User");
		f.setContentPane(new SearchUserByMobile());
		f.setBounds(180, 230, 380, 300);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
