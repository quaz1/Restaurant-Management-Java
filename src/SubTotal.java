
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

class SubTotal extends JFrame implements KeyListener {
	
	double perItemTotal, grandTotal;
	// gui elements
	private JFrame subTotalFrame;
	private JPanel subTotalNorthPanel,subTotalSouthPanel,subTotalCenterPanel,subTotalTitlePanel,subTotalDetailPanel,subTotalOrderedPanel,subTotalHeaderPanel;
	private JLabel subTotalStoreLabel,subTotalTitleLabel,subTotalCashierLabel,subTotalHeaderLabel,subTotalOrderedLabel[],subTotalGrandTotalLabel;
							   					
	
	public SubTotal() {
		subTotalFrame = new JFrame("Sub Total");
		subTotalFrame.getContentPane().setLayout(new BorderLayout(0,0));
		
		subTotalNorthPanel = new JPanel();
		subTotalNorthPanel.setLayout(new FlowLayout());
		subTotalNorthPanel.setBackground(Color.white);
		
		subTotalSouthPanel = new JPanel();
	
		subTotalTitlePanel = new JPanel();
		subTotalTitlePanel.setLayout(new BorderLayout(10,10));

		subTotalDetailPanel = new JPanel();
		subTotalDetailPanel.setLayout(new GridLayout(2,1));
	
		subTotalCenterPanel = new JPanel();
		subTotalCenterPanel.setLayout(new BorderLayout(0,0));
	
		subTotalStoreLabel = new JLabel(" Restaurant ");
		subTotalStoreLabel.setForeground(Color.blue);
		subTotalStoreLabel.setFont(new Font("Arial Black",Font.BOLD,36));
		
		subTotalTitleLabel = new JLabel(" SUB TOTAL ", JLabel.CENTER);
		subTotalTitleLabel.setForeground(Color.black);
		subTotalTitleLabel.setFont(new Font("Arial Black",Font.BOLD,24));

		subTotalCashierLabel = new JLabel("   Cashier on Duty : " +LoginDB.textField.getText());
		subTotalCashierLabel.setForeground(Color.black);
		subTotalCashierLabel.setFont(new Font("Arial Black",Font.BOLD,14));
	
		subTotalHeaderLabel = new JLabel("    Food Item"+"           Price/Unit"+"    Ordered"+"    Total(BDT)   ");
		subTotalHeaderLabel.setForeground(Color.white);
		subTotalHeaderLabel.setFont(new Font("Arial Black",Font.BOLD,18));
	
		subTotalOrderedPanel = new JPanel();
		subTotalOrderedPanel.setBackground(new Color(0,0,0));
		subTotalOrderedPanel.add(subTotalHeaderLabel);
	
		subTotalOrderedLabel = new JLabel[Menu.choice.length];
		perItemTotal = 0;
		grandTotal = 0;
		int count = 0;
		for (int i = 0; i < Menu.choice.length; i++)	{
			if (Menu.ordered[i] > 0) {
			perItemTotal = Menu.ordered[i] * Menu.price[i];
			grandTotal+= perItemTotal;
			count++;

			subTotalOrderedLabel[i] = new JLabel("  " + Menu.choice[i]+"    " + Menu.price[i] + "0"+"        " + Menu.ordered[i]+"       " + perItemTotal + "0");
			subTotalOrderedLabel[i].setForeground(Color.white);
			subTotalOrderedLabel[i].setFont(new Font("Courier New",Font.BOLD,18));
			subTotalOrderedPanel.add(subTotalOrderedLabel[i]);
			
			Menu.ordered[i] = 0;
			}
		}
	
		subTotalGrandTotalLabel = new JLabel(" Sub Total : BDT " + grandTotal + "0");
		subTotalGrandTotalLabel.setForeground(Color.white);
		subTotalGrandTotalLabel.setFont(new Font("Courier New",Font.BOLD,30));			
		subTotalOrderedPanel.add(subTotalGrandTotalLabel);
	
		
		subTotalOrderedPanel.setLayout(new GridLayout(count+2,1,0,0));
	}

	public void launchFrame() {	
		subTotalFrame.setSize(200,350);
		
		subTotalDetailPanel.add(subTotalCashierLabel);
		
		subTotalTitlePanel.add(subTotalTitleLabel, BorderLayout.WEST);
		subTotalTitlePanel.add(subTotalDetailPanel, BorderLayout.EAST);
		
		subTotalNorthPanel.add(subTotalStoreLabel, BorderLayout.NORTH);
		
		
		
		subTotalCenterPanel.add(subTotalTitlePanel, BorderLayout.NORTH);
		subTotalCenterPanel.add(subTotalOrderedPanel, BorderLayout.CENTER);
		
		subTotalFrame.getContentPane().add(subTotalNorthPanel, BorderLayout.NORTH);
		subTotalFrame.getContentPane().add(subTotalCenterPanel, BorderLayout.CENTER);
		subTotalFrame.getContentPane().add(subTotalSouthPanel, BorderLayout.SOUTH);
		subTotalFrame.pack();		
		subTotalFrame.setLocationRelativeTo(null);
		subTotalFrame.addKeyListener(this);
		subTotalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		subTotalFrame.setVisible(true);
	}

	public void keyTyped(KeyEvent ke) { }
	public void keyReleased(KeyEvent ke) { }
	public void keyPressed(KeyEvent ke) { 
	
		if (ke.getKeyCode() == 27) {
			subTotalFrame.setVisible(false);
			Menu menu = new Menu();
			menu.launchFrame();
		}
	}}