package com.avinash.swing.ProductsRelated;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.avinash.jdbc.daos.ProductCategoriesDao;
import com.avinash.jdbc.pojos.ProductCategories;
import com.avinash.swing.StoreSale.CreateStoreSale;

public class CreateProCat extends JPanel implements ActionListener{
	
	JLabel lb1, lb2, lb3, lb4, lb5;
	JFormattedTextField tf1, tf2, tf3, tf4, tf5;
	JButton btn1;
	
	public CreateProCat() {
		
		setBackground(new Color(120,1,8));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JPanel p1 = new JPanel(new GridLayout(6,2));
		JPanel p2 = new JPanel(new FlowLayout());
		
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
		tf1.selectAll();
		p1.add(tf1);
		
		lb2 = new JLabel();
		lb2.setText("Category Name");
		lb2.setFont(new Font("Serif", Font.BOLD, 15));
		lb2.setForeground(Color.white);;
		p1.add(lb2);
		
		tf2 = new JFormattedTextField(new String());
		tf2.setText("");
		tf2.setColumns(18);
		tf2.setBackground(Color.white);
		tf2.setCaretColor(Color.black);
		tf2.setSelectedTextColor(Color.red);
		tf2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tf2.selectAll();
		p1.add(tf2);
		
		lb3 = new JLabel();
		lb3.setText("C.G.S.T");
		lb3.setFont(new Font("Serif", Font.BOLD, 15));
		lb3.setForeground(Color.white);;
		p1.add(lb3);
		
		tf3 = new JFormattedTextField(new String());
		tf3.setText("");
		tf3.setColumns(18);
		tf3.setBackground(Color.white);
		tf3.setCaretColor(Color.black);
		tf3.setSelectedTextColor(Color.red);
		tf3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tf3.selectAll();
		p1.add(tf3);
		
		lb4 = new JLabel();
		lb4.setText("S.G.S.T");
		lb4.setFont(new Font("Serif", Font.BOLD, 15));
		lb4.setForeground(Color.white);;
		p1.add(lb4);
		
		tf4 = new JFormattedTextField(new String());
		tf4.setText("");
		tf4.setColumns(18);
		tf4.setBackground(Color.white);
		tf4.setCaretColor(Color.black);
		tf4.setSelectedTextColor(Color.red);
		tf4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tf4.selectAll();
		p1.add(tf4);
		
		lb5 = new JLabel();
		lb5.setText("Details");
		lb5.setFont(new Font("Serif", Font.BOLD, 15));
		lb5.setForeground(Color.white);;
		p1.add(lb5);
		
		tf5 = new JFormattedTextField(new String());
		tf5.setText("");
		tf5.setColumns(18);
		tf5.setBackground(Color.white);
		tf5.setCaretColor(Color.black);
		tf5.setSelectedTextColor(Color.red);
		tf5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tf5.selectAll();
		p1.add(tf5);
		
		btn1 = new JButton();
		btn1.setText("                 Submit              ");
		btn1.setActionCommand("Submit");
		btn1.addActionListener(this);
		p2.add(btn1);
		
		p1.setOpaque(false);
		
		add(p1);
		
		p2.setOpaque(false);
		
		add(p2);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		ProductCategories procat = new ProductCategories();
		procat.setpCatId(Integer.parseInt(tf1.getText().trim()));
		procat.setpCatName(tf2.getText().trim());
		procat.setCgst(Double.parseDouble(tf3.getText().trim()));
		procat.setSgst(Double.parseDouble(tf4.getText().trim()));
		procat.setDetails(tf5.getText().trim());
		ProductCategoriesDao procatdao = new ProductCategoriesDao();
		procatdao.CreateCategory(procat);
		
		JOptionPane.showMessageDialog(this, "Successfully Submitted", "Success", JOptionPane.INFORMATION_MESSAGE);

		
	}
	
	public static void main(String args[]) {
		
		JFrame f = new JFrame("Create Pro Category");
		f.setContentPane(new CreateProCat());
		f.setBounds(500, 500, 500, 250);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
