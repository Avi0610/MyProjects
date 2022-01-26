package com.avinash.swing.customers;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import com.avinash.jdbc.daos.CustomersDao;
import com.avinash.jdbc.daos.StoreSalesDeatailsDao;
import com.avinash.jdbc.daos.StoreStockDetailsDao;
import com.avinash.jdbc.pojos.Customers;
import com.avinash.jdbc.pojos.StoreSalesDetails;
import com.avinash.jdbc.pojos.StoreStockDetails;
import com.avinash.swing.StoreSale.StoreSalesTableModel;

import com.avinash.swing.users.SearchUserByMobile;
public class UpdateCustomers extends JPanel implements ActionListener {
	
	JLabel lb1, lb2, lb3, lb4;
	JFormattedTextField tf1, tf2, tf3, tf4;
	JButton btn1, btn2;
	JPanel p1, p2,p3;
	private static String str;
	
	public UpdateCustomers() {
		
		setBackground(new Color(120,1,8));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		p1 = new JPanel(new FlowLayout());
		p2 = new JPanel(new GridLayout(4, 2));
		p3 = new JPanel(new FlowLayout());
		
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
		p3.setOpaque(false);
		
		add(p1);
		add(p2);
		add(p3);
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
 		
 		ButtonEventListener btnlistener = new ButtonEventListener();
 		str = tf1.getText().trim();
 		

		
 		
 		 lb2 = new JLabel();
 		 lb2.setText("Name");
 		 lb2.setFont(new Font("Times New Roman", Font.BOLD, 15));
 		 lb2.setForeground(Color.WHITE);
		 p2.add(lb2);
		 
		 tf2 = new JFormattedTextField();
		 tf2.setText(cust2.getCustName());
		 tf2.setColumns(15);
		 tf2.setBackground(Color.white);
		 tf2.setCaretColor(Color.black);
		 tf2.setSelectedTextColor(Color.red);
		 tf2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		 p2.add(tf2);
		 
		 
 		 lb3 = new JLabel();
 		 lb3.setText("Email");
 		 lb3.setFont(new Font("Times New Roman", Font.BOLD, 15));
 		 lb3.setForeground(Color.WHITE);
		 p2.add(lb3);
		 
		 tf3 = new JFormattedTextField();
		 tf3.setText(cust2.getEmail());
		 tf3.setColumns(15);
		 tf3.setBackground(Color.white);
		 tf3.setCaretColor(Color.black);
		 tf3.setSelectedTextColor(Color.red);
		 tf3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		 p2.add(tf3);
		 
		 
 		 lb4 = new JLabel();
 		 lb4.setText("Gender");
 		 lb4.setFont(new Font("Times New Roman", Font.BOLD, 15));
 		 lb4.setForeground(Color.WHITE);
		 p2.add(lb4);
		 
		 tf4 = new JFormattedTextField();
		 tf4.setText(cust2.getGender());
		 tf4.setColumns(15);
		 tf4.setBackground(Color.white);
		 tf4.setCaretColor(Color.black);
		 tf4.setSelectedTextColor(Color.red);
		 tf4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		 p2.add(tf4);
		 
		 btn2 = new JButton();
		 btn2.setText("Update");
		 btn2.setForeground(Color.black);
		 btn2.setToolTipText("click to submit the record");
		 btn2.addActionListener(btnlistener);
		 p3.add(btn2);
		
		
		 p2.invalidate();
		 p2.updateUI();
		 
		 p3.invalidate();
		 p3.updateUI();
		 
 	}
	
	}

class ButtonEventListener implements ActionListener {

	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		 Customers customer = new Customers();
		 customer.setCustName(tf2.getText().trim());
		 customer.setMobile(tf1.getText().trim());
		 customer.setEmail(tf3.getText().trim());
		 customer.setGender(tf4.getText().trim());
		 CustomersDao customerDao = new CustomersDao();
		 customerDao.updateCustomers(customer,str);
		 
		 JOptionPane.showMessageDialog(btn2, "Updated", "success", JOptionPane.INFORMATION_MESSAGE);
		
		
	}		
		
}


public static void main(String args[]) {
	JFrame f =  new JFrame("Update Customer");
	f.setContentPane(new UpdateCustomers());
	f.setBounds(180, 230, 350, 230);
	f.setVisible(true);
	f.setLocationRelativeTo(null);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

}
