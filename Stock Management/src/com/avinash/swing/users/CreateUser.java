package com.avinash.swing.users;
import java.awt.*;
import javax.swing.*;
import com.avinash.jdbc.daos.UsersDao;
import com.avinash.jdbc.pojos.Users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.avinash.jdbc.utlities.DateUtils;

public class CreateUser extends JPanel implements ActionListener{
	
	JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9;
	JFormattedTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	JButton btn1;
	JPanel northPanel, centerPanel,southPanel;
	JComboBox<String> comboTypesList;
	String cmbType;
	JPasswordField pswf;
	
	public CreateUser() {
		setBackground(new Color(234, 25, 22));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		setLayout(new BorderLayout());
		northPanel = new JPanel(new FlowLayout());
		centerPanel = new JPanel(new GridLayout(8, 2));
		southPanel = new JPanel(new FlowLayout());
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		 
		 lb1 = new JLabel();
		 
		 lb1.setText("Mobile ");
		 lb1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		 northPanel.add(lb1);
		 
		 tf1  = new JFormattedTextField(new String());
		 tf1.setColumns(10);
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
		
		UsersDao userdao3  = new UsersDao();
		Users user7 = userdao3.findAllByMobile(tf1.getText().trim());
		if(user7.getUserName() == null) {
			
			ButtonEventListener btnlistener = new ButtonEventListener();
			lb2 = new JLabel();
			lb2.setText("Name");
			lb2.setFont(new Font("Times New Roman", Font.BOLD, 12));
			centerPanel.add(lb2);
			
			 
			 tf2  = new JFormattedTextField(new String());
			 tf2.setColumns(10);
			 tf2.setBackground(Color.white);
			 tf2.setCaretColor(Color.black);
			 tf2.setFont(new Font("Times New Roman", Font.BOLD, 12));
			 centerPanel.add(tf2);
			 

			 lb3 = new JLabel();
   			 lb3.setText("Address");
			 lb3.setFont(new Font("Times New Roman", Font.BOLD, 12));
			 centerPanel.add(lb3);
				
				 
			 tf3  = new JFormattedTextField(new String());
			 tf3.setColumns(10);
			 tf3.setBackground(Color.white);
			 tf3.setCaretColor(Color.black);
			 tf3.setFont(new Font("Times New Roman", Font.BOLD, 12));
			 centerPanel.add(tf3);
			 
			 lb4 = new JLabel();
   			 lb4.setText("Doj");
			 lb4.setFont(new Font("Times New Roman", Font.BOLD, 12));
			 centerPanel.add(lb4);
				
			 tf4  =  new JFormattedTextField(new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()));
			 tf4.setColumns(10);
			 tf4.setBackground(Color.white);
			 tf4.setCaretColor(Color.black);
			 tf4.setFont(new Font("Times New Roman", Font.BOLD, 12));
			 centerPanel.add(tf4);
			 
			 lb5 = new JLabel();
   			 lb5.setText("Dob");
			 lb5.setFont(new Font("Times New Roman", Font.BOLD, 12));
			 centerPanel.add(lb5);
				
				 
			 tf5  = new JFormattedTextField(new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()));
			 tf5.setColumns(10);
			 tf5.setBackground(Color.white);
			 tf5.setCaretColor(Color.black);
			 tf5.setFont(new Font("Times New Roman", Font.BOLD, 12));
			 centerPanel.add(tf5);
			 
			 lb6 = new JLabel();
   			 lb6.setText("UserType");
			 lb6.setFont(new Font("Times New Roman", Font.BOLD, 12));
			 centerPanel.add(lb6);
			 
			 
			 
			 String[] comboTypes = { "Ware House Admin", "Ware House Entry Controller", "Waren House Exit Controler", "Store Billing Staff", "Store Co-ordinator", "Admin", "Manager" };

			comboTypesList = new JComboBox<String>(comboTypes);
			comboTypesList.setSelectedIndex(0);
			comboTypesList.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					JComboBox<?> jcmbType = (JComboBox<?>) e.getSource();
					cmbType = (String) jcmbType.getSelectedItem();
					}
				});
				centerPanel.add(comboTypesList);
				
			lb7 = new JLabel();
	   		lb7.setText("Eamil");
			lb7.setFont(new Font("Times New Roman", Font.BOLD, 12));
			centerPanel.add(lb7);
					
					 
			tf6  = new JFormattedTextField(new String());
			tf6.setColumns(10);
			tf6.setBackground(Color.white);
			tf6.setCaretColor(Color.black);
			tf6.setFont(new Font("Times New Roman", Font.BOLD, 12));
			centerPanel.add(tf6);	
			 
			lb8 = new JLabel();
   			lb8.setText("Password");
			lb8.setFont(new Font("Times New Roman", Font.BOLD, 12));
			centerPanel.add(lb8);
				
				 
			pswf = new JPasswordField();
			pswf.setColumns(10);
			pswf.setBackground(Color.white);
			pswf.setCaretColor(Color.black);
			pswf.setFont(new Font("Times New Roman", Font.BOLD, 12));
			centerPanel.add(pswf);
			 
			lb9 = new JLabel();
   			lb9.setText("Store Id");
			lb9.setFont(new Font("Times New Roman", Font.BOLD, 12));
			centerPanel.add(lb9); 
			
			tf7  = new JFormattedTextField(new String());
			tf7.setColumns(10);
			tf7.setBackground(Color.white);
			tf7.setCaretColor(Color.black);
			tf7.setFont(new Font("Times New Roman", Font.BOLD, 12));
			centerPanel.add(tf7);
			
			btn1 = new JButton();
			btn1.setText("Register");
			btn1.setForeground(Color.black);
			btn1.setToolTipText("click to submit the record");
			btn1.addActionListener(btnlistener);
			southPanel.add(btn1);
				
			centerPanel.invalidate();
			centerPanel.updateUI();
			
			southPanel.invalidate();
			southPanel.updateUI();
		}
		else {
			JOptionPane.showMessageDialog(this, "the user is already registered", "Error", JOptionPane.INFORMATION_MESSAGE);
		
		}
		
	}
	 class ButtonEventListener implements ActionListener {

		
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			 Users user = new Users();
			 user.setMobile(tf1.getText().trim());
			 user.setUserName(tf2.getText());
			 user.setAddress(tf3.getText());
			 String date1 = tf5.getText();
			 user.setDoj(DateUtils.convertDate(date1));
			 String date = tf4.getText();
			 user.setDob(DateUtils.convertDate(date));
			 user.setUserType(cmbType);
			 user.setEmail(tf6.getText());
			 user.setPassword(pswf.getText());
			 user.setStoreId(Integer.parseInt(tf7.getText().trim()));
			 user.setTotalSale(Integer.parseInt("0"));
			 UsersDao userDao = new UsersDao();
			 userDao.createUser(user);
			 JOptionPane.showMessageDialog(btn1, "Records successsfully submitted", "Success", JOptionPane.INFORMATION_MESSAGE);
			
			
		}
		 
	 }
	
	public static void main(String args[]) {
		JFrame f = new JFrame("Create User");
		f.setContentPane(new CreateUser());
		f.setBounds(180, 230, 430, 350);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		
		
	}

}
