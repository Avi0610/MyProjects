package com.avinash.swing.integration;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import com.avinash.swing.ProductsRelated.CreateProCat;
import com.avinash.swing.ProductsRelated.UpdateProCat;
import com.avinash.swing.ProductsRelated.UpdateProduct;
import com.avinash.swing.StoreSale.CreateStoreSale;
import com.avinash.swing.StoreSale.FindMaxSellingProducts;
import com.avinash.swing.StoreSale.FindStoreStock;
import com.avinash.swing.StoreSale.FindStoreWiseSale;
import com.avinash.swing.StoreSale.FindTotalSale;
import com.avinash.swing.admin.AdminLogin;
import com.avinash.swing.users.CreateUser;
import com.avinash.swing.users.RemoveUser;
import com.avinash.swing.users.SearchUserByMobile;
import com.avinash.swing.users.UsersByType;
import com.avinash.swing.wareHousePurchase.CreateWareHousePurchase;
import com.avinash.swing.wareHousePurchase.ExpiryList;
import com.avinash.swing.wareHousePurchase.PurchaseList;
import com.avinash.swing.wareHousePurchase.SeeWareHouseStocks;
import com.avinash.wareHouseSupply.CreateWareHouseSupply;
import com.avinash.wareHouseSupply.SupplyHistory;

public class AdminVirtualDesktop extends JFrame implements ActionListener {
	JDesktopPane desktopPane;
	JLabel statusLabel;
	UIManager.LookAndFeelInfo laf[];
	JMenuBar menuBar;
	JToolBar jToolBar;
	JPopupMenu jPopupMenu;
	
	public AdminVirtualDesktop() {
		
		setLayout(new BorderLayout());
		desktopPane = new JDesktopPane() {
			ImageIcon icon;
			Image image;
			{
				icon = new ImageIcon(getClass().getResource("/images/stock2.jpg"));
				image = icon.getImage();
			}
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		
		laf = UIManager.getInstalledLookAndFeels();
		statusLabel = new JLabel("Stock Management Software Developed By Avinash");
		desktopPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		statusLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		statusLabel.setFont(new Font("Time New Roman", Font.BOLD, 16));
		
		createToolBar();
		createMenuBar();
		createPopupMenu();

		getContentPane().add(desktopPane, BorderLayout.CENTER);
		//getContentPane().add(statusLabel, BorderLayout.SOUTH);

		setTitle("Admin Virtual Desktop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/icon.png"));
		setIconImage(icon1.getImage());
		setVisible(true);
		
	}

	private void createPopupMenu() {
		// TODO Auto-generated method stub
		
	}

	private void createMenuBar() {
		// TODO Auto-generated method stub
		
		menuBar = new JMenuBar();
		menuBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		JMenu jMenu1 = new JMenu("Users");
		jMenu1.setMnemonic('U');

		JMenu jMenu2 = new JMenu("Stores");
		jMenu2.setMnemonic('S');
		
		JMenu jMenu3 = new JMenu("Ware House");
		jMenu3.setMnemonic('W');
		
		JMenu jMenu4 = new JMenu("Others");
		jMenu4.setMnemonic('O');
		
		JMenu jMenu5 = new JMenu("Look And Feel");
		jMenu5.setMnemonic('L');

		JMenuItem menuItem1 = new JMenuItem("Create Users", new ImageIcon(getClass().getResource("/images/addUser.png")));
		menuItem1.setActionCommand("CreateUsers");
		menuItem1.setMnemonic('C');
		menuItem1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.Event.CTRL_MASK));
		menuItem1.addActionListener(this);
		jMenu1.add(menuItem1);
		
		JMenuItem menuItem2 = new JMenuItem("Remove User", new ImageIcon(getClass().getResource("/images/delete.png")));
		menuItem2.setActionCommand("RemoveUsers");
		menuItem2.setMnemonic('R');
		menuItem2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.Event.CTRL_MASK));
		menuItem2.addActionListener(this);
		jMenu1.add(menuItem2);
		
		JMenuItem menuItem3 = new JMenuItem("Search By Mobile", new ImageIcon(getClass().getResource("/images/mobsearch.png")));
		menuItem3.setActionCommand("SearchByMobile");
		menuItem3.setMnemonic('S');
		menuItem3.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.Event.CTRL_MASK));
		menuItem3.addActionListener(this);
		jMenu1.add(menuItem3);
		
		JMenuItem menuItem4 = new JMenuItem("Search By Type", new ImageIcon(getClass().getResource("/images/sbt.png")));
		menuItem4.setActionCommand("SearchByType");
		menuItem4.setMnemonic('E');
		menuItem4.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.Event.CTRL_MASK));
		menuItem4.addActionListener(this);
		jMenu1.add(menuItem4);
		
		JMenuItem menuItem5 = new JMenuItem("Date Wise Sale", new ImageIcon(getClass().getResource("/images/find.png")));
		menuItem5.setActionCommand("DateWiseSale");
		menuItem5.setMnemonic('D');
		menuItem5.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.Event.CTRL_MASK));
		menuItem5.addActionListener(this);
		jMenu2.add(menuItem5);
		
		JMenuItem menuItem6 = new JMenuItem("Store Stocks", new ImageIcon(getClass().getResource("/images/findall.png")));
		menuItem6.setActionCommand("StoreStocks");
		menuItem6.setMnemonic('O');
		menuItem6.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.Event.CTRL_MASK));
		menuItem6.addActionListener(this);
		jMenu2.add(menuItem6);
		
		JMenuItem menuItem7 = new JMenuItem("Stores Date Wise Sale", new ImageIcon(getClass().getResource("/images/sws.png")));
		menuItem7.setActionCommand("StoresDateWiseSale");
		//menuItem7.setMnemonic('O');
		//menuItem7.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.Event.CTRL_MASK));
		menuItem7.addActionListener(this);
		jMenu2.add(menuItem7);
		
		JMenuItem menuItem8 = new JMenuItem("Purchase History", new ImageIcon(getClass().getResource("/images/history.png")));
		menuItem8.setActionCommand("PurchaseHistory");
		//menuItem7.setMnemonic('O');
		//menuItem7.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.Event.CTRL_MASK));
		menuItem8.addActionListener(this);
		jMenu3.add(menuItem8);
		
		JMenuItem menuItem9 = new JMenuItem("Supply History", new ImageIcon(getClass().getResource("/images/clock.png")));
		menuItem9.setActionCommand("SupplyHistory");
		//menuItem7.setMnemonic('O');
		//menuItem7.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.Event.CTRL_MASK));
		menuItem9.addActionListener(this);
		jMenu3.add(menuItem9);
		
		JMenuItem menuItem10 = new JMenuItem("Ware House Stock", new ImageIcon(getClass().getResource("/images/database.png")));
		menuItem10.setActionCommand("WareHouseStock");
		//menuItem7.setMnemonic('O');
		//menuItem7.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.Event.CTRL_MASK));
		menuItem10.addActionListener(this);
		jMenu3.add(menuItem10);
		
		JMenuItem menuItem11 = new JMenuItem("Maximum Selling Products", new ImageIcon(getClass().getResource("/images/max.png")));
		menuItem11.setActionCommand("MaximumSellingProducts");
		//menuItem7.setMnemonic('O');
		//menuItem7.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.Event.CTRL_MASK));
		menuItem11.addActionListener(this);
		jMenu4.add(menuItem11);
		
		JMenuItem menuItem12 = new JMenuItem("Update Product", new ImageIcon(getClass().getResource("/images/update.png")));
		menuItem12.setActionCommand("UpdateProduct");
		//menuItem7.setMnemonic('O');
		//menuItem7.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.Event.CTRL_MASK));
		menuItem12.addActionListener(this);
		jMenu4.add(menuItem12);
		
		JMenuItem menuItem13 = new JMenuItem("Expiring Products", new ImageIcon(getClass().getResource("/images/finish.png")));
		menuItem13.setActionCommand("ExpiringProducts");
		//menuItem7.setMnemonic('O');
		//menuItem7.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.Event.CTRL_MASK));
		menuItem13.addActionListener(this);
		jMenu4.add(menuItem13);
		
		JCheckBoxMenuItem menuItem14 = new JCheckBoxMenuItem("Metal");
		menuItem14.setSelected(true);
//		menuItem14.setActionCommand("Metal");
//		menuItem14.setMnemonic('e');
		menuItem14.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.Event.CTRL_MASK));
		menuItem14.addActionListener(this);
		jMenu5.add(menuItem14);

		JCheckBoxMenuItem menuItem15 = new JCheckBoxMenuItem("Motif");
		menuItem15.setActionCommand("Motif");
//		menuItem15.setMnemonic('f');
//		menuItem15.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.Event.CTRL_MASK));
		menuItem15.addActionListener(this);
		jMenu5.add(menuItem15);

		JCheckBoxMenuItem menuItem16 = new JCheckBoxMenuItem("Nimbus");
		menuItem16.setActionCommand("Nimbus");
//		menuItem16.setMnemonic('N');
//		menuItem16.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.Event.CTRL_MASK));
		menuItem16.addActionListener(this);
		jMenu5.add(menuItem16);

		JCheckBoxMenuItem menuItem17 = new JCheckBoxMenuItem("Windows");
		menuItem17.setActionCommand("Windows");
//		menuItem17.setMnemonic('W');
//		menuItem17.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.Event.CTRL_MASK));
		menuItem17.addActionListener(this);
		jMenu5.add(menuItem17);

		JCheckBoxMenuItem menuItem18 = new JCheckBoxMenuItem("Windows Classic");
		menuItem18.setActionCommand("WindowsClassic");
//		menuItem18.setMnemonic('C');
//		menuItem18.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.Event.CTRL_MASK));
		menuItem18.addActionListener(this);
		jMenu5.add(menuItem18);

		ButtonGroup bg = new ButtonGroup();
		bg.add(menuItem14);
		bg.add(menuItem15);
		bg.add(menuItem16);
		bg.add(menuItem17);
		bg.add(menuItem18);

		
		
		
		
		menuBar.add(jMenu1);
		menuBar.add(jMenu2);
		menuBar.add(jMenu3);
		menuBar.add(jMenu4);
		menuBar.add(jMenu5);
	
		setJMenuBar(menuBar);
		
	}

	private void createToolBar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		int i = -1;
		if (str.equals("Metal")) {
			i = 0;
		} else if (str.equals("Nimbus")) {
			i = 1;
		} else if (str.equals("Motif")) {
			i = 2;
		} else if (str.equals("Windows")) {
			i = 3;
		} else if (str.equals("WindowsClassic")) {
			i = 4;
		}

		if (i > -1) {
			try {
				UIManager.setLookAndFeel(laf[i].getClassName());
				SwingUtilities.updateComponentTreeUI(this);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Unable to Apply Look And Feel");
			}
			return;
		}

		JInternalFrame internalFrame = new JInternalFrame("Title", true, true, true, true);
		
		if (str.equals("CreateUsers")) {
			internalFrame.setTitle("User Registratrion");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/store1.png")));
			internalFrame.setContentPane(new CreateUser());
			internalFrame.setBounds(500, 200, 400, 350);
			internalFrame.setVisible(true);
		} 
		
		else if (str.equals("RemoveUsers")) {
			internalFrame.setTitle("Remove User");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/store1.png")));
			internalFrame.setContentPane(new RemoveUser());
			internalFrame.pack();
			internalFrame.setVisible(true);
		} 
		
		else if (str.equals("SearchByMobile")) {
			internalFrame.setTitle("Find User");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/store1.png")));
			internalFrame.setContentPane(new SearchUserByMobile());
			internalFrame.setBounds(500, 200, 380, 300);
			internalFrame.setVisible(true);
		} 
		
		else if (str.equals("SearchByType")) {
			internalFrame.setTitle("Find User");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/store1.png")));
			internalFrame.setContentPane(new UsersByType());
			internalFrame.setBounds(20, 1, 1250, 620);
			internalFrame.setVisible(true);
		} 
		
		else if (str.equals("DateWiseSale")) {
			internalFrame.setTitle("Date Wise Sale");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/store1.png")));
			internalFrame.setContentPane(new FindTotalSale());
			internalFrame.setBounds(80, 1, 1100, 650);
			internalFrame.setVisible(true);
		} 
		
		else if (str.equals("StoreStocks")) {
			internalFrame.setTitle("Store Stocks");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/store1.png")));
			internalFrame.setContentPane(new FindStoreStock());
			internalFrame.setBounds(80, 1, 1100, 650);
			internalFrame.setVisible(true);
		} 
		
		else if (str.equals("StoresDateWiseSale")) {
			internalFrame.setTitle("Stores Date Wise Sale");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/store1.png")));
			internalFrame.setContentPane(new  FindStoreWiseSale());
			internalFrame.setBounds(80, 1, 1100, 650);
			internalFrame.setVisible(true);
		} 
		
		else if (str.equals("PurchaseHistory")) {
			internalFrame.setTitle("Purchase History");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/store1.png")));
			internalFrame.setContentPane(new  PurchaseList());
			internalFrame.setBounds(80, 1, 1100, 650);
			internalFrame.setVisible(true);
		} 
		else if (str.equals("SupplyHistory")) {
			internalFrame.setTitle("Supply History");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/store1.png")));
			internalFrame.setContentPane(new  SupplyHistory());
			internalFrame.setBounds(80, 1, 1100, 650);
			internalFrame.setVisible(true);
		} 
		else if (str.equals("WareHouseStock")) {
			internalFrame.setTitle("Ware House Stock");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/store1.png")));
			internalFrame.setContentPane(new  SeeWareHouseStocks());
			internalFrame.setBounds(80, 1, 1100, 650);
			internalFrame.setVisible(true);
		} 
		
		else if (str.equals("MaximumSellingProducts")) {
			internalFrame.setTitle("Maximum Selling Products");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/store1.png")));
			internalFrame.setContentPane(new  FindMaxSellingProducts());
			internalFrame.setBounds(80, 1, 1100, 650);
			internalFrame.setVisible(true);
		} 
		else if (str.equals("UpdateProduct")) {
			internalFrame.setTitle("Update Product");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/store1.png")));
			internalFrame.setContentPane(new  UpdateProduct());
			internalFrame.setBounds(400, 150, 500, 250);
			internalFrame.setVisible(true);
		} 
		else if (str.equals("ExpiringProducts")) {
			internalFrame.setTitle("Expiry List");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/store1.png")));
			internalFrame.setContentPane(new  ExpiryList());
			internalFrame.setBounds(80, 1, 1100, 650);
			internalFrame.setVisible(true);
		}
		desktopPane.add(internalFrame, new Integer(1));
	}
	
	public static void main(String args[]) {
		new AdminVirtualDesktop();
	}

}
