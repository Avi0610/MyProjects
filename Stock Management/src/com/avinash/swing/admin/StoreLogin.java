package com.avinash.swing.admin;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import com.avinash.jdbc.daos.*;
import com.avinash.jdbc.pojos.*;
import com.avinash.jdbc.utlities.DateUtils;
import com.avinash.swing.integration.AdminVirtualDesktop;
import com.avinash.swing.integration.StoreVirtualDesktop;
import com.avinash.swing.wareHousePurchase.CreateWareHousePurchase;

public class StoreLogin extends JPanel implements ActionListener {
	JLabel lb1, lb2;
	JFormattedTextField tf1;
	JPasswordField pswf;
	JButton btn1;
	
	public StoreLogin() {
		
		setBackground(Color.white);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JPanel p1 = new JPanel(new FlowLayout());
		JPanel p2 = new JPanel(new FlowLayout());
		JPanel p3 = new JPanel(new FlowLayout());
		
		lb1 = new JLabel();
		lb1.setText("User Id    ");
		lb1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		p1.add(lb1);
		
		tf1  = new JFormattedTextField(new String());
		tf1.setColumns(10);
		tf1.setBackground(Color.white);
		tf1.setCaretColor(Color.black);
		tf1.setSelectedTextColor(Color.red);
		tf1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tf1.selectAll();
		p1.add(tf1);
		
		lb2 = new JLabel();
		lb2.setText("Password");
		lb2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		p2.add(lb2);
		
		pswf  = new JPasswordField(new String());
		pswf.setColumns(10);
		pswf.setBackground(Color.white);
		pswf.setCaretColor(Color.black);
		pswf.setFont(new Font("Times New Roman", Font.BOLD, 12));
		p2.add(pswf);
		
		btn1 = new JButton();
		btn1.setText("                     Login                 ");
		btn1.setActionCommand("Login");
		btn1.addActionListener(this);
		p3.add(btn1);
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
		
		UsersDao userdao = new UsersDao();
		Users user = userdao.findByUserIdAndPassword(Integer.parseInt(tf1.getText().trim()), pswf.getText().trim());
		if(user.getUserName() == null) {
			JOptionPane.showMessageDialog(this, "please enter valid credintial", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			
			
				new StoreVirtualDesktop();
			
		}
		
	}
	
	public static void main(String args[]) {
		JFrame f = new JFrame("Admin Login");
		f.setContentPane(new StoreLogin());
		f.setBounds(300	, 300, 300, 170);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}
