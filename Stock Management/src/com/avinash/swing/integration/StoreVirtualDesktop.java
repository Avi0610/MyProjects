package com.avinash.swing.integration;
import java.io.*;
import java.net.URL;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import com.avinash.swing.StoreSale.CreateStoreSale;
import com.avinash.swing.StoreSale.StoreProByName;
import com.avinash.swing.admin.AdminLogin;
import com.avinash.swing.customers.FindCustomer;
import com.avinash.swing.customers.UpdateCustomers;
import com.avinash.swing.wareHousePurchase.CreateWareHousePurchase;
import com.avinash.wareHouseSupply.CreateWareHouseSupply;


public class StoreVirtualDesktop extends JFrame implements ActionListener {
	
	JDesktopPane desktopPane;
	JLabel statusLabel;
	UIManager.LookAndFeelInfo laf[];
	JMenuBar menuBar;
	JToolBar jToolBar;
	JPopupMenu jPopupMenu;
	
	public StoreVirtualDesktop() {
		setLayout(new BorderLayout());
		desktopPane = new JDesktopPane() {
			ImageIcon icon;
			Image image;
			{
				icon = new ImageIcon(getClass().getResource("/images/pic1.png"));
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

		setTitle("Stocks Management Store Virtual Desktop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/icon.png"));
		setIconImage(icon1.getImage());
		setVisible(true);
	}

	private void createPopupMenu() {
		// TODO Auto-generated method stub
		
		JMenuItem menuItem1 = new JMenuItem("Create Store Sales", new ImageIcon(getClass().getResource("/images/sell.png")));
		menuItem1.setActionCommand("Create Store Sales");
		menuItem1.setMnemonic('R');
		menuItem1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.Event.CTRL_MASK));
		menuItem1.addActionListener(this);
		
		JMenuItem menuItem2 = new JMenuItem("Store Pro By Name", new ImageIcon(getClass().getResource("/images/find.png")));
		menuItem2.setActionCommand("Store Pro By Name");
		menuItem2.setMnemonic('P');
		menuItem2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.Event.CTRL_MASK));
		menuItem2.addActionListener(this);
		
		JMenuItem menuItem3 = new JMenuItem("Find Customer", new ImageIcon(getClass().getResource("/images/findall.png")));
		menuItem3.setActionCommand("Find Customer");
		menuItem3.setMnemonic('F');
		menuItem3.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.Event.CTRL_MASK));
		menuItem3.addActionListener(this);
		
		JMenuItem menuItem4 = new JMenuItem("Update Customer", new ImageIcon(getClass().getResource("/images/update.png")));
		menuItem4.setActionCommand("Update Customer");
		menuItem4.setMnemonic('U');
		menuItem4.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.Event.CTRL_MASK));
		menuItem4.addActionListener(this);
		

		jPopupMenu = new JPopupMenu();
		jPopupMenu.add(menuItem1);
		jPopupMenu.add(menuItem2);
		jPopupMenu.add(menuItem3);
		jPopupMenu.add(menuItem4);
		
		desktopPane.setComponentPopupMenu(jPopupMenu);
		
	}

	private void createMenuBar() {
		// TODO Auto-generated method stub
		
		menuBar = new JMenuBar();
		menuBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		JMenu jMenu1 = new JMenu("MENU");
		jMenu1.setMnemonic('M');

		JMenu jMenu2 = new JMenu("Look And Feel");
		jMenu2.setMnemonic('L');

		JMenuItem menuItem1 = new JMenuItem("Create Store Sales", new ImageIcon(getClass().getResource("/images/sell.png")));
		menuItem1.setActionCommand("Create Store Sales");
		menuItem1.setMnemonic('R');
		menuItem1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.Event.CTRL_MASK));
		menuItem1.addActionListener(this);
		jMenu1.add(menuItem1);

		JMenuItem menuItem2 = new JMenuItem("Store Pro By Name", new ImageIcon(getClass().getResource("/images/find.png")));
		menuItem2.setActionCommand("Store Pro By Name");
		menuItem2.setMnemonic('P');
		menuItem2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.Event.CTRL_MASK));
		menuItem2.addActionListener(this);
		jMenu1.add(menuItem2);

		JMenuItem menuItem3 = new JMenuItem("Find Customer", new ImageIcon(getClass().getResource("/images/findall.png")));
		menuItem3.setActionCommand("Find Customer");
		menuItem3.setMnemonic('F');
		menuItem3.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.Event.CTRL_MASK));
		menuItem3.addActionListener(this);
		jMenu1.add(menuItem3);
		
		JMenuItem menuItem4 = new JMenuItem("Update Customer", new ImageIcon(getClass().getResource("/images/update.png")));
		menuItem4.setActionCommand("Update Customer");
		menuItem4.setMnemonic('U');
		menuItem4.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.Event.CTRL_MASK));
		menuItem4.addActionListener(this);
		jMenu1.add(menuItem4);
		
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

	private void createToolBar() {
		// TODO Auto-generated method stub
		
		jToolBar = new JToolBar();
		JButton btn1 = new JButton(new ImageIcon(getClass().getResource("/images/sell.png")));
		btn1.setActionCommand("Create Store Sales");
		btn1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn1.setToolTipText("Create Store Sales");
		btn1.addActionListener(this);
		jToolBar.add(btn1);

		JButton btn2 = new JButton(new ImageIcon(getClass().getResource("/images/find.png")));
		btn2.setActionCommand("Store Pro By Name");
		btn2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn2.setToolTipText("Store Pro By Name");
		btn2.addActionListener(this);
		jToolBar.add(btn2);

		JButton btn3 = new JButton(new ImageIcon(getClass().getResource("/images/findall.png")));
		btn3.setActionCommand("Find Customer");
		btn3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn3.setToolTipText("Find Customer");
		btn3.addActionListener(this);
		jToolBar.add(btn3);
		
		JButton btn4 = new JButton(new ImageIcon(getClass().getResource("/images/update.png")));
		btn4.setActionCommand("Update Customer");
		btn4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn4.setToolTipText("UpdateCustomer");
		btn4.addActionListener(this);
		jToolBar.add(btn4);
		
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
		if (str.equals("Create Store Sales")) {
			internalFrame.setTitle("Sell");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/sell.png")));
			internalFrame.setContentPane(new CreateStoreSale());
			internalFrame.setBounds(50, 1, 1100, 700);
			internalFrame.setVisible(true);
		}
		
		if (str.equals("Store Pro By Name")) {
			internalFrame.setTitle("Details");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/find.png")));
			internalFrame.setContentPane(new StoreProByName());
			internalFrame.setBounds(50, 1, 1100, 700);
			internalFrame.setVisible(true);
		}
		if(str.equals("Find Customer")) {
			internalFrame.setTitle("Customers");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/findall.png")));
			internalFrame.setContentPane(new FindCustomer());
			internalFrame.setBounds(500, 200, 350, 200);
			internalFrame.setVisible(true);
			
		}
		
		if(str.equals("Update Customer")) {
			internalFrame.setTitle("Update");
			internalFrame.setFrameIcon(new ImageIcon(getClass().getResource("/images/update.png")));
			internalFrame.setContentPane(new UpdateCustomers());
			internalFrame.setBounds(500, 200, 350, 200);
			internalFrame.setVisible(true);
			
		}
		
		
		desktopPane.add(internalFrame, new Integer(1));
		
	}
	
	public static void main(String args[]) {
		new StoreVirtualDesktop();
	}


}
