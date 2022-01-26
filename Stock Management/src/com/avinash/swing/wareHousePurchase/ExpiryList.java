package com.avinash.swing.wareHousePurchase;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import com.avinash.swing.users.TableModelOfUserType;

public class ExpiryList extends JPanel {
	
	JTable table;
	JPanel centerPanel;
	
	public ExpiryList() {
		setBackground(Color.white);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout());
		
		ExpiryProductTableModel med = new ExpiryProductTableModel();
		table = new JTable(med);
		table.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public static void main(String args[]) {
		JFrame f = new JFrame("Expiring products List");
		f.setContentPane(new ExpiryList());
		f.setBounds(1000, 1000, 1100, 730);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
