

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Cashier extends JFrame {


	public static void main(String args[]) {		
	LoginDB loginob = new LoginDB();
	loginob.initialize();
	loginob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	loginob.loginFrame.setVisible(true);		
	}	

}