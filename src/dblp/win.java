package dblp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class win {
	private JFrame frame;
	private JPanel startPanel;
	private JPanel startPanel2;
	private JLabel startLabel;
	private JComboBox query;
	private JButton search;
	private JButton reset;
	private JComboBox searchBy;
	private JLabel publications;
	private JTextField fld;
	private JPanel queryOnePanel;
	private JPanel queryTwoPanel;
	win(){
		frame = new JFrame("DBLP");
		frame.setSize(900,700);
		
		startPanel = new JPanel();
		startPanel.setLayout(null);
		startPanel.setBackground(Color.cyan);
		
		startPanel2 = new JPanel();
		startPanel2.setLayout(null);
		startPanel2.setBackground(Color.white);
		startPanel2.setBounds(420, 90, 455, 565);
		
		startLabel = new JLabel("DBLP Query Engine");
		startLabel.setBounds(170,0, 500, 100);
		startLabel.setFont(new Font("serif",Font.ITALIC,45));	
		startLabel.setForeground(Color.red);
		
		search = new JButton("Search");
		search.setBounds(30, 450, 75, 35);
		search.setForeground(Color.black);
		
		reset = new JButton("reset");
		reset.setBounds(110, 450, 75, 35);
		reset.setForeground(Color.black);
		
		String[] str = {"Query","Query 1","Query 2"};
		
		query = new JComboBox(str);
		query.setSelectedIndex(0);
		query.setBounds(50, 110, 90, 40);
		
		startPanel.add(startLabel);
		startPanel.add(startPanel2);
		startPanel.add(query);
		startPanel.add(search);
		startPanel.add(reset);
		
		frame.add(startPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String [] args){
		win n = new win();
	}
}
