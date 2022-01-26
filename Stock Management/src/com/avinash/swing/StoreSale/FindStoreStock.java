package com.avinash.swing.StoreSale;
import com.avinash.jdbc.daos.StoreSalesDao;
import com.avinash.jdbc.pojos.StoreSales;
import com.avinash.jdbc.utlities.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class FindStoreStock extends JPanel implements ActionListener {
	
	JLabel lb1;
	JFormattedTextField tf1;
	JTable table;
	JPanel northPanel, centerPanel;
	
	public FindStoreStock() {
		setBackground(Color.white);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout());
		northPanel = new JPanel(new FlowLayout());
		
		
		lb1 = new JLabel();
		lb1.setText("Store Id");
		lb1.setFont(new Font("Serif", Font.BOLD, 15));
		lb1.setForeground(Color.black);;
		northPanel.add(lb1);
		
		tf1 = new JFormattedTextField(new String());
		tf1.setColumns(18);
		tf1.setBackground(Color.white);
		tf1.setCaretColor(Color.black);
		tf1.setSelectedTextColor(Color.red);
		tf1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tf1.addActionListener(this);
		northPanel.add(tf1);
		
	
		
		northPanel.setOpaque(false);
		
		add(northPanel, BorderLayout.NORTH);
		
		StoreStockTableModel med = new StoreStockTableModel(0);
		table = new JTable(med);
		table.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		add(new JScrollPane(table), BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		StoreStockTableModel mt = new StoreStockTableModel(Integer.parseInt(tf1.getText().trim()));
	    table.setModel(mt);
	 
		
	}
	
	public static void main(String args[]) {
		JFrame f = new JFrame("Find Stock");
		f.setContentPane(new FindStoreStock());
		f.setBounds(1000, 1000, 1100, 730);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
