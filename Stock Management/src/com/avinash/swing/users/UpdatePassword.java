package com.avinash.swing.users;
import java.awt.*;
import java.awt.*;
import javax.swing.*;


import com.avinash.jdbc.daos.UsersDao;
import com.avinash.jdbc.pojos.Users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.avinash.jdbc.utlities.DateUtils;

public class UpdatePassword extends JPanel implements ActionListener{
	JLabel lb1, lb2, lb3;
	JTextField tf1, tf2, tf3;
	JPanel northPanel, centerPanel,southPanel;
	JButton btn1;
	
	public UpdatePassword() {
		
		setBackground(Color.white);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		setLayout(new BorderLayout());
		northPanel = new JPanel(new FlowLayout());
		centerPanel = new JPanel(new GridLayout(2, 2));
		southPanel = new JPanel(new FlowLayout());
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		 
		 lb1 = new JLabel();
		 lb1.setText(" UserID");
		 lb1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		 northPanel.add(lb1);
		 
		 tf1  = new JFormattedTextField(new String());
		 tf1.setColumns(10);
		 tf1.setBackground(Color.white);
		 tf1.setCaretColor(Color.black);
		 tf1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		 tf1.addActionListener(this);
		 northPanel.add(tf1);
		 
			lb2 = new JLabel();
			lb2.setText("Old Password");
			lb2.setFont(new Font("Times New Roman", Font.BOLD, 12));
			northPanel.add(lb2);
			 
			 tf2  = new JFormattedTextField(new String());
			 tf2.setColumns(10);
			 tf2.setBackground(Color.white);
			 tf2.setCaretColor(Color.black);
			 tf2.setFont(new Font("Times New Roman", Font.BOLD, 12));
			 tf2.addActionListener(this);
			 northPanel.add(tf2);
		 
		 add(northPanel, BorderLayout.NORTH);
		 add(centerPanel, BorderLayout.CENTER);	
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		 UsersDao userdao4  = new UsersDao();
		 Users user7 = UsersDao.findByUserIdAndPassword(Integer.parseInt(tf1.getText().trim()),tf2.getText());
		if(user7.getUserName() == null) {
			
			JOptionPane.showMessageDialog(this, "no records found plese enter a valid userId and password", "Error", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
			
		}
		else {
			
			ButtonEventListener btnlistener = new ButtonEventListener(); 
			lb3 = new JLabel();
			lb3.setText("New Password");
			lb3.setFont(new Font("Times New Roman", Font.BOLD, 12));
			centerPanel.add(lb3);
				 
			tf3  = new JFormattedTextField(new String());
			tf3.setColumns(10);
			tf3.setBackground(Color.white);
			tf3.setCaretColor(Color.black);
			tf3.setFont(new Font("Times New Roman", Font.BOLD, 12));
			tf3.addActionListener(this);
			centerPanel.add(tf3);
			
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
		
	}
	
	class ButtonEventListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Users user1 = new Users();
			UsersDao userdao = new UsersDao();
			userdao.updatePassword(tf3.getText(), Integer.parseInt(tf1.getText()), tf2.getText());
			JOptionPane.showMessageDialog(btn1, "Done", "Success", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		
	}
	
	public static void main(String args[]) {
		JFrame f = new JFrame("Update Password");
		f.setContentPane(new UpdatePassword());
		f.setBounds(50, 100, 400, 200);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

}
