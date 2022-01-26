package com.avinash.wareHouseSupply;
import com.avinash.jdbc.daos.*;
import com.avinash.jdbc.pojos.*;
import com.avinash.jdbc.utlities.DateUtils;
import com.avinash.sendEamil.SendEmail;
import com.avinash.swing.users.CreateUser;
import com.avinash.swing.wareHousePurchase.PurchaseTableModel;

import java.util.ArrayList;
import java.util.Optional;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class CreateWareHouseSupply extends JPanel implements ActionListener{
	
	JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9;
	JPasswordField pswf;
	JFormattedTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;
	JPanel p1, p2, p3, p4,p5, p6;
	JTable table;
	private static int count = 0;
	private static int whsId = 0;
	
	
	public CreateWareHouseSupply() {
		setBackground(new Color(120,1,8));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		p1 = new JPanel(new FlowLayout());
		p2 = new JPanel(new FlowLayout());
		p3 = new JPanel(new FlowLayout());
		p4 = new JPanel(new FlowLayout());
		p5 = new JPanel(new FlowLayout());
		
		lb1 = new JLabel();
		lb1.setText("User Id");
		lb1.setFont(new Font("Serif", Font.BOLD, 15));
		lb1.setForeground(Color.white);;
		p1.add(lb1);
		
		tf1 = new JFormattedTextField(new Integer(00));
		tf1.setText("");
		tf1.setColumns(18);
		tf1.setBackground(Color.white);
		tf1.setCaretColor(Color.black);
		tf1.setSelectedTextColor(Color.red);
		tf1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tf1.selectAll();
		p1.add(tf1);
		
		lb2 = new JLabel();
		lb2.setText("            Password");
		lb2.setFont(new Font("Serif", Font.BOLD, 15));
		lb2.setForeground(Color.white);;
		p1.add(lb2);
		
		pswf  = new JPasswordField(new String());
		pswf.setColumns(18);
		pswf.setBackground(Color.white);
		pswf.setCaretColor(Color.black);
		pswf.setFont(new Font("Times New Roman", Font.BOLD, 12));
		p1.add(pswf);
		
		btn1 = new JButton();
		btn1.setText("                     Login                 ");
		btn1.setActionCommand("Login");
		btn1.addActionListener(this);

		p1.add(btn1);
		p1.setOpaque(false);
		
		add(p1);
		
		WareHouseSupplyTableModel med = new WareHouseSupplyTableModel(Integer.parseInt("100000"));
		table = new JTable(med);
		table.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UsersDao userdao = new UsersDao();
		Users user = userdao.findByUserIdAndPassword(Integer.parseInt(tf1.getText().trim()), pswf.getText().trim());
		if(user.getUserName() == null) {
			JOptionPane.showMessageDialog(this, "no user found", "Error", JOptionPane.INFORMATION_MESSAGE);
			
		}
		else {
			ButtonEventListener btnlistener = new ButtonEventListener();
			btn1.setEnabled(false);
			
			lb3 = new JLabel();
			lb3.setText(user.getUserName());
			lb3.setFont(new Font("Serif", Font.BOLD, 15));
			lb3.setForeground(Color.white);;
			p1.add(lb3);
			
			lb4 = new JLabel();
			lb4.setText("Store Id");
			lb4.setFont(new Font("Serif", Font.BOLD, 15));
			lb4.setForeground(Color.white);;
			p2.add(lb4);
			
			tf2 = new JFormattedTextField(new Integer(00));
			tf2.setColumns(18);
			tf2.setText("");
			tf2.setBackground(Color.white);
			tf2.setCaretColor(Color.black);
			tf2.setSelectedTextColor(Color.red);
			tf2.setFont(new Font("Times New Roman", Font.BOLD, 12));
			tf2.selectAll();
			p2.add(tf2);
			
			lb7 = new JLabel();
			lb7.setText("Date");
			lb7.setFont(new Font("Serif", Font.BOLD, 15));
			lb7.setForeground(Color.white);
			p2.add(lb7);
			
			tf4 = new JFormattedTextField(new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()));
			tf4.setColumns(18);
			tf4.setBackground(Color.white);
			tf4.setCaretColor(Color.black);
			tf4.setSelectedTextColor(Color.red);
			tf4.setFont(new Font("Times New Roman", Font.BOLD, 12));
			tf4.selectAll();
			p2.add(tf4);
			
			btn2 = new JButton();
			btn2.setText("                     Start                 ");
			btn2.setActionCommand("Start");
			btn2.addActionListener(btnlistener);
			p2.add(btn2);
			
			p2.setOpaque(false);
			
			add(p2);
			
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
				
				if(tf2.getText().equals("")|| tf4.getText().equals("")) {
					JOptionPane.showMessageDialog(btn2, "Please fill all the textFileds", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					StoresDao storedao  = new StoresDao();
					Stores store = StoresDao.findByStoreId(Integer.parseInt(tf2.getText().trim()));
					if(store.getLocation() == null) {
						JOptionPane.showMessageDialog(btn2, "Please enter a valid store id", "Error", JOptionPane.INFORMATION_MESSAGE);
						tf2.setText("");
					}
					else {
						
						WareHouseSupplyDao whsd = new WareHouseSupplyDao();
						whsId = whsd.findLastSupplyId().getWhsId();
						
						add(new JScrollPane(table), BorderLayout.CENTER);
						

		     			lb6 = new JLabel();
						lb6.setText(store.getLocation().trim());
						lb6.setFont(new Font("Serif", Font.BOLD, 18));
						lb6.setForeground(Color.white);
						p2.add(lb6);
							
						p2.invalidate();
						p2.updateUI();
							
						ButtonEventListener1 btnlistener1 = new ButtonEventListener1();
						ButtonEventListener2 btnlistener2 = new ButtonEventListener2();
						ButtonEventListener3 btnlistener3 = new ButtonEventListener3();
						
						btn2.setEnabled(false);
						tf2.setEditable(false);
						
						lb5 = new JLabel();
						lb5.setText("           Product Id");
						lb5.setFont(new Font("Serif", Font.BOLD, 15));
						lb5.setForeground(Color.white);
						p3.add(lb5);
						
						tf3 = new JFormattedTextField(new String());
						tf3.setColumns(18);
						tf3.setText("");
						tf3.setBackground(Color.white);
						tf3.setCaretColor(Color.black);
						tf3.setSelectedTextColor(Color.red);
						tf3.setFont(new Font("Times New Roman", Font.BOLD, 12));
						tf3.selectAll();
						p3.add(tf3);
						
						lb8 = new JLabel();
						lb8.setText("               Quantity");
						lb8.setFont(new Font("Serif", Font.BOLD, 15));
						lb8.setForeground(Color.white);
						p3.add(lb8);
						
						tf5 = new JFormattedTextField(new String());
						tf5.setText("");
						tf5.setColumns(18);
						tf5.setBackground(Color.white);
						tf5.setCaretColor(Color.black);
						tf5.setSelectedTextColor(Color.red);
						tf5.setFont(new Font("Times New Roman", Font.BOLD, 12));
						tf5.selectAll();
						p3.add(tf5);
						
						btn3 = new JButton();
						btn3.setText("                     Send                 ");
						btn3.setActionCommand("Send");
						btn3.addActionListener(btnlistener1);
						p3.add(btn3);
						
						lb9 = new JLabel();
						lb9.setText("Delete    ");
						lb9.setFont(new Font("Serif", Font.BOLD, 15));
						lb9.setForeground(Color.white);
						p4.add(lb9);
						
						tf6 = new JFormattedTextField(new String());
						tf6.setText("");
						tf6.setColumns(18);
						tf6.setBackground(Color.white);
						tf6.setCaretColor(Color.black);
						tf6.setSelectedTextColor(Color.red);
						tf6.setFont(new Font("Times New Roman", Font.BOLD, 12));
						tf6.selectAll();
						p4.add(tf6);
						
						btn4 = new JButton();
						btn4.setText("                      Delete                  ");
						btn4.setActionCommand("Delete");
						btn4.addActionListener(btnlistener2);
						p4.add(btn4);
						
						btn5 = new JButton();
						btn5.setText("                                                                                                  Finalize                                                                                              ");
						btn5.setActionCommand("Finalize");
						btn5.addActionListener(btnlistener3);
						p5.add(btn5);
						
						add(p3);
						add(p4);
						add(p5);
						
						p3.setOpaque(false);
						p3.invalidate();
						p3.updateUI();
						
						p4.setOpaque(false);
						p4.invalidate();
						p4.updateUI();
						
						p5.setOpaque(false);
						p5.invalidate();
						p5.updateUI();
						
					}
				}
			} 
		 }
	 
	 class ButtonEventListener1 implements ActionListener {

			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 WareHouseStocksDao whsd1  = new WareHouseStocksDao();
				 WareHouseStocks whs1 = whsd1.findBypId(Integer.parseInt(tf3.getText().trim()));
				 Integer l = new Integer(whs1.getpId());
				 if (Optional.ofNullable(l).orElse(0).intValue() != 0) {
					 WareHouseSupply whs = new WareHouseSupply();
						whs.setpId(Integer.parseInt(tf3.getText().trim()));
						whs.setStoreId(Integer.parseInt(tf2.getText().trim()));
						whs.setQuantity(Integer.parseInt(tf5.getText().trim()));
						String date1 = tf4.getText();
						whs.setDos(DateUtils.convertDate(date1));
						whs.setUserId(Integer.parseInt(tf1.getText().trim()));
						WareHouseSupplyDao whsd = new WareHouseSupplyDao();
						whsd.createWareHouseSupply(whs);
						
						count += 1;
						
						if((whs1.getTotalAmouont() - (Integer.parseInt(tf5.getText().trim()))) < 50) {
							
							SendEmail email = new SendEmail();
							String str = "Please Purchase pId = "+ whs1.getpId()+"\n We have only ="+ (whs1.getTotalAmouont()- Integer.parseInt(tf5.getText().trim()))+"\n left with us";
							email.pro();
							email.sendMessage(System.getProperties(), "doremondisney9@gmail.com", "ninjahatodhi", str);
							
						}
						
						WareHouseSupplyTableModel mt = new WareHouseSupplyTableModel(whsId);
					    table.setModel(mt);
					
				 }
				 else {
					 
						JOptionPane.showMessageDialog(btn2, "Please check the productiD  entered", "Error", JOptionPane.INFORMATION_MESSAGE);
						return;

					 
				 }
				 
				StoreStockDetailsDao ssdd  = new StoreStockDetailsDao();
				StoreStockDetails ssd = ssdd.findByProIdAndStoreId(Integer.parseInt(tf3.getText().trim()), Integer.parseInt(tf2.getText().trim()));
				Integer i = new Integer(ssd.getpId());
				if (Optional.ofNullable(i).orElse(0).intValue() != 0) {
					
					WareHouseStocks whs = new WareHouseStocks();
					whs.setpId(Integer.parseInt(tf3.getText().trim()));
					whs.setTotalAmouont(Integer.parseInt(tf5.getText().trim()));
					WareHouseStocksDao whsd = new WareHouseStocksDao();
					whsd.sendWareHouseStocks(whs);
					
					StoreStockDetails ssd2 = new StoreStockDetails();
					ssd2.setStoreId(Integer.parseInt(tf2.getText().trim()));
					ssd2.setpId(Integer.parseInt(tf3.getText().trim()));
					ssd2.setQuantity(Integer.parseInt(tf5.getText().trim()));
					StoreStockDetailsDao ssdd2 = new StoreStockDetailsDao();
					ssdd.addStoreStocks(ssd2);

				}
				else {
					
					WareHouseStocks whs = new WareHouseStocks();
					whs.setpId(Integer.parseInt(tf3.getText().trim()));
					whs.setTotalAmouont(Integer.parseInt(tf5.getText().trim()));
					WareHouseStocksDao whsd = new WareHouseStocksDao();
					whsd.sendWareHouseStocks(whs);
					
					StoreStockDetails ssd1 = new StoreStockDetails();
					ssd.setStoreId(Integer.parseInt(tf2.getText().trim()));
					ssd.setpId(Integer.parseInt(tf3.getText().trim()));
					ssd.setQuantity(Integer.parseInt(tf5.getText().trim()));
					StoreStockDetailsDao ssdd1 = new StoreStockDetailsDao();
					ssdd.createStoreStock(ssd);

				}
				
				
			    
			    tf3.setText("");
			    tf5.setText("");
				
			}
			 
		 }
	 
	 class ButtonEventListener2 implements ActionListener {

			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				WareHouseSupplyDao whsd = new WareHouseSupplyDao();
				WareHouseSupply whs = whsd.findProductBySupplyId(Integer.parseInt(tf6.getText().trim()));
				
				WareHouseStocks whs1 = new WareHouseStocks();
				whs1.setpId(whs.getpId());
				whs1.setTotalAmouont(whs.getQuantity());
				WareHouseStocksDao whsd1 = new WareHouseStocksDao();
				whsd1.addWareHouseStocks(whs1);
				
				StoreStockDetails ssd = new StoreStockDetails();
				ssd.setStoreId(Integer.parseInt(tf2.getText().trim()));
				ssd.setpId(whs.getpId());
				ssd.setQuantity(whs.getQuantity());
				StoreStockDetailsDao ssdd = new StoreStockDetailsDao();
				ssdd.sellStoreStocks(ssd);
				
				whsd.removeWareHouseSupply(Integer.parseInt(tf6.getText().trim()));
				
				WareHouseSupplyTableModel mt = new WareHouseSupplyTableModel(whsId);
			    table.setModel(mt);
			    
			    count -= 1;
			    
			    tf6.setText("");
				
			}
			 
		 }
	 
	 class ButtonEventListener3 implements ActionListener {

			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				UsersDao udao = new UsersDao();
				Users user7 = udao.findByUserId(Integer.parseInt(tf1.getText().trim()));
				int final1 = user7.getTotalSale()+count;
				udao.updateSales(final1, Integer.parseInt(tf1.getText().trim()));
				JOptionPane.showMessageDialog(btn5, "You Have Succesfully Sent All The Products", "Success", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			
			}
			 
		 }
	public static void main(String args[]) {
		JFrame f = new JFrame("Create Ware House Supply");
		f.setContentPane(new CreateWareHouseSupply());
		f.setBounds(1000, 1000, 1100, 730);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
