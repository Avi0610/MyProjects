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

public class FindMaxSellingProducts extends JPanel implements ActionListener {
	
	JLabel lb1;
	JFormattedTextField tf1;
	JTable table;
	JPanel northPanel, centerPanel;
	
	public FindMaxSellingProducts() {
		setBackground(Color.white);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout());
		northPanel = new JPanel(new FlowLayout());
		
		lb1 = new JLabel();
		lb1.setText("Date");
		lb1.setFont(new Font("Serif", Font.BOLD, 15));
		lb1.setForeground(Color.black);;
		northPanel.add(lb1);
		
		tf1 = new JFormattedTextField(new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()));
		tf1.setColumns(18);
		tf1.setBackground(Color.white);
		tf1.setCaretColor(Color.black);
		tf1.setSelectedTextColor(Color.red);
		tf1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tf1.addActionListener(this);
		northPanel.add(tf1);
		
		
		northPanel.setOpaque(false);
		
		add(northPanel, BorderLayout.NORTH);
		
		MaxSellingTableModel med = new MaxSellingTableModel(new java.util.Date());
		table = new JTable(med);
		table.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		add(new JScrollPane(table), BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		MaxSellingTableModel mt = new MaxSellingTableModel(DateUtils.convertDate(tf1.getText().trim()));
	    table.setModel(mt);
		
	}
	
	public static void main(String args[]) {
		JFrame f = new JFrame("Find Max Sales");
		f.setContentPane(new FindMaxSellingProducts());
		f.setBounds(1000, 1000, 1100, 730);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
