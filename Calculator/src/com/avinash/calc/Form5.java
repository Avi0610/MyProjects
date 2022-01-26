package com.avinash.calc;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Form5 extends JPanel implements ActionListener {
	JButton bn[];
	JButton bnmul, bndiv, bnadd, bnsub, bnequal, bnreset;
	JTextArea tf1;
	static int num1 , num2, operation;
	
	
	public Form5() {
		Panel panelDisplay = new Panel(new FlowLayout());
		tf1 = new JTextArea();
		tf1.setColumns(20);
		tf1.setRows(2);
		tf1.setEditable(false);
		tf1.setBackground(Color.YELLOW);
		tf1.setCaretColor(Color.red);
		tf1.setForeground(Color.red);
		tf1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		
		panelDisplay.add(tf1);
		
		Panel panelButtons = new Panel(new GridLayout(4, 4, 5, 5));
		bn = new JButton[10];
		bn[7] = new JButton("7");
		bn[7].setForeground(Color.red);
		bn[7].setBackground(Color.white);
		bn[7].setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelButtons.add(bn[7]);
		bn[8] = new JButton("8");
		bn[8].setForeground(Color.red);
		bn[8].setBackground(Color.white);
		bn[8].setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelButtons.add(bn[8]);
		bn[9] = new JButton("9");
		bn[9].setForeground(Color.red);
		bn[9].setBackground(Color.white);
		bn[9].setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelButtons.add(bn[9]);
		bnadd = new JButton("+");
		bnadd.setForeground(Color.red);
		bnadd.setBackground(Color.white);
		bnadd.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelButtons.add(bnadd);
		bn[4] = new JButton("4");
		bn[4].setForeground(Color.red);
		bn[4].setBackground(Color.white);
		bn[4].setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelButtons.add(bn[4]);
		bn[5] = new JButton("5");
		bn[5].setForeground(Color.red);
		bn[5].setBackground(Color.white);
		bn[5].setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelButtons.add(bn[5]);
		bn[6] = new JButton("6");
		bn[6].setForeground(Color.red);
		bn[6].setBackground(Color.white);
		bn[6].setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelButtons.add(bn[6]);
		bnsub = new JButton("-");
		bnsub.setForeground(Color.red);
		bnsub.setBackground(Color.white);
		bnsub.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelButtons.add(bnsub);
		bn[1] = new JButton("1");
		bn[1].setForeground(Color.red);
		bn[1].setBackground(Color.white);
		bn[1].setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelButtons.add(bn[1]);
		bn[2] = new JButton("2");
		bn[2].setForeground(Color.red);
		bn[2].setBackground(Color.white);
		bn[2].setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelButtons.add(bn[2]);
		bn[3] = new JButton("3");
		bn[3].setForeground(Color.red);
		bn[3].setBackground(Color.white);
		bn[3].setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelButtons.add(bn[3]);
		bnmul = new JButton("*");
		bnmul.setForeground(Color.red);
		bnmul.setBackground(Color.white);
		bnmul.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelButtons.add(bnmul);
		bn[0] = new JButton("0");
		bn[0].setForeground(Color.red);
		bn[0].setBackground(Color.white);
		bn[0].setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelButtons.add(bn[0]);
		bnreset = new JButton("C");
		bnreset.setForeground(Color.red);
		bnreset.setBackground(Color.white);
		bnreset.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelButtons.add(bnreset);
		bnequal = new JButton("=");
		bnequal.setForeground(Color.red);
		bnequal.setBackground(Color.white);
		bnequal.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelButtons.add(bnequal);
		bndiv = new JButton("/");
		bndiv.setForeground(Color.red);
		bndiv.setBackground(Color.white);
		bndiv.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelButtons.add(bndiv);
		
		//bn.addActionListner(this);
		for(int i = 0; i <10; i++) {
			bn[i].addActionListener(this);
		}
		bnadd.addActionListener(this);
		bnsub.addActionListener(this);
		bnmul.addActionListener(this);
		bndiv.addActionListener(this);
		bnequal.addActionListener(this);
		bnreset.addActionListener(this);
		
		
		setLayout(new BorderLayout());
		add(panelDisplay, BorderLayout.NORTH);
		add(panelButtons, BorderLayout.CENTER);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int result = 0;
		String str = arg0.getActionCommand();
		if(str.equals("1")) 
			 tf1.setText(tf1.getText().concat("1"));
		else if(str.equals("2"))
			tf1.setText(tf1.getText().concat("2"));
		else if(str.equals("3"))
			tf1.setText(tf1.getText().concat("3"));
		else if(str.equals("4"))
			tf1.setText(tf1.getText().concat("4"));
		else if(str.equals("5"))
			tf1.setText(tf1.getText().concat("5"));
		else if(str.equals("6"))
			tf1.setText(tf1.getText().concat("6"));
		else if(str.equals("7"))
			tf1.setText(tf1.getText().concat("7"));
		else if(str.equals("8"))
			tf1.setText(tf1.getText().concat("8"));
		else if(str.equals("9"))
			tf1.setText(tf1.getText().concat("9"));
		else if(str.equals("0"))
			tf1.setText(tf1.getText().concat("0"));
		else if(str.equals("C"))
			tf1.setText("");
		else if(str.equals("+")) {
			num1 = Integer.parseInt(tf1.getText().trim());
			tf1.setText("");
			operation = 1;	
		}
		else if(str.equals("-")) {
			num1 = Integer.parseInt(tf1.getText().trim());
			tf1.setText("");
			operation = 2;
			
		}
		else if(str.equals("*")) {
			num1 = Integer.parseInt(tf1.getText().trim());
			tf1.setText("");
			operation = 3;
			
		}
		else if(str.equals("/")) {
			num1 = Integer.parseInt(tf1.getText().trim());
			tf1.setText("");
			operation = 4;
			
		}
		else {
			num2 = Integer.parseInt(tf1.getText().trim());
			switch(operation) {
			case 1:
				result = num1 + num2;
				tf1.setText(result+"");
				break;
			case 2:
				result = num1 - num2;
				tf1.setText(result+"");
				break;
			case 3:
				result = num1 * num2;
				tf1.setText(result+"");
				break;
			case 4:
				result = num1 / num2;
				tf1.setText(result+"");
				break;
			default:
				tf1.setText("wrong operation");
					
			
			}
			
			
		}
			
		
	}
	public static void main(String args[]) {
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Form5());
		//frame.setBounds(100, 100, 400, 300);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
