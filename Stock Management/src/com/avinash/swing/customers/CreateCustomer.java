package com.avinash.swing.customers;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import com.avinash.jdbc.daos.CustomersDao;

import com.avinash.jdbc.pojos.Customers;



public class CreateCustomer extends JPanel implements ActionListener{
	
	JLabel lb1, lb2, lb3, lb4, lb5, lb6;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6;
	JButton btn1;
	JPanel northPanel, centerPanel, southPanel;
	JRadioButton rb1, rb2;
	String gender = "Male";
	
	RadioListner mylistner = null;
	
	static JFrame f = new JFrame("Create Customer");

	
	public CreateCustomer() {
		
		setBackground(new Color(25, 234, 22));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		

		setLayout(new BorderLayout());
		northPanel = new JPanel(new FlowLayout());
		centerPanel = new JPanel(new FlowLayout());
		southPanel = new JPanel(new FlowLayout());
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		 
		 lb1 = new JLabel();
		 lb1.setText("Mobile                  ");
		 lb1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		 northPanel.add(lb1);
		 
		 tf1  = new JFormattedTextField(new String());
		 tf1.setColumns(15);
		 tf1.setBackground(Color.white);
		 tf1.setCaretColor(Color.black);
		 tf1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		 tf1.addActionListener(this);
		 northPanel.add(tf1);
		 
		 add(northPanel, BorderLayout.NORTH);
		 add(centerPanel, BorderLayout.CENTER);
		 add(southPanel,BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		 CustomersDao customerdao2  = new CustomersDao();
	 	 Customers cust2 = CustomersDao.find(tf1.getText().trim());
	 	 
	 	 if(cust2.getCustName() == null) {
	 		ButtonEventListener btnlistener = new ButtonEventListener();
	 		

			 lb2 = new JLabel();
			 lb2.setText(" Name                   ");
			 lb2.setFont(new Font("Times New Roman", Font.BOLD, 12));
			 centerPanel.add(lb2);
			 
			 tf2  = new JFormattedTextField(new String());
			 tf2.setColumns(15);
			 tf2.setBackground(Color.white);
			 tf2.setCaretColor(Color.black);
			 tf2.setFont(new Font("Times New Roman", Font.BOLD, 12));
			 tf2.addActionListener(this);
			 centerPanel.add(tf2);
			 
			 lb3 = new JLabel();
			 lb3.setText("Email                    ");
			 lb3.setFont(new Font("Times New Roman", Font.BOLD, 12));
			 centerPanel.add(lb3);
			 
			 tf3  = new JFormattedTextField(new String());
			 tf3.setColumns(15);
			 tf3.setBackground(Color.white);
			 tf3.setCaretColor(Color.black);
			 tf3.setFont(new Font("Times New Roman", Font.BOLD, 12));
			 tf3.addActionListener(this);
			 centerPanel.add(tf3);
			 
			 lb2 = new JLabel();
			 lb2.setText("Gender                         ");
			 lb2.setFont(new Font("Times New Roman", Font.BOLD, 12));
			 centerPanel.add(lb2);
			 
			 rb1 = new JRadioButton();
				rb1.setText("Male");
				rb1.setMnemonic(KeyEvent.VK_M);
				rb1.setActionCommand("Male");
				rb1.setSelected(true);
				rb1.setOpaque(false);
				rb1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
				centerPanel.add(rb1);
				
				rb2 = new JRadioButton();
				rb2.setText("Female");
				rb2.setMnemonic(KeyEvent.VK_F);
				rb2.setActionCommand("Female");
				rb2.setOpaque(false);
				rb2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
				centerPanel.add(rb2);
				
				ButtonGroup group = new ButtonGroup();
				group.add(rb1);
				group.add(rb2);
			
				
				mylistner = new RadioListner();
				rb1.addActionListener(mylistner);
				rb2.addActionListener(mylistner);
				
				 btn1 = new JButton();
				 btn1.setText("register");
				 btn1.setForeground(Color.black);
				 btn1.setToolTipText("click to submit the record");
				 btn1.setActionCommand("submit");
				 btn1.addActionListener(btnlistener);
				 southPanel.add(btn1);
				 
				centerPanel.invalidate();
				centerPanel.updateUI();
					
				southPanel.invalidate();
				southPanel.updateUI();
	 		
	 		
	 	 }
	 	 
	 	else {
			JOptionPane.showMessageDialog(this, "the Customer is already registered", "Error", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		
	}
	
	 class ButtonEventListener implements ActionListener {

			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				Customers customer = new Customers();
				customer.setCustName(tf2.getText().trim());
				customer.setMobile(tf1.getText().trim());
				customer.setEmail(tf3.getText());
				customer.setGender(gender);
				customer.setRewards(00.00);
				CustomersDao customerDao = new CustomersDao();
				customerDao.createCustomer(customer);
				JOptionPane.showMessageDialog(btn1, "Records successsfully submitted", "Success", JOptionPane.INFORMATION_MESSAGE);
				f.dispose();
				//System.exit(0);
				
			}
			 
		 }
	 
	 class RadioListner implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				gender = arg0.getActionCommand();	
			}
		}
	
	public static void main(String args[]) {
		f.setContentPane(new CreateCustomer());
		f.setBounds(180, 230, 350, 250);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		
	}

}
