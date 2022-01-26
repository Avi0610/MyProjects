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

public class StoreProByName  extends JPanel implements ActionListener {
	
	
	JLabel lb1, lb2;
	JFormattedTextField tf1, tf2;
	JButton btn1;
	JTable table;
	JPanel northPanel, centerPanel;
	
	public StoreProByName() {
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
		tf1.setColumns(15);
		tf1.setBackground(Color.white);
		tf1.setCaretColor(Color.black);
		tf1.setSelectedTextColor(Color.red);
		tf1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		northPanel.add(tf1);
		
		lb2 = new JLabel();
		lb2.setText("Pro Name");
		lb2.setFont(new Font("Serif", Font.BOLD, 15));
		lb2.setForeground(Color.black);;
		northPanel.add(lb2);
		
		tf2 = new JFormattedTextField(new String());
		tf2.setColumns(15);
		tf2.setBackground(Color.white);
		tf2.setCaretColor(Color.black);
		tf2.setSelectedTextColor(Color.red);
		tf2.setFont(new Font("Times New Roman", Font.BOLD, 12));

		northPanel.add(tf2);
		
		btn1 = new 	JButton();
		btn1.setText("Find");
		btn1.setActionCommand("Find");
		btn1.addActionListener(this);
		northPanel.add(btn1);
		
		northPanel.setOpaque(false);
		
		add(northPanel, BorderLayout.NORTH);
		
		StoreProTableModel med = new StoreProTableModel(1, "Avinash");
		table = new JTable(med);
		table.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		StoreProTableModel mt = new StoreProTableModel(Integer.parseInt(tf1.getText().trim()), tf2.getText().trim());
	    table.setModel(mt);
		
	}
	
	public static void main(String args[]) {
		
		JFrame f = new JFrame("Store Pro By Name");
		f.setContentPane(new StoreProByName());
		f.setBounds(1000, 1000, 1100, 730);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
