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
import com.avinash.swing.StoreSale.CreateStoreSale;
import com.avinash.swing.admin.AdminLogin;
import com.avinash.swing.admin.StoreLogin;
import com.avinash.swing.users.UpdatePassword;
import com.avinash.swing.wareHousePurchase.CreateWareHousePurchase;
import com.avinash.wareHouseSupply.CreateWareHouseSupply;


public class VirtualDesktop1 extends JFrame implements ActionListener {
	
	JDesktopPane desktopPane;
	JLabel statusLabel;
	UIManager.LookAndFeelInfo laf[];
	JMenuBar menuBar;
	JToolBar jToolBar;
	JPopupMenu jPopupMenu;
	
	public VirtualDesktop1() {
		setLayout(new BorderLayout());
		desktopPane = new JDesktopPane() {
			ImageIcon icon;
			Image image;
			{
				icon = new ImageIcon(getClass().getResource("/images/pic6.png"));
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
		getContentPane().add(statusLabel, BorderLayout.SOUTH);

		setTitle("Stock Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/pic1.png"));
		setIconImage(icon1.getImage());
		setVisible(true);
	}

	private void createMenuBar() {
		// TODO Auto-generated method stub
		
		menuBar = new JMenuBar();
		menuBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		JMenu jMenu1 = new JMenu("MENU");
		jMenu1.setMnemonic('M');

		JMenu jMenu2 = new JMenu("Look And Feel");
		jMenu2.setMnemonic('L');
		
		JMenuItem menuItem1 = new JMenuItem("Store Virtual Desktop", new ImageIcon(getClass().getResource("/images/store1.png")));
		menuItem1.setActionCommand("StoreVirtualDesktop");
		menuItem1.setMnemonic('D');
		menuItem1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.Event.CTRL_MASK));
		menuItem1.addActionListener(this);
		jMenu1.add(menuItem1);

		JMenuItem menuItem2 = new JMenuItem("Add WareHouse Purchase", new ImageIcon(getClass().getResource("/images/whp.png")));
		menuItem2.setActionCommand("AddWareHouseProduct");
		menuItem2.setMnemonic('A');
		menuItem2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.Event.CTRL_MASK));
		menuItem2.addActionListener(this);
		jMenu1.add(menuItem2);

		JMenuItem menuItem3 = new JMenuItem("Send WareHouse Product", new ImageIcon(getClass().getResource("/images/whs.png")));
		menuItem3.setActionCommand("SendWareHouseProduct");
		menuItem3.setMnemonic('S');
		menuItem3.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.Event.CTRL_MASK));
		menuItem3.addActionListener(this);
		jMenu1.add(menuItem3);
		
		JMenuItem menuItem4 = new JMenuItem("Create New Category", new ImageIcon(getClass().getResource("/images/addCat.png")));
		menuItem4.setActionCommand("CreateNewCategory");
		menuItem4.setMnemonic('R');
		menuItem4.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.Event.CTRL_MASK));
		menuItem4.addActionListener(this);
		jMenu1.add(menuItem4);
		

		JMenuItem menuItem5 = new JMenuItem("Update Pro Cat", new ImageIcon(getClass().getResource("/images/update.png")));
		menuItem5.setActionCommand("UpdateProCat");
		menuItem5.setMnemonic('U');
		menuItem5.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.Event.CTRL_MASK));
		menuItem5.addActionListener(this);
		jMenu1.add(menuItem5);
		
		JMenuItem menuItem6 = new JMenuItem("admin virtual desktop", new ImageIcon(getClass().getResource("/images/admin.png")));
		menuItem6.setActionCommand("AdminVirtualDesktop");
		menuItem6.setMnemonic('A');
		menuItem6.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.Event.CTRL_MASK));
		menuItem6.addActionListener(this);
		jMenu1.add(menuItem6);
		
		JCheckBoxMenuItem menuItem14 = new JCheckBoxMenuItem("Metal");
		menuItem14.setSelected(true);
		menuItem14.setActionCommand("Metal");
		menuItem14.setMnemonic('e');
		menuItem14.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.Event.CTRL_MASK));
		menuItem14.addActionListener(this);
		jMenu2.add(menuItem14);

		JCheckBoxMenuItem menuItem15 = new JCheckBoxMenuItem("Motif");
		menuItem15.setActionCommand("Motif");
		menuItem15.setMnemonic('f');
		menuItem15.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.Event.CTRL_MASK));
		menuItem15.addActionListener(this);
		jMenu2.add(menuItem15);

		JCheckBoxMenuItem menuItem16 = new JCheckBoxMenuItem("Nimbus");
		menuItem16.setActionCommand("Nimbus");
		menuItem16.setMnemonic('N');
		menuItem16.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.Event.CTRL_MASK));
		menuItem16.addActionListener(this);
		jMenu2.add(menuItem16);

		JCheckBoxMenuItem menuItem17 = new JCheckBoxMenuItem("Windows");
		menuItem17.setActionCommand("Windows");
		menuItem17.setMnemonic('W');
		menuItem17.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.Event.CTRL_MASK));
		menuItem17.addActionListener(this);
		jMenu2.add(menuItem17);

		JCheckBoxMenuItem menuItem18 = new JCheckBoxMenuItem("Windows Classic");
		menuItem18.setActionCommand("WindowsClassic");
		menuItem18.setMnemonic('C');
		menuItem18.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.Event.CTRL_MASK));
		menuItem18.addActionListener(this);
		jMenu2.add(menuItem18);

		ButtonGroup bg = new ButtonGroup();
		bg.add(menuItem14);
		bg.add(menuItem15);
		bg.add(menuItem16);
		bg.add(menuItem17);
		bg.add(menuItem18);

		menuBar.add(jMenu1);
		menuBar.add(jMenu2);
		setJMenuBar(menuBar);
		
		
	}

	private void createPopupMenu() {
		// TODO Auto-generated method stub
		
		JMenuItem menuItem1 = new JMenuItem("Store Virtual Desktop", new ImageIcon(getClass().getResource("/images/store1.png")));
		menuItem1.setActionCommand("StoreVirtualDesktop");
		menuItem1.setMnemonic('D');
		menuItem1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.Event.CTRL_MASK));
		menuItem1.addActionListener(this);
		
		JMenuItem menuItem2 = new JMenuItem("Add WareHouse Purchase", new ImageIcon(getClass().getResource("/images/whp.png")));
		menuItem2.setActionCommand("AddWareHouseProduct");
		menuItem2.setMnemonic('A');
		menuItem2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.Event.CTRL_MASK));
		menuItem2.addActionListener(this);
		
		JMenuItem menuItem3 = new JMenuItem("Send WareHouse Product", new ImageIcon(getClass().getResource("/images/whs.png")));
		menuItem3.setActionCommand("SendWareHouseProduct");
		menuItem3.setMnemonic('S');
		menuItem3.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.Event.CTRL_MASK));
		menuItem3.addActionListener(this);
		
		JMenuItem menuItem4 = new JMenuItem("Create New Category", new ImageIcon(getClass().getResource("/images/addCat.png")));
		menuItem4.setActionCommand("CreateNewCategory");
		menuItem4.setMnemonic('R');
		menuItem4.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.Event.CTRL_MASK));
		menuItem4.addActionListener(this);
		
		JMenuItem menuItem5 = new JMenuItem("Update Pro Cat", new ImageIcon(getClass().getResource("/images/update.png")));
		menuItem5.setActionCommand("UpdateProCat");
		menuItem5.setMnemonic('U');
		menuItem5.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.Event.CTRL_MASK));
		menuItem5.addActionListener(this);
		
		JMenuItem menuItem6 = new JMenuItem("Update Password", new ImageIcon(getClass().getResource("/images/update.png")));
		menuItem6.setActionCommand("UpdatePassword");
		menuItem6.setMnemonic('P');
		menuItem6.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.Event.CTRL_MASK));
		menuItem6.addActionListener(this);
		
		JMenuItem menuItem7 = new JMenuItem("Admin Virtual Desktop", new ImageIcon(getClass().getResource("/images/admin.png")));
		menuItem7.setActionCommand("AdminVirtualDesktop");
		menuItem7.setMnemonic('A');
		menuItem7.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.Event.CTRL_MASK));
		menuItem7.addActionListener(this);

		
		jPopupMenu = new JPopupMenu();
		jPopupMenu.add(menuItem1);
		jPopupMenu.add(menuItem2);
		jPopupMenu.add(menuItem3);
		jPopupMenu.add(menuItem4);
		jPopupMenu.add(menuItem5);
		jPopupMenu.add(menuItem6);
		jPopupMenu.add(menuItem7);
		
		
		desktopPane.setComponentPopupMenu(jPopupMenu);

		
	}

	private void createToolBar() {
		// TODO Auto-generated method stub
		
		jToolBar = new JToolBar();
		JButton btn1 = new JButton(new ImageIcon(getClass().getResource("/images/store1.png")));
		btn1.setActionCommand("StoreVirtualDesktop");
		btn1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn1.setToolTipText("Store Virtual Desktop");
		btn1.addActionListener(this);
		jToolBar.add(btn1);

		JButton btn2 = new JButton(new ImageIcon(getClass().getResource("/images/whp.png")));
		btn2.setActionCommand("AddWareHouseProduct");
		btn2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn2.setToolTipText("Add Ware House Purchase");
		btn2.addActionListener(this);
		jToolBar.add(btn2);

		JButton btn3 = new JButton(new ImageIcon(getClass().getResource("/images/whs.png")));
		btn3.setActionCommand("SendWareHouseProduct");
		btn3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn3.setToolTipText("SendWareHouseProduct");
		btn3.addActionListener(this);
		jToolBar.add(btn3);
		
		JButton btn4 = new JButton(new ImageIcon(getClass().getResource("/images/addCat.png")));
		btn4.setActionCommand("CreateNewCategory");
		btn4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn4.setToolTipText("Create New Category");
		btn4.addActionListener(this);
		jToolBar.add(btn4);
		
		JButton btn5 = new JButton(new ImageIcon(getClass().getResource("/images/update.png")));
		btn5.setActionCommand("UpdateProCat");
		btn5.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn5.setToolTipText("Update Pro Cat");
		btn5.addActionListener(this);
		jToolBar.add(btn5);
		
		JButton btn6 = new JButton(new ImageIcon(getClass().getResource("/images/admin.png")));
		btn6.setActionCommand("AdminVirtualDesktop");
		btn6.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn6.setToolTipText("admin virtual desktop");
		btn6.addActionListener(this);
		jToolBar.add(btn6);
		
		jToolBar.addSeparator();

		JButton btn7 = new JButton(new ImageIcon(getClass().getResource("/images/java.png")));
		btn7.setActionCommand("Metal");
		btn7.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn7.setToolTipText("Metal Look And Feel");
		btn7.addActionListener(this);
		jToolBar.add(btn7);

		JButton btn8 = new JButton(new ImageIcon(getClass().getResource("/images/ubuntoo.png")));
		btn8.setActionCommand("Motif");
		btn8.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn8.setToolTipText("Motif look and feel");
		btn8.addActionListener(this);
		jToolBar.add(btn8);

		JButton btn9 = new JButton(new ImageIcon(getClass().getResource("/images/apple.png")));
		btn9.setActionCommand("Nimbus");
		btn9.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn9.setToolTipText("Nimbus look and feel");
		btn9.addActionListener(this);
		jToolBar.add(btn9);

		JButton btn10 = new JButton(new ImageIcon(getClass().getResource("/images/w.png")));
		btn10.setActionCommand("Windows");
		btn10.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn10.setToolTipText("Windows look and feel");
		btn10.addActionListener(this);
		jToolBar.add(btn10);

		JButton btn11 = new JButton(new ImageIcon(getClass().getResource("/images/wc.png")));
		btn11.setActionCommand("WindowsClassic");
		btn11.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn11.setToolTipText("WindowsClassic look and feel");
		btn11.addActionListener(this);
		jToolBar.add(btn11);
		
		add(jToolBar, BorderLayout.NORTH);
		
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
		if (str.equals("StoreVirtualDesktop")) {
			internalFrame.setTitle("ValidateIdentity");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/store1.png")));
			internalFrame.setContentPane(new StoreLogin());
			internalFrame.setBounds(500, 200, 250, 200);
			internalFrame.setVisible(true);
		} 
		else if (str.equals("AddWareHouseProduct")) {
			internalFrame.setTitle("Add To WareHouse");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/whp.png")));
			internalFrame.setContentPane(new CreateWareHousePurchase());
			internalFrame.setBounds(50, 0, 1100, 710);
			internalFrame.setVisible(true);  
		} 
		
		else if (str.equals("SendWareHouseProduct")) {
			internalFrame.setTitle("Send  To Store");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/whs.png")));
			internalFrame.setContentPane(new CreateWareHouseSupply());
			internalFrame.setBounds(50, 1, 1100, 700);
			internalFrame.setVisible(true);  
		} 
		
		else if (str.equals("CreateNewCategory")) {
			internalFrame.setTitle("Create New Category");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/addCat.png")));
			internalFrame.setContentPane(new CreateProCat());
			internalFrame.setBounds(500, 200, 500, 250);
			internalFrame.setVisible(true);  
		}

		else if (str.equals("UpdateProCat")) {
			internalFrame.setTitle("Update Pro Cat");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/update.png")));
			internalFrame.setContentPane(new UpdateProCat());
			internalFrame.setBounds(500, 200, 500, 250);
			internalFrame.setVisible(true);  
		}
		
		else if (str.equals("UpdatePassword")) {
			internalFrame.setTitle("Update Password");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/update.png")));
			internalFrame.setContentPane(new UpdatePassword());
			internalFrame.setBounds(500, 200, 400, 200);
			internalFrame.setVisible(true);  
		}
		else if (str.equals("AdminVirtualDesktop")) {
			internalFrame.setTitle("Validate Identity");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/admin.png")));
			internalFrame.setContentPane(new AdminLogin());
			internalFrame.setBounds(500, 200, 250, 200);
			internalFrame.setVisible(true);  
		}
		
		desktopPane.add(internalFrame, new Integer(1));
		
	}
	
	public static void main(String args[]) {
		new VirtualDesktop1();
	}

}
