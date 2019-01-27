

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

class Menu extends JFrame implements KeyListener {
	
	// gui elements
	
	private JFrame menuFrame;
	private JPanel menuNorthPanel,menuSouthPanel,menuCenterPanel,menuTitlePanel,menuDetailPanel,menuChoicePanel,menuHeaderPanel;
	private JLabel menuStoreLabel,menuTitleLabel,menuCashierLabel,menuHeaderLabel,menuChoiceLabel[];

	public static String choice[] = {"Chicken Fry  ","Burger       ","French Fry   ","Rice Platter ","Sandwiches   ","Soft Drinks  ","Fruit Juices ","Mineral Water"};	

	public static double price[] = {100,300,100,150,100,100,100,100};

	public static int ordered[];
				   
	String option[] = {"Sub Total", "Log Off"};

	public Menu() {
		menuFrame = new JFrame("Food Menu");
		menuNorthPanel = new JPanel();
		menuNorthPanel.setLayout(new FlowLayout());
		
		
		menuSouthPanel = new JPanel();
		
		menuTitlePanel = new JPanel();
		
		menuDetailPanel = new JPanel();
		menuDetailPanel.setLayout(new GridLayout(2,1));
		
		menuCenterPanel = new JPanel();
		menuCenterPanel.setLayout(new BorderLayout(0,0));
		
		menuStoreLabel = new JLabel(" Restaurant ");
		menuStoreLabel.setForeground(Color.blue);
		menuStoreLabel.setFont(new Font("Arial Black",Font.BOLD,36));
		
		menuTitleLabel = new JLabel(" Cashier Menu ", JLabel.CENTER);
		menuTitleLabel.setForeground(Color.black);
		menuTitleLabel.setFont(new Font("Arial Black",Font.BOLD,24));
		
		menuCashierLabel = new JLabel("   Cashier on Duty : " + LoginDB.textField.getText());
		menuCashierLabel.setForeground(Color.black);
		menuCashierLabel.setFont(new Font("Arial Black",Font.BOLD,14));
		
		menuHeaderLabel = new JLabel("             Food Item"+"         Price(BDT)"+"  Ordered");
		menuHeaderLabel.setForeground(Color.white);
		menuHeaderLabel.setFont(new Font("Arial Black",Font.BOLD,18));
	
		menuChoicePanel = new JPanel();
		menuChoicePanel.setLayout(new GridLayout(choice.length+4,1,0,0));
		menuChoicePanel.setBackground(new Color(0,0,0));
		menuChoicePanel.add(menuHeaderLabel);
		
	
		menuChoiceLabel = new JLabel[choice.length + 2];
		ordered = new int[choice.length];
		for (int i = 0; i < choice.length; i++)	{
		
			ordered[i] = 0;
		
			menuChoiceLabel[i] = new JLabel("  [" + (i+1) + "]  " + choice[i] +"      "+ price[i] + "0"+"       "+ ordered[i]);
			menuChoiceLabel[i].setForeground(Color.white);
			menuChoiceLabel[i].setFont(new Font("Courier New",Font.BOLD,18));
			menuChoicePanel.add(menuChoiceLabel[i]);
		}
	
		menuChoiceLabel[choice.length] = new JLabel("  [0]  " + option[0]);
		menuChoiceLabel[choice.length+1] = new JLabel("  [Q]  " + option[1] + " "+LoginDB.textField.getText() );
		menuChoiceLabel[choice.length].setForeground(Color.white);
		menuChoiceLabel[choice.length+1].setForeground(Color.white);
		menuChoiceLabel[choice.length].setFont(new Font("Courier New",Font.BOLD,18));
		menuChoiceLabel[choice.length+1].setFont(new Font("Courier New",Font.BOLD,18));
		
		menuChoicePanel.add(menuChoiceLabel[choice.length]);
		menuChoicePanel.add(menuChoiceLabel[choice.length+1]);

		
	}

	public void launchFrame() {	
		menuFrame.setSize(200,350);
	
		menuDetailPanel.add(menuCashierLabel);
		
		menuTitlePanel.add(menuTitleLabel, BorderLayout.WEST);
		menuTitlePanel.add(menuDetailPanel, BorderLayout.EAST);
		
		menuNorthPanel.add(menuStoreLabel, BorderLayout.NORTH);
		
		
		
		menuCenterPanel.add(menuTitlePanel, BorderLayout.NORTH);
		menuCenterPanel.add(menuChoicePanel, BorderLayout.CENTER);
		
		menuFrame.getContentPane().add(menuNorthPanel, BorderLayout.NORTH);
		menuFrame.getContentPane().add(menuCenterPanel, BorderLayout.CENTER);
		menuFrame.getContentPane().add(menuSouthPanel, BorderLayout.SOUTH);
		menuFrame.pack();		
	
		menuFrame.setLocationRelativeTo(null);
		menuFrame.addKeyListener(this);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setVisible(true);
		menuFrame.pack();
	}
	private void refresh() {
		for (int i = 0; i < choice.length; i++)	{
		
			menuChoiceLabel[i].setText("  [" + (i+1) + "]  " + choice[i]+"      "+ price[i] + "0"+"       "+ ordered[i]);
		}		
	}

	public void keyTyped(KeyEvent ke) { }
	public void keyReleased(KeyEvent ke) { }
	public void keyPressed(KeyEvent ke) { 		
		switch(ke.getKeyCode()) {
		case 49:
		case 50:
		case 51:
		case 52:
		case 53:
		case 54:
		case 55:
		case 56:
			
			ordered[ke.getKeyCode() - 49]++;
			break;
			//subtotal case
		case 48:
	
			menuFrame.setVisible(false);
			SubTotal subTotal = new SubTotal();
			subTotal.launchFrame();
			break;
			//logout case
		case 81:
	
			menuFrame.setVisible(false);
			JOptionPane.showMessageDialog(this, "User Log Off",
				"Goodbye and have a nice day!", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
			break;
		}
		
		this.refresh();
	}
}