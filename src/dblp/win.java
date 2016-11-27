package dblp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;


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
		
		
		String data[][]={ {"ID","NAME","SALARY"},{"101","Amit","670000"},  
	              {"102","Jai","780000"},  
	                          {"101","Sachin","700000"}};  
	    String column[]={"ID","NAME","SALARY"};  
	      
	    JTable jt=new JTable(data,column);
	    jt.setBackground(Color.white);
	    jt.setBounds(420, 90, 455, 565);
		
		search = new JButton("Search");
		search.setBounds(30, 450, 75, 35);
		search.setForeground(Color.black);
		
		reset = new JButton("reset");
		reset.setBounds(110, 450, 75, 35);
		reset.setForeground(Color.black);
		
		startLabel = new JLabel("DBLP Query Engine");
		startLabel.setBounds(170,0, 500, 100);
		startLabel.setFont(new Font("serif",Font.ITALIC,45));	
		startLabel.setForeground(Color.red);
		
		String[] str = {"Query","Query 1","Query 2"};
		
		query = new JComboBox(str);
		query.setSelectedIndex(0);
		query.setBounds(50, 110, 90, 40);
		
		
		query.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				String options = (String)query.getSelectedItem();
				switch(options)
				{
					case "Query": break;
					
					case "Query 1": qOne();
									break;
									
					case "Query 2": qTwo();
									break;
				}
			}
		});
		
		startPanel.add(startLabel);
		startPanel.add(jt);
		startPanel.add(query);
		startPanel.add(search);
		startPanel.add(reset);
		
		frame.add(startPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void qOne(){
		try {
			startPanel.remove(queryTwoPanel);
		} catch (Exception e) {
		}
		
		queryOnePanel = new JPanel();
		queryOnePanel.setLayout(null);
		queryOnePanel.setBackground(Color.cyan);
		queryOnePanel.setBounds(0, 160, 450, 285);
		queryOnePanel.setVisible(true);
		
		String[] str2 = {"Search By","By author Name","By title tags"};
		searchBy = new JComboBox(str2);
		searchBy.setSelectedIndex(0);
		searchBy.setBounds(50, 10, 80, 40);
		
		//searchBy action
		
		JLabel label1 = new JLabel("Name / Title Tag");
		label1.setBounds(30, 70, 150, 40);
		
		JTextField fld2 = new JTextField();
		fld2.setBounds(150, 80, 80, 30);
		
		JLabel label2 = new JLabel("Since year");
		label2.setBounds(30, 130, 150, 40);
		
		JTextField fld3 = new JTextField();
		fld3.setBounds(150, 130, 80, 30);
		
		JLabel label3 = new JLabel("Between years");
		label3.setBounds(30, 180, 150, 40);

		JTextField fld4 = new JTextField();
		fld4.setBounds(150, 180, 80, 30);
		
		JLabel label4 = new JLabel("-");
		label4.setBounds(240, 180, 150, 20);
		
		JTextField fld5 = new JTextField();
		fld5.setBounds(260, 180, 80, 30);
		
		queryOnePanel.add(searchBy);
		queryOnePanel.add(label1);
		queryOnePanel.revalidate();
		queryOnePanel.add(fld2);
		queryOnePanel.add(label2);
		queryOnePanel.add(fld3);
		queryOnePanel.add(label3);
		queryOnePanel.add(fld4);
		queryOnePanel.add(label4);
		queryOnePanel.add(fld5);
		
		startPanel.add(queryOnePanel);
		frame.validate();
		frame.repaint();
	}
	
	public void qTwo(){
		
		try {
			startPanel.remove(queryOnePanel);
		} catch (Exception e) {
		}
		queryTwoPanel = new JPanel();
		queryTwoPanel.setLayout(null);
		queryTwoPanel.setBackground(Color.cyan);
		queryTwoPanel.setBounds(0, 160, 450, 285);
		queryTwoPanel.setVisible(true);
		
		fld = new JTextField("Number of publications");
		fld.setBounds(40, 30, 170, 40);
		
		queryTwoPanel.add(fld);
		
		startPanel.add(queryTwoPanel);
		frame.validate();
		frame.repaint();
		
	}
	
	public static void main(String [] args) throws FileNotFoundException{
		win n = new win();
		
		try {	
	         File inputFile = new File("dblp.xml");
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         handler userhandler = new handler();
	         saxParser.parse(inputFile, userhandler);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }  
		
		
	}
}
