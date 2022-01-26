package com.avinash.swing.users;
import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import javax.swing.border.BevelBorder;



public class UsersByType extends JPanel implements ActionListener {
	

	JComboBox<String> comboTypesList;
	String cmbType;
	JTable table;
	JPanel northPanel, centerPanel;
	
	public UsersByType() {
		setBackground(Color.white);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout());
		JPanel northPanel = new JPanel();
		
		 String[] comboTypes = { "Ware House Admin", "Ware House Entry Controller", "Waren House Exit Controler", "Store Billing Staff", "Store Co-ordinator", "Admin", "Manager" };


			comboTypesList = new JComboBox<String>(comboTypes);
			comboTypesList.setSelectedIndex(0);
			comboTypesList.addActionListener(this);
			northPanel.add(comboTypesList);
			add(northPanel, BorderLayout.NORTH);
			
			TableModelOfUserType st = new TableModelOfUserType("Ware House Admin");
			table = new JTable(st);
			table.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			add(new JScrollPane(table), BorderLayout.CENTER);
			
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JComboBox<?> jcmbType = (JComboBox<?>) arg0.getSource();
		cmbType = (String) jcmbType.getSelectedItem();
		TableModelOfUserType ut = new TableModelOfUserType(cmbType.trim());
		table.setModel(ut);		
	}
	
	public static void main(String args[]) {
		JFrame f = new JFrame("Users Type");
		f.setContentPane(new UsersByType());
		f.setBounds(500, 500, 1250, 620);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		
	}


}
