package com.avinash.swing.ProductsRelated;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.avinash.jdbc.daos.ProductCategoriesDao;

import com.avinash.jdbc.pojos.ProductCategories;



public class UpdateProCat extends JPanel implements ActionListener {
	
	JLabel lb1, lb2, lb3, lb4, lb5;
	JFormattedTextField tf1, tf2, tf3, tf4, tf5;
	JButton btn1;
	JPanel p2, p3;
	
	public UpdateProCat() {
		
		setBackground(new Color(120,1,8));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JPanel p1 = new JPanel(new GridLayout(1, 2));
		p2 = new JPanel(new GridLayout(4, 2));
		
		lb1 = new JLabel();
		lb1.setText("Category Id");
		lb1.setFont(new Font("Serif", Font.BOLD, 15));
		lb1.setForeground(Color.white);;
		p1.add(lb1);
		
		tf1 = new JFormattedTextField(new String());
		tf1.setText("");
		tf1.setColumns(18);
		tf1.setBackground(Color.white);
		tf1.setCaretColor(Color.black);
		tf1.setSelectedTextColor(Color.red);
		tf1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tf1.addActionListener(this);
		p1.add(tf1);
		
		p1.setOpaque(false);
		add(p1);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ProductCategoriesDao procatdao = new ProductCategoriesDao();
		ProductCategories pro7 = procatdao.findByCatId(Integer.parseInt(tf1.getText().trim()));
		
		if(pro7.getpCatName() == null) {
			
			JOptionPane.showMessageDialog(this, "No such products found", "Error", JOptionPane.INFORMATION_MESSAGE);

		}
		else {
			
			ButtonEventListener btnlistener = new ButtonEventListener();
			
			lb2 = new JLabel();
			lb2.setText("Category Name");
			lb2.setFont(new Font("Serif", Font.BOLD, 15));
			lb2.setForeground(Color.white);;
			p2.add(lb2);
			
			tf2 = new JFormattedTextField(new String());
			tf2.setText(pro7.getpCatName());
			tf2.setColumns(18);
			tf2.setBackground(Color.white);
			tf2.setCaretColor(Color.black);
			tf2.setSelectedTextColor(Color.red);
			tf2.setFont(new Font("Times New Roman", Font.BOLD, 12));
			tf2.selectAll();
			p2.add(tf2);
			
			lb3 = new JLabel();
			lb3.setText("C.G.S.T");
			lb3.setFont(new Font("Serif", Font.BOLD, 15));
			lb3.setForeground(Color.white);;
			p2.add(lb3);
			
			tf3 = new JFormattedTextField(new String());
			tf3.setText(""+pro7.getCgst());
			tf3.setColumns(18);
			tf3.setBackground(Color.white);
			tf3.setCaretColor(Color.black);
			tf3.setSelectedTextColor(Color.red);
			tf3.setFont(new Font("Times New Roman", Font.BOLD, 12));
			tf3.selectAll();
			p2.add(tf3);
			
			lb4 = new JLabel();
			lb4.setText("S.G.S.T");
			lb4.setFont(new Font("Serif", Font.BOLD, 15));
			lb4.setForeground(Color.white);;
			p2.add(lb4);
			
			tf4 = new JFormattedTextField(new String());
			tf4.setText(""+pro7.getSgst());
			tf4.setColumns(18);
			tf4.setBackground(Color.white);
			tf4.setCaretColor(Color.black);
			tf4.setSelectedTextColor(Color.red);
			tf4.setFont(new Font("Times New Roman", Font.BOLD, 12));
			tf4.selectAll();
			p2.add(tf4);
			
			lb5 = new JLabel();
			lb5.setText("Details");
			lb5.setFont(new Font("Serif", Font.BOLD, 15));
			lb5.setForeground(Color.white);;
			p2.add(lb5);
			
			tf5 = new JFormattedTextField(new String());
			tf5.setText(""+pro7.getDetails());
			tf5.setColumns(18);
			tf5.setBackground(Color.white);
			tf5.setCaretColor(Color.black);
			tf5.setSelectedTextColor(Color.red);
			tf5.setFont(new Font("Times New Roman", Font.BOLD, 12));
			tf5.selectAll();
			p2.add(tf5);
			
			p3 = new JPanel(new FlowLayout());
			
			btn1 = new JButton();
			btn1.setText("                 Upadte              ");
			btn1.setActionCommand("Update");
			btn1.addActionListener(btnlistener);
			p3.add(btn1);
			
			add(p2);
			add(p3);
			
			p2.setOpaque(false);
			p3.setOpaque(false);
			
			p2.invalidate();
			p2.updateUI();
			p3.invalidate();
			p3.updateUI();
			tf1.setEditable(false);

		}
		
	}
	
	class ButtonEventListener implements ActionListener {

		
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			
			ProductCategories procat = new ProductCategories();
			procat.setpCatId(Integer.parseInt(tf1.getText().trim()));
			procat.setpCatName(tf2.getText().trim());
			procat.setCgst(Double.parseDouble(tf3.getText().trim()));
			procat.setSgst(Double.parseDouble(tf4.getText().trim()));
			procat.setDetails(tf5.getText().trim());
			ProductCategoriesDao procatdao = new ProductCategoriesDao();
			procatdao.editCategories(procat);
			
			JOptionPane.showMessageDialog(btn1, "Successfully Updated", "Success", JOptionPane.INFORMATION_MESSAGE);

	
	
		}
		 
	 }
	
public static void main(String args[]) {
		
		JFrame f = new JFrame("Update Pro Category");
		f.setContentPane(new UpdateProCat());
		f.setBounds(500, 500, 500, 250);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
