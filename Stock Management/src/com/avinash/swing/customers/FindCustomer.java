package com.avinash.swing.customers;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import com.avinash.jdbc.daos.CustomersDao;
import com.avinash.jdbc.pojos.Customers;
import com.avinash.swing.users.SearchUserByMobile;

public class FindCustomer extends JPanel implements ActionListener {
	
	JLabel lb1, lb2, lb3, lb4, lb5, lb6;
	JFormattedTextField tf1;
	JButton btn1;
	JPanel p1, p2;
	
	public FindCustomer() {
		
		setBackground(new Color(120,1,8));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		p1 = new JPanel(new FlowLayout());
		p2 = new JPanel(new GridLayout(10, 1));
		
		lb1 = new JLabel();
		lb1.setText("Mobile");
		lb1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lb1.setForeground(Color.WHITE);
		p1.add(lb1);
		
		tf1 = new JFormattedTextField(new String());
		tf1.setColumns(15);
		tf1.setBackground(Color.white);
		tf1.setCaretColor(Color.black);
		tf1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tf1.addActionListener(this);
		p1.add(tf1);
		
		btn1 = new JButton();
		btn1.setText("Find");
		btn1.setForeground(Color.black);
		btn1.setToolTipText("click to submit the record");
		btn1.addActionListener(this);
		p1.add(btn1);
		p1.setOpaque(false);
		p2.setOpaque(false);
		
		add(p1);
		add(p2);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		 CustomersDao customerdao2  = new CustomersDao();
	 	 Customers cust2 = CustomersDao.find(tf1.getText().trim());
	 	 
	 	 if(cust2.getCustName() == null) {
				JOptionPane.showMessageDialog(this, "the Customer is not registered", "Error", JOptionPane.INFORMATION_MESSAGE);

	 	 }
	 	 
	 	 else {
	 		 
	 		 lb2 = new JLabel();
	 		 lb2.setText("Name =  "+cust2.getCustName() );
	 		 lb2.setFont(new Font("Times New Roman", Font.BOLD, 18));
	 		 lb2.setForeground(Color.WHITE);
			 p2.add(lb2);
			 
			 
	 		 lb3 = new JLabel();
	 		 lb3.setText("Email =  "+cust2.getEmail() );
	 		 lb3.setFont(new Font("Times New Roman", Font.BOLD, 18));
	 		 lb3.setForeground(Color.WHITE);
			 p2.add(lb3);
			 
			 
	 		 lb4 = new JLabel();
	 		 lb4.setText("Gender =  "+cust2.getGender() );
	 		 lb4.setFont(new Font("Times New Roman", Font.BOLD, 18));
	 		 lb4.setForeground(Color.WHITE);
			 p2.add(lb4);
			 
			 
	 		 lb5 = new JLabel();
	 		 lb5.setText("Rewards =  "+cust2.getRewards() );
	 		 lb5.setFont(new Font("Times New Roman", Font.BOLD, 18));
	 		 lb5.setForeground(Color.WHITE);
	 		 p2.add(lb5);
			 
			 p2.invalidate();
			 p2.updateUI();
	 	 }
		
	}
	
	public static void main(String args[]) {
		JFrame f =  new JFrame("Find Customer");
		f.setContentPane(new FindCustomer());
		f.setBounds(180, 230, 350, 200);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
