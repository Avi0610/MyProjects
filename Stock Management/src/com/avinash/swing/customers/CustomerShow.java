package com.avinash.swing.customers;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.TableModel;

public class CustomerShow extends JPanel{
	
	JTable table;
	
	
	public CustomerShow() {
		setLayout(new BorderLayout());

		
		CustomerTableModel ct = new CustomerTableModel();
		table = new JTable(ct);
		table.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(new JScrollPane(table), BorderLayout.CENTER);
	
		
	}
	public static void main(String args[]) {
		JFrame f = new JFrame("All customers");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new CustomerShow());
		f.setMinimumSize(new Dimension(800, 450));
		f.pack();
		f.setLocationRelativeTo(null);
		//f.setResizable(false);
		f.setVisible(true);
	}

}
