package com.avinash.swing.users;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;


import com.avinash.jdbc.daos.UsersDao;
import com.avinash.jdbc.pojos.Users;
public class RemoveUser extends JPanel implements ActionListener  {
	
	JLabel lb1;
	JTextField tf1;
	JButton btn1;
	
	public RemoveUser() {
		
		setBackground(Color.yellow);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		Panel p1 = new Panel(new FlowLayout());
		
		lb1 = new JLabel();
		lb1.setText("UserId");
		lb1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		p1.add(lb1);
		
		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setCaretColor(new Color (20,20,15));
		tf1.setBackground(Color.white);
		p1.add(tf1);
		
		btn1 = new JButton();
		Icon defaultIcon = new ImageIcon(getClass().getResource("/images/green.PNG"));
		Icon rollOverIcon = new ImageIcon(getClass().getResource("/images/Red.PNG"));
		btn1.setRolloverEnabled(true);
		btn1.setIcon(defaultIcon);
		btn1.setActionCommand("Delete");
		btn1.setRolloverIcon(rollOverIcon);
		btn1.setToolTipText("Button to Delete a record");
		btn1.setContentAreaFilled(false);
		btn1.setBorderPainted(false);
		btn1.setFocusPainted(false);
		btn1.addActionListener(this);
		
		setLayout(new FlowLayout());
		add(p1);
		add(btn1);
	
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		 UsersDao userdao4  = new UsersDao();
		 Users user = UsersDao.findByUserId(Integer.parseInt(tf1.getText().trim()));
		 if(user.getUserName() != null ) {
			 int x = JOptionPane.showConfirmDialog(this, "Are you Sure, you want to delete records of "+user.getUserName()+"\n"+
		 "working as "+user.getUserType(), "Delete",
						JOptionPane.YES_NO_OPTION);
			 
			 if (x == JOptionPane.YES_OPTION) {
				 	UsersDao userdao1  = new UsersDao();
				 	userdao1.removeUser(Integer.parseInt(tf1.getText()));
				 	 JOptionPane.showMessageDialog(this, "Records Successfully Deleted ", "Success", JOptionPane.INFORMATION_MESSAGE);
				 	 System.exit(0);
			 }
			 
		 }
		 else {
			 JOptionPane.showMessageDialog(this, "No User With This User Id Exists ", "Error", JOptionPane.INFORMATION_MESSAGE);
		 }
		
	}
	public static void main(String args[]) {
		JFrame f = new JFrame("Remove User");
		f.setContentPane(new RemoveUser());
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
	}

}
