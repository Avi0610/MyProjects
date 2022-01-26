package com.avinash.swing.StoreSale;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.avinash.jdbc.daos.*;
import com.avinash.jdbc.pojos.*;
import com.avinash.swing.customers.*;
import com.avinash.wareHouseSupply.CreateWareHouseSupply;
import com.avinash.wareHouseSupply.WareHouseSupplyTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.avinash.jdbc.utlities.DateUtils;
import com.avinash.sendEamil.SendEmail;

import javax.swing.border.BevelBorder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Optional;
import java.io.*;
import de.vogella.itext.write.*;

public class CreateStoreSale extends JPanel implements ActionListener{
	
	JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11;
	JFormattedTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8;
	JPasswordField pswf;
	JButton btn1, btn2, btn3, btn4, btn5, btn6;
	JPanel p1, p2, p3, p4,p5, p6;
	JTable table;
	private static int count = 0;
	private static int storeSalesId = 0;
	private double reward = 00.00;
	private int custId = 00;
	
	 static JFrame f = new JFrame("Create Store Sales");
	
	public CreateStoreSale() {
		
		setBackground(new Color(120,1,8));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		p1 = new JPanel(new FlowLayout());
		p2 = new JPanel(new FlowLayout());
		p3 = new JPanel(new FlowLayout());
		p4 = new JPanel(new FlowLayout());
		p5 = new JPanel(new FlowLayout());
		p6 = new JPanel(new FlowLayout());
		
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

		StoreSalesTableModel med = new StoreSalesTableModel(Integer.parseInt("100000"));
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
			lb4.setText("                                     Store Id        ");
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
			tf2.addActionListener(btnlistener);
			p2.add(tf2);
			
			p2.setOpaque(false);
			add(p2);
			p2.invalidate();
			p2.updateUI();
			
		}
		
	}
	
	 class ButtonEventListener implements ActionListener {

			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ButtonEventListener2 btnlistener2 = new ButtonEventListener2();
				
				StoresDao storedao  = new StoresDao();
				Stores store = StoresDao.findByStoreId(Integer.parseInt(tf2.getText().trim()));
				
				if(store.getLocation() == null) {
					JOptionPane.showMessageDialog(btn1, "Please enter a valid store id", "Error", JOptionPane.INFORMATION_MESSAGE);

				}
				
				else {
					
					tf2.setEditable(false);
					
					lb5 = new JLabel();
					lb5.setText("       "+store.getLocation()+ "                                           ");
					lb5.setFont(new Font("Serif", Font.BOLD, 15));
					lb5.setForeground(Color.white);;
					p2.add(lb5);
					
					lb4 = new JLabel();
					lb4.setText(" Mobile no  ");
					lb4.setFont(new Font("Serif", Font.BOLD, 15));
					lb4.setForeground(Color.white);
					p3.add(lb4);
					
					tf3 = new JFormattedTextField(new String());
					tf3.setColumns(18);
					tf3.setText("");
					tf3.setBackground(Color.white);
					tf3.setCaretColor(Color.black);
					tf3.setSelectedTextColor(Color.red);
					tf3.setFont(new Font("Times New Roman", Font.BOLD, 12));
					p3.add(tf3);
					
					
					lb7 = new JLabel();
					lb7.setText("      Date");
					lb7.setFont(new Font("Serif", Font.BOLD, 15));
					lb7.setForeground(Color.white);;
					p3.add(lb7);
					
					tf4 = new JFormattedTextField(new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()));
					tf4.setColumns(18);
					tf4.setBackground(Color.white);
					tf4.setCaretColor(Color.black);
					tf4.setSelectedTextColor(Color.red);
					tf4.setFont(new Font("Times New Roman", Font.BOLD, 12));
					tf4.selectAll();
					p3.add(tf4);
					
					btn2 = new JButton();
					btn2.setText(" Proceed ");
					btn2.setActionCommand("Proceed");
					btn2.addActionListener(btnlistener2);
					p3.add(btn2);
					
					p3.setOpaque(false);
					add(p3);
					
					p2.invalidate();
					p2.updateUI();
					
					p3.invalidate();
					p3.updateUI();
					
				}
				 
		 }
	 }	
	 
	 class ButtonEventListener2 implements ActionListener {

			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(tf3.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(btn2, "Please enter the mobile first", "Error", JOptionPane.INFORMATION_MESSAGE);
					
				}
				
				else {
					ButtonEventListener3 btnlistener3 = new ButtonEventListener3();
					ButtonEventListener4 btnlistener4 = new ButtonEventListener4();
					ButtonEventListener5 btnlistener5 = new ButtonEventListener5();
					
					 CustomersDao customerdao2  = new CustomersDao();
				 	 Customers cust2 = CustomersDao.find(tf3.getText().trim());
				 	 
				 	 if(cust2.getCustName() == null) {
				 		f.setContentPane(new CreateCustomer());
						f.setBounds(180, 230, 350, 250);
						f.setVisible(true);
						f.setLocationRelativeTo(null);
						f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
						
				 	 }
				 	 else {
				 		 
				 		StoreSales ss = new StoreSales();
						ss.setCustId(cust2.getCustId());
						ss.setUserId(Integer.parseInt(tf1.getText().trim()));
						ss.setStoreId(Integer.parseInt(tf2.getText().trim()));
						String date1 = tf4.getText();
						ss.setDos(DateUtils.convertDate(date1));
						StoreSalesDao ssd = new StoreSalesDao();
						ssd.createStoreSale(ss);
						
						StoreSalesDao ssd1 = new StoreSalesDao();
						
						storeSalesId = ssd1.findLastSalesId().getStoreSalesId();
						
						reward = cust2.getRewards();
						custId = cust2.getCustId();
				 		
				 		lb6 = new JLabel();
						lb6.setText(cust2.getCustName());
						lb6.setFont(new Font("Serif", Font.BOLD, 15));
						lb6.setForeground(Color.white);;
						p3.add(lb6);
						
						lb7 = new JLabel();
						lb7.setText("    Reward = "+cust2.getRewards());
						lb7.setFont(new Font("Serif", Font.BOLD, 15));
						lb7.setForeground(Color.white);;
						p3.add(lb7);
						
						lb8 = new JLabel();
						lb8.setText("        Product Id           ");
						lb8.setFont(new Font("Serif", Font.BOLD, 15));
						lb8.setForeground(Color.white);;
						p4.add(lb8);
						
						tf5 = new JFormattedTextField(new String());
						tf5.setColumns(18);
						tf5.setBackground(Color.white);
						tf5.setCaretColor(Color.black);
						tf5.setSelectedTextColor(Color.red);
						tf5.setFont(new Font("Times New Roman", Font.BOLD, 12));
						tf5.selectAll();
						p4.add(tf5);
						
						lb9 = new JLabel();
						lb9.setText("          Quantity            ");
						lb9.setFont(new Font("Serif", Font.BOLD, 15));
						lb9.setForeground(Color.white);;
						p4.add(lb9);
						
						tf6 = new JFormattedTextField(new String());
						tf6.setColumns(18);
						tf6.setBackground(Color.white);
						tf6.setCaretColor(Color.black);
						tf6.setSelectedTextColor(Color.red);
						tf6.setFont(new Font("Times New Roman", Font.BOLD, 12));
						tf6.selectAll();
						p4.add(tf6);
						
						btn3 = new JButton();
						btn3.setText(" Proceed ");
						btn3.setActionCommand("Proceed");
						btn3.addActionListener(btnlistener3);
						p4.add(btn3);
						
					
						
						add(p4);
						p4.setOpaque(false);
						p4.invalidate();
						p4.updateUI();
						
						p3.invalidate();
						p3.updateUI();
						
						add(new JScrollPane(table), BorderLayout.CENTER);
						
						lb10 = new JLabel();
						lb10.setText("           Store Stocks Detalil Id     ");
						lb10.setFont(new Font("Serif", Font.BOLD, 15));
						lb10.setForeground(Color.white);;
						p5.add(lb10);
						
						tf7 = new JFormattedTextField(new String());
						tf7.setColumns(18);
						tf7.setBackground(Color.white);
						tf7.setCaretColor(Color.black);
						tf7.setSelectedTextColor(Color.red);
						tf7.setFont(new Font("Times New Roman", Font.BOLD, 12));
						tf7.selectAll();
						p5.add(tf7);
						
						btn4 = new JButton();
						btn4.setText("                        Delete                     ");
						btn4.setActionCommand("Delete");
						btn4.addActionListener(btnlistener4);
						p5.add(btn4);
						
						lb11 = new JLabel();
						lb11.setText("           Reedem Points    ");
						lb11.setFont(new Font("Serif", Font.BOLD, 15));
						lb11.setForeground(Color.white);;
						p5.add(lb11);
						
						tf8 = new JFormattedTextField(new String());
						tf8.setColumns(18);
						tf8.setBackground(Color.white);
						tf8.setCaretColor(Color.black);
						tf8.setSelectedTextColor(Color.red);
						tf8.setFont(new Font("Times New Roman", Font.BOLD, 12));
						tf8.setText("00");
						p5.add(tf8);
						
						btn5 = new JButton();
						btn5.setText("                                                         Create Bill                                                            ");
						btn5.setActionCommand("CreateBill");
						btn5.addActionListener(btnlistener5);
						p6.add(btn5);
						
						add(p5);
						p5.setOpaque(false);
						p5.invalidate();
						p5.updateUI();
						
						add(p6);
						p6.setOpaque(false);
						p6.invalidate();
						p6.updateUI();
						
				 		
				 	 }
					
				}
				
			}		
				
	 }	
	 
	 class ButtonEventListener3 implements ActionListener {

			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(tf5.getText().trim().equals("") || tf6.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(btn3, "Please fill the product id or quantity", "Error", JOptionPane.INFORMATION_MESSAGE);

				}
				else {
					
					StoreStockDetailsDao ssdd11  = new StoreStockDetailsDao();
					StoreStockDetails ssd11 = ssdd11.findByProIdAndStoreId(Integer.parseInt(tf5.getText().trim()), Integer.parseInt(tf2.getText().trim()));
					Integer i = ssd11.getQuantity();
					
					if (Optional.ofNullable(i).orElse(0).intValue() != 0)  {
						StoreSalesDetails ssd = new StoreSalesDetails();
						ssd.setpId(Integer.parseInt(tf5.getText().trim()));
						ssd.setQuantity(Integer.parseInt(tf6.getText().trim()));
						StoreSalesDeatailsDao ssdd = new StoreSalesDeatailsDao();
						ssdd.createStoreSaleDetail(ssd);
						
						StoreStockDetails ssd1 = new StoreStockDetails();
						ssd1.setpId(Integer.parseInt(tf5.getText().trim()));
						ssd1.setQuantity(Integer.parseInt(tf6.getText().trim()));
						ssd1.setStoreId(Integer.parseInt(tf2.getText().trim()));
						StoreStockDetailsDao ssdd1 = new StoreStockDetailsDao();
						ssdd1.sellStoreStocks(ssd1);
						
						if((ssd11.getQuantity() - Integer.parseInt(tf6.getText().trim())) <= 10) {
							SendEmail email = new SendEmail();
							String str = "Please Send product Id = "+ ssd11.getpId()+"\n to strore id ="+ssd11.getStoreId()+"\n We have only ="+ (ssd11.getQuantity()- Integer.parseInt(tf6.getText().trim()))+"\n left with us";
							email.pro();
							email.sendMessage(System.getProperties(), "doremondisney9@gmail.com", "ninjahatodhi", str);
							
						}	
					}
					else {
						
						JOptionPane.showMessageDialog(btn3, "Please enter a valid pro Id", "Error", JOptionPane.INFORMATION_MESSAGE);
					}
					StoreSalesTableModel mt = new StoreSalesTableModel(storeSalesId);
				    table.setModel(mt);
					
				    tf5.setText("");
				    tf6.setText("");
				    
				    count++;
				}
				
			}		
				
	 }
	 
	 class ButtonEventListener4 implements ActionListener {

			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				StoreSalesDeatailsDao ssdd  = new StoreSalesDeatailsDao();
				StoreSalesDetails ssd = ssdd.findByStoreSalesDetailsId(Integer.parseInt(tf7.getText().trim()));
				
				StoreStockDetails ssd1 = new StoreStockDetails();
				ssd1.setpId(ssd.getpId());
				ssd1.setQuantity(ssd.getQuantity());
				ssd1.setStoreId(Integer.parseInt(tf2.getText().trim()));
				StoreStockDetailsDao ssdd1 = new StoreStockDetailsDao();
				ssdd1.addStoreStocks(ssd1);
				
				ssdd.removeSaleDetail(Integer.parseInt(tf7.getText().trim()));
				
				StoreSalesTableModel mt = new StoreSalesTableModel(storeSalesId);
			    table.setModel(mt);
			    
			    tf7.setText("");
				
			}		
				
	 }
	 
	 class ButtonEventListener5 implements ActionListener {

			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(Integer.parseInt(tf8.getText().trim()) > reward) {
					JOptionPane.showMessageDialog(btn5, "please enter a valid reedmtion amount", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				
				else {
					
					StoreSalesDeatailsDao ssdd  = new StoreSalesDeatailsDao();
					Double totalBill = ssdd.totalPayable(storeSalesId);
					
					StoreSalesDao ssd = new StoreSalesDao();
					ssd.updateAmuontAndDiscount(totalBill, Double.parseDouble(tf8.getText().trim()),totalBill - Double.parseDouble(tf8.getText().trim()), storeSalesId);
					
					CustomersDao custDao = new CustomersDao();
					custDao.updatePoint(reward - Integer.parseInt(tf8.getText()), custId);
					
					CustomersDao custDao1 = new CustomersDao();
					custDao1.updatePoint(custDao1.find(tf3.getText().trim()).getRewards() + 1, custId);
					
					
					StoreSalesDeatailsDao ssdd1  = new StoreSalesDeatailsDao();
					ArrayList<SellingList> al1 = ssdd1.findAllByStoreSalesId(storeSalesId);
					File file = new File("G:/project/"+storeSalesId+".xls");
					try (FileWriter fw = new FileWriter(file)) {
						fw.write("P ID"+"\t"+"P NAME"+"\t"+"QUNATITY"+"\t" +"Cost"+ "\t"+"CGST"+"\t"+"SGST"+"\t"+"TOTAL");
						fw.flush();
					for (SellingList sl : al1) {
						fw.write("\n");
						fw.flush();
						fw.write(""+sl.getpId()+"\t");
						fw.flush();
						fw.write(""+sl.getpName()+"\t");
						fw.flush();
						fw.write(""+sl.getQuantity()+"\t");
						fw.flush();
						fw.write(""+sl.getSp()+"\t");
						fw.flush();
						fw.write(""+sl.getCgst()+"\t");
						fw.flush();
						fw.write(""+sl.getSgst()+"\t");
						fw.flush();
						fw.write(""+sl.getPayable()+"\t");
						fw.flush();

					}
					//System.out.println(sl.get);
						
						fw.close();
					} catch (IOException e1) {
					}
					
					
					FirstPdf firstPdf = new FirstPdf();
					firstPdf.main(null);
				
					UsersDao udao = new UsersDao();
					Users user7 = udao.findByUserId(Integer.parseInt(tf1.getText().trim()));
					int final1 = user7.getTotalSale()+count;
					udao.updateSales(final1, Integer.parseInt(tf1.getText().trim()));
					
					StoreSalesDao ssd1 = new StoreSalesDao();
					Desktop desktop = Desktop.getDesktop();
					File file1 = new File("G:/project/"+storeSalesId+".pdf");
					try {
						desktop.open(file1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//JOptionPane.showMessageDialog(btn5, ssd1.totalPayable(storeSalesId), "Please Collect", JOptionPane.INFORMATION_MESSAGE);
					
					f.dispose();
					f.setVisible(false);
					f.setContentPane(new CreateStoreSale());
					f.setBounds(1000, 1000, 1100, 730);
					f.setVisible(true);
					f.setLocationRelativeTo(null);
					f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
				}
				
			}		
				
	 }
	 
	 public static void main(String args[]) {
		 
		 	//JFrame f = new JFrame("Create Store Sales");
			f.setContentPane(new CreateStoreSale());
			f.setBounds(1000, 1000, 1100, 730);
			f.setVisible(true);
			f.setLocationRelativeTo(null);
			f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
	 }
		
}


