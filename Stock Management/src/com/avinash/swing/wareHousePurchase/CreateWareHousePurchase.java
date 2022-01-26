package com.avinash.swing.wareHousePurchase;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.BevelBorder;


import com.avinash.jdbc.daos.*;
import com.avinash.jdbc.pojos.*;
import com.avinash.jdbc.pojos.WareHousePurchaseList;
import com.avinash.jdbc.utlities.DateUtils;


public class CreateWareHousePurchase extends JPanel implements ActionListener{
	
	JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11,  lb12;
	JFormattedTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tfo;
	JPasswordField pswf;
	JButton btn1, btn2, btn3, btn4, btn5, btn6;
	JPanel p1, p2, p3, p4,p5, p6;
	JTable table;
	private static int count = 0;
	
	public CreateWareHousePurchase() {
		setBackground(Color.white);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		p1 = new JPanel(new FlowLayout());
		p2 = new JPanel(new FlowLayout());
		p3 = new JPanel(new FlowLayout());
		p4 = new JPanel(new GridLayout(2, 4));
		p5 = new JPanel(new FlowLayout());
		p6 = new JPanel(new FlowLayout());
		
		lb1 = new JLabel();
		lb1.setText("User Id               ");
		lb1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		p1.add(lb1);
		
		tfo = new JFormattedTextField();
		tfo.setColumns(10);
		tfo.setBackground(Color.white);
		tfo.setCaretColor(Color.black);
		tfo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tfo.setEditable(false);
		
		tf1  = new JFormattedTextField(new String());
		tf1.setColumns(10);
		tf1.setBackground(Color.white);
		tf1.setCaretColor(Color.black);
		tf1.setSelectedTextColor(Color.red);
		tf1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tf1.selectAll();
		p1.add(tf1);
		
		lb2 = new JLabel();
		lb2.setText("            Password                    ");
		lb2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		p1.add(lb2);
		
		pswf  = new JPasswordField(new String());
		pswf.setColumns(10);
		pswf.setBackground(Color.white);
		pswf.setCaretColor(Color.black);
		pswf.setFont(new Font("Times New Roman", Font.BOLD, 12));
		p1.add(pswf);
		
		btn1 = new JButton();
		btn1.setText("                     Login                 ");
		btn1.setActionCommand("Login");
		btn1.addActionListener(this);
		p1.add(btn1);
		
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		PurchaseTableModel med = new PurchaseTableModel(Integer.parseInt("0"));
		table = new JTable(med);
		table.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		UsersDao userdao = new UsersDao();
		Users user = userdao.findByUserIdAndPassword(Integer.parseInt(tf1.getText().trim()), pswf.getText().trim());
		if(user.getUserName() == null) {
			JOptionPane.showMessageDialog(this, "no user found", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			ButtonEventListener btnlistener = new ButtonEventListener();
			
			tf1.setEditable(false);
			pswf.setEditable(false);
			btn1.setEnabled(false);
			
			lb3 = new JLabel();
			lb3.setText(user.getUserName().trim());
			lb3.setFont(new Font("Times New Roman", Font.BOLD, 12));
			p1.add(lb3);
			
			lb4 = new JLabel();
			lb4.setText("                 Date                ");
			lb4.setFont(new Font("Times New Roman", Font.BOLD, 12));
			p2.add(lb4);
			
			tf2 = new JFormattedTextField(new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()));
			tf2.setColumns(10);
			tf2.setBackground(Color.white);
			tf2.setCaretColor(Color.black);
			tf2.setFont(new Font("Times New Roman", Font.BOLD, 12));
			p2.add(tf2);
			
			btn2 = new JButton();
			btn2.setText("            Proceed             ");
			btn2.setActionCommand("Proceed");
			btn2.addActionListener(btnlistener);
			p2.add(btn2);
			
			p1.invalidate();
			p1.updateUI();
			p2.invalidate();
			p2.updateUI();
			
		
		}
		
	}
	
	 class ButtonEventListener implements ActionListener {

			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				ButtonEventListener2 btnlistener2 = new ButtonEventListener2();
				ButtonEventListener3 btnlistener3 = new ButtonEventListener3();
				ButtonEventListener4 btnlistener4 = new ButtonEventListener4();
				ButtonEventListener5 btnlistener5 = new ButtonEventListener5();
				
				WareHousePurchase whp = new WareHousePurchase();
				String date1 = tf2.getText();
				whp.setDop(DateUtils.convertDate(date1));
				whp.setUserId(Integer.parseInt(tf1.getText().trim()));
				WareHousePurchaseDao whpd =  new WareHousePurchaseDao();
				whpd.CreatePurchase(whp);
				add(new JScrollPane(table), BorderLayout.CENTER);
				add(p6, BorderLayout.SOUTH);
				 
				 tf2.setEditable(false);
				 btn2.setEnabled(false);
				 
				 lb5 = new JLabel();
				 lb5.setText("P Id                 ");
				 lb5.setFont(new Font("Times New Roman", Font.BOLD, 12));
				 p3.add(lb5);
				 
				 tf3 = new JFormattedTextField();
				 tf3.setColumns(10);
				 tf3.setBackground(Color.white);
				 tf3.setCaretColor(Color.black);
				 tf3.setFont(new Font("Times New Roman", Font.BOLD, 12));
				 p3.add(tf3);
				 
				 lb6 = new JLabel();
				 lb6.setText("      Quantity              ");
				 lb6.setFont(new Font("Times New Roman", Font.BOLD, 12));
				 p3.add(lb6);
				 
				 tf4 = new JFormattedTextField();
				 tf4.setColumns(10);
				 tf4.setBackground(Color.white);
				 tf4.setCaretColor(Color.black);
				 tf4.setFont(new Font("Times New Roman", Font.BOLD, 12));
				 p3.add(tf4);
				 
				 lb7 = new JLabel();
				 lb7.setText("          Exp Date              ");
				 lb7.setFont(new Font("Times New Roman", Font.BOLD, 12));
				 p3.add(lb7);
				 
				 tf5 = new JFormattedTextField(new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()));
				 tf5.setColumns(10);
				 tf5.setBackground(Color.white);
				 tf5.setCaretColor(Color.black);
				 tf5.setFont(new Font("Times New Roman", Font.BOLD, 12));
				 p3.add(tf5);
				 
				 btn3 = new JButton();
				 btn3.setText("          Add          ");
				 btn3.setActionCommand("Add");
				 btn3.addActionListener(btnlistener2);
				 p3.add(btn3);
				 
				 lb8 = new JLabel();
				 lb8.setText("Cat Id");
				 lb8.setFont(new Font("Times New Roman", Font.BOLD, 12));
				 p4.add(lb8);
				 
				 tf6 = new JFormattedTextField();
				 tf6.setColumns(15);
				 tf6.setBackground(Color.white);
				 tf6.setCaretColor(Color.black);
				 tf6.setFont(new Font("Times New Roman", Font.BOLD, 12));
				 p4.add(tf6);
				 
				 lb9 = new JLabel();
				 lb9.setText("Name");
				 lb9.setFont(new Font("Times New Roman", Font.BOLD, 12));
				 p4.add(lb9);
				 
				 tf7 = new JFormattedTextField();
				 tf7.setColumns(15);
				 tf7.setBackground(Color.white);
				 tf7.setCaretColor(Color.black);
				 tf7.setFont(new Font("Times New Roman", Font.BOLD, 12));
				 p4.add(tf7);
				 
				 lb10 = new JLabel();
				 lb10.setText("C.P");
				 lb10.setFont(new Font("Times New Roman", Font.BOLD, 12));
				 p4.add(lb10);
				 
				 tf8 = new JFormattedTextField();
				 tf8.setColumns(15);
				 tf8.setBackground(Color.white);
				 tf8.setCaretColor(Color.black);
				 tf8.setFont(new Font("Times New Roman", Font.BOLD, 12));
				 p4.add(tf8);
				 
				 lb11 = new JLabel();
				 lb11.setText("S.P");
				 lb11.setFont(new Font("Times New Roman", Font.BOLD, 12));
				 p4.add(lb11);
				 
				 tf9 = new JFormattedTextField();
				 tf9.setColumns(15);
				 tf9.setBackground(Color.white);
				 tf9.setCaretColor(Color.black);
				 tf9.setFont(new Font("Times New Roman", Font.BOLD, 12));
				 p4.add(tf9);
				 
				 lb12 = new JLabel();
				 lb12.setText("Unit");
				 lb12.setFont(new Font("Times New Roman", Font.BOLD, 12));
				 p5.add(lb12);
				 
				 tf10 = new JFormattedTextField();
				 tf10.setColumns(15);
				 tf10.setBackground(Color.white);
				 tf10.setCaretColor(Color.black);
				 tf10.setFont(new Font("Times New Roman", Font.BOLD, 12));
				 p5.add(tf10);
				 
				 btn4 = new JButton();
				 btn4.setText("                                 Add                        ");
				 btn4.setActionCommand("Add");
				 btn4.setEnabled(false);
				 btn4.addActionListener(btnlistener3);
				 p5.add(btn4);
				 
				 btn5 = new JButton();
				 btn5.setText("                                   Update                               ");
				 btn5.setActionCommand("Update");
				 btn5.addActionListener(btnlistener4);
				 p5.add(btn5);
				 
				 btn6 = new JButton();
				 btn6.setText("                                                                                                     Finalize                                                                                                   ");
				 btn6.setActionCommand("Finalize");
				 btn6.addActionListener(btnlistener5);
				 p6.add(btn6, BorderLayout.WEST);
				 
				 p3.invalidate();
				 p3.updateUI();
				 p4.invalidate();
				 p4.updateUI();
				 p5.invalidate();
				 p5.updateUI();
				 p6.invalidate();
				 p6.updateUI();
			
			}
			 
		 }
	 
	 class ButtonEventListener2 implements ActionListener {

			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				ProductsDao productdao  = new ProductsDao();
				Products product = productdao.findByProductId(Integer.parseInt(tf3.getText().trim()));
				 if(product.getpName() != null) {
					 tf6.setText(""+product.getpCatId());
					 tf7.setText(product.getpName());
					 tf8.setText(""+product.getCp());
					 tf9.setText(""+product.getSp());
					 tf10.setText(""+product.getUnit());
					 
					 WareHousePurchaseDetails whpd = new WareHousePurchaseDetails();
						whpd.setpId(Integer.parseInt(tf3.getText().trim()));
						whpd.setQuantityPurchased(Integer.parseInt(tf4.getText().trim()));
						WareHousePurchaseDao whpd1 =  new WareHousePurchaseDao();
						WareHousePurchase l  = whpd1.findLastPurchaseId();
						tfo.setText(String.valueOf(l.getWareHousePurId()));
						whpd.setWhpId(l.getWareHousePurId()+1);
						String date = tf5.getText();
						whpd.setExpDate(DateUtils.convertDate(date));
						WareHousePurchaseDetailsDao whpdd =  new WareHousePurchaseDetailsDao();
						whpdd.createPurchaseDetails(whpd);
						
				 
				 }
				
				 else{
					 JOptionPane.showMessageDialog(btn3, "No products available please Add", "Problem", JOptionPane.INFORMATION_MESSAGE);
					 btn5.setEnabled(false);
					 btn4.setEnabled(true);
				 }
		
			}
			 
		 }
	 
	 class ButtonEventListener3 implements ActionListener {

			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
			
				Products pro = new Products();
				pro.setpId(Integer.parseInt(tf3.getText().trim()));
				pro.setpCatId(Integer.parseInt(tf6.getText().trim()));
				pro.setpName(tf7.getText().trim());
				pro.setCp((Double.parseDouble(tf8.getText().trim()))/(Integer.parseInt(tf10.getText().trim())));
				pro.setSp((Double.parseDouble(tf9.getText().trim()))/(Integer.parseInt(tf10.getText().trim())));
				pro.setUnit(1);
				ProductsDao prodao = new ProductsDao();
				prodao.createProducts(pro);
				
				WareHouseStocks whs = new WareHouseStocks();
				whs.setpId(Integer.parseInt(tf3.getText().trim()));
				whs.setTotalAmouont(Integer.parseInt("0"));
				WareHouseStocksDao whsd = new WareHouseStocksDao();
				whsd.createWareHouseStocks(whs);
				count += 1;
				
				JOptionPane.showMessageDialog(btn4, "Now Update the product", "Success", JOptionPane.INFORMATION_MESSAGE);
				btn4.setEnabled(false);
				btn5.setEnabled(true);
				
				
				tf6.setText("");
				tf7.setText("");
				tf8.setText("");
				tf9.setText("");
				tf10.setText("");
				
			}
			 
		 }
	 
	 class ButtonEventListener4 implements ActionListener {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Products pro = new Products();
				pro.setpCatId(Integer.parseInt(tf6.getText().trim()));
				pro.setpName(tf7.getText().trim());
				pro.setCp((Double.parseDouble(tf8.getText().trim()))/(Integer.parseInt(tf10.getText().trim())));
				pro.setSp((Double.parseDouble(tf9.getText().trim()))/(Integer.parseInt(tf10.getText().trim())));
				pro.setUnit(1);
				pro.setpId(Integer.parseInt(tf3.getText().trim()));
				ProductsDao prodao = new ProductsDao();
				prodao.updateProducts(pro);
				
				WareHouseStocks whs = new WareHouseStocks();
				whs.setpId(Integer.parseInt(tf3.getText().trim()));
				whs.setTotalAmouont(Integer.parseInt(tf4.getText().trim()));
				WareHouseStocksDao whsd = new WareHouseStocksDao();
				whsd.addWareHouseStocks(whs);
				count += 1;
				
				PurchaseTableModel mt = new PurchaseTableModel(Integer.parseInt(tfo.getText().trim()));
			    table.setModel(mt);
			
				tf3.setText("");
				tf4.setText("");
				tf6.setText("");
				tf7.setText("");
				tf8.setText("");
				tf9.setText("");
				tf10.setText("");
				
			}
			 
		 }
	 
	 class ButtonEventListener5 implements ActionListener {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				UsersDao udao = new UsersDao();
				Users user7 = udao.findByUserId(Integer.parseInt(tf1.getText().trim()));
				int final1 = user7.getTotalSale()+count;
				udao.updateSales(final1, Integer.parseInt(tf1.getText().trim()));
				JOptionPane.showMessageDialog(btn5, "You Have Succesfully Added All The Products", "Success", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			
			}
			 
		 }
	
	public static void main(String args[]) {
		JFrame f = new JFrame("Create Ware House Purchase");
		f.setContentPane(new CreateWareHousePurchase());
		f.setBounds(1000, 1000, 1100, 730);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
