package com.avinash.swing.ProductsRelated;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.avinash.jdbc.daos.ProductsDao;
import com.avinash.jdbc.pojos.Products;


public class UpdateProduct extends JPanel implements ActionListener {
	
	JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7;
	JFormattedTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	JButton btn1;
	JPanel p2, p3;
	private static int id;
	
	public UpdateProduct() {
		setBackground(new Color(120,1,8));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JPanel p1 = new JPanel(new GridLayout(1, 2));
		p2 = new JPanel(new GridLayout(5, 2));
		
		lb1 = new JLabel();
		lb1.setText("Product Id");
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		id = Integer.parseInt(tf1.getText().trim());
		
		 ProductsDao productdao  = new ProductsDao();
		 Products product = productdao.findByProductId(id);
		 if(product.getpName() == null) {
				JOptionPane.showMessageDialog(this, "No such products found", "Error", JOptionPane.INFORMATION_MESSAGE);

		 }
		 else {
			 ButtonEventListener btnlistener = new ButtonEventListener();
				
				lb2 = new JLabel();
				lb2.setText("Category Id");
				lb2.setFont(new Font("Serif", Font.BOLD, 15));
				lb2.setForeground(Color.white);;
				p2.add(lb2);
				
				tf2 = new JFormattedTextField(new String());
				tf2.setText(""+product.getpCatId());
				tf2.setColumns(18);
				tf2.setBackground(Color.white);
				tf2.setCaretColor(Color.black);
				tf2.setSelectedTextColor(Color.red);
				tf2.setFont(new Font("Times New Roman", Font.BOLD, 12));
				tf2.selectAll();
				p2.add(tf2);
				
				lb3 = new JLabel();
				lb3.setText("Name");
				lb3.setFont(new Font("Serif", Font.BOLD, 15));
				lb3.setForeground(Color.white);;
				p2.add(lb3);
				
				tf3 = new JFormattedTextField(new String());
				tf3.setText(product.getpName());
				tf3.setColumns(18);
				tf3.setBackground(Color.white);
				tf3.setCaretColor(Color.black);
				tf3.setSelectedTextColor(Color.red);
				tf3.setFont(new Font("Times New Roman", Font.BOLD, 12));
				tf3.selectAll();
				p2.add(tf3);
				
				lb4 = new JLabel();
				lb4.setText("C.P");
				lb4.setFont(new Font("Serif", Font.BOLD, 15));
				lb4.setForeground(Color.white);;
				p2.add(lb4);
				
				tf4 = new JFormattedTextField(new String());
				tf4.setText(""+product.getCp());
				tf4.setColumns(18);
				tf4.setBackground(Color.white);
				tf4.setCaretColor(Color.black);
				tf4.setSelectedTextColor(Color.red);
				tf4.setFont(new Font("Times New Roman", Font.BOLD, 12));
				tf4.selectAll();
				p2.add(tf4);
				
				lb5 = new JLabel();
				lb5.setText("S.P");
				lb5.setFont(new Font("Serif", Font.BOLD, 15));
				lb5.setForeground(Color.white);;
				p2.add(lb5);
				
				tf5 = new JFormattedTextField(new String());
				tf5.setText(""+product.getSp());
				tf5.setColumns(18);
				tf5.setBackground(Color.white);
				tf5.setCaretColor(Color.black);
				tf5.setSelectedTextColor(Color.red);
				tf5.setFont(new Font("Times New Roman", Font.BOLD, 12));
				tf5.selectAll();
				p2.add(tf5);
				
				lb6 = new JLabel();
				lb6.setText("Unit");
				lb6.setFont(new Font("Serif", Font.BOLD, 15));
				lb6.setForeground(Color.white);;
				p2.add(lb6);
				
				tf6 = new JFormattedTextField(new String());
				tf6.setText(""+product.getUnit());
				tf6.setColumns(18);
				tf6.setBackground(Color.white);
				tf6.setCaretColor(Color.black);
				tf6.setSelectedTextColor(Color.red);
				tf6.setFont(new Font("Times New Roman", Font.BOLD, 12));
				tf6.selectAll();
				p2.add(tf6);
				
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
			
			Products pro = new Products();
			pro.setpId(Integer.parseInt(tf1.getText().trim()));
			pro.setpCatId(Integer.parseInt(tf2.getText().trim()));
			pro.setpName(tf3.getText().trim());
			pro.setCp((Double.parseDouble(tf4.getText().trim()))/(Integer.parseInt(tf6.getText().trim())));
			pro.setSp(Double.parseDouble(tf5.getText().trim())/(Integer.parseInt(tf6.getText().trim())));
			pro.setUnit(1);
			ProductsDao prodao = new ProductsDao();
			prodao.updateProductsCost(pro, id);
			
			JOptionPane.showMessageDialog(btn1, "Successfully Updated", "Success", JOptionPane.INFORMATION_MESSAGE);

	
	
		}
		 
	 }
	
public static void main(String args[]) {
		
		JFrame f = new JFrame("Update Product");
		f.setContentPane(new UpdateProduct());
		f.setBounds(500, 500, 500, 250);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


