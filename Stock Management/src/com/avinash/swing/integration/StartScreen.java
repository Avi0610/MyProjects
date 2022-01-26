package com.avinash.swing.integration;
import java.awt.*;

import javax.swing.*;

public class StartScreen extends JPanel {
	
	JProgressBar progressBar;
	
	public StartScreen() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(new Color(0, 0, 128), 10));
		Icon icon = new ImageIcon(getClass().getResource("/images/pic5.png"));
		add(new JLabel(icon), BorderLayout.CENTER);
		progressBar = new JProgressBar(1, 100);
		progressBar.setForeground(new Color(250, 10, 100));
		add(progressBar, BorderLayout.SOUTH);
	}
	
	public void setProgress(int progress) {
		progressBar.setValue(progress);
		progressBar.setStringPainted(true);
	}

	public static void main(String args[]) {
		StartScreen sp = new StartScreen();
		
		JWindow win = new JWindow();
		win.setContentPane(sp);
		win.setBounds(100, 100, 450, 300);
		win.setLocationRelativeTo(null);
		win.setVisible(true);
		try {
			for (int i = 1; i <= 100; i++) {
				Thread.sleep(50);
				sp.setProgress(i);
			}
		} catch (Exception e) {
		}
		win.setVisible(false);
		win.dispose();
		new VirtualDesktop1();
	
	}

}
